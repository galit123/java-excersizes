package codility;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

    public int solution(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++){
            set.add(A[i]);
        }
        int j = 0;
        while (set.contains(j)){
            j++;
        }

        return j;
    }

    public static void main(String[] args) {

    }
}
