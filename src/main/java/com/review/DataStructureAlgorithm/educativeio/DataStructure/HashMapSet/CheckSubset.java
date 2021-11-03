package com.review.DataStructureAlgorithm.educativeio.DataStructure.HashMapSet;

import java.util.HashSet;
import java.util.Set;

//Hash Set  =>  HashSet<Integer> hSet = new HashSet<>();
//HashMap   =>  HashMap<Integer,String> hMap = new HashMap<>();
//HashTable =>  Hashtable<Integer,String> hTable = new Hashtable<>();
//Hash Set Functions => {add(), remove(), contains()}
//Hash Map and Table Functions => {put(key,value), get(key), remove(key), containsKey(key), containsValue(value)}
class CheckSubset {
    public static void main(String args[]) {
        int[] arr1 = {9, 4, 7, 1, -2, 6, 5};
        int[] arr2 = {7, 1, -2};
        int[] arr3 = {10, 12};

        System.out.println(isSubset(arr1, arr2));
        System.out.println(isSubset(arr1, arr3));
    }

    public static boolean isSubset(int[] arr1, int[] arr2) {
        int[] longestArray = arr1.length > arr2.length ? arr1 : arr2;
        int[] shorterArray = arr1.length < arr2.length ? arr1 : arr2;

        // Set can hold values - as no duplicate we can store value in set
        Set<Integer> set = new HashSet<Integer>();
        for (int eachItem : longestArray) {
            set.add(eachItem);
        }

        for (int i = 0; i < shorterArray.length; i++) {
            if (!set.contains(shorterArray[i])) {
                return false;
            }
        }
        return true;
    }
}
