package com.dsa.ds18greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _02ActivitySelection {
    static class Activity{
        int start;
        int finish;
        public Activity(int start,int finish){
            this.start = start;
            this.finish = finish;
        }
    }

    public static List<Activity> getMaxActivity(Activity[] activities){
        List<Activity> result = new ArrayList<>();
        Arrays.sort(activities, Comparator.comparingInt(a->a.finish));
        int finish = activities[0].finish;

        result.add(activities[0]);

        for (int i = 1 ; i < activities.length ; i++){
            if (activities[i].start >= finish){
                result.add(activities[i]);
                finish = activities[i].finish;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Activity[] input = {
                new Activity(12, 25),
                new Activity(10, 20),
                new Activity(20, 30)
        };

        List<Activity> result = getMaxActivity(input);

        for (Activity activity : result){
            System.out.println(activity.start +"  "+activity.finish);
        }

    }
}
