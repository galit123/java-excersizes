package codility;

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


//
// there are N tres (numbered 0 - N-1) in the forest. The K-th tree is
// located at coordinates (X[k],Y[k])
// Write a function that given two arrays X and Y consisting of N integers
// each, denoting the positions of trees, returns the wisth of the widest possible path
// Given X=[1,8,7,3,4,1,8], Y=[6,4,1,8,5,1,7] shuold return 3
//       X= [5,5,5,7,7,7], Y=[3,4,5,1,3,7] should return 2
//       X= [4,1,5,4], Y=[4,5,1,3] should return 3
//       X= [6,10,1,4,3], Y=[2,5,3,1,6] should return 4

public class NovaLomusTest {
    public int solution1(int[] X, int[] Y) {
        List<Integer> xList = new ArrayList<Integer>();

        for (int i = 0; i < X.length; i++){
            xList.add(X[i]);
        }
        Collections.sort(xList);

        int max = 0;
        int j = 1;
        while (j < xList.size()){
            int pathLength = xList.get(j) - xList.get(j-1);
            if (max < pathLength){
                max = pathLength;
            }
            j++;
        }
        return max;
    }

    public int solution2(String S, String T) {
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
        NovaLomusTest test = new NovaLomusTest();
        int counter;

        counter = test.solution2("23:57:00", "23:59:59");
        System.out.println();
        System.out.println(counter);
//
//        counter = test.solution2("22:21:21", "22:22:21");
//        System.out.println(counter);
//
//        counter = test.solution2("15:15:00", "15:15:12");
//        System.out.println(counter);
//
//        counter = test.solution2("22:22:21", "22:22:23");
//        System.out.println(counter);

    }
}
