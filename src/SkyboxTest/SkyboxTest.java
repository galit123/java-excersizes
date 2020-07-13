package SkyboxTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SkyboxTest {

    final int test() {
        List<Integer> list = new ArrayList<>(2);
        list.add(1);
        list.add(1);
        list.add(1);
        return list.size();
    }

    static boolean exists(int[] ints, int k) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < ints.length; i++) {
            list.add(ints[i]);
        }
        Collections.sort(list);

        return list.contains(k);
    }

    public static void main(String[] args) {
        SkyboxTest test = new SkyboxTest();
        int s = test.test();
        System.out.println(s);
    }

}
