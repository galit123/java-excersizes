package GeeksForGeeks.HowManyIlands;

import GeeksForGeeks.HowManyIlands.Indices;

import java.util.*;
//        Given a Matrix consisting of 0s and 1s. Find the number of islands of connected 1s present in the matrix.
//        Note: A 1 is said to be connected if it has another 1 around it (either of the 8 directions).
//
//        Input:
//        The first line of input will be the number of testcases T, then T test cases follow. The first line of each testcase contains two space separated integers N and M. Then in the next line are the NxM inputs of the matrix A separated by space .
//
//        Output:
//        For each testcase in a new line, print the number of islands present.
//
//        Your Task:
//        You don't need to read input or print anything. Your task is to complete the function findIslands() which takes the matrix A and its dimensions N and M as inputs and returns the number of islands of connected 1s present in the matrix. A 1 is said to be connected if it has another 1 around it (either of the 8 directions).
//
//        Expected Time Complexity: O(N*M).
//        Expected Auxiliary Space: O(N*M).
//
//        Constraints:
//        1 <= T <= 100
//        1 <= N, M <= 100
//        0 <= A[i][j] <= 1
//
//        Example(To be used only for expected output) :
//        Input
//        2
//        3 3
//        1 1 0 0 0 1 1 0 1
//        4 4
//        1 1 0 0 0 0 1 0 0 0 0 1 0 1 0 0
//
//        Output
//        2
//        2
//
//        Explanation:
//        Testcase 1: The graph will look like
//        1 1 0
//        0 0 1
//        1 0 1
//        Here, two islands will be formed
//        First island will be formed by elements {A[0][0] ,  A[0][1], A[1][2], A[2][2]}
//        Second island will be formed by {A[2][0]}.
//        Testcase 2: The graph will look like
//        1 1 0 0
//        0 0 1 0
//        0 0 0 1
//        0 1 0 0
//        Here, two islands will be formed
//        First island will be formed by elements {A[0][0] ,  A[0][1], A[1][2], A[2][3]}
//        Second island will be formed by {A[3][1]}.
public class IsIslands {
    // Function to find the number of island in the given list A
    // N, M: size of list row and column respectively

//    1 1 0 0
//    0 0 1 0
//    0 0 0 1
//    0 1 0 0

//    1 1 0
//    0 0 1
//    1 0 1
    static int findIslands(int[][] A) {
        Set<Indices> alreadyVisited = new HashSet<Indices>();
        int N = A.length;
        int M = A[0].length;

        int[][] tmp = new int[N+2][M+2];

        for (int x = 0; x < N + 2; x++){
            for (int  y = 0; y  < M + 2; y++){
                if ((x == 0) || (x == N + 1) || (y == 0) || (y == M + 1)){
                    tmp[x][y] = 0;
                } else {
                    tmp[x][y] = A[x-1][y-1];
                }
            }
        }

        int counter = 0;
        Queue<Indices> s = new LinkedList<Indices>();
        int i = 1;
        int j = 1;

        while (i < N + 1) {
            while (j < M + 1) {
                Indices a = new Indices(i, j);
                check(tmp, alreadyVisited, s, a);
                if (!s.isEmpty()){
                    counter++;
                }
                while (!s.isEmpty()) {
                    Indices inx = s.peek();
                    check(tmp, alreadyVisited, s, new Indices(inx.x - 1, inx.y - 1));
                    check(tmp, alreadyVisited, s, new Indices(inx.x - 1, inx.y ));
                    check(tmp, alreadyVisited, s, new Indices(inx.x - 1, inx.y + 1));
                    check(tmp, alreadyVisited, s, new Indices(inx.x , inx.y - 1));
                    check(tmp, alreadyVisited, s, new Indices(inx.x , inx.y + 1));
                    check(tmp, alreadyVisited, s, new Indices(inx.x + 1, inx.y - 1));
                    check(tmp, alreadyVisited, s, new Indices(inx.x + 1, inx.y ));
                    check(tmp, alreadyVisited, s, new Indices(inx.x + 1, inx.y + 1));

                    s.remove(inx);
                }
                j++;
            }
            j = 1;
            i++;
        }
        return counter;
    }

    private static void check(int[][] ar, Set<Indices> alreadyVisited, Queue<Indices> s, Indices inx) {
        if (ar[inx.x][inx.y] == 1) {
            if (!alreadyVisited.contains(inx)) {
                s.add(inx);
                alreadyVisited.add(inx);
            }
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0},{0, 0, 1},{1, 0, 1}};

        int n = findIslands(A);
        System.out.println(n);

        int B[][] = {{1, 1, 0, 0},{0, 0, 1, 0},{0, 0, 0, 1},{0, 1, 0, 0}};
        n = findIslands(B);
        System.out.println(n);

        int C[][] = {{1, 1, 0, 0, 0},{0, 0, 1, 0, 0},{0, 0, 0, 1, 0},{0, 1, 0, 0, 0}, {0, 0, 0, 1, 1}};
        n = findIslands(C);
        System.out.println(n);

//    1 1 0 0 0
//    0 0 1 0 0
//    0 0 0 1 0
//    0 1 0 0 0
//    0 0 0 1 1
    }
}
