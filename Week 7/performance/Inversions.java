/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Inversions {
    // https://coursera.cs.princeton.edu/introcs/assignments/performance/specification.php

    /*
    Q1
    Inversions. Suppose that a music site wants to compare your song preferences
    to those of a friend. One approach is to have you and your friend each rank
    a set of n songs and count the number of pairs of songs (i, j) for which you
    prefer i to j but your friend prefers j to i. When the count is low, the
    preferences are similar.
    */

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        // 1. find largest value in array and permutate to end
        // 2. repeat

        long n = a.length;
        int[] b = new int[(int) n];

        // create replica of a[] so not mutate a[]
        for (int i = 0; i < n; i++) b[i] = a[i];

        int k = 0;
        long permutation = 0;
        for (int j = 0; j < n; j++) {
            long val = n - 1 - k;
            int i = 0;

            // find next largest value
            while (b[i] != val) i++;

            // move value to end
            int temp = 0;
            for (int m = i; m < n - k - 1; m++) {
                temp = b[m + 1];
                b[m] = b[m + 1];
                b[m + 1] = temp;
                permutation++;
            }
            k++;
        }
        return permutation;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        // based on number of permutations, easy to find how many of
        // the items moved to new final position
        double m = ((1 + Math.sqrt(1 + 4 * (n * n - n - (2 * k)))) / 2);

        double m_floor = Math.ceil(m);
        int mm = (int) (0.5 * (n * n - n - m_floor * m_floor + m_floor));

        // number of items fully permutated
        int fully_moved = (int) Math.floor(n - m);

        // remaining moves to get current permutating item to final position
        int remainder = (int) k - mm;

        // build output array
        int[] a = new int[n];
        int j = 0, h = 0;
        for (int i = 0; i < n; i++) {
            if (j < fully_moved) a[i] = n - 1 - j;
            else if (i == n - 1 - remainder) {
                a[i] = n - 1 - fully_moved;
                h = 1;
            }
            else a[i] = i - fully_moved - h;

            j++;
        }

        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] a = generate(n, k);
        for (int i = 0; i < a.length; i++) StdOut.print(a[i] + " ");
    }
}
