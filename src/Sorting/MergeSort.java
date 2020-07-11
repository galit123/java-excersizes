package Sorting;

import Arrays.MyArrays;

import java.util.Arrays;

public class MergeSort {

    public int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int[] firstHalf = Arrays.copyOfRange(array, 0, array.length/2);
        int[] secondHalf = Arrays.copyOfRange(array, array.length/2, array.length);
        return merge(mergeSort(firstHalf), mergeSort(secondHalf));
    }

    private int[] merge(int[] ar1, int[] ar2) {
        int res[] = new int[ar1.length + ar2.length];
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;

        System.out.print("merge ar1: ");
        MyArrays.printArr(ar1);
        System.out.print("with ar2: ");
        MyArrays.printArr(ar2);


        while (i1 < ar1.length && i2 < ar2.length) {
            if (ar1[i1] <= ar2[i2]) {
                res[i3] = ar1[i1];
                i1++;
            } else {
                res[i3] = ar2[i2];
                i2++;
            }
            i3++;
        }

        while (i1 < ar1.length) {
            res[i3] = ar1[i1];
            i1++;
            i3++;
        }

        while (i2 < ar2.length) {
            res[i3] = ar2[i2];
            i2++;
            i3++;
        }
        System.out.print("res: ");
        MyArrays.printArr(res);

        return res;
    }

    public static void main(String[] args) {
        int[] ar1 = {0, 2, 3, 5, 8};
        int[] ar2 = {1, 4, 6, 7, 9};
        int[] ar3;
        int[] ar4 = {6, 3, 8, 1, 0, 2, 4, 9, 5, 7};

        System.out.print("ar1: ");
        MyArrays.printArr(ar1);
        System.out.print("ar2: ");
        MyArrays.printArr(ar2);

        MergeSort ms = new MergeSort();
        ar3 = ms.merge(ar1, ar2);

        System.out.print("ar3: ");
        MyArrays.printArr(ar3);

        System.out.println();
        System.out.print("ar4: ");
        MyArrays.printArr(ar4);

        int [] ar5 = ms.mergeSort(ar4);
        System.out.print("ar5: ");
        MyArrays.printArr(ar5);

    }
}
