/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        /*

         * https://coursera.cs.princeton.edu/introcs/assignments/loops/specification.php
         *
         * Question 3
         *
         * Random walk. A Java programmer begins walking aimlessly. At each time
         * step, she takes one step in a random direction (either north, east,
         * south, or west), each with probability 25%. She stops once she is at
         * Manhattan distance r from the starting point. How many steps will the
         * random walker take? This process is known as a two-dimensional random
         * walk.
         *
         * Write a program RandomWalker.java that takes an integer command-line
         * argument r and simulates the motion of a random walk until the random
         * walker is at Manhattan distance r from the starting point. Print the
         * coordinates at each step of the walk (including the starting and
         * ending points), treating the starting point as (0, 0). Also, print
         * the total number of steps taken.
         * */

        int r = Integer.parseInt(args[0]);

        // coordinates
        int x = 0;
        int y = 0;
        int manhattan = 0;
        double rand_step = 0;

        int count = 0;

        // print (0, 0)
        System.out.println("(" + x + ", " + y + ")");
        while (manhattan < r) {
            rand_step = Math.random();

            // simulate the walk
            if (rand_step <= 0.25) y += 1; // north
            else if (rand_step <= 0.5) x += 1; // east
            else if (rand_step <= 0.75) y -= 1; // south
            else x -= 1; // west

            // print output
            System.out.println("(" + x + ", " + y + ")");

            manhattan = Math.abs(x) + Math.abs(y);
            count += 1;
        }
        System.out.println("steps = " + count);
    }
}
