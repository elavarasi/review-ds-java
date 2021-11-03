package com.review.DataStructureAlgorithm.leetcode.tree.dp.wordbreak;

import java.util.*;

/** Amazon question
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */


public class workbreak1 {
    public static void main(String []args)
    {

        // array of strings to be added in dictionary set.
        List<String> temp_dictionary = new ArrayList<>(Arrays. asList("leet","code"));

        HashMap<String, Boolean> memo = new HashMap<>();
        // sample input cases
        System.out.println(wordBreak("leetcode", temp_dictionary, memo));

    }


    public static boolean wordBreak(String s, List<String> wordDict, HashMap<String, Boolean> memo) {
        // HashMap of wordDict
        Set<String> wordDictionary = new HashSet<String>();
        for (int i = 0; i < wordDict.size(); i++) {
            wordDictionary.add(wordDict.get(i));
        }

        return isWordBreakable(s, wordDictionary, memo);
    }

    public static boolean isWordBreakable(String s, Set<String> wordDict, HashMap<String, Boolean> memo) {
        if(s.length() == 0) {
            return true;
        }

        for (int i = 1; i <= s.length(); i++) {

            String rest = s.substring(i, s.length());
            if (memo.containsKey(rest)) {
                if (wordDict.contains(s.substring(0, i)) && memo.get(rest)) {
                    return true;
                }
            }  else  {
                boolean isRestOfWordBreakable = isWordBreakable(rest, wordDict, memo);
                memo.put(rest, isRestOfWordBreakable);
                if (wordDict.contains(s.substring(0, i)) && isRestOfWordBreakable) {
                    return true;
                }
            }
        }

        return false;

    }

}
