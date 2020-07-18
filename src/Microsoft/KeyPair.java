package Microsoft;

import java.util.*;

public class KeyPair {
    public boolean solution(int[] a, int x){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++){
            add(map, a[i]);
        }
        for (int j = 0; j < a.length; j++){
            reduce(map, a[j]);
             if (map.containsKey(x-a[j])){
                return true;
            }
        }
        return false;
    }

    private void add(Map<Integer, Integer> map, int x){
        if (map.containsKey(x)) {
            int count = map.get(x) + 1;
            map.replace(x, count);
        } else {
            map.put(x, 1);
        }
    }

    private void reduce(Map<Integer, Integer> map, int x){
        if (map.containsKey(x)) {
            int count = map.get(x) - 1;
            if (count == 0){
                map.remove(x);
            } else {
                map.replace(x, count);
            }

        }
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
        answer = k.solution(d, x)? "Yes": "No";
        System.out.println(answer);

        x = 4;
        int e[] = {1, 2, 2, 6, 7};
        answer = k.solution(e, x)? "Yes": "No";
        System.out.println(answer);

    }

}
