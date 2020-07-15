package Microsoft;

public class Questions {
// 1. How to arrange an array of strings in the groups of the same strings
//    which can be obtained by permutating characters in them.
//
// 2. Implement a method that given a sorted array with negative and positive values,
//    find a value that is equal to its index. for example: [-4, 0, 2, 5, 6, 7, 9 ] => will return 3.
//    Do it with better complexity than O(n).
//
// 3. Write code to solve a problem in Polish notation. e.g : 1 2 3 + / is 1/(2+3)
//

    public static int findValueEqualsToIndex(int[] array){
        return findValue(array, 0, array.length);

    }

    private static int findValue(int[] array, int i1, int i2) {
        int length = i2 - i1;
        int middle = i1 + length / 2;
        if (i1 == i2){
            return array[middle] == middle? middle: -9999;
        }
        if (array[middle] == middle){
            return middle;
        } else if (array[middle] < middle){
            return findValue(array, middle, i2);
        } else {
            return findValue(array, i1, middle);
        }
    }

//    First part: Given a sorted array that was "shifted", e.g., [1, 2, 3, 4] ---> [2, 3, 4, 1]
//    write an algorithm that finds the maximum value in the array. Second part: Improve the time
//    complexity using parallel computing.
    private static int findMaxInShiftedArray(int[] array) {
        return 0;
    }

//    Given an NxN matrix where every row and column is sorted,
//    count the negative values.

//    how much memory is int[3000][3000] in bytes and then in MB's.
//    should this size of memory be allocated or static?

//    Given a full binary tree, iterate over it from the top to the bottom
//    while for each level of the tree iterate from left to right.

//    rotate an array from: 1|3|4|6|8 rotate by 2: 6|8|1|3|4

//    you have a tree, return the longest path from root to a leaf.
//    talked about time complexity. then another function that when
//    you needed to use the first function. A little more complex

//    Given an NXN array, filled with battleships that can only be horizontal or
//    vertical, count how many battleships are there in the board. The battleships will
//    always have at least one horizontal/vertical space between them. Solution should be
//    with no extra memory, one pass, and without changing the board.

//   Given a string made of 3 types of brackets, return true if it is a balanced one.
    public static void main(String[] args) {
        int[] a = {-10, -2, 0, 1, 2, 5, 6, 9, 10};
        int res = findValueEqualsToIndex(a);

        System.out.println(res);
    }

}
