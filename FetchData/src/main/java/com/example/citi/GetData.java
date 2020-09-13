package com.example.citi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import consumer2.main.Portfolio;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;
import yahoofinance.quotes.stock.StockQuote;

@RestController
public class GetData extends TopGainers {
	
	//Reading sectoral indices
	public ArrayList<String> fetchIndices(String file_path) {
		String filePath = file_path;
		ArrayList<String> list = new ArrayList<String>();
	    try {
	    	BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
	        String lineText = null;
	        while ((lineText = lineReader.readLine()) != null) {
	        	list.add(lineText); 
	        }
	        
	    lineReader.close();
	        } catch (IOException ex) {
	            System.err.println(ex);
	        }
	    return list;
	   
	}
	
	//Fetching stock data
	public HashMap<String, StockQuote> fetchQuote(ArrayList<String> arr) throws IOException {
		int n = arr.size();
		String symbols[] = new String[n];
		StockQuote quotes = null;
		for(int i=0;i<n;i++)
			symbols[i] = arr.get(i);
        
		HashMap<String, StockQuote> stocks = new HashMap<String,StockQuote>();
		try {
			
			for(int i=0;i<symbols.length;i++)
			{
	    		String sym = symbols[i];
				Stock s = YahooFinance.get(sym+".NS");
 		
				quotes = s.getQuote();
 		
				stocks.put(sym,quotes);
			}
	
		} catch (IOException e) {
	
			e.printStackTrace();
		}

		return stocks;
	}
	
	
	//AutoMobile Sector
	@RequestMapping("/AutoSector")
	public ArrayList<Data> autoMobileSector() throws IOException {
		String filePath = "E:\\spring\\FetchData\\ind_niftyautolist.txt";
		ArrayList<String> AutoList = new ArrayList<String>();
		HashMap<String, StockQuote> List;
		ArrayList<Data> data = new ArrayList<Data>();
		AutoList = fetchIndices(filePath);
		List = fetchQuote(AutoList);
		for(String s: List.keySet())
		{
			
			String sym = s;
			double op = List.get(s).getOpen().doubleValue();
			double prevclose = List.get(s).getPreviousClose().doubleValue();
			double dayhigh = List.get(s).getDayHigh().doubleValue();
			double daylow = List.get(s).getDayLow().doubleValue();
			double change = List.get(s).getChange().doubleValue();
			double changeOverTwoWeeks = List.get(s).getChange().doubleValue();
			data.add(new Data(sym,op,prevclose,dayhigh,daylow,change,changeOverTwoWeeks));
			
		}
		
		
		return data;
	}
	
	//IT Sector
	@RequestMapping("/ITSector")
	public ArrayList<Data> itSector() throws IOException {
		String filePath = "E:\\spring\\FetchData\\ind_niftyitlist.txt";
		ArrayList<String> ITList = new ArrayList<String>();
		
		ArrayList<Data> data = new ArrayList<Data>();
		HashMap<String, StockQuote> List;
		ITList = fetchIndices(filePath);
		
		List = fetchQuote(ITList);
		
		
		for(String s: List.keySet())
		{
			
			String sym = s;
			double op = List.get(s).getOpen().doubleValue();
			double prevclose = List.get(s).getPreviousClose().doubleValue();
			double dayhigh = List.get(s).getDayHigh().doubleValue();
			double daylow = List.get(s).getDayLow().doubleValue();
			double change = List.get(s).getChange().doubleValue();
			double changeOverTwoWeeks = List.get(s).getChange().doubleValue();
			data.add(new Data(sym,op,prevclose,dayhigh,daylow,change,changeOverTwoWeeks));
			
		}
		
		
		return data;
	}
	
	//Bank Sector
	@RequestMapping("/BankSector")
	public ArrayList<Data> bankSector() throws IOException {
		String filePath = "E:\\spring\\FetchData\\ind_niftybanklist.txt";
		ArrayList<String> BankList = new ArrayList<String>();
		ArrayList<Data> data = new ArrayList<Data>();
		HashMap<String, StockQuote> List;
		BankList = fetchIndices(filePath);
		List = fetchQuote(BankList);
		for(String s: List.keySet())
		{
			
			String sym = s;
			double op = List.get(s).getOpen().doubleValue();
			double prevclose = List.get(s).getPreviousClose().doubleValue();
			double dayhigh = List.get(s).getDayHigh().doubleValue();
			double daylow = List.get(s).getDayLow().doubleValue();
			double change = List.get(s).getChange().doubleValue();
			double changeOverTwoWeeks = List.get(s).getChange().doubleValue();
			data.add(new Data(sym,op,prevclose,dayhigh,daylow,change,changeOverTwoWeeks));
			
		}
		
		return data;
	}
	
	//Pharma Sector
	@RequestMapping("/PharmaSector")
	public ArrayList<Data> pharmaSector() throws IOException {
		String filePath = "E:\\spring\\FetchData\\ind_niftypharmalist.txt";
		ArrayList<String> PharmaList = new ArrayList<String>();
		ArrayList<Data> data = new ArrayList<Data>();
		HashMap<String, StockQuote> List;
		PharmaList = fetchIndices(filePath);
		List = fetchQuote(PharmaList);
		for(String s: List.keySet())
		{
			
			String sym = s;
			double op = List.get(s).getOpen().doubleValue();
			double prevclose = List.get(s).getPreviousClose().doubleValue();
			double dayhigh = List.get(s).getDayHigh().doubleValue();
			double daylow = List.get(s).getDayLow().doubleValue();
			double change = List.get(s).getChange().doubleValue();
			double changeOverTwoWeeks = List.get(s).getChange().doubleValue();
			data.add(new Data(sym,op,prevclose,dayhigh,daylow,change,changeOverTwoWeeks));
			
		}
		
		
		return data;
	}
	
	//Oil and Gas Sector
	@RequestMapping("/OilandGasSector")
	public ArrayList<Data> oilAndGasSector() throws IOException {
		String filePath = "E:\\spring\\FetchData\\ind_niftyoilgaslist.txt";
		ArrayList<String> OIlGasList = new ArrayList<String>();
		ArrayList<Data> data = new ArrayList<Data>();
		HashMap<String, StockQuote> List;
		OIlGasList = fetchIndices(filePath);
		List = fetchQuote(OIlGasList);
		for(String s: List.keySet())
		{
			
			String sym = s;
			double op = List.get(s).getOpen().doubleValue();
			double prevclose = List.get(s).getPreviousClose().doubleValue();
			double dayhigh = List.get(s).getDayHigh().doubleValue();
			double daylow = List.get(s).getDayLow().doubleValue();
			double change = List.get(s).getChange().doubleValue();
			double changeOverTwoWeeks = List.get(s).getChange().doubleValue();
			data.add(new Data(sym,op,prevclose,dayhigh,daylow,change,changeOverTwoWeeks));
			
		}
		
		
		return data;
	}
	
	//Media Sector
	@RequestMapping("/MediaSector")
	public ArrayList<Data> mediaSector() throws IOException {
		String filePath = "E:\\spring\\FetchData\\ind_niftymedialist.txt";
		ArrayList<String> MediaList = new ArrayList<String>();
		ArrayList<Data> data = new ArrayList<Data>();
		HashMap<String, StockQuote> List;
		MediaList = fetchIndices(filePath);
		List = fetchQuote(MediaList);
		for(String s: List.keySet())
		{
			
			String sym = s;
			double op = List.get(s).getOpen().doubleValue();
			double prevclose = List.get(s).getPreviousClose().doubleValue();
			double dayhigh = List.get(s).getDayHigh().doubleValue();
			double daylow = List.get(s).getDayLow().doubleValue();
			double change = List.get(s).getChange().doubleValue();
			double changeOverTwoWeeks = List.get(s).getChange().doubleValue();
			data.add(new Data(sym,op,prevclose,dayhigh,daylow,change,changeOverTwoWeeks));
			
		}
		
		
		return data;
	}
	
	// Per Sector Top Gainers 
	
	//Top gainers for Automobile Sector 
	@RequestMapping("/topGainersAutoMobileSector")
	public ArrayList<Data> topGainersAutoMobileSector() throws IOException{
		ArrayList<Data> data = new ArrayList<Data>();
		data = autoMobileSector();
		ArrayList<Data> topGainerData = new ArrayList<Data>();
		topGainerData = topGainerPerSector(data);
		return topGainerData;
		
	}
	
	//Top gainers for IT Sector 
	@RequestMapping("/topGainersITSector")
	public ArrayList<Data> topGainersITSector() throws IOException{
		ArrayList<Data> data = new ArrayList<Data>();
		data = itSector();
		ArrayList<Data> topGainerData = new ArrayList<Data>();
		topGainerData = topGainerPerSector(data);
		return topGainerData;
	}
	
	//Top gainers for Bank Sector 
	@RequestMapping("/topGainersBankSector")
	public ArrayList<Data> topGainersBankSector() throws IOException{
		ArrayList<Data> data = new ArrayList<Data>();
		data = bankSector();
		ArrayList<Data> topGainerData = new ArrayList<Data>();
		topGainerData = topGainerPerSector(data);
		return topGainerData;
	}
	
	//Top gainers for Pharmaceutical Sector 
	@RequestMapping("/topGainersPharmaSector")
	public ArrayList<Data> topGainersPharmaSector() throws IOException{
		ArrayList<Data> data = new ArrayList<Data>();
		data = pharmaSector();
		ArrayList<Data> topGainerData = new ArrayList<Data>();
		topGainerData = topGainerPerSector(data);
		return topGainerData;
	}
	
	//Top gainers for Oil and Gas Sector 
	@RequestMapping("/topGainersOilandGasSector")
	public ArrayList<Data> topGainersOilandGasSector() throws IOException {
		ArrayList<Data> data = new ArrayList<Data>();
		data = oilAndGasSector();
		ArrayList<Data> topGainerData = new ArrayList<Data>();
		topGainerData = topGainerPerSector(data);
		return topGainerData;
	}
	
	//Top gainers for Media Sector 
	@RequestMapping("/topGainersMediaSector")
	public ArrayList<Data> topGainersMediaSector() throws IOException{
		ArrayList<Data> data = new ArrayList<Data>();
		data = mediaSector();
		ArrayList<Data> topGainerData = new ArrayList<Data>();
		topGainerData = topGainerPerSector(data);
		return topGainerData;
	}
	

}
