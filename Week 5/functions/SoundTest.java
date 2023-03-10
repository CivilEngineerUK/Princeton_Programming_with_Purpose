/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class SoundTest {
    public static void main(String[] args) {
        double hz = Double.parseDouble(args[0]);
        double duration = Double.parseDouble(args[1]);
        int rate = Integer.parseInt(args[2]);
        double[] a = tone(hz, duration, rate);
        StdAudio.play(a);
    }

    public static double[] tone(double hz, double duration, int rate) {
        int N = (int) (rate * duration);
        double[] a = new double[N + 1];
        for (int i = 0; i <= N; i++)
            a[i] = Math.sin(2 * Math.PI * i * hz / rate);
        return a;
    }

}
