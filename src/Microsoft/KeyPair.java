package Microsoft;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KeyPair {
    public boolean solution(int[] a, int x){
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++){
            set.add(a[i]);
        }
        for (int j = 0; j < a.length; j++){
            if (set.contains(x-a[j])){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        KeyPair k = new KeyPair();

//        Scanner in = new Scanner(System.in);
//        int T = Integer.valueOf(in.nextLine());
//
//        for (int i = 0; i < T; i++){
//            int n = in.nextInt();
//            int x = Integer.valueOf(in.nextLine().trim());
//            int[] ar = new int[n];
//            for (int j = 0; j < n; j++){
//                ar[j] = in.nextInt();
//            }
//            String answer = k.solution(ar, x)? "YES": "NO";
//            System.out.println(answer);
//            if (i < T - 1)
//                in.nextLine();
//
//        }

        int x= 16;
        int a[] = {1, 4, 45, 6, 10, 8};
        String answer = k.solution(a, x)? "Yes": "No";

        System.out.println(answer);
        x = 10;
        int[] c = {1, 2, 4, 3, 6};
        answer = k.solution(c, x)? "Yes": "No";
        System.out.println(answer);

        x= 4;
        int d[] = {1, 2, 5, 6, 7};
        answer = k.solution(a, x)? "Yes": "No";
        System.out.println(answer);
    }

}
