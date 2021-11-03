package com.review.DataStructureAlgorithm.educativeio.Pattern9_TwoHeap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
    Given an array of numbers and a number ‘k’, find the median of all the ‘k’ sized sub-arrays (or windows) of the array.
 */
public class SlidingWindowMedian {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String args[]) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double result[] = slidingWindowMedian.findSlidingWindowMedian(new int[] {1,2,-1,3,5}, 2);

        for (double eachNum : result) {
            System.out.println(eachNum);
        }

    }

    private double[] findSlidingWindowMedian(int[] nums, int i) {
        double result[] = new double[nums.length - i + 1];

        for (int j = 0; j < nums.length; j++) {
            if (maxHeap.isEmpty() || nums[j] <= maxHeap.peek()) {
                maxHeap.add(nums[j]);
            } else {
                minHeap.add(nums[j]);
            }

            rebalanceHeap();

            if ( j - i + 1 >= 0) {
                if (maxHeap.size() == minHeap.size()) {
                    result[j - i + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else {
                    result[j - i + 1] = maxHeap.peek();
                }

            int elementToBeRemoved = nums[j-i+1];
            if (elementToBeRemoved <= maxHeap.peek()) {
                maxHeap.remove(elementToBeRemoved);
            } else {
                minHeap.remove(elementToBeRemoved);
            }

            }
        }
        return result;
    }

    private void rebalanceHeap() {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        }
    }
}
