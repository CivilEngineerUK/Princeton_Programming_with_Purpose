/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] b = new double[a.length];
        double max = 0;
        double min = 0;
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] * alpha;
            if (b[i] > max) max = b[i];
            if (b[i] < min) min = b[i];
        }
        for (int i = 0; i < a.length; i++)
            b[i] = -1.0 + ((2.0 / (max - min)) * b[i]);
        return b;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) b[i] = a[a.length - i - 1];
        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) c[i] = a[i];
        for (int i = 0; i < b.length; i++) c[a.length + i] = b[i];
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] c;
        if (a.length < b.length) {
            c = new double[b.length];
            for (int i = 0; i < a.length; i++) c[i] = (a[i]) + (b[i]);
            for (int i = a.length; i < b.length; i++) c[i] = b[i];
        }
        else {
            c = new double[a.length];
            for (int i = 0; i < b.length; i++) c[i] = (a[i]) + (b[i]);
            for (int i = b.length; i < a.length; i++) c[i] = a[i];
        }
        return c;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] b = new double[(int) (a.length / alpha)];
        // resample
        for (int i = 0; i < b.length; i++) {
            b[i] = a[(int) Math.floor(i * alpha)];
        }
        return b;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        // load files
        double[] cow = StdAudio.read("cow.wav");
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] singer = StdAudio.read("singer.wav");
        double[] scratch = StdAudio.read("scratch.wav");

        // mix together samples
        StdAudio.play(
                merge(
                        merge(
                                merge(amplify(cow, 3), changeSpeed(scratch, 0.5)),
                                merge(mix(harp, changeSpeed(singer, 2)), reverse(beatbox))
                        ), reverse(merge(
                                merge(amplify(cow, 3), changeSpeed(scratch, 0.5)),
                                merge(mix(harp, changeSpeed(singer, 2)), reverse(beatbox))
                        ))));
    }
}
