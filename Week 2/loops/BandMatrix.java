/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class BandMatrix {
    public static void main(String[] args) {

        /*
         *2. Band matrices. Write a program BandMatrix.java that takes two
         * integer command-line arguments n and width and prints an n-by-n
         * pattern like the ones below, with a zero (0) for each element whose
         * distance from the main diagonal is strictly more than width, and an
         * asterisk (*) for each entry that is not, and two spaces between each
         * 0 or *.
         * */

        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        for (int i = 1; i <= n; i++) {
            String line = "";
            for (int j = 1; j <= n; j++) {
                if (i - width <= j && j <= i + width) line += "* ";
                else line += "0 ";
            }
            System.out.println(line);
        }
    }
}
