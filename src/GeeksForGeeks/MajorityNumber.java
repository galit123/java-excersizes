package GeeksForGeeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityNumber {
//    Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.
//
//    Input:
//    The first line of the input contains T denoting the number of testcases. The first line of the test case will be the size of array and second line will be the elements of the array.
//
//    Output:
//    For each test case the output will be the majority element of the array. Output "-1" if no majority element is there in the array.
//
//    Constraints:
//            1 <= T<= 100
//            1 <= N <= 107
//            0 <= Ai <= 106
//
//    Example:
//    Input:
//            2
//            5
//            3 1 3 3 2
//            3
//            1 2 3
//
//    Output:
//            3
//            -1
    public int solution(int a[]){

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        double len = a.length / 2;
        for (int i = 0; i < a.length; i++){
            int cur = map.containsKey(a[i])? map.get(a[i]): 0;
            map.put(a[i], ++cur);

            if (cur > len ) {
                return a[i];
            }
        }
        return  -1;
    }


    public static void main(String[] args) {
        MajorityNumber m = new MajorityNumber();

//        Scanner in = new Scanner(System.in);
//        int T = Integer.valueOf(in.nextLine());
//
//        int[] res = new int[T];
//        for (int i = 0; i < T; i++){
//            int n = Integer.valueOf(in.nextLine());
//            int[] ar = new int[n];
//            for (int j = 0; j < n; j++){
//                ar[j] = in.nextInt();
//            }
//            res[i] = m.solution(ar);
//            System.out.println(res[i]);
//            if (i < T - 1)
//                in.nextLine();
//
//        }

        int[] c = {2, 1};
        int x = m.solution(c);
        System.out.println(x);


        int[] a = {3, 1, 3, 3, 2};
        int n = m.solution(a);

        System.out.println(n);

        int[] b = {1, 2, 3};
        n = m.solution(b);

        System.out.println(n);
    }
}
