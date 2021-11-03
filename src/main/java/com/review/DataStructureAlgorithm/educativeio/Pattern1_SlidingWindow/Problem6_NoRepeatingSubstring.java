package com.review.DataStructureAlgorithm.educativeio.Pattern1_SlidingWindow;

/*
Given a string, find the length of the longest substring which has no repeating characters.

Example 1:

Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".
Example 2:

Input: String="babbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".
 */

import java.util.HashMap;
import java.util.Map;

public class Problem6_NoRepeatingSubstring {
    private static Object HashMap;

    public static void main(String args[]) {
//        String inputString ="araaci";
//        int result = longestSubstringWithDistinctCharacters(inputString);
//        System.out.println(result);
//
//        String inputString1 ="abbbb";
//        int result1 = longestSubstringWithDistinctCharacters(inputString1);
//        System.out.println(result1);

        String inputString2 ="abbbb";
        int result2 = longestSubstringWithDistinctCharacters1(inputString2);
        System.out.println(result2);




    }

    static int longestSubstringWithDistinctCharacters(String inputstr){
        int lengthOfLongestSubstringWithDistinctCharacters = 0;
        Map<Character, Integer> characterMap = new HashMap<Character, Integer>();

        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < inputstr.length(); windowEnd++ ){
            char rightChar = inputstr.charAt(windowEnd);
            characterMap.put(rightChar, characterMap.getOrDefault(rightChar, 0) + 1);

            while(characterMap.get(rightChar) > 1){
                char leftChar = inputstr.charAt(windowStart);
                characterMap.put(leftChar,characterMap.get(leftChar) -1);

                if(characterMap.get(leftChar) == 0) {
                    characterMap.remove(leftChar);
                }
                windowStart++;
            }

            lengthOfLongestSubstringWithDistinctCharacters = Math.max(lengthOfLongestSubstringWithDistinctCharacters, windowEnd - windowStart +1);
        }
        return lengthOfLongestSubstringWithDistinctCharacters;
    }

    static int longestSubstringWithDistinctCharacters1(String inputstr){
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < inputstr.length(); windowEnd++) {
            char rightChar = inputstr.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }
}
