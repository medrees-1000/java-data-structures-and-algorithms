package edu.citytech.cst3650.ds.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.learning.framework.dto.Pair;

import edu.citytech.cst3650.s24405505.ds.array.ArrayUtil;

public class T2_ArrayCopyFrom {
	
		// Developer: Mohammad, Bahar
		@Test void t1() {
			
		   String[]  symbols= {"WGMI",	"NUGT",	"JNUG",	"GDXJ",	"RING",	"SIL",	"SLVP",
				              "STCE",	"SGDM",	"GDX",	"SGDJ",	"ETHU",	"SILJ",	"GOAU",	"EETH",	"DAPP",	"SETM"};
		   
		   Pair<Long, String[]> pair = ArrayUtil.copyFrom(String[]::new, symbols, 7);
		   
		   String expected = symbols[6];
		   String actual = pair.item2[pair.item2.length - 1];
		   
		   ArrayUtil.print(ArrayUtil.class, pair.item2);
		   assertEquals(expected, actual);

		}
		
		@Test void t2() {
			
			   String[]  symbols= {"WGMI",	"NUGT",	"JNUG",	"GDXJ",	"RING",	"SIL",	"SLVP",
					              "STCE",	"SGDM",	"GDX",	"SGDJ",	"ETHU",	"SILJ",	"GOAU",	"EETH",	"DAPP",	"SETM"};
			   
			   Pair<Long, String[]> pair = ArrayUtil.copyFrom(String[]::new, symbols, 3,9);
			   ArrayUtil.print(ArrayUtil.class, pair.item2);
			   String actual = pair.item2[6];
			   String expected = "GDX";
			   assertEquals(actual, expected);
			   
			}
		
		
		@Test void t3() {
			
			   String[]  symbols= {"WGMI",	"NUGT",	"JNUG",	"GDXJ",	"RING",	"SIL",	"SLVP",
					              "STCE",	"SGDM",	"GDX",	"SGDJ",	"ETHU",	"SILJ",	"GOAU",	"EETH",	"DAPP",	"SETM"};
			   
			   Pair<Long, String[]> pair = ArrayUtil.copyFrom(String[]::new, symbols, 16,16);
			   ArrayUtil.print(ArrayUtil.class, pair.item2);
			   String actual = pair.item2[0];
			   String expected = "SETM";
			   assertEquals(actual, expected);
			   
			}
		
		@Test void t4() {
			
			   String[]  symbols= {"WGMI",	"NUGT",	"JNUG",	"GDXJ",	"RING",	"SIL",	"SLVP",
					              "STCE",	"SGDM",	"GDX",	"SGDJ",	"ETHU",	"SILJ",	"GOAU",	"EETH",	"DAPP",	"SETM"};
			   
			   Pair<Long, String[]> pair = ArrayUtil.copyFrom(String[]::new, symbols, 0, 16);
			   ArrayUtil.print(ArrayUtil.class, pair.item2);
			   String actual = pair.item2[10];
			   String expected = "SGDJ";
			   assertEquals(actual, expected);
			   
			}

		@Test void t5() {
			
			   String[]  symbols= {"WGMI",	"NUGT",	"JNUG",	"GDXJ",	"RING",	"SIL",	"SLVP",
					              "STCE",	"SGDM",	"GDX",	"SGDJ",	"ETHU",	"SILJ",	"GOAU",	"EETH",	"DAPP",	"SETM"};
			   
			   Pair<Long, String[]> pair = ArrayUtil.copyFrom(String[]::new, symbols, 11, 14);
			   ArrayUtil.print(ArrayUtil.class, pair.item2);
			   String actual = pair.item2[1];
			   String expected = "SILJ";
			   assertEquals(actual, expected);
			   
			}
       
}
