package com.review.educativeio.dynamicProgramming;

class LongestPalindromeSubstringDP {

    public static void main(String args[]) {
        //String s = "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg";
        //String s = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        String s = "uzhynqvopdbnkvuxizirzjsslptlhmvyfqhqvqffmqldkrrdwapbdcxqbchvxqixmvbbtalrgzvkobyxlkonkfknabjwzeoazankqzuhexhcwkbvwtioubrcujqqeqoedhploqklhgeilwwnndbnzeadzefkcvaxdhgnmocadvvzjocoweyoidhleuwhmavpdiizbwkukpstyorlwwyiwwyyyzqqgipzzlxsgcdjscdfvrrrqmllbdjkkuisxeqaprfblvjuixajhucmcvffmevaztvadrujbthlnsdrxzvbldwxbazxmilpkbccigkihcgjbtpvignmrgzdqnufaacxtihfgwrllrwgfhitxcaafunqdzgrmngivptbjgchikgiccbkplimxzabxwdlbvzxrdsnlhtbjurdavtzavemffvcmcuhjaxiujvlbfrpaqexsiukkjdbllmqrrrvfdcsjdcgsxlzzpigqqzyyywwiywwlroytspkukwbziidpvamhwuelhdioyewocojzvvdacomnghdxavckfezdaeznbdnnwwlieghlkqolphdeoqeqqjucrbuoitwvbkwchxehuzqknazaoezwjbankfknoklxybokvzgrlatbbvmxiqxvhcbqxcdbpawdrrkdlqmffqvqhqfyvmhltplssjzrizixuvknbdpovqnyhzu";
//        String s = "zzzz";
//        String s = "babad";
//        String s = "cbbd";
//        String s = "a";
//        String s = "ac";

//        System.out.println(longestPalindrome(s));

        int[] result = findLPSBottomUp(s);
        System.out.println(s.substring(result[0], result[1]+1));

    }

    public static String longestPalindrome(String s) {
        return LPS(s);
    }

    private static String LPS(String s) {
        int[][] dp[] = new int[s.length()][s.length()][3];
        int[] lps = findLPS(s, 0, s.length()-1, dp);
        return s.substring(lps[0], lps[1] + 1);
    }

    private static int[] findLPS(String s, int startIndex, int endIndex, int[][][] dp) {

        int[] lpsInfo = new int[3];

        if (startIndex == endIndex)  {
            lpsInfo[0] = startIndex;
            lpsInfo[1] = endIndex;
            lpsInfo[2] = 1;
            return lpsInfo;
        }

        if (startIndex > endIndex)  {
            return lpsInfo;
        }


        if (dp[startIndex][endIndex][2] == 0) {
            // If first and last character match, find if remaining of the substring is a palindrome and take the length
            if (s.charAt(startIndex) == s.charAt(endIndex)) {
                int[] LPSOfRemaining = findLPS(s, startIndex + 1, endIndex -1, dp);
                if (LPSOfRemaining[2] == (endIndex-1) - (startIndex + 1) + 1) {
                    if (lpsInfo[2] < 2 + ((endIndex-1) - (startIndex + 1) + 1)) {
                        lpsInfo[0] = startIndex;
                        lpsInfo[1] = endIndex;
                        lpsInfo[2] = 2 + ((endIndex-1) - (startIndex + 1) + 1);
                        // return lpsInfo;
                        dp[startIndex][endIndex] = lpsInfo;
                    }
                }
            }

            int[] LPSOfRemainingSkipStart = findLPS(s, startIndex + 1, endIndex, dp);
            int[] LPSOfRemainingSkipEnd = findLPS(s, startIndex, endIndex - 1, dp);

            if (LPSOfRemainingSkipStart[2] > lpsInfo[2]) {
                lpsInfo[0] = LPSOfRemainingSkipStart[0];
                lpsInfo[1] = LPSOfRemainingSkipStart[1];
                lpsInfo[2] = LPSOfRemainingSkipStart[2];
            }

            if (LPSOfRemainingSkipEnd[2] > lpsInfo[2]) {
                lpsInfo[0] = LPSOfRemainingSkipEnd[0];
                lpsInfo[1] = LPSOfRemainingSkipEnd[1];
                lpsInfo[2] = LPSOfRemainingSkipEnd[2];
            }
            dp[startIndex][endIndex] = lpsInfo;

        }

        return dp[startIndex][endIndex];
    }



    private static int[] findLPSBottomUp(String s) {
        int[][] dp[] = new int[s.length()][s.length()][3];

        for (int i = 0; i < s.length(); i++) {
                int[] data = new int[3];
                data[0] = i;
                data[1] = i;
                data[2] = 1;
                dp[i][i] = data;
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                int[] lps = new int[3];

                if (s.charAt(i) == s.charAt(j)) {
                    int[] LPSOfRemaining = dp[i + 1][j - 1];
                    if (LPSOfRemaining[2] == (j - 1) - (i + 1) + 1) {
                        lps[0] = i;
                        lps[1] = j;
                        lps[2] = 2 + ((j - 1) - (i + 1) + 1);
                        dp[i][j] = lps;
                        continue;
                    }
                }

                int[] LPSOfRemainingSkipStart = dp[i + 1][j];
                int[] LPSOfRemainingSkipEnd = dp[i][j - 1];

                if (LPSOfRemainingSkipStart[2] > lps[2]) {
                    lps[0] = LPSOfRemainingSkipStart[0];
                    lps[1] = LPSOfRemainingSkipStart[1];
                    lps[2] = LPSOfRemainingSkipStart[2];
                }

                if (LPSOfRemainingSkipEnd[2] > lps[2]) {
                    lps[0] = LPSOfRemainingSkipEnd[0];
                    lps[1] = LPSOfRemainingSkipEnd[1];
                    lps[2] = LPSOfRemainingSkipEnd[2];
                }
                dp[i][j] = lps;

            }
        }

        return dp[0][s.length()-1];
    }
}