/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {
        // https://coursera.cs.princeton.edu/introcs/assignments/io/specification.php
        /*
        1. Shannon entropy. Write a program ShannonEntropy.java that takes a
        command-line integer m; reads a sequence of integers between 1 and m
        from standard input; and prints the Shannon entropy to standard output,
        with 4 digits after the decimal point. The Shannon entropy of a sequence
        of integers is given by the formula:
        H=−(p1log2p1+p2log2p2+…+pmlog2pm)
        where pi denotes the proportion of integers whose value is i. If pi=0
        , then treat pilog2pi as 0.
        */
        int m = Integer.parseInt(args[0]);
        int[] f = new int[m + 1];
        int n = 0;

        // calculating the frequency by incrementing the array and incrementing n alongside
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            f[value]++;
            n++;
        }
        double entropy = 0;
        for (int i = 1; i <= m; i++) {
            double p = (double) f[i] / n;
            if (f[i] > 0)
                entropy -= p * (Math.log(p) / Math.log(2));
        }

        // printing the output
        StdOut.printf("%.4f\n", entropy);
    }
}
