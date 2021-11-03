package com.review.educativeio.dynamicProgramming;

class LPS {
    public static int findLPS (String s, int start, int end) {

        // Base case
        if (start > end) {
            return 0;
        }

        if (start == end) {
        return 1;
        }

        if (s.charAt(start) == s.charAt(end)) {
            return 2 + findLPS(s, start+1, end-1);
        } else {
            return Math.max(findLPS (s, start + 1, end), findLPS (s, start, end-1));
        }

    }

    public static void main(String args[]) {
        String input = "abdbca";
        System.out.println(findLPS(input, 0, input.length()-1));
    }

}

