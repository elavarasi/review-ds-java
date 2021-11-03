package com.review.DataStructureAlgorithm.gaylee.recursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface Problem_Parens {

    public static void main(String args[]) {
        int n = 3;
        List<String> result = new ArrayList<String>();

        System.out.println(findParens(n));
    }


    public static Set<String> findParens(int n) {
        Set<String> set = new HashSet<>();
        // base condition
        if (n == 0) {
            set.add("");
            return set;
        } else {
            // find Perms for n-1 and then place a paren after all open braces and one at the beginning
            Set<String> prev = findParens(n-1);

            // for each Prev perm insert paren after left branch
            for (String eachPrev : prev) {
                for (int i = 0; i < eachPrev.length(); i++) {
                    if(eachPrev.charAt(i) == '(') {
                        String str = insertParens(eachPrev, i);
                        set.add(str);
                    }
                }
                set.add("()" + eachPrev);
            }
            return set;
        }

    }

    public static String insertParens(String str, int index) {
        String left = str.substring(0, index+1);
        String right = str.substring(index+1, str.length());
        return left + "()" + right;
    }


}
