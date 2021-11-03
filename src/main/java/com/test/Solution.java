package com.test;

public class Solution {
    public static void main(String[] args) {
        int[] input = { 2,2,2,2,4,4,4,9,9,9 };

        // O(n)  { 2=> 4, 4 => 3, 9 => 3 };
        int n = 9;
        int positionOf9 = findPositionOfN(input, n); // Time O(n log n) / space O(1)
        int count9s = countGivenNumber(input, positionOf9, n); // O(count) // worst O(n)
        System.out.println(count9s);
    }


    public static int findPositionOfN(int[] input, int n) {
        int positionOfn = -1;
        int left = 0;
        int right = input.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (input[mid] == n) {
                positionOfn = mid;
                break;
            } else if (input[mid] < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return positionOfn;
    }

    public static int countGivenNumber(int[] input, int position, int n) {
        int count = 0;
        int left = position - 1;
        int right = position;

        while (left >=0 && input[left] == n) {
            count ++;
            left --;
        }

        while (right < input.length && input[right] == n) {
            count ++;
            right ++;
        }

        return count;
    }
}
