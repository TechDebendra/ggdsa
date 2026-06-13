package com.dsa.ds3recursive;

public class _08TowerOfHonoi {

    public static void main(String[] args) {
        towerOfHanoi(2, "A", "B", "C");
    }

    /**
     * Solves the Tower of Hanoi problem recursively.
     * @param n       number of disks
     * @param fromRod source rod
     * @param toRod   destination rod
     * @param auxRod  auxiliary rod
     */
    public static void towerOfHanoi(int n, String fromRod, String toRod, String auxRod) {
        if (n == 0) {
            return;
        }

        towerOfHanoi(n - 1, fromRod, auxRod, toRod);

        System.out.println(
                "Disk " + n + " moved from rod " + fromRod + " to rod " + toRod);

        towerOfHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public int towerOfHanoiSteps(int n, int from, int to, int aux) {
        // code here
        if(n==1) return 1;

        int left= towerOfHanoiSteps(n-1,from,aux,to);
        int current=1;
        int right= towerOfHanoiSteps(n-1,aux,to,from);

        return left+current+right;
    }
}