package Microsoft;

import Arrays.MyArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {

    List<int[]> findPath(int[][] m, int[] s, int[] e){
        List<int[]> list = new ArrayList<int[]>();
        if (findPath(m, s, e, list)) {
            return list;
        }
        return null;
    }
    boolean findPath(int m[][], int[] s, int[] e, List<int[]> res){
        if ((s[0] == e[0]) && (s[1] == e[1])){
            res.add(s);
            return true;
        } else if (m[s[0]][s[1]] == 0){
            res.add(s);
            int[] next = new int[2];
            if (s[1] < m.length - 1) {
                next[0] = s[0];
                next[1] = s[1] + 1;
                if (findPath(m, next, e, res)) {
                    return true;
                }
            }
            if (s[0] < m.length - 1) {
                next[0] = s[0] + 1;
                next[1] = s[1];
                if (findPath(m, next, e, res)) {
                    return true;
                }
            }
            if (s[0] > 0){
                next[0] = s[0] - 1;
                next[1] = s[1];
                if (findPath(m, next, e, res)) {
                    return true;
                }
            }
            if (s[1] > 0){
                next[0] = s[0];
                next[1] = s[1] - 1;
                if (findPath(m, next, e, res)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{0,1,0,0},
                     {0,1,0,0},
                     {0,0,0,1},
                     {1,1,0,0}
        };

        int[][] b = {{0,0,1,0},
                     {1,0,1,0},
                     {0,0,1,1},
                     {1,0,0,0}
        };


        Maze m = new Maze();

        int[] s = new int[2];
        s[0] = 1;
        s[1] = 0;
        int[] e = new int[2];
        e[0] = 3;
        e[1] = 3;
        List<int[]> res = m.findPath(a, s, e);
        if (res == null){
            System.out.println("returned null");
        } else {
            for (int[] p : res) {
                System.out.println(Arrays.toString(p));
            }
        }
    }
}
