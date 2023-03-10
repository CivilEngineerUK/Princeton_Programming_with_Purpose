/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        // if (n < 1729) return false;
        // long a, b, c, d;
        // double tol = 1e-6;
        boolean ab = false, cd = false;

        // largest cube possible
        long n_max = (long) Math.cbrt(n - 1);

        // count along to find pairs
        long i = 1;
        boolean step = false;
        while (i < n_max && (!ab || !cd)) {
            double i_cubed = i * i * i;
            double test = Math.cbrt(n - i_cubed);
            double test2 = Math.round(test);
            step = false;
            double check = Math.abs(test - test2);
            if (!ab && check == 0 && !step) {
                ab = true;
                // a = i;
                // b = (long) test;
                // StdOut.println("The first pair is " + a + " and " + b);
                step = true;
            }
            if (ab && check == 0 && !step) {
                cd = true;
                // c = i;
                // d = (long) test;
                // StdOut.println("The second pair is " + c + " and " + d);
            }
            i++;
        }
        return ab && cd;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);

        // long[] check = root(n, 1e-15);

        boolean ramanujan = isRamanujan(n);
        StdOut.println(ramanujan);
    }
}
