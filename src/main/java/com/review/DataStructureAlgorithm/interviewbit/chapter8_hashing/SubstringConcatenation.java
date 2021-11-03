/**
You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).
 */

package com.review.DataStructureAlgorithm.interviewbit.chapter8_hashing;

import java.util.ArrayList;
import java.util.List;

public class SubstringConcatenation {
	
	public static void main(String args[]) {
		SubstringConcatenation obj1 = new SubstringConcatenation();
		List inputList = new ArrayList();
		inputList.add("ela");
		inputList.add("isa");
		inputList.add("grl");			
		obj1.findSubstring("thiselaisgoodgirl", inputList);
		
	}
	
	
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
    	int eachWordLength = 0;
    	long expectedHash = 0;
    	ArrayList result = new ArrayList<Integer>();
    	
    	// Find hash of all strings in input List
    	for(int i=0; i< B.size(); i++) {    		
       		expectedHash = expectedHash + B.get(i).hashCode();
    		System.out.println(expectedHash);	
    		eachWordLength = B.get(i).length();
    	}
    	
    	System.out.println(eachWordLength);
    	System.out.println(expectedHash);	
    	
    	// iterate over A and get substring from each index and check its hash.
    	// If the hash at an index is same as expected hash then add to the output List
    	int pointer = 0;
    	int currentHash = 0;
    	
    	//IF total length of A is less than all the words * each word length then return empty arraylist
    	if (A.length() < (B.size() * eachWordLength)) {
    		return result;
    	} else {
        	while (pointer < A.length()) {
        		int beginningIndex = pointer;
        		if(beginningIndex + B.size() * eachWordLength > A.length()) {
        			return result;
        		} else {
        
                	for (int endIndex = pointer; endIndex < A.length(); ) {      		  
                		  System.out.println(A.charAt(endIndex));
                		  System.out.println(A.substring(beginningIndex, beginningIndex + eachWordLength));
                		  currentHash = currentHash + A.substring(beginningIndex, beginningIndex + eachWordLength).hashCode();
                		  System.out.println(currentHash);
                		  endIndex = endIndex + eachWordLength;
                		  
                        if(currentHash == expectedHash) {
                      	  result.add(beginningIndex); 
                      	  beginningIndex = endIndex;
                        } if(currentHash > expectedHash) {
                        	beginningIndex = endIndex;pointer ++;
                      	  break;
                        } else {
                      	  continue;
                        }                  		  
                  	}
        		}
            	pointer++;
        	}    		
    	}    	


    	System.out.println(result);
    	
    	//return the Output list of indexes
		return null;
    }

}
