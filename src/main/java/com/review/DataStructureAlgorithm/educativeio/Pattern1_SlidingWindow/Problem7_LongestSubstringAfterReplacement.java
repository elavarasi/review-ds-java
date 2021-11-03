package com.review.DataStructureAlgorithm.educativeio.Pattern1_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement #
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.
 *
 * Example 1:
 *
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 */


public class Problem7_LongestSubstringAfterReplacement {

    public static void main(String args[]) {
        String input = "aabccbb";
        int k = 2;
        int length = longestSubstringAfterReplacement1(input, k);
        System.out.println(length);

        String input1 = "abbcb";
        int k1 = 1;
        int length1 = longestSubstringAfterReplacement1(input1, k1);
        System.out.println(length1);

        String input2 = "abccde";
        int k2 = 1;
        int length2 = longestSubstringAfterReplacement1(input2, k2);
        System.out.println(length2);

    }

    public static int longestSubstringAfterReplacement(String input, int k) {
        int lengthOfLongestSubstring = 0;
        int windowStart = 0;
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        int replacementCounter = k;
        int counter = 0;

        for(int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            if(charMap.isEmpty()) {
                charMap.put(input.charAt(windowEnd), windowEnd);
            } else {
                // Same character as the one on the map
                if(charMap.get(input.charAt(windowEnd)) != null){
                    charMap.put(input.charAt(windowEnd), windowEnd);
                    lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, windowEnd - windowStart + 1);
                } else {  //new character
                    if(replacementCounter == 0) {
                        lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, windowEnd - windowStart);
                        replacementCounter = k;
                        Map.Entry<Character, Integer> entry = charMap.entrySet().iterator().next();
                        windowStart = entry.getValue() + 1;
                        windowEnd = windowStart - 1;
                        charMap.clear();
                    } else {
                        replacementCounter --;
                    }
                }
            }
            counter ++;
        }
        System.out.println("counter" + counter);
        return lengthOfLongestSubstring;
    }

    public static int longestSubstringAfterReplacement1(String input, int k) {

        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        int maxRepeatingLetterCharacter = 0;
        int counter = 0;

        for(int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char rightChar = input.charAt(windowEnd);
            charMap.put(rightChar, charMap.getOrDefault(rightChar, 0)+1);

            maxRepeatingLetterCharacter = Math.max(maxRepeatingLetterCharacter, charMap.get(rightChar));

            if(windowEnd - windowStart + 1 - maxRepeatingLetterCharacter > k) {
                char leftChar = input.charAt(windowStart);
                charMap.put(leftChar, charMap.get(leftChar)-1);
                windowStart ++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            counter ++;
        }
        System.out.println("Counter" + counter);
        return maxLength;
    }
}