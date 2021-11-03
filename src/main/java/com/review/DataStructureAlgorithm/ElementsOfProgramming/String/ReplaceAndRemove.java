package com.review.DataStructureAlgorithm.ElementsOfProgramming.String;

// Need to fix
// Replace a by 2 d and delete each entry containing b
public class ReplaceAndRemove {
    public static void main(String[] args) {

        // char[] input = new char[] {'a', 'c', 'd', 'b', 'b', 'c', 'a'};

        // Corner cases
//        char[] input = new char[] {'b', 'b', 'c', 'a', 'a'};
        char[] input = new char[] {'b', 'b', 'j'};

        replaceAndRemove(input);
    }

    public static void replaceAndRemove(char[] input) {
        // First remove all b
        for (int i = 0; i < input.length;) {
            if (input[i] == 'b') {
                for (int j = i + 1; j < input.length; j++) {
                    input[j-1] = input[j];
                }
            } else {
                i++;
            }
        }


        // Now replace all a by 2 d
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 'a') {
                if (i < input.length-1) {
                    input[i] = 'd';
                    char temp = input[i+1];
                    input[i+1] = 'd';

                    int j = i + 2;
                    while (j < input.length) {
                        char currentTemp = input[j];
                        input[j] = temp;
                        temp = currentTemp;
                        j++;
                    }
                }
            }
        }

        System.out.println(input);
    }
}
