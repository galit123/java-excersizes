package codility.IsAdjacent;

import MyArrays.MyArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//      Given an array as input A[0,1,2,3…N], in this array two elements A[i] and A[j] are said to be adjacent if there is no element in range (A[i],A[j]) i.e, if A[i]=1 and A[j]=5 then A[i] and A[j] are said to be adjacent if array doesn’t contain element in range (1,5).
//
//        Calculate the minimum possible distance j-i where j and i are indices of adjacent element in given array.
//
//        Expected time complexity: O(N logN)
public class IsAdjacent {
    public int solution(int[] A) {
        List<Item> items = new ArrayList<Item>();

        for (int i = 0; i < A.length; i++){
            items.add(new Item(i, A[i]));
        }
        System.out.println(items);

        Collections.sort(items);

        System.out.println(items);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i = 1;
        while (i < items.size()){
            int sub = Math.abs(items.get(i).value - items.get(i - 1).value);
            if (min > sub){
                min =sub;
            }
            if (max < sub){
                max = sub;
            }
            i++;
        }

        return min;
    }

    public static void main(String[] args) {
//                 0  1  2  3  4  5  6
        int B[] = {0, 3, 3, 5, 7, 1, 2};

        //Sorted:
        //0 5 6 1 2 3 4 indexes
        //0 1 2 3 3 5 7 values

        IsAdjacent x = new IsAdjacent();
        int minDistance = x.solution(B);
        System.out.println(minDistance);

        int C[] = {7,1,5};
        minDistance = x.solution(B);
        System.out.println(minDistance);


    }
}
