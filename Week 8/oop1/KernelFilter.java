/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {

    private static Picture kernel(Picture picture, int[][] filter, double factor) {
        int w = picture.width(), h = picture.height();
        Picture pic = new Picture(w, h);
        int offset = (int) Math.floor((double) filter.length / 2);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // inner loop
                double rr = 0, gg = 0, bb = 0;
                for (int k = -offset; k < (offset + 1); k++) {
                    for (int m = -offset; m < (offset + 1); m++) {
                        Color color = picture.get((w + j + m) % w, (h + i + k) % h);
                        int r = color.getRed();
                        int g = color.getGreen();
                        int b = color.getBlue();

                        rr += r * filter[k + offset][m + offset];
                        gg += g * filter[k + offset][m + offset];
                        bb += b * filter[k + offset][m + offset];
                    }
                }

                rr *= factor;
                gg *= factor;
                bb *= factor;

                rr = Math.round(rr);
                gg = Math.round(gg);
                bb = Math.round(bb);

                if (rr < 0) rr = 0;
                if (rr > 255) rr = 255;
                if (gg < 0) gg = 0;
                if (gg > 255) gg = 255;
                if (bb < 0) bb = 0;
                if (bb > 255) bb = 255;

                Color new_col = new Color((int) rr, (int) gg, (int) bb);
                pic.set(j, i, new_col);
            }
        }
        return pic;
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        int[][] filter = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        Picture pic = kernel(picture, filter, 1);
        return pic;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        int[][] filter = new int[][] { { 1, 2, 1 }, { 2, 4, 2 }, { 1, 2, 1 } };
        double factor = (double) 1 / 16;
        Picture pic = kernel(picture, filter, factor);
        return pic;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        int[][] filter = new int[][] { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
        Picture pic = kernel(picture, filter, 1);
        return pic;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        int[][] filter = new int[][] { { -1, -1, -1, }, { -1, 8, -1 }, { -1, -1, -1 } };
        Picture pic = kernel(picture, filter, 1);
        return pic;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        int[][] filter = new int[][] { { -2, -1, 0, }, { -1, 1, 1 }, { 0, 1, 2 } };
        Picture pic = kernel(picture, filter, 1);
        return pic;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        int[][] filter = new int[9][9];
        for (int i = 0; i < 9; i++)
            filter[i][i] = 1;
        double factor = (double) 1 / 9;
        Picture pic = kernel(picture, filter, factor);
        return pic;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture input = new Picture(args[0]);

        // identity
        Picture identity_pic = identity(input);
        identity_pic.show();

        // gaussian
        Picture gaussian_pic = gaussian(input);
        gaussian_pic.show();

        // sharpen
        Picture sharpen_pic = sharpen(input);
        sharpen_pic.show();

        // laplacian
        Picture laplacian_pic = laplacian(input);
        laplacian_pic.show();

        // emboss
        Picture emboss_pic = emboss(input);
        emboss_pic.show();

        // motion blur
        Picture motion_pic = motionBlur(input);
        motion_pic.show();
    }

}
