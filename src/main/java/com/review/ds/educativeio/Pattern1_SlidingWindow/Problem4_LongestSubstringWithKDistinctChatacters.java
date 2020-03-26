package com.review.ds.educativeio.Pattern1_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement #
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * Example 1:
 *
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 *
 * Example 2:
 *
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 *
 */
public class Problem4_LongestSubstringWithKDistinctChatacters {

    public static void main(String args[]) {
        String inputString ="araaci";
        int k = 2;

        int result = longestSubstringWithKDistinctChatacters(k, inputString);
        System.out.println(result);
    }
    public static int longestSubstringWithKDistinctChatacters(int k, String inputString){
        if(inputString.length() ==0 || inputString.length() < k) {
            throw new IllegalArgumentException();
        }

        int longestSubstring = 0;
        int windowStart = 0;
        Map<Character, Integer> distinctCharHashMap = new HashMap<Character, Integer>();

        for(int windowEnd=0; windowEnd < inputString.length(); windowEnd++) {
            char currChar = inputString.charAt(windowEnd);
            distinctCharHashMap.put(currChar, distinctCharHashMap.getOrDefault(currChar,0) + 1);

            while(distinctCharHashMap.size() > k) {
                char windowstartcharacter = inputString.charAt(windowStart);
                distinctCharHashMap.put(windowstartcharacter, distinctCharHashMap.get(windowstartcharacter)-1);
                if(distinctCharHashMap.get(windowstartcharacter) == 0 ) {
                    distinctCharHashMap.remove(windowstartcharacter);
                }
                windowStart ++;
            }

            longestSubstring = Math.max(longestSubstring, windowEnd - windowStart + 1 );
        }
        return longestSubstring;
    }
}
