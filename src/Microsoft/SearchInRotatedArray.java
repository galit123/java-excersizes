package Microsoft;

import java.util.Scanner;

//    Given a sorted and rotated array A of N distinct elements which is rotated
//    at some point, and given an element K. The task is to find the index of
//    the given element K in the array A.
//
//    Input:
//    The first line of the input contains an integer T, denoting the total number
//    of test cases. Then T test cases follow. Each test case consists of three lines.
//    First line of each test case contains an integer N denoting the size of the given array.
//    Second line of each test case contains N space separated integers denoting the elements of
//    the array A. Third line of each test case contains an integer K denoting the element to be
//    searched in the array.
//
//    Output:
//    Corresponding to each test case, output the index of the element
//    found in the array.  If element is not present, then output -1.
//
//    Constraints:
//    1 ≤ T ≤ 100
//    1 ≤ N ≤ 107
//    0 ≤ Ai ≤ 108
//    1 ≤ K ≤ 108
//
//    Example:
//    Input:
//    3
//    9
//    5 6 7 8 9 10 1 2 3
//    10
//    3
//    3 1 2
//    1
//    4
//    3 5 1 2
//    6
//
//    Output:
//    5
//    1
//    -1
public class SearchInRotatedArray {

    public int solution(int[] ar, int k){
        System.out.println("find " + k);
        int r = findRotationInx(ar);
        int inx = findK(ar, k, 0, ar.length - 1, r);

        return inx;
    }

    // r = 3
    // i1 = 6, i2 = 5
    // 5 6 7 8 9 10 1 2 3
    private int findK(int[] ar, int k, int i1, int i2, int r) {
        int i1fixed = getFixedInx(i1,  r, ar.length);
        int len = i2 - i1 + 1;
        if (len == 1){
            if (ar[i1fixed] == k){
                return i1fixed;
            } else {
                return -1;
            }
        }
        int mid = i1 + len/2;
        int fixedmid = getFixedInx(mid, r , ar.length);

        if (k == ar[fixedmid]){
            return fixedmid;
        } else if (k < ar[fixedmid]){
            return findK(ar, k, i1, i1 + mid - 1,  r);
        } else {
            return findK(ar, k, i1 + mid + 1, i2, r);
        }

    }

    int getFixedInx(int i, int r, int n){
        return ((i+r)% n);
    }

    private int findRotationInx(int[] ar){
        for (int i = 0; i < ar.length - 1; i++){
            if (ar[i] > ar[i+1]){
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
 //       Scanner in = new Scanner(System.in);
 //       int T = Integer.valueOf(in.nextLine());
       // System.out.println("\nn = " + T);
        SearchInRotatedArray s = new SearchInRotatedArray();
//
//        int[] res = new int[T];
//        for (int i = 0; i < T; i++){
//            int n = Integer.valueOf(in.nextLine());
//            int[] ar = new int[n];
//            for (int j = 0; j < n; j++){
//                ar[j] = in.nextInt();
//            }
//            int k = in.nextInt();
//            in.nextLine();
//            res[i] = s.solution(ar, k);
//
//        }
//
//
//        System.out.println();
//        for (int i = 0; i < T; i++){
//            System.out.println(res[i]);
//        }
        int[] ar = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int inx = s.solution(ar, 3);
        System.out.println(inx);


        int[] b = {1, 2, 3 , 5, 6, 7, 8, 9, 10};
        inx = s.solution(ar, 3);
        System.out.println(inx);

        inx = s.solution(ar, 1);
        System.out.println(inx);

        inx = s.solution(ar, 10);
        System.out.println(inx);

        inx = s.solution(ar, 4);
        System.out.println(inx);

    }

}
