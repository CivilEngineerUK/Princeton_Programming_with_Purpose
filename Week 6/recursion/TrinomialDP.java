/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialDP {

    /*
    https://coursera.cs.princeton.edu/introcs/assignments/recursion/specification.php

    Q2
    Trinomial coefficients (dynamic programming). Write a program
    TrinomialDP.java that takes two integer command-line arguments n and k and
    computes the trinomial coefficient T(n,k)
    using dynamic programming. To do so, organize your program according to the
    following public API:
     */

    public static long trinomial(int n, int k) {

        // if (Math.abs(k) > n / 2) return 0;
        if (k < -n || k > n) return 0;
        if (n < 2) return 1;

        // create jagged array. Due to symmetry, only half size required
        long[][] t = new long[n + 1][];

        // initialise first two rows
        t[0] = new long[] { 1 };
        t[1] = new long[] { 1, 1, 1 };

        for (int i = 2; i <= n; i++) {
            t[i] = new long[i + 1];

            // edge cases
            t[i][0] = 1;
            t[i][1] = i;

            // centre case
            t[i][i] = t[i - 1][i - 1] + (2 * t[i - 1][i - 2]);
            for (int j = 2; j < t[i].length - 1; j++)
                for (int m = j - 2; m <= j; m++)
                    t[i][j] += t[i - 1][m];
        }

        long tri = t[n][n - Math.abs(k)];
        return tri;
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
