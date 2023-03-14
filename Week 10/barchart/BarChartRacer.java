/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        String name = args[0];
        int k = Integer.parseInt(args[1]);
        In in = new In(name);

        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();
        in.readLine();

        BarChart chart = new BarChart(title, xAxis, source);

        while (!in.isEmpty()) {
            int n = Integer.parseInt(in.readLine());
            Bar[] barchart = new Bar[n];
            String year = "";

            for (int i = 0; i < n; i++) {
                String observation = in.readLine();
                String[] parts = observation.split(",");
                year = parts[0];
                String bar_name = parts[1];
                int value = Integer.parseInt(parts[3]);
                String category = parts[4];
                barchart[i] = new Bar(bar_name, value, category);
            }

            Arrays.sort(barchart);
            chart.setCaption(year);

            for (int i = barchart.length - 1; i > barchart.length - 1 - k; i--) {
                chart.add(barchart[i].getName(), barchart[i].getValue(), barchart[i].getCategory());
            }

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(1);
            chart.reset();
            in.readLine();
        }
        chart.reset();
    }
}

