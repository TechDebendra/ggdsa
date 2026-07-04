package com.dsa.ds9string;

public class _10LexicographicRankOfAString {
    public static void main(String[] args) {
        System.out.println(lexicographicRank("ABC"));      // 1
        System.out.println(lexicographicRank("ACB"));      // 2
        System.out.println(lexicographicRank("BAC"));      // 3
        System.out.println(lexicographicRank("BCA"));      // 4
        System.out.println(lexicographicRank("CAB"));      // 5
        System.out.println(lexicographicRank("CBA"));      // 6
        System.out.println(lexicographicRank("DCBA"));     // 24
        System.out.println(lexicographicRank("ABCD"));     // 1
        System.out.println(lexicographicRank("BDCA"));     // 12

    }

    public static int lexicographicRank(String str) {

        int n = str.length();
        int rank = 1;

        int fact = factorial(n);

        for (int i = 0; i < n; i++) {

            fact /= (n - i);

            int count = 0;

            for (int j = i + 1; j < n; j++) {
                if (str.charAt(j) < str.charAt(i)) {
                    count++;
                }
            }

            rank += count * fact;
        }

        return rank;
    }

    private static int factorial(int n) {

        int fact = 1;

        for (int i = 2; i <= n; i++)
            fact *= i;

        return fact;
    }

    public static int lexicographicRankOptimised(String string){
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Invalid Input");
        }
        int n = string.length();
        int rank = 1;
        int fact = factorial(n);
        int[] count = new int[256];
        for (int i=0;i<n;i++){
            count[string.charAt(i)]++;
        }

        for (int i=1;i<count.length;i++){
            count[i]+=count[i-1];
        }

        for (int i=0; i<n;i++){
            fact/=(n-i);

            if (string.charAt(i) != 0) {
                rank += fact * count[string.charAt(i) - 1];
            }
            for (int j=string.charAt(i);j<count.length;j++){
                count[j]--;
            }
        }

        return rank;
    }


}
