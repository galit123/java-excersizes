package codility;

import java.util.HashSet;
import java.util.Set;


//        You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.
//        Note: Expected solution in O(n) time using constant extra space.
//
//        Input:
//        First line consists of T test cases. First line of every test case consists of N, denoting the number of elements in array. Second line of every test case consists of elements in array.
//
//        Output:
//        Single line output, print the smallest positive number missing.
//
//        Constraints:
//        1 <= T <= 100
//        1 <= N <= 106
//        -106 <= arr[i] <= 106
//
//        Example:
//        Input:
//        2
//        5
//        1 2 3 4 5
//        5
//        0 -10 1 3 -20
//        Output:
//        6
//        2
//
//        Explanation:
//        Testcase 1: Smallest positive missing number is 6.
//        Testcase 2: Smallest positive missing number is 2.
public class FirstMissingPositive {

    public static int solution(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++){
            set.add(A[i]);
        }
        int j = 1;
        while (set.contains(j)){
            j++;
        }

        return j;
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int n = solution(a);
        System.out.println(n);

        int[] b = {0, -10, 1, 3, -20};
        n = solution(b);
        System.out.println(n);

    }
}
