package inclass.project;

import edu.cst.csv.function.csv.CSVColumn;
import static edu.cst.csv.function.number.NumberUtility.*;

public class AlphaModel{
	@CSVColumn(index = "0") private int rank;
	@CSVColumn(index = "1") private String symbol;
	@CSVColumn(index = "2") private String companyName;
	@CSVColumn(index = "3") private float price;
	@CSVColumn(index = "4") private float rating;
	@CSVColumn(index = "5") private String sectorIndustry;
	@CSVColumn(index = "6") private float marketCap;
	@CSVColumn(index = "7") private float nETIncomeTTM;
	@CSVColumn(index = "8") private float $52WHigh;
	
	
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

	public float getRating() {
	    return rating;
	}

	public String getSectorIndustry() {
	    return sectorIndustry;
	}

	public float getMarketCap() {
	    return marketCap;
	}

	public float getnETIncomeTTM() {
	    return nETIncomeTTM;
	}

	public float get$52WHigh() {
	    return $52WHigh;
	}

	@Override
	public String toString() {
		return "AlphaModel [rank=" + rank + ", symbol=" + symbol + ", marketCap=" + shortMoney(marketCap)+ ", price=" + price
				+ ", rating=" + rating + ", sectorIndustry=" + sectorIndustry 
				+ ", nETIncomeTTM=" + nETIncomeTTM + ", $52WHigh=" + $52WHigh + "]";
	}
}



