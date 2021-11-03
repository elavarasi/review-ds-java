package com.review.DataStructureAlgorithm.educativeio.Strings;

public class Reverse {

        public static void main(String args[]) {
            char[] input = "World Hello".toCharArray();
            System.out.println(input);
            reverseWords(input);
            System.out.println(input);
        }

        public static void reverseWords (char[] sentence) {
            System.out.println(sentence);

            char[] temp = new char[sentence.length];

            for (int i = 0; i < sentence.length; i++) {
                temp[i] = sentence[i];
            }
            System.out.println(temp);
            System.out.println(temp.length);

            int wordStartPointer = temp.length - 1;
            int wordEndPointer = temp.length - 1;
            int sentencePointer = 0;

            System.out.println(wordStartPointer);
            System.out.println(wordEndPointer);

            while (wordStartPointer >= 0) {
                while (wordStartPointer >= 0 && temp[wordStartPointer] != ' ') {
                    wordStartPointer--;
                }

                // Reached a word beginning - now put this word in the sentence
                System.out.println(wordStartPointer);
                System.out.println(wordEndPointer);
                for (int i = wordStartPointer + 1; i <= wordEndPointer; i++) {
                    sentence[sentencePointer++] = temp[i];
                }

                while (wordStartPointer >= 0 && temp[wordStartPointer] == ' ') {
                    sentence[sentencePointer++] = ' ';
                    wordStartPointer--;
                }

                wordEndPointer = wordStartPointer;
            }
        }

}
