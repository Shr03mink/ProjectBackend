package com.example.citi;

public class Data {
	
	
	private String symbol;
	private Double open;
	private Double prevclose;
	private Double dayhigh;
	private Double daylow;
	private Double change;
	private Double changeOverTwoWeeks;
	
	public Data( String symbol, Double open, Double prevclose, Double dayhigh, Double daylow, Double change,
			Double changeOverTwoWeeks) {
		super();

		this.symbol = symbol;
		this.open = open;
		this.prevclose = prevclose;
		this.dayhigh = dayhigh;
		this.daylow = daylow;
		this.change = change;
		this.changeOverTwoWeeks = changeOverTwoWeeks;
	}

	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Double getOpen() {
		return open;
	}
	public void setOpen(Double open) {
		this.open = open;
	}
	public Double getPrevclose() {
		return prevclose;
	}
	public void setPrevclose(Double prevclose) {
		this.prevclose = prevclose;
	}
	public Double getDayhigh() {
		return dayhigh;
	}
	public void setDayhigh(Double dayhigh) {
		this.dayhigh = dayhigh;
	}
	public Double getDaylow() {
		return daylow;
	}
	public void setDaylow(Double daylow) {
		this.daylow = daylow;
	}
	public Double getChange() {
		return change;
	}
	public void setChange(Double change) {
		this.change = change;
	}
	public Double getChangeOverTwoWeeks() {
		return changeOverTwoWeeks;
	}
	public void setChangeOverTwoWeeks(Double changeOverTwoWeeks) {
		this.changeOverTwoWeeks = changeOverTwoWeeks;
	}
}