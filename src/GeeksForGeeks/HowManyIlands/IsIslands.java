package GeeksForGeeks.HowManyIlands;

import GeeksForGeeks.HowManyIlands.Indices;

import java.util.*;

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
