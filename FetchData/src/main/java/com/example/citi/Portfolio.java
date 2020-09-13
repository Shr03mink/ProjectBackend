package com.example.citi;


public class Portfolio {
	private String symbol;
	private Double open;
	private Double prevclose;
	private Double dayhigh;
	private Double daylow;
	private Double change;
	
	
	public Portfolio(String symbol, Double open, Double prevclose, Double dayhigh, Double daylow, Double change) {
		super();
		this.symbol = symbol;
		this.open = open;
		this.prevclose = prevclose;
		this.dayhigh = dayhigh;
		this.daylow = daylow;
		this.change = change;
		
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
	
}