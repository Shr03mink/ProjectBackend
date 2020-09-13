package com.example.citi;

import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;


public class TopGainers{
	List<HistoricalQuote> history = null;
	ArrayList<String> list = new ArrayList<String>() ;
	Stock stock;
	
	//Getting number of trading days
	public long getAllDays(int dayOfWeek, long businessDays) {
		
	    long result = 0;
	    if (businessDays != 0) {
	        boolean isStartOnWorkday = dayOfWeek < 6;
	        long absBusinessDays = Math.abs(businessDays);
	        if (isStartOnWorkday) {
	            int shiftedWorkday = businessDays > 0 ? dayOfWeek : 6 - dayOfWeek;
	            result = absBusinessDays + (absBusinessDays + shiftedWorkday - 1) / 5 * 2;
	        } else { 
	            int shiftedWeekend = businessDays > 0 ? dayOfWeek : 13 - dayOfWeek;
	            result = absBusinessDays + (absBusinessDays - 1) / 5 * 2 + (7 - shiftedWeekend);
	        }
	    }
	    return result;
	}
	
	//Fetching historical data over two weeks
	public List<HistoricalQuote> fetchHistoricData(String symbol)
	{
		LocalDate startDate = LocalDate.now();
		Date date_sorted = Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date_sorted);
		
		long businessDays = -14;
		LocalDate endDate = startDate.minusDays(getAllDays(startDate.getDayOfWeek().getValue(), businessDays));
		Date date = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		long days = ChronoUnit.DAYS.between(date.toInstant(), date_sorted.toInstant());
		Calendar from = Calendar.getInstance();
	    Calendar to = Calendar.getInstance();
	    to.add(cal1.DATE,-1);
     	from.add(cal1.DATE , - (int)days);
     	//String b1[] = new String[2];
		
     	try {
     		
     		history =  YahooFinance.get(symbol).getHistory(from, to, Interval.DAILY);
     		
	    }
     	
     	catch (IOException e) {
	        e.printStackTrace();
	        }
     	
     	return history;
	}
	
	//Extracting Closing prices for a stock over two weeks
	public ArrayList<Double> closingPrice(String sym)
	{
		//ClosingPrice.clear();
		ArrayList<Double> ClosingPrice = new ArrayList<Double>();
		String symbol = sym;
		List<HistoricalQuote> historicalQuotes = fetchHistoricData(symbol);
		for (HistoricalQuote historicalQuote : historicalQuotes)
	       {
			if(historicalQuote.getClose()!=null)
			{
				Double hq = historicalQuote.getClose().doubleValue();
				ClosingPrice.add(Double.valueOf(String.format("%.2f", hq)));
			}
			
	       }
		
	       return ClosingPrice;
	}
	
	//Fetching top gainers for a sector 
	public ArrayList<Data> topGainerPerSector(ArrayList<Data> list) throws IOException
	{
		ArrayList<Double> closingPrice;
		ArrayList<ArrayList<Double>> Change = new ArrayList<ArrayList<Double>>();
		
		for(int i=0;i<list.size();i++)
		{
			Change.add(new ArrayList<Double>());
			String s = list.get(i).getSymbol();
			String symm = s+".NS";
			closingPrice = new ArrayList<Double>();
			closingPrice = closingPrice(symm);
			Double a = closingPrice.get(0);
			Double b = list.get(i).getPrevclose().doubleValue();
			list.get(i).setChangeOverTwoWeeks(b-a);
		}
		Collections.sort(list, new Comparator<Data>() {    
			@Override
		    public int compare(Data o1, Data o2) {
		        return o1.getChangeOverTwoWeeks().compareTo(o2.getChangeOverTwoWeeks());
		    }              
	});
		Collections.reverse(list);

		return list;
		
	}
}
	

