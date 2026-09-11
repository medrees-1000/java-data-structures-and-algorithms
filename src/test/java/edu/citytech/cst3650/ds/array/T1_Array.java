package edu.citytech.cst3650.ds.array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.learning.framework.dto.Pair;

import edu.citytech.cst3650.s24405505.ds.array.ArrayUtil;

public class T1_Array {
	
		// Developer: Mohammad, Bahar
		@Test void t1() {
			
			assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
				String[] stocks = {"IBM", "COST", "VTI", "NVDL"};
				stocks[4] = "MSFT";
			});
		}
		
       @Test void t2() {
			
		   String[] stocks = {"IBM", "COST", "VTI", "NVDL"};
		   Pair<Long, String[]> pair = ArrayUtil.allocateMoreSpace(String[]::new, 3, stocks);
		   int actual = pair.item2.length;
		   int expected = 7;
		   assertEquals(expected, actual);
		   ArrayUtil.print(ArrayUtil.class, pair.item2);
		}
       
       @Test void t3() {
			
		   String[] stocks = {"IBM", "COST", "VTI", "NVDL"};
		   Pair<Long, String[]> pair = ArrayUtil.allocateMoreSpace(String[]::new, 3, stocks);
		   String actual = pair.item2[3];
		   String expected = "NVDL";
		   assertEquals(expected, actual);  
		   ArrayUtil.print(ArrayUtil.class, pair.item2);
		}
		
       @Test void t4() {
			
		   String[] stocks = {"IBM", "COST", "VTI", "NVDL"};
		   Pair<Long, String[]> pair = ArrayUtil.allocateMoreSpace(String[]::new, 3, stocks);
		   
		   pair.item2[4] = "MSFT";
		   String actual = pair.item2[4];
		   String expected = "MSFT";
		   assertEquals(expected, actual);  
		   
		   ArrayUtil.print(ArrayUtil.class, pair.item2);
		}
}
