package GeeksForGeeks;

import java.util.ArrayList;
import java.util.List;

public class MinMax {

    public int DAC_Max(int a[]){
        List<Integer> ar = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++){
            ar.add(a[i]);
        }
        return DAC_Max(ar);
    }

    // function to find the maximum no.
    // in a given array.
    private int DAC_Max(List<Integer> ar)
    {
        if (ar.size() == 1){
            return ar.get(0);
        } else {
            int n = ar.get(0);
            ar.remove(0);
            int max = DAC_Max(ar);

            if (max > n){
                return max;
            } else {
                return n;
            }
        }
    }

    public int DAC_Min(int a[]){
        List<Integer> ar = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++){
            ar.add(a[i]);
        }
        return DAC_Min(ar);
    }

    // function to find the maximum no.
    // in a given array.
    private int DAC_Min(List<Integer> ar)
    {
        if (ar.size() == 1){
            return ar.get(0);
        } else {
            int n = ar.get(0);
            ar.remove(0);
            int min = DAC_Min(ar);

            if (min > n){
                return n;
            } else {
                return min;
            }
        }
    }


    public static void main(String[] args) {
        MinMax s = new MinMax();

        int[] ar = { 70, 250, 50, 80, 140, 12, 14 };
        int max = s.DAC_Max(ar);
        System.out.println("Max: " + max);

        int min = s.DAC_Min(ar);
        System.out.println("Min: " + min);
    }
}
