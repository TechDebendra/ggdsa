package com.dsa.ds3recursive;

public class _08TowerOfHonoi {

    public static void main(String[] args) {
        towerOfHonoi(2, "A", "B", "C");
    }

    /**
     * Solves the Tower of Hanoi problem recursively.
     *
     * @param n       number of disks
     * @param fromRod source rod
     * @param toRod   destination rod
     * @param auxRod  auxiliary rod
     */
    public static void towerOfHonoi(int n, String fromRod, String toRod, String auxRod) {
        if (n == 0) {
            return;
        }

        towerOfHonoi(n - 1, fromRod, auxRod, toRod);

        System.out.println(
                "Disk " + n + " moved from rod " + fromRod + " to rod " + toRod);

        towerOfHonoi(n - 1, auxRod, toRod, fromRod);
    }
}