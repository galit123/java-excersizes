package Microsoft;

public class CountNegativesInMatrix {

//    Given an NxN matrix where every row and column is sorted,
//    count the negative values.
//
//    -10 -6 -3 0   1  3   5
//    -7  -4 -1 0   3  4   6
//    -5  -3 -1 5   7  8   9
//    -2  -1  2 4   6  8   10
//     1   2  3 4   5  8   11
//     4   6  8 10  14 20  23
//     5   8 10 12  17 22  25
//
//      result = 11

    int solution(int[][] a) {
        int N = a.length;

        int count = 0;

        for (int i = 0; i < N && a[i][0] < 0; i++) {
            for (int j = 0; j < N && a[i][j] < 0; j++) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] a = {{-10, -6, -3,  0,   1,  3,  5},
                     {-7,  -4, -1,  0,   3,  4,  6},
                     {-5,  -3, -1,  5,   7,  8,  9},
                     {-2,  -1,  2,  4,   6,  8,  10},
                     { 1,   2,  3,  4,   5,  8,  11},
                     { 4,   6,  8,  10, 14,  20, 23},
                     { 5,   8,  10, 12, 17,  22, 25}
        };
        CountNegativesInMatrix x = new CountNegativesInMatrix();
        int c = x.solution(a);
        System.out.println(c);
    }
}
