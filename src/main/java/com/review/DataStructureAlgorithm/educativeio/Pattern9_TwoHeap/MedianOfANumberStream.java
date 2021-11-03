package com.review.DataStructureAlgorithm.educativeio.Pattern9_TwoHeap;

/*
Design a class to calculate the median of a number stream. The class should have the following two methods:

insertNum(int num): stores the number in the class
findMedian(): returns the median of all numbers inserted in the class
If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.

*/

import java.util.PriorityQueue;

public class MedianOfANumberStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    MedianOfANumberStream() {
        maxHeap = new PriorityQueue<Integer>((a,b) -> b - a );
        minHeap = new PriorityQueue<Integer>((a,b) -> a - b );
    }

    public void insertNum(int num) {
        // Insert into the right heap.
        if (maxHeap.size() == 0 || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // If Max heap size is not equal to min heap or not equal to min heap size + 1 then move from max heap to min heap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add((minHeap.poll()));
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        return  maxHeap.peek();
    }

    public static void main(String args[]) {
        MedianOfANumberStream medianOfAStream = new MedianOfANumberStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is " + medianOfAStream.findMedian());
    }
}
