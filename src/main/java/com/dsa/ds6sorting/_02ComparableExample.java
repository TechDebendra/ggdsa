package com.dsa.ds6sorting;

import java.util.*;

public class _02ComparableExample {

    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(2,7));
        list.add(new Point(1,5));
        list.add(new Point(8,5));

        for (Point p: list){
            System.out.println(p.x+" "+p.y);
        }

        Collections.sort(list);

        System.out.println("After sorting....");
        for (Point p: list){
            System.out.println(p.x+" "+p.y);
        }
    }


     static class Point implements Comparable<Point>{
        int x;
        int y;
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }

         @Override
         public int compareTo(Point p) {
             return this.x-p.x;
         }
     }
}
