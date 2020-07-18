package GeeksForGeeks;


import java.util.*;
//    Given an array of N positive integers, print k largest elements from the array.  The output elements should be printed in decreasing order.
//
//    Input:
//    The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N and k, N is the size of array and K is the largest elements to be returned. The second line of each test case contains N input C[i].
//
//    Output:
//    Print the k largest element in descending order.
//
//    Constraints:
//    1 ≤ T ≤ 100
//    1 ≤ N ≤ 100
//    K ≤ N
//    1 ≤ C[i] ≤ 1000
//
//    Example:
//    Input:
//    2
//    5 2
//    12 5 787 1 23
//    7 3
//    1 23 12 9 30 2 50
//
//    Output:
//    787 23
//    50 30 23
//
//    Explanation:
//    Testcase 1: 1st largest element in the array is 787 and second largest is 23.
//    Testcase 2: 3 Largest element in the array are 50, 30 and 23.

public class LargestKElements {

    public static void largestKElements(int[] ar, int k){
        List<Integer> list = new LinkedList();

        for (int i = 0; i < ar.length; i++){
            list.add(ar[i]);
        }

        Collections.sort(list);


        Iterator<Integer> iterator = list.listIterator(list.size() - k);
        printListDsc(iterator);
         System.out.println();

    }

    private  static void printListDsc(Iterator<Integer> iterator) {
        if (iterator.hasNext()){
            int x = iterator.next();
            printListDsc(iterator);
            System.out.print(x + " ");

        }

    }

    public static void main(String[] args) {
        int[] ar1 = {12, 5, 787, 1, 23};
        largestKElements(ar1, 2);
        //787 23

        int[] ar2 = {1, 23, 12, 9, 30, 2, 50};
        largestKElements(ar2, 3);
        //50 30 23

        int[] ar3 = {335, 501, 170, 725, 479, 359, 963, 465, 706, 146, 282, 828, 962, 492, 996, 943, 828, 437, 392, 605, 903, 154, 293, 383, 422, 717, 719, 896, 448, 727, 772, 539, 870, 913, 668, 300, 36, 895, 704, 812, 323, 33};
        largestKElements(ar3, 30);
        //996 963 962 943 913 903 896 895 870 828 828 812 772 727 725 719 717 706 704 668 605 539 501 492 479 465 448 437 422 392

    }
}
