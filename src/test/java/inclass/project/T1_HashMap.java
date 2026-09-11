package inclass.project;

import org.junit.jupiter.api.Test;
import edu.cst.csv.function.csv.PopulateDTO;
import static edu.cst.csv.function.number.NumberUtility.*;

import java.util.HashMap;
import java.util.Map;

public class T1_HashMap {

    String fileName = "/Users/idree/Desktop/Downloads/csv/2026.03.29.StockData.csv";

    @Test
    void t1() {

        Map<String, AlphaModel> map = new HashMap<>();
        PopulateDTO.process(AlphaModel.class
                , fileName
                , e -> e
                , e -> e.getMarketCap() > BILLION * 8
                , e -> {
                    map.put(e.getSymbol(), e);
                }
                , 1);

        map.forEach((k,v) -> {
            System.out.println(k + " " + v);
        });
    }
    
    @Test
    void t2() {
        Map<String, AlphaModel> stockMap = new HashMap<>();
        
        PopulateDTO.process(AlphaModel.class, fileName, e -> e, e -> true, e -> {
            stockMap.put(e.getSymbol(), e);
        }, 1);
        
        Map<String, Integer> industryCounts = new HashMap<>();
        stockMap.values().forEach(stock -> {
            String industry = stock.getSectorIndustry();
            industryCounts.put(industry, industryCounts.getOrDefault(industry, 0) + 1);
        });
        System.out.println("Display All Sectors and Category");
        industryCounts.forEach((industry, count) -> {
            System.out.println(industry + " " + count);
        });
    }
}

