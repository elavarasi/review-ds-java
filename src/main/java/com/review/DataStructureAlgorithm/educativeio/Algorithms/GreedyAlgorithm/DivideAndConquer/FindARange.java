package com.review.DataStructureAlgorithm.educativeio.Algorithms.GreedyAlgorithm.DivideAndConquer;

public class FindARange {

    public static void main(String args[]) {
//        int[] input = new int[] {5,7,7,8,8,10};
//        int target = 8;

        int[] input = new int[] {1};
        int target = 1;

        int[] result = searchRange(input, target);
        System.out.println(result[0] +  "    "  + result[1]);
    }

    public static int[] searchRange(int[] nums, int target) {

        int[] result = new int[] {-1, -1};

        // Search for the given target using binary search O(log n)
        int foundIndex = searchTarget(nums, 0, nums.length-1, target);

        if (foundIndex > -1) {
            // If target was found then find the start and end by going right and left

            int startIndex = foundIndex;
            int endIndex = foundIndex;

            // Find start index
            while (startIndex > 0 && nums[startIndex - 1] == target) {
                startIndex --;
            }

            // Find end index
            while (endIndex < nums.length-1 && nums[endIndex + 1] == target) {
                endIndex ++;
            }

            result[0] = startIndex;
            result[1] = endIndex;
        }

        return result;
    }

    public static int searchTarget(int[] nums, int left, int right, int target) {
        int mid = (left + right) / 2;
        int index = -1;

        if (right < left) {
            return index;
        }

        if (nums[mid] == target) {
            return mid;
        }


        if (nums[mid] > target) {
            index = searchTarget(nums, left, mid - 1, target);
        } else {
            index = searchTarget(nums, mid + 1, right, target);
        }

        return index;
    }
}
