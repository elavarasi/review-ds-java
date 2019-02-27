package com.review.ds.interviewbit.chapter8_hashing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {
	public static void main(String args[]) throws FileNotFoundException, IOException{
		String[] A = {"cat","dog","god","tca"};
		System.out.println(A);
		ArrayList<Number>[] result = anagrams(A);
		System.out.println(result);
	}
	
    public static ArrayList<Number>[] anagrams(final String[] A) {
    	Integer result[][] = new Integer[A.length][A.length];
    	ArrayList<Number>[] group = (ArrayList<Number>[])new ArrayList[4];
    	HashMap<Number, List<Number>> map = new HashMap<Number, List<Number>>();
    	for(int i=0; i<A.length; i++) {
    		System.out.println(A[i].hashCode());
    		char[] letters = A[i].toCharArray();
    		Arrays.sort(letters);
    		String newWord = new String(letters); 
    		if(map.containsKey(newWord.hashCode())) {
    			List<Number> positions = map.get(newWord.hashCode());
    			positions.add(i);
    			map.put(newWord.hashCode(), positions);
    		} else {
      			List<Number> positions = new ArrayList<Number>();
    			positions.add(i+1);
    			map.put(newWord.hashCode(), positions);	
    		}
    	}
    	
    	int j = 0;
    	for(Number i: map.keySet()){
    		ArrayList<Number> positions = (ArrayList<Number>) map.get(i);
    		if(positions.size()>1){
    			System.out.println(positions);    			
    			group[0] = positions;
    			j++;
    		}
    	}
    	
		return group;
		
    }
}
