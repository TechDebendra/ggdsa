package com.dsa.ds13dequeue;

public class _05FirstCircularTourSingleLoop {

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
        int start = 0;
        int currentPetrol = 0;
        int prevPetrol = 0;


        for (int i = 0 ; i<n ;i++){
             currentPetrol += petrol[i] - dist[i];
             if (currentPetrol < 0){
                 prevPetrol += currentPetrol;
                 currentPetrol = 0;
                 start = i+1;
             }
        }

        return (currentPetrol + prevPetrol >= 0)? start+1 : -1;
    }
}
