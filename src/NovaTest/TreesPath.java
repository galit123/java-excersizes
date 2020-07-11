package NovaTest;

import Arrays.MyArrays;

import java.util.*;


//
// there are N trees (numbered 0 - N-1) in the forest. The K-th tree is
// located at coordinates (X[k],Y[k])
// Write a function that given two arrays X and Y consisting of N integers
// each, denoting the positions of trees, returns the width of the widest possible path
// Given X=[1,8,7,3,4,1,8], Y=[6,4,1,8,5,1,7] should return 3
//       X= [5,5,5,7,7,7], Y=[3,4,5,1,3,7] should return 2
//       X= [4,1,5,4], Y=[4,5,1,3] should return 3
//       X= [6,10,1,4,3], Y=[2,5,3,1,6] should return 4

public class TreesPath {
    public int solution(int[] X, int[] Y) {
        List<Integer> xList = new ArrayList<Integer>();

        for (int i = 0; i < X.length; i++) {
            xList.add(X[i]);
        }
        Collections.sort(xList);

        int max = 0;
        int j = 1;
        while (j < xList.size()) {
            int pathLength = xList.get(j) - xList.get(j - 1);
            if (max < pathLength) {
                max = pathLength;
            }
            j++;
        }
        return max;
    }


    public static void main(String[] args) {
        TreesPath t = new TreesPath();
        int[] X = {1, 8, 7, 3, 4, 1, 8};
        int[] Y = {6, 4, 1, 8, 5, 1, 7};
        int counter = 0;
        MyArrays.printArr(X);
        MyArrays.printArr(Y);

        counter = t.solution(X, Y);
        System.out.println(counter);

        int[] X1 = {5, 5, 5, 7, 7, 7};
        int[] Y1 = {3, 4, 5, 1, 3, 7};
        MyArrays.printArr(X1);
        MyArrays.printArr(Y1);

        counter = t.solution(X1, Y1);
        System.out.println(counter);

        int[] X2 = {4,1,5,4};
        int[] Y2 = {4,5,1,3};
        MyArrays.printArr(X2);
        MyArrays.printArr(Y2);

        counter = t.solution(X2, Y2);
        System.out.println(counter);

        int[] X3 = {6,10,1,4,3};
        int[] Y3 = {2,5,3,1,6};
        MyArrays.printArr(X3);
        MyArrays.printArr(Y3);

        counter = t.solution(X3, Y3);
        System.out.println(counter);

    }
}
