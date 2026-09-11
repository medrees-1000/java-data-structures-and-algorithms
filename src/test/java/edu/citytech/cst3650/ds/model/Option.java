package edu.citytech.cst3650.ds.model;

import com.learning.framework.INumber;

import edu.cst.csv.function.csv.CSVColumn;

public class Option implements Comparable<Option>, INumber{

	@CSVColumn(index = "0") private String symbol;
	@CSVColumn(index = "1") private float strike;
	@CSVColumn(index = "2") private String contractID;
	@CSVColumn(index = "3") private float delta;
	@CSVColumn(index = "4") private float bid;
	@CSVColumn(index = "5") private String expiration;
	@CSVColumn(index = "6") private float volume;
	@CSVColumn(index = "7") private float impliedVolatility;
	@CSVColumn(index = "8") private float income;
	@CSVColumn(index = "9") private int daysBetween;
	@CSVColumn(index = "10") private float yearlyIncome;
	@CSVColumn(index = "11") private float rateOfReturn;
	@CSVColumn(index = "12") private float collateral;
	@CSVColumn(index = "13") private float price;
	@CSVColumn(index = "14") private float dailyIncome;
	@CSVColumn(index = "15") private double marketCap;
	@CSVColumn(index = "16") private float difference;

	
	public Option(String symbol) {
	    this.symbol = symbol;
	}
	
	public Option() {}
	
	@Override
	public int compareTo(Option o) {
	    int status = this.symbol.compareTo(o.symbol);
	    return status;
	}
	
	@Override
	public double getNumber() {
	    return price;
	}
	
	@Override
	public String toString() {
		return "Option [symbol=" + symbol + ", strike=" + strike + ", contractID=" + contractID + ", delta=" + delta
				+ ", bid=" + bid + ", expiration=" + expiration + ", volume=" + volume + ", impliedVolatility="
				+ impliedVolatility + ", income=" + income + ", daysBetween=" + daysBetween + ", yearlyIncome="
				+ yearlyIncome + ", rateOfReturn=" + rateOfReturn + ", collateral=" + collateral + ", price=" + price
				+ ", dailyIncome=" + dailyIncome + ", marketCap=" + marketCap + ", difference=" + difference + "]";
	}
	
	
}
