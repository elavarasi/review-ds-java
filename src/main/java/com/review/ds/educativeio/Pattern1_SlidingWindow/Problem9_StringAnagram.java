package com.review.ds.educativeio.Pattern1_SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 *
 * Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:
 *
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 *
 * Example 1:
 *
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 */
public class Problem9_StringAnagram {

    public static void main(String args[]) {
        String input = "ppqp";
        String pattern = "pq";
        List<Integer> result = new ArrayList<Integer>();
        result = findStringAnagram(input, pattern);
        System.out.println(result);

        String input1 = "abbcabc";
        String pattern1 = "abc";
        List<Integer> result1 = new ArrayList<Integer>();
        result1 = findStringAnagram(input1, pattern1);
        System.out.println(result1);
    }


    private static List<Integer> findStringAnagram(String input, String pattern) {
        List<Integer> result = new ArrayList<Integer>();

        Map<Character, Integer> patternMap = new HashMap<Character, Integer>();
        for (char c : pattern.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0)+1);
        }

        int windowStart = 0; int matched = 0;
        for(int windowEnd=0; windowEnd < input.length(); windowEnd++) {
            char rightChar = input.charAt(windowStart);

            // decrement the frequency of the matched character
            if(patternMap.containsKey(rightChar)) {
                patternMap.put(rightChar, patternMap.get(rightChar)-1);
                if(patternMap.get(rightChar) == 0) { //completely matched
                    matched++;
                }
            }

            if(matched == patternMap.size()) { //have we found an anagram
                result.add(windowStart);
            }

            if(windowEnd >= pattern.length() -1) {  // shrink the window
                char leftChar = input.charAt(windowStart++);
                if(patternMap.containsKey(leftChar)) {
                    if(patternMap.get(leftChar) == 0) {
                        matched--; // before putting the character back, decrement the matched count
                    }
                    // put the character back
                    patternMap.put(leftChar, patternMap.get(leftChar) + 1);
                }
            }
        }

        return result;
    }
}

