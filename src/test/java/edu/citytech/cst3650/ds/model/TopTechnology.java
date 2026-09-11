package edu.citytech.cst3650.ds.model;

import edu.cst.csv.function.csv.CSVColumn;

public class TopTechnology implements Comparable<TopTechnology> {

	@CSVColumn(index = "0") private int rank;
	@CSVColumn(index = "1") private String symbol;
	@CSVColumn(index = "2") private String companyName;
	@CSVColumn(index = "3") private float price;
	@CSVColumn(index = "4") private float change;
	@CSVColumn(index = "5") private float quantRating;
	@CSVColumn(index = "6") private String sectorIndustry;
	@CSVColumn(index = "7") private float marketCap;
	
	public TopTechnology() {}

	public TopTechnology(String symbol, String companyName) {
		super();
		this.symbol = symbol;
		this.companyName = companyName;
	}
	
	public int getRank() {
		return rank;
	}
	public String getSymbol() {
		return symbol;
	}
	public String getCompanyName() {
		return companyName;
	}
	public float getPrice() {
		return price;
	}
	public float getChange() {
		return change;
	}
	public float getQuantRating() {
		return quantRating;
	}
	public String getSectorIndustry() {
		return sectorIndustry;
	}
	public float getMarketCap() {
		return marketCap;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TopTechnology [symbol=");
		builder.append(symbol);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}	
	
	@Override
    public int compareTo(TopTechnology o) {
        return this.symbol.compareTo(o.symbol);
    }
}