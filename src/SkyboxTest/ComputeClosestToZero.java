package SkyboxTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputeClosestToZero {
    class Temp implements Comparable {
        int val;

        public Temp(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Temp) {
                return compareTo((Temp) o);
            } else {
                throw new ClassCastException("object is not Pair");
            }
        }


        public int compareTo(Temp o) {
            if (Math.abs(val) == Math.abs(o.val)) {
                if (val < o.val) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return Math.abs(val) - Math.abs(o.val);
        }
    }

    // Solution O(N^2)
    public int computeClosestToZero1(int[] ts) {
        int closestToZero = Integer.MAX_VALUE;

        for (int i = 0; i < ts.length; i++) {
            int n = Math.abs(ts[i]);
            int curVal = Math.abs(closestToZero);

            if (n < curVal) {
                closestToZero = ts[i];
            } else if (n == curVal) {
                closestToZero = ts[i] < closestToZero ? closestToZero : ts[i];
            }
        }
        return closestToZero;
    }


    // Solution O(NlogN)
    public int computeClosestToZero(int[] ts) {

        if (ts == null || ts.length == 0) {
            return 0;
        }
        List<Temp> list = new ArrayList<Temp>();
        for (int i = 0; i < ts.length; i++) {
            list.add(new Temp(ts[i]));
        }
        Collections.sort(list);

        return list.get(0).val;
    }

    public static void main(String[] args) {
        int[] ar = {-2, 2, 6, 10, 3, 4, -6};
        ComputeClosestToZero c = new ComputeClosestToZero();

        int solution = c.computeClosestToZero(ar);

        System.out.println(solution);

    }
}
