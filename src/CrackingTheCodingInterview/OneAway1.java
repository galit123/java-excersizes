package CrackingTheCodingInterview;

import org.junit.Assert;

public class OneAway1 {
    public void isOneAway(String w1, String w2, boolean expected) {
        System.out.println("\nw1 = " + w1 + ", w2 = " + w2);
        boolean actual = isOneAway(w1, w2);

        System.out.println("res = " + actual);
        Assert.assertEquals(expected, actual);

    }
    public boolean isOneAway(String w1, String w2) {

        char[] c1 = w1.toCharArray();
        char[] c2 = w2.toCharArray();

        int i = 0;
        int j = 0;

        int count = 0;

        while ((i < c1.length) &&  (j < c2.length)) {
            if (c1[i] == c2[j]) {
                i++;
                j++;
            } else {
                count++;
                if (i < c1.length - 1 && c1[i + 1] == c2[j]) {
                    i++;
                } else if (j < c2.length - 1 && c1[i] == c2[j + 1]) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        while (i < c1.length){
            i++;
            count++;
        }

        while (j < c2.length){
            j++;
            count++;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        OneAway1 p = new OneAway1();

        p.isOneAway("pale", "ple", true);

        p.isOneAway("pale", "pales", true);

        p.isOneAway("pale", "bale", true);

        p.isOneAway("pale", "bake", false);

        p.isOneAway("pale", "pil", false);

        p.isOneAway("pale", "pile", true);

        p.isOneAway("pale", "pela", false);

        p.isOneAway("p", "", true);

    }
}
