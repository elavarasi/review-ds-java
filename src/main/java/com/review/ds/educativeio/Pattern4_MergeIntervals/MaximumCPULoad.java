package com.review.ds.educativeio.Pattern4_MergeIntervals;
/*
We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running. Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.

Example 1:

Jobs: [[1,4,3], [2,5,4], [7,9,6]]
Output: 7
Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
jobs are running at the same time i.e., during the time interval (2,4).
 */

import java.util.*;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};


public class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        if(jobs.isEmpty() || jobs == null) {
            return 0;
        }
        // Sort the jobs by start time
        Collections.sort(jobs, (a,b) -> Integer.compare(a.start, b.start));

        // Create a priority queue to queue based on job end time.
        PriorityQueue<Job> jobPriorityQueue = new PriorityQueue<>(jobs.size(), (a,b) -> Integer.compare(a.end, b.end));

        int maximumCPULoad = 0;
        int currentCPULoad = 0;
        // For each job, first remove existing jos that end before this job from queue and then add the new job. Find CPU load.
        for(Job eachJob: jobs) {
            while(!jobPriorityQueue.isEmpty() && jobPriorityQueue.peek().end < eachJob.start) {
                currentCPULoad = currentCPULoad - jobPriorityQueue.peek().cpuLoad;
                jobPriorityQueue.poll();
            }
            currentCPULoad = currentCPULoad + eachJob.cpuLoad;
            jobPriorityQueue.add(eachJob);
            maximumCPULoad = Math.max(maximumCPULoad, currentCPULoad);
        }
        return maximumCPULoad;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}
