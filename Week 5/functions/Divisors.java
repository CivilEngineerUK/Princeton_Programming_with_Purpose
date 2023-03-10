/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Divisors {

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b != 0) return b;
        else if (a != 0 && b == 0) return a;
        else if (a == 0 && b == 0) return 0;
        else {
            int largest = Math.max(Math.abs(a), Math.abs(b));
            int smallest = Math.min(Math.abs(a), Math.abs(b));
            int x = 0;
            while (smallest != 0) {
                x = largest % smallest;
                largest = smallest;
                smallest = x;
            }
            return largest;
        }
    }

    // least common mulitple of a and b
    public static int lcm(int a, int b) {
        if (a == 0 && b == 0) return 0;
        else return Math.abs(a * b) / gcd(a, b);
    }

    public static boolean areRelativelyPrime(int a, int b) {
        int x = gcd(a, b);
        if (x == 1) return true; // relatively prime
        else return false;
    }

    public static int totient(int n) {
        if (n == 0) return 0;
        int x = 0;
        for (int i = 1; i < n; i++) {
            if (areRelativelyPrime(n, i)) x += 1;
        }
        return x;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        StdOut.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        StdOut.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        StdOut.println("totient(" + a + ") = " + totient(a));
        StdOut.println("totient(" + b + ") = " + totient(b));
    }
}
