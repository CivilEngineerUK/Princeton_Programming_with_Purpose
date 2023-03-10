/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {

    public static int size(int[][] a) {
        if (a.length == 0) return 0;
        if (a.length == 1)
            if (a[0][0] == 0) return 0;
            else return 1;

        // maximum size of submatrix possible = n^2
        int n = a.length, all_sum = 0;

        // row & col sums
        int[] row_sum = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                row_sum[i] += a[i][j];
            all_sum += row_sum[i];
        }

        if (all_sum == n * n) return n; // all entries 1
        if (all_sum == 0) return 0;     // all entries 0
        if (all_sum == 1) return 1;

        // search for smaller submatrix
        int m = (int) Math.sqrt(all_sum); // find maximum possible matrix size

        while (m > 2) {
            int m_size = m * m;
            for (int i = 0; i < (n - m); i++) {
                int left_mat = 0, right_mat = 0;

                // create right_matrix sum
                for (int k = i; k < (i + m); k++)
                    for (int j = m; j < a[i].length; j++)
                        right_mat += a[k][j];

                // move along each row
                for (int j = 0; j < (n - m); j++) {
                    int sub_sum = 0;
                    for (int k = i; k < (i + m); k++) {  // add row totals
                        sub_sum += row_sum[k];
                    }
                    if (j != 0) { // update the left & right matrices
                        for (int p = i; p < (i + m); p++) {
                            left_mat += a[p][j - 1];
                            if (j == a[i].length - 1) right_mat = 0;
                            else right_mat -= a[p][j + m - 1];
                        }
                    }
                    sub_sum -= (left_mat + right_mat);
                    if (sub_sum == m_size) return m;
                }
            }
            m--;
        }
        return m;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
/*        int[][] a = new int[7][];
        a[0] = new int[] { 0, 1, 1, 0, 1, 1, 1 };
        a[1] = new int[] { 1, 1, 0, 1, 1, 1, 1 };
        a[2] = new int[] { 0, 1, 1, 1, 1, 1, 1 };
        a[3] = new int[] { 1, 1, 1, 1, 1, 0, 1 };
        a[4] = new int[] { 1, 1, 1, 1, 1, 1, 0 };
        a[5] = new int[] { 1, 1, 1, 1, 0, 1, 1 };
        a[6] = new int[] { 1, 1, 1, 1, 0, 1, 1 };*/

        /*int[][] a = new int[6][];
        a[0] = new int[] { 0, 1, 1, 0, 1, 1 };
        a[1] = new int[] { 1, 1, 0, 1, 0, 1 };
        a[2] = new int[] { 0, 1, 1, 1, 0, 1 };
        a[3] = new int[] { 1, 1, 1, 1, 1, 0 };
        a[4] = new int[] { 1, 1, 1, 1, 1, 1 };
        a[5] = new int[] { 0, 0, 0, 0, 1, 1 };*/


        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        while (!StdIn.isEmpty()) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = StdIn.readInt();
                }
            }
        }
        int s = size(a);
        StdOut.println(s);
    }
}