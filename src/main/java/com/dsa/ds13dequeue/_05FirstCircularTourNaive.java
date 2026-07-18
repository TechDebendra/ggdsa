package com.dsa.ds13dequeue;

public class _05FirstCircularTourNaive {

    public static void main(String[] args) {
        int[] petrol = {4,8,7,4};
        int[] dist = {6,5,3,5};
        System.out.println(firstCircularTour(petrol,dist));
    }

    public static int firstCircularTour(int[] petrol, int[] dist){
        if ( petrol == null
                || petrol.length == 0
                || dist == null
                || dist.length == 0
                || dist.length != petrol.length
        ){
            throw new IllegalArgumentException("Invalid Input!");
        }

        int n = petrol.length;


        for (int start = 0 ; start<n ;start++){
            int currentPetrol = 0;
            int end = start;

            while (true){
                currentPetrol += petrol[end] - dist[end];
                if (currentPetrol < 0){
                    break;
                }
                end = (end + 1)%n;
                if (start == end){
                    return start + 1;
                }
            }
        }

        return -1;
    }
}
