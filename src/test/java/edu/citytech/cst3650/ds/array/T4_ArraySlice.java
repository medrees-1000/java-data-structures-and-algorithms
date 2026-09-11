package edu.citytech.cst3650.ds.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.learning.framework.dto.Triple;

import edu.citytech.cst3650.s24405505.ds.array.ArrayUtil;

public class T4_ArraySlice {
	
	       @Test void t1() {
		
		   String[]  symbols= {"WGMI",	"NUGT",	"JNUG",	"GDXJ",	"RING",	"SIL",	"SLVP",
				              "STCE",	"SGDM",	"GDX",	"SGDJ",	"ETHU",	"SILJ",	"GOAU",	"EETH",	"DAPP",	"SETM"};
		   
		   
		   Triple<Long, Long, String[]> triple = ArrayUtil.splice(String[]::new, symbols, -2);
		   long expected = 15;
		   long actual = triple.item2;
		   ArrayUtil.print(ArrayUtil.class, triple.item3);
		   assertEquals(expected, actual);

		}
	       
	       @Test void t2() {
	   		
			   String[]  symbols= {"WGMI",	"NUGT",	"JNUG",	"GDXJ",	"RING",	"SIL",	"SLVP",
					              "STCE",	"SGDM",	"GDX",	"SGDJ",	"ETHU",	"SILJ",	"GOAU",	"EETH",	"DAPP",	"SETM"};
			   
			   
			   Triple<Long, Long, String[]> triple = ArrayUtil.splice(String[]::new, symbols, -2);
			   String expected = triple.item3[14];
			   String actual = "EETH";
			   ArrayUtil.print(ArrayUtil.class, triple.item3);
			   assertEquals(expected, actual);

			}
	       @Test void t3() {
		   		
			   String[]  symbols= {"WGMI",	"NUGT",	"JNUG",	"GDXJ",	"RING",	"SIL",	"SLVP",
					              "STCE",	"SGDM",	"GDX",	"SGDJ",	"ETHU",	"SILJ",	"GOAU",	"EETH",	"DAPP",	"SETM"};
			   
			   
			   Triple<Long, Long, String[]> triple = ArrayUtil.sliceCount(String[]::new, symbols, 0);
			   long expected = 0;
			   long actual = triple.item2;
			   ArrayUtil.print(ArrayUtil.class, triple.item3);
			   assertEquals(expected, actual);

			}
	       @Test void t4() {
		   		
			   String[]  symbols= {"WGMI",	"NUGT",	"JNUG",	"GDXJ",	"RING",	"SIL",	"SLVP",
					              "STCE",	"SGDM",	"GDX",	"SGDJ",	"ETHU",	"SILJ",	"GOAU",	"EETH",	"DAPP",	"SETM"};
			   
			   
			   Triple<Long, Long, String[]> triple = ArrayUtil.sliceCount(String[]::new, symbols, -1);
			   long expected = 1;
			   long actual = triple.item2;
			   ArrayUtil.print(ArrayUtil.class, triple.item3);
			   assertEquals(expected, actual);

			}
	       @Test void t5() {
		   		
			   String[]  symbols= {"WGMI",	"NUGT",	"JNUG",	"GDXJ",	"RING",	"SIL",	"SLVP",
					              "STCE",	"SGDM",	"GDX",	"SGDJ",	"ETHU",	"SILJ",	"GOAU",	"EETH",	"DAPP",	"SETM"};
			   
			   
			   Triple<Long, Long, String[]> triple = ArrayUtil.sliceCount(String[]::new, symbols, -3);
			   long expected = 3;
			   long actual = triple.item2;
			   ArrayUtil.print(ArrayUtil.class, triple.item3);
			   assertEquals(expected, actual);

			}
	       @Test void t6() {
		   		
			   String[]  symbols= {"WGMI",	"NUGT",	"JNUG",	"GDXJ",	"RING",	"SIL",	"SLVP",
					              "STCE",	"SGDM",	"GDX",	"SGDJ",	"ETHU",	"SILJ",	"GOAU",	"EETH",	"DAPP",	"SETM"};
			   
			   
			   Triple<Long, Long, String[]> triple = ArrayUtil.sliceCount(String[]::new, symbols, -7);
			   long expected = 7;
			   long actual = triple.item2;
			   ArrayUtil.print(ArrayUtil.class, triple.item3);
			   assertEquals(expected, actual);

			}
	       
	       @Test void t7() {
		   		
			   String[]  symbols= {"WGMI",	"NUGT",	"JNUG",	"GDXJ",	"RING",	"SIL",	"SLVP",
					              "STCE",	"SGDM",	"GDX",	"SGDJ",	"ETHU",	"SILJ",	"GOAU",	"EETH",	"DAPP",	"SETM"};
			   
			   
			   Triple<Long, Long, String[]> triple = ArrayUtil.sliceCount(String[]::new, symbols, -9999);
			   long expected = symbols.length;
			   long actual = triple.item2;
			   ArrayUtil.print(ArrayUtil.class, triple.item3);
			   assertEquals(expected, actual);

			}
	       
	       
}
