/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Clock {

    private int hour, minute;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59)
            throw new IllegalArgumentException();
        hour = h;
        minute = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5 || !s.contains(":"))
            throw new IllegalArgumentException();
        String hour1 = s.substring(0, 1);
        String minute1 = s.substring(3, 4);
        hour = Integer.parseInt(hour1);
        minute = Integer.parseInt(minute1);
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59)
            throw new IllegalArgumentException();
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String hr, mn;
        if (hour <= 9) hr = "0" + hour;
        else hr = "" + hour;
        if (minute <= 9) mn = "0" + minute;
        else mn = "" + minute;
        return hr + ":" + mn;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        int hour1 = that.hour;
        int minute1 = that.minute;
        if (hour < hour1) return true;
        if (hour > hour1) return false;
        if (hour == hour1)
            if (minute < minute1) return true;
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        minute += 1;
        if (minute == 60) {
            minute = 00;
            hour += 1;
        }
        if (hour == 24) hour = 0;
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException();
        int total = minute + delta;
        minute = total % 60;
        hour += Math.floor(total / 60.0);
        hour = hour % 24;
    }

    // Test client (see below).
    public static void main(String[] args) {
        // int h = Integer.parseInt(args[0]);
        // int m = Integer.parseInt(args[1]);
        Clock time1 = new Clock(10, 59);
        Clock time2 = new Clock(23, 15);
        StdOut.println(time1);
        StdOut.println(time2);
        time1.tic();
        StdOut.println(time1);
        time1.toc(13 * 60);
        StdOut.println(time1);
        boolean b = time1.isEarlierThan(time2);
        StdOut.println(b);
        String s = time1.toString();
        StdOut.println(s);
    }
}
