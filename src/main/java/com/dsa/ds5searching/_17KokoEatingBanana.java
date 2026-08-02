package com.dsa.ds5searching;

public class _17KokoEatingBanana {


    public static int minSpeed(int[] piles,int h){
        int low = 1;
        int high = piles[0];

        for (int i : piles){
            high = Math.max(i,high);
        }
        int res=0;

        while (low<=high){
            int mid = low + (high -low)/2;
            if (isEatable(piles,h,mid)){
                res = mid;
                high = mid -1;

            }else {
                low = mid +1;
            }

        }
        return res;
    }

    public static  boolean isEatable(int[] piles,int h,int speed){
        int hours=0;

        for (int i=0;i<piles.length;i++){
            hours += (piles[i]+speed-1)/speed;
            if (hours>h){
                return false;
            }
        }

        return true;
    }
}
