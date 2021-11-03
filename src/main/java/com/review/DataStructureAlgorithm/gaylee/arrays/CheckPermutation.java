package com.review.DataStructureAlgorithm.gaylee.arrays;

import java.util.*;


/*
 * 
 * Given two strings write a method to decide if one is a permutation of the other:
 * 
 * 
 * Pseudocode
 * string1 = "ELA", 
 * string2= "ALGAE"
 * 
 * traverse string 1 and set boolen array chars
 * traverse string 2 and if not set then flag
 * 
 * 
 */
public class CheckPermutation {
	
	public static void main(String args[]){
		String str1 = "ela";
		String str2 = "ale";
		
		Set set = new HashSet<>();
		str1 = sort(str1);
		str2 = sort(str2);

		List<Integer> jobs = new ArrayList<Integer>((a, b) -> a.start - b.start);
		System.out.println(isPermutation(str1,str2));
	}
	
	
	static String sort(String s) {	
		
		char[] characters = s.toCharArray();
		Arrays.sort(characters);
		System.out.println(characters);
		return new String(characters);
		
	}



	public static boolean isPermutation(String str1,String str2){
//		System.out.println(str1);
//		System.out.println(str2);
		if(str1.length() != str2.length()){

			return false;
		}
		
		return str1.equals(str2);
		
	}

	

}
