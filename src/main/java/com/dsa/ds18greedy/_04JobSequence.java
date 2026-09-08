package com.dsa.ds18greedy;

import java.util.Arrays;

public class _04JobSequence {
    static class Job{
        char id;
        int deadline;
        int profit;
        public Job(char id,int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static int maxProfit(Job[] jobs){
        int maxProfit = 0;

        Arrays.sort(jobs,(a,b)->b.profit-a.profit);

        int maxDeadline = 0 ;

        for (Job job : jobs){
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        boolean[] slot = new boolean[maxDeadline];

        for (Job job : jobs){

            for (int j = job.deadline-1 ; j >= 0; j--){
                if (!slot[j]){
                    slot[j] = true;
                    maxProfit += job.profit;
                    break;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Job jobs[] = {new Job('a', 2, 100),
                new Job('b', 1, 19),
                new Job('c', 2, 27),
                new Job('d', 1, 25),
                new Job('e', 3, 15)};

        int maxProfit = maxProfit(jobs);
        System.out.println("Max profit : "+maxProfit);
    }
}
