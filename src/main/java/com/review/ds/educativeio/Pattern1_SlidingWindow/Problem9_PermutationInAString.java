package com.review.ds.educativeio.Pattern1_SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem9_PermutationInAString {

    public static void main(String args[]) {
//        String input = "oidbcaf";
//        String pattern = "abc";
//        boolean isFound = foundPermutationInAString(input, pattern);
//        System.out.println(isFound);
//
//        String input1 = "odicf";
//        String pattern1 = "dc";
//        boolean isFound1 = foundPermutationInAString(input1, pattern1);
//        System.out.println(isFound1);
//
//        String input2 = "bcdxabcdy";
//        String pattern2 = "bcdyabcdx";
//        boolean isFound2 = foundPermutationInAString(input2, pattern2);
//        System.out.println(isFound2);
//
//        String input3 = "aaacb";
//        String pattern3 = "abc";
//        boolean isFound3 = foundPermutationInAString(input3, pattern3);
//        System.out.println(isFound3);




//        String input = "oidbcaf";
//        String pattern = "abc";
//        boolean isFound = findPermutation(input, pattern);
//        System.out.println(isFound);

        String input1 = "odicf";
        String pattern1 = "dc";
        boolean isFound1 = findPermutation(input1, pattern1);
        System.out.println(isFound1);

//        String input2 = "bcdxabcdy";
//        String pattern2 = "bcdyabcdx";
//        boolean isFound2 = findPermutation(input2, pattern2);
//        System.out.println(isFound2);
//
//        String input3 = "aaacb";
//        String pattern3 = "abc";
//        boolean isFound3 = findPermutation(input3, pattern3);
//        System.out.println(isFound3);

    }

    private static boolean foundPermutationInAString(String input, String pattern) {

        boolean isFound = false;
        Map<Character, Integer> patternMap = new HashMap<Character, Integer>();

        for (char c : pattern.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0)+1);
        }

        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            if(patternMap.get(input.charAt(windowEnd)) != null && patternMap.get(input.charAt(windowEnd)) > 0){
                patternMap.put(input.charAt(windowEnd), (patternMap.get(input.charAt(windowEnd))-1));
                if(windowEnd - windowStart + 1 == pattern.length()) {
                    return true;
                }
            } else {
                while(windowStart <= windowEnd) {
                    if(patternMap.get(input.charAt(windowStart)) != null) {
                        patternMap.put(input.charAt(windowStart), input.charAt(windowStart)+ 1);
                    }
                    windowStart ++;
                }


            }
        }
        return false;
    }

    public static boolean findPermutation(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        // our goal is to match all the characters from the 'charFrequencyMap' with the current window
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
                    matched++;
            }

            if (matched == charFrequencyMap.size())
                return true;

            if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count
                    // put the character back for matching
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return false;
    }

}
