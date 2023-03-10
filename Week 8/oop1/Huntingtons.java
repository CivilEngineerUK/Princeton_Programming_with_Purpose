/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0, max = 0;
        int i = dna.indexOf("CAG");
        while (i < dna.length() - 2) {
            String cag = dna.substring(i, i + 3);
            if (cag.equals("CAG")) {
                count++;
                i += 3;
                if (count > max) max = count;
            }
            else {
                count = 0;
                i++;
            }
        }
        if (count > max) max = count;
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String t = s.replace(" ", "");
        t = t.replace("\n", "");
        t = t.replace("\t", "");
        return t;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9) return "not human";
        else if (maxRepeats <= 35) return "normal";
        else if (maxRepeats <= 39) return "high risk";
        else if (maxRepeats <= 180) return "Huntington's";
        else return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String file_name = args[0];
        In data = new In(file_name);
        String s = data.readAll();
        String dna = removeWhitespace(s);
        int repeats = maxRepeats(dna);
        StdOut.println("max repeats = " + repeats);
        String diagnosis = diagnose(repeats);
        StdOut.println(diagnosis);
    }

}
