public class ThueMorse {
    public static void main(String[] args) {
        /* https://coursera.cs.princeton.edu/introcs/assignments/arrays/specification.php
         *
         * 2. Thue–Morse weave. Write a program ThueMorse.java that takes an
         * integer command-line argument n and prints an n-by-n pattern like the
         * ones below. Include two space characters between each + and -
         * character.
         * */
        int n = Integer.parseInt(args[0]);

        // genererate the sequence
        int[] thue = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) thue[i] = 0;
            if (i % 2 == 0) thue[i] = thue[i / 2];    // even
            else thue[i] = 1 - thue[i - 1];           // odd
            //System.out.print(thue[i]);
        }

        // print to line
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (thue[j] == thue[k]) System.out.print("+  ");
                else System.out.print("-  ");
            }
            System.out.println();
        }
    }
}