/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ColorHSB {

    private final int hue, sat, bri;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        hue = h;
        sat = s;
        bri = b;
        if (hue < 0 || hue > 360 || sat < 0 || sat > 100 || bri < 0 || bri > 100)
            throw new IllegalArgumentException();
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + sat + ", " + bri + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        if (sat == 0 || bri == 0) return true;
        else return false;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException();
        int h1 = that.hue;
        int s1 = that.sat;
        int b1 = that.bri;

        int d1 = (h1 - hue) * (h1 - hue);
        int d2 = (360 - Math.abs(h1 - hue)) * (360 - Math.abs(h1 - hue));
        int d = Math.min(d1, d2) +
                ((s1 - sat) * (s1 - sat) + (b1 - bri) * (b1 - bri));
        return d;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        ColorHSB color = new ColorHSB(h, s, b);
        String name = StdIn.readString();
        String col = name;
        int h2 = StdIn.readInt();
        int s2 = StdIn.readInt();
        int b2 = StdIn.readInt();
        ColorHSB nearest_col = new ColorHSB(h2, s2, b2);
        int dist = 0;
        
        while (!StdIn.isEmpty()) {
            name = StdIn.readString();
            h2 = StdIn.readInt();
            s2 = StdIn.readInt();
            b2 = StdIn.readInt();

            ColorHSB test = new ColorHSB(h2, s2, b2);
            int new_dist = color.distanceSquaredTo(test);
            if (new_dist < dist) {
                dist = new_dist;
                nearest_col = test;
                col = name;
            }
        }
        StdOut.println(col + " " + nearest_col.toString());
    }

}
