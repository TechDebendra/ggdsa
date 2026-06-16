package com.dsa.ds4array;

public class _15LeadersInArrayProblem {
    public static void main(String[] args) {

    }
    public static void leadersInArray1(int[] arr){
        for (int i=0;i<arr.length;i++){
            boolean isLeader=true;
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]<arr[j]){
                    isLeader=false;
                    break;
                }
            }
            if (isLeader){
                System.out.print(arr[i]+" ");
            }
        }
    }


    public static void leadersInArray2(int[] arr){
        int size=arr.length;
        int leader=arr[size-1];

        System.out.print(leader+" ");
        for (int i=size-2;i>=0;i--){
            if (leader<arr[i]){
                System.out.print(arr[i]+" ");
                leader=arr[i];
            }
        }
    }
}
