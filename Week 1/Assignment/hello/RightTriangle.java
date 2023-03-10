/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class
RightTriangle {
    public static void main(String[] args) {
        // find hypotenuse
        int a = Math.abs(Integer.parseInt(args[0]));
        int b = Math.abs(Integer.parseInt(args[1]));
        int c = Math.abs(Integer.parseInt(args[2]));

        int hyp = Math.max(a, Math.max(b, c));
        int adj = Math.min(a, Math.min(b, c));
        int opp = a + b + c - hyp - adj;

        System.out.println(Math.pow(adj, 2) + Math.pow(opp, 2) == Math.pow(hyp, 2));
    }
}

