/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class WorldMap {
    public static void main(String[] args) {
        /*
         * https://coursera.cs.princeton.edu/introcs/assignments/io/specification.php
         *
         * World maps. Write a program WorldMap.java that reads boundary
         * information of a country (or other geographic entity) from standard
         * input and plots the results to standard drawing. A country consists of
         * a set of regions (e.g., states, provinces, or other administrative
         * divisions), each of which is described by a polygon.*/

        StdDraw.enableDoubleBuffering();
        // read bounding box
        int x_max = StdIn.readInt();
        int y_max = StdIn.readInt();

        // set bounding box
        StdDraw.setCanvasSize(x_max, y_max);
        StdDraw.setXscale(0, x_max);
        StdDraw.setYscale(0, y_max);
        StdDraw.setPenColor(StdDraw.BLACK);

        // program to read over and get the polygons
        while (!StdIn.isEmpty()) {

            // read over space and name
            StdIn.readLine();
            StdIn.readString();

            // read coordinates to x and y arrays
            int n = StdIn.readInt();
            double[] x = new double[n];
            double[] y = new double[n];
            for (int i = 0; i < n; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            // plot the polygon
            StdDraw.polygon(x, y);
        }
        StdDraw.show();
    }
}
