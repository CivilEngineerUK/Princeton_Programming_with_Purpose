/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RevesPuzzle {

    public static void hanoi(int n, int k, String from, String temp,
                             String to) {
        if (n != 0) {
            hanoi(n - 1, k, from, to, temp);
            StdOut.println("Move disc " + (n + k) + " from " +
                                   from + " to " + to);
            hanoi(n - 1, k, temp, from, to);
        }
    }

    public static void reves(int n, String from, String temp_1,
                             String temp_2, String to) {

        if (n == 1)
            StdOut.println("Move disc " + n + " from " + from + " to " + to);
        else {
            int k = (int) Math.round((double) n + 1 - Math.sqrt(2 * (double) n + 1));

            // int k = (int) (n + 1 - Math.sqrt(2 * n + 1));
            reves(k, from, temp_2, temp_1, to);
            hanoi(n - k, k, from, temp_2, to);
            reves(k, temp_1, from, temp_2, to);

        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "B", "C", "D");
    }
}
