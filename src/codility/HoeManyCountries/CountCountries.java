package codility.HoeManyCountries;

import java.util.*;
//A rectangular map consisting of N rows and M columns of square areas is
// given. Each area is painted with a certain color.
//
// Two areas on the map belong to the same country if the following conditions are met:
//
// - they have the same color
// - it is possible to travel from one area to the other orthogonally
// (that is, by moving only north, south, west or east) without
// moving over areas of a different color.
//
// The map can be described by a zero-indexed matrix A consisting of N rows
// and M columns of integers. The color of each area is described by the
// corresponding element of the matrix. Two areas have the same color if and
// only if their corresponding matrix elements have the same value.

// For example, consider the following matrix A consisting of seven rows and three columns:
//A[0][0] = 5    A[0][1] = 4    A[0][2] = 4
//A[1][0] = 4    A[1][1] = 3    A[1][2] = 4
//A[2][0] = 3    A[2][1] = 2    A[2][2] = 4
//A[3][0] = 2    A[3][1] = 2    A[3][2] = 2
//A[4][0] = 3    A[4][1] = 3    A[4][2] = 4
//A[5][0] = 1    A[5][1] = 4    A[5][2] = 4
//A[6][0] = 4    A[6][1] = 1    A[6][2] = 1
//
// Matrix A describea a map that is colored with five colors. The areas on the map belong
// eleven different countries (C1-C11), as shown in the following figure:
//
// Write a function
// class Solution{
//    public int solution(int[][]A);
// }
// that, given a zero-indexed matrix A consisting of N rows and M columns of
// integers, returns the number of different countries to which the area of the
// map described by matrix A belong.
//
// Write an efficient algorithm for the following assumptions:
// - N and M are integers within the range [1..300,000]
// - the number of elements in matrix A is within the range [1..300,000]
// - each elemenet of matrix A is an integer within the range [-1,000,000,000..1,000,000,000].
public class CountCountries {

    private Queue<Pair> q = new LinkedList<Pair>();
    private Set<Pair> alreadyVisited = new HashSet<Pair>();

    public int solution(int[][] A) {
        q.clear();
        alreadyVisited.clear();

        int N = A.length;
        int M = A[0].length;

        int[][] tmp = new int[N+2][M+2];
        int counter = 0;

        copyToSurraoundingMatrix(A,tmp, N, M);

        int i = 1;
        int j = 1;

        while (i < N + 1) {
            while (j < M + 1) {
                check(i, j, tmp, tmp[i][j]);

                if (!q.isEmpty()){
                    counter++;
                }
                while (!q.isEmpty()) {
                    Pair p = q.peek();

                    check(p.i-1, p.j, tmp, p.color);
                    check(p.i, p.j - 1, tmp, p.color);
                    check(p.i+1, p.j, tmp, p.color);
                    check(p.i, p.j+1, tmp, p.color);

                    q.remove(p);
                }
                j++;
            }
            j = 1;
            i++;
        }

        return counter;
    }

    private void check(int i, int j, int[][] ar, int color) {
        Pair p = new Pair(i, j, color);

        if ((ar[i][j] != -1) && (ar[i][j] == color) && !alreadyVisited.contains(p)){
             q.add(p);
             alreadyVisited.add(p);
         }
    }

    private void copyToSurraoundingMatrix(int[][] a, int[][] tmp, int N, int M) {
         for (int i = 0; i < N + 2; i++){
             for (int j = 0; j < M + 2; j++){
                 if ((i == 0) || (j == 0) || (i == N + 1) || (j == M + 1)){
                     tmp[i][j] = -1;
                 } else {
                     tmp[i][j] = a[i-1][j-1];
                 }
             }
         }
    }

    // 5 4 4
    // 4 3 4
    // 3 2 4
    // 2 2 2
    // 3 3 4
    // 1 4 4
    // 4 1 1

    public static void main(String[] args) {
        int[][] A =  {{5, 4, 4}, {4, 3, 4}, {3, 2, 4}, {2, 2, 2}, {3, 3, 4}, {1, 4, 4}, {4, 1, 1}};
        CountCountries x = new CountCountries();

        int res = x.solution(A);
        System.out.println(res);
    }


}
