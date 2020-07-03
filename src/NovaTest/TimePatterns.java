package NovaTest;

import java.util.*;

// in this task we consider interesting patterns that could
// be obsereved on a digital clock.
// Such clock displays current time using the format "HH:MM:SS"
// Where:
// - "HH" is the hour of the day (00 - 23) as two decimal digits;
// - "MM" is the minute within the hour (00 - 59) as two digital digits
// - "SS" is the second within the minute (00 - 59) as two decimal digits

// HH, MM, SS are always represented as two digits, so the clock displays leading zeros
//
// A point in time is interesting if digital clock needs at most two
// distinct digits to display it.
// For example 13:31:33, 02:20:22
// 15:45:14 is not interesting due to the fact that more than 2 digits are used
// Delimiter ":" is permananetly printed onto clock's display and deosn't
// count as one of displayed digits
// The task is to count interesting points in time in a given period of time
//

public class TimePatterns {
    public int solution(String S, String T) {
        String[] sar = S.split(":");
        String[] tar = T.split(":");

        if ((sar.length < 3) || (tar.length < 3)){
            return 0;
        }

        int[] ar1 = new int[3];
        int[] ar2 = new int[3];

        int k = 0;
        for (k = 0; k < 3; k++){
            ar1[k] = Integer.valueOf(sar[k]);
            ar2[k] = Integer.valueOf(tar[k]);
        }

        System.out.format("HH1 = %d, MM1 = %d, SS1 = %d\n", ar1[0], ar1[1], ar1[2]);
        System.out.format("HH2 = %d, MM2 = %d, SS2 = %d\n", ar2[0], ar2[1], ar2[2]);

        int Ssec = ar1[0] * 60 * 60 + ar1[1] * 60 + ar1[2] ;
        int Tsec = ar2[0] * 60 * 60 + ar2[1] * 60 + ar2[2];

        int delta = Tsec - Ssec;
        int counter = 0;

        int i = 0;
        while (i <= delta && ar1 != null){
            System.out.format("%02d:%02d:%02d,\n",ar1[0], ar1[1], ar1[2]);
            //analyze time digits
            if (isInterseting(ar1)){
                counter++;
            };

            i++;
            ar1 = nextTime(ar1);
        }

        return counter;
    }

    private int[] nextTime(int[] ar) {
        int carry = 0;

        ar[2]++;
        if (ar[2] >= 60){
            carry = ar[2] / 60;
            ar[2] = 0;
            ar[1] += carry ;

            if (ar[1] >= 60){
                carry = ar[1] / 60;
                ar[1] = 0;
                ar[0] += carry ;

                if (ar[0] > 23){
                    return null;
                }
            }
        }
        return ar;
    }

    private boolean isInterseting(int[] ar) {

        Set<Integer> digits = new HashSet<>();
        for (int i = 0; i < ar.length; i++) {
            int d1 = ar[i] / 10;
            int d2 = ar[i] % 10;
            digits.add(d1);
            digits.add(d2);
        }
        return digits.size() <= 2;
    }


    public static void main(String[] args) {
        TimePatterns test = new TimePatterns();
        int counter;

        counter = test.solution("23:57:00", "23:59:59");
        System.out.println();
        System.out.println(counter);

        counter = test.solution("22:21:21", "22:22:21");
        System.out.println(counter);

        counter = test.solution("15:15:00", "15:15:12");
        System.out.println(counter);

        counter = test.solution("22:22:21", "22:22:23");
        System.out.println(counter);

    }

}
