/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        /*

         * https://coursera.cs.princeton.edu/introcs/assignments/loops/specification.php
         *
         * Question 4
         *
         * Random walkers. Write a program RandomWalkers.java that takes two
         * integer command-line arguments r and trials. In each of trials
         * independent experiments, simulate a random walk until the random
         * walker is at Manhattan distance r from the starting point. Print the
         * average number of steps.
         * */

        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        // coordinates
        int x = 0;
        int y = 0;

        double rand_step = 0;
        int total_count = 0;

        for (int k = 1; k <= trials; k++) {
            int count = 0;
            int manhattan = 0;
            x = 0;
            y = 0;
            while (manhattan < r) {
                rand_step = Math.random();

                // simulate the walk
                if (rand_step <= 0.25) y += 1; // north
                else if (rand_step <= 0.5) x += 1; // east
                else if (rand_step <= 0.75) y -= 1; // south
                else x -= 1; // west

                manhattan = Math.abs(x) + Math.abs(y);
                count += 1;
            }
            total_count += count;
        }
        double tc = total_count;
        double tr = trials;
        System.out.println("average number of steps = " + tc / tr);
    }
}
