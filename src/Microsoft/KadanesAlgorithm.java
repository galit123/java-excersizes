package Microsoft;

import java.util.Scanner;

public class KadanesAlgorithm {
    public int solution(int[] ar){
        int[] sum = new int[ar.length];
        sum[0] = ar[0];
        int max = sum[0];
        for (int i = 1; i < ar.length; i++){
            sum[i] = sum[i - 1] + ar[i];
            if (max < sum[i]){
                max = sum[i];
            }
        }
        return max;
    }

    //max = 0 0 0 0
    //ar =  1 2 3 -2 5
    //sum = 1 3 6 4
    public static void main(String[] args) {
        KadanesAlgorithm k = new KadanesAlgorithm();
//
//        Scanner in = new Scanner(System.in);
//        int T = Integer.valueOf(in.nextLine());
//
//        int[] res = new int[T];
//        for (int i = 0; i < T; i++){
//            int n = Integer.valueOf(in.nextLine());
//            int[] ar = new int[n];
//            for (int j = 0; j < n; j++){
//                ar[j] = in.nextInt();
//            }
//            in.nextLine();
//            res[i] = k.solution(ar);
//
//        }
//
//        System.out.println();
//        for (int i = 0; i < T; i++){
//            System.out.println(res[i]);
//        }


        int[] ar = {1, 2, 3, -2, 5};
        int res = k.solution(ar);
        System.out.println("res = " + res);

        int b[] = {-1, -2, -3, -4};
        res= k.solution(b);
        System.out.println("res = " + res);

        int c[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        res= k.solution(b);
        System.out.println("res = " + res);



    }
}
