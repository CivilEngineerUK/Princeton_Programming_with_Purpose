/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class GeneralizedHarmonic {
    public static void main(String[] args) {
        // https://coursera.cs.princeton.edu/introcs/assignments/loops/specification.php
        // Task 1

        /*
         * Generalized harmonic numbers.
         * Write a program GeneralizedHarmonic.java that takes two integer
         * command-line arguments n and r and uses a for loop to compute the nth
         * generalized harmonic number of order r,
         * which is defined by the following formula:
         * */

        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double H = 0.0;

        for (int i = 1; i <= n; i++) H += 1 / Math.pow(i, r);

        System.out.println(H);
    }
}
