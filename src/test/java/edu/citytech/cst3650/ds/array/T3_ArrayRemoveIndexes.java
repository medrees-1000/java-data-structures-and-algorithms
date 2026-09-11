package edu.citytech.cst3650.ds.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.learning.framework.dto.Triple;

import edu.citytech.cst3650.s24405505.ds.array.ArrayUtil;

public class T3_ArrayRemoveIndexes {
	
		// Developer: Mohammad, Bahar
		@Test void t1() {
			
		   String[]  symbols= {"WGMI",	"NUGT",	"JNUG",	"GDXJ",	"RING",	"SIL",	"SLVP",
				              "STCE",	"SGDM",	"GDX",	"SGDJ",	"ETHU",	"SILJ",	"GOAU",	"EETH",	"DAPP",	"SETM"};
		   
		   
		   Triple<Long, Long, String[]> triple = ArrayUtil.removeIndexes(String[]::new, symbols, 0, 5, 7, 10, 14);
		   String expected = "SETM";
		   String actual = triple.item3[11];
		   ArrayUtil.print(ArrayUtil.class, triple.item3);
		   assertEquals(expected, actual);

		}
		
		@Test void t2() {
			
			   String[]  symbols= {"WGMI",	"NUGT",	"JNUG",	"GDXJ",	"RING",	"SIL",	"SLVP",
					              "STCE",	"SGDM",	"GDX",	"SGDJ",	"ETHU",	"SILJ",	"GOAU",	"EETH",	"DAPP",	"SETM"};
			   
			   
			   Triple<Long, Long, String[]> triple = ArrayUtil.removeIndexes(String[]::new, symbols, 0, 5, 7, 10, 14);
			   long expected = 12;// Data Count
			   long actual = triple.item2;
			   ArrayUtil.print(ArrayUtil.class, triple.item3);
			   assertEquals(expected, actual);

			}
			
		

}
