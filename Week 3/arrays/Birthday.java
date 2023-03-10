/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {
        /*
         * https://coursera.cs.princeton.edu/introcs/assignments/arrays/specification.php
         *
         * Birthday problem. Suppose that people enter a room one at a time.
         * How people must enter until two share a birthday? Counterintuitively,
         * after 23 people enter the room, there is approximately a 50–50 chance
         * that two share a birthday. This phenomenon is known as the birthday
         * problem or birthday paradox.
         * Write a program Birthday.java that takes two integer command-line
         * arguments n and trials and performs the following experiment, trials
         * times:
         *
         * Choose a birthday for the next person, uniformly at random between 0
         * and n−1.
         * Have that person enter the room.
         * If that person shares a birthday with someone else in the room, stop;
         * otherwise repeat.
         * In each experiment, count the number of people that enter the room.
         * Print a table that summarizes the results (the count i, the number of
         * times that exactly i people enter the room, and the fraction of times
         * that i or fewer people enter the room) for each possible value of i
         * from 1 until the fraction reaches (or exceeds) 50%.
         */

        int n = Integer.parseInt(args[0]);      // number of days to draw from
        int trials = Integer.parseInt(args[1]); // number of simulations

        int[] totalCount = new int[n + 1];         // total count for counting
        // the number of simulations

        for (int i = 0; i < trials; i++) {  // main loop
            int[] count = new int[n];       // count for this simmulation
            int j = 0;                      // counter for total count array
            boolean match = false;          // change to true when match found
            while (!match) {                // loop for finding match for one simulation
                int day = (int) (Math.random() * n);    // select a random day
                count[day] += 1;


                // run through all of count to check if any have 2
                int k = 0;
                while (!match && k < n) {
                    if (count[k] == 2) {
                        match = true;
                        totalCount[j] += 1;
                    }
                    k++;
                }
                j++;
            }
        }
        // now calculate the statistics
        double[] statistics = new double[n + 1];
        for (int h = 1; h <= n; h++) {
            statistics[h] = ((double) totalCount[h]) + statistics[h - 1];
        }

        for (int h = 0; h <= n; h++)
            if (statistics[h] != 0)
                statistics[h] /= trials;

        // print the results
        int i = 0;
        if (i < n) {
            while (statistics[i] < 0.5) {
                System.out.println(i + 1 + "\t" + totalCount[i] + "\t" + statistics[i]);
                i++;
            }
        }
        System.out.println(i + 1 + "\t" + totalCount[i] + "\t" + statistics[i]);
    }
}
