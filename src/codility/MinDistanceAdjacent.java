package codility;

import MyArrays.MyArrays;

import java.util.*;

public class MinDistanceAdjacent {
    public int solution(int[] A) {

        return 0;
    }



    class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }
    }

    public int solution(int[][] A) {
        Queue<Pair> q = new LinkedList<Pair>();
        int counter = 0;

        int i = 0;
        int j = 0;
        int color = A[0][0];
        q.add(new Pair(i, j));
        int M = A.length;
        int N = A[0].length;
        int B[][] = new int[N][M];
        B[i][j] = counter;

        boolean sameCountry = false;
        while (!q.isEmpty()) {
            Pair p1 = q.peek();
            color = A[p1.i][p1.j];

            if ((p1.i + 1 < N) && (A[p1.i + 1][p1.j] == color)) {
                q.add(new Pair(p1.i + 1, p1.j));
                sameCountry = true;
            }
            if ((p1.j + 1 < M) && (A[p1.i ][p1.j + 1] == color)) {
                q.add(new Pair(p1.i , p1.j + 1));
                sameCountry = true;
            }

            if (!sameCountry) {
                counter++;
                if (j < M) {
                    j++;
                }

                if ((j < M) && (i < N)){
                    i++;
                    if (i >= N){

                    }
                    j = 0;
                }
                q.add(new Pair(i, j));
            }
            q.remove(p1);
        }

        return counter;
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

    public static void main(String[] args) {
        int[][] A =  {{5, 4, 4}, {4, 3, 4}, {3, 2, 4}, {2, 2, 2}, {3, 3, 4}, {1, 4, 4}, {4, 1, 1}};
        MinDistanceAdjacent x = new MinDistanceAdjacent();

        int res = x.solution(A);
        System.out.println(res);

        int B[] = {0, 3, 3, 5, 7, 1, 2};
    }


}
