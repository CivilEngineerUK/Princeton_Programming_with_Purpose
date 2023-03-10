/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ActivationFunction {

    public static double heaviside(double x) {
        if (x < 0) x = 0;
        else if (x == 0) x = 0.5;
        else if (x > 0) x = 1;
        else x = Math.sqrt(-1);
        return x;
    }

    public static double sigmoid(double x) {
        x = (1 / (1 + Math.exp(-x)));
        return x;
    }

    public static double tanh(double x) {
        if (x == Double.POSITIVE_INFINITY || x == Double.MAX_VALUE) return 1;
        else if (x == Double.NEGATIVE_INFINITY || x == -Double.MAX_VALUE) return -1;
        else return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    public static double softsign(double x) {
        if (x == Double.POSITIVE_INFINITY || x == Double.MAX_VALUE) return 1;
        else if (x == Double.NEGATIVE_INFINITY || x == -Double.MAX_VALUE) return -1;
        else return x / (1 + Math.abs(x));
    }

    public static double sqnl(double x) {
        if (x <= -2) x = -1;
        else if (-2 < x && x <= 0) x = x + (Math.pow(x, 2) / 4);
        else if (0 < x && x < 2) x = x - (Math.pow(x, 2) / 4);
        else if (x >= 2) x = 1;
        else x = Math.sqrt(-1);
        return x;
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println("heaviside(" + x + ") = " + heaviside(x));
        StdOut.println("sigmoid(" + x + ") = " + sigmoid(x));
        StdOut.println("tanh(" + x + ") = " + tanh(x));
        StdOut.println("softsign(" + x + ") = " + softsign(x));
        StdOut.println("sqnl(" + x + ") = " + sqnl(x));
    }
}
