/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class GreatCircle {
    public static void main(String[] args) {
        // parse main arguments of two sets of coordinates in degrees
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);

        // earth radius
        double r = 6371.0;

        // calculate distance between using Haversine formula
        double distance = 2 * r * Math.asin(
                Math.sqrt(
                        Math.pow(Math.sin(Math.toRadians((x2 - x1) / 2)), 2)
                                + Math.cos(Math.toRadians(x1)) *
                                Math.cos(Math.toRadians(x2)) *
                                Math.pow(Math.sin(
                                                 Math.toRadians((y2 - y1) / 2)),
                                         2)));

        System.out.println(distance + " kilometers");
    }
}
