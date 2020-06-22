package MyArrays;

import java.util.ArrayList;
import java.util.Collections;

public class MyArrays {
    public static void printArr(int []A){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, java.util.Arrays.stream(A).boxed().toArray(Integer[]::new));
        System.out.println(list);
    }

}
