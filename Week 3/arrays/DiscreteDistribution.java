/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {

        /*
         * https://coursera.cs.princeton.edu/introcs/assignments/arrays/specification.php
         *
         * Task 1
         *
         * Discrete distribution. Write a program DiscreteDistribution.java that
         * takes an integer command-line argument m, followed by a sequence of
         * positive integer command-line arguments a1,a2,…,an, and prints m
         * random indices (separated by whitespace), choosing each index i with
         * probability proportional to ai.*/
        int m = Integer.parseInt(args[0]);
        int length = args.length;

        int[] a = new int[length - 1];
        int[] s = new int[length - 1];

        for (int i = 0; i < length - 1; i++) {
            a[i] = Integer.parseInt(args[i + 1]);
            for (int j = i + 1; j < length - 1; j++) {
                s[j] += a[i];
            }
        }

        int[] index = new int[m];
        for (int j = 0; j < m; j++) {
            // pick random integer between 0 and s_n - 1
            int r = (int) Math.round(Math.random() * (s[s.length - 1] - 1));

            // find the unique index

            int h = 0;
            while (s[h] < r) {
                index[j] += 1;
                h++;
            }
            index[j] += 1;
        }
        String output = "";
        for (int k = 0; k < index.length; k++) {
            output += index[k] + " ";
        }
        System.out.println(output);
    }
}
