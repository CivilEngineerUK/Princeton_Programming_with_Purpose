/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Checkerboard {
    public static void main(String[] args) {
        /*
        https://coursera.cs.princeton.edu/introcs/assignments/io/specification.php

        2. Checkerboard.  Write a program Checkerboard.java that takes a
        command-line integer n and plots an n-by-n checkerboard pattern to
        standard drawing. Color the squares blue and light gray, with the
        bottom-left square blue.*/

        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (((i + j) % 2) != 0)
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                else StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }

    }
}

