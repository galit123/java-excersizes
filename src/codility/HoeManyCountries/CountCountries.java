package codility.HoeManyCountries;

import java.util.*;

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

        boolean newCountry = false;
        while (i < N + 1) {
            while (j < M + 1) {
                check(i, j, tmp, tmp[i][j]);

                while (!q.isEmpty()) {
                    newCountry = true;
                    Pair p = q.peek();

                    check(p.i-1, p.j, tmp, p.color);
                    check(p.i, p.j - 1, tmp, p.color);
                    check(p.i+1, p.j, tmp, p.color);
                    check(p.i, p.j+1, tmp, p.color);

                    q.remove(p);
                }
                j++;

                if (newCountry == true) {
                    counter++;
                    newCountry = false;
                }
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


    int abs(int n){
        if (n < 0)
            return -1 * n;
        else
            return n;
    }

    boolean isAdjacent(int x1, int y1, int x2, int y2){
        if (((x1 == x2) && (abs(y1 - y2 ) == 1)) ||
                ((y1 == y2) && abs(x1  - x2) == 1)){
            return true;
        }
        return false;
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

        int B[] = {0, 3, 3, 5, 7, 1, 2};
    }


}
