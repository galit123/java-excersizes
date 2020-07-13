package GeeksForGeeks;

import java.util.Scanner;
//    Given a binary number, write a program that prints 1 if given binary number is a multiple of 3.  Else prints 0. The given number can be big upto 2^100. It is recommended to finish the task using one traversal of input binary string.
//
//    Input:
//    The first line contains T denoting the number of testcases. Then follows description of testcases.
//    Each case contains a string containing 0's and 1's.
//
//    Output:
//    For each test case, output a 1 if string is multiple of 3, else 0.
//
//    Constraints:
//    1<=T<=100
//    1<=Length of Input String<=100
//
//    Example:
//    Input:
//    2
//    011
//    100
//
//    Output:
//    1
//    0
public class IsBinaryNumberMultipleOf3 {

    //based on the fact that every pow(2,x) can be written as 3*k+1(if x is even) or 3*k-1(if x is odd).
    public boolean solution(String binaryNumber){
        char[] digits = binaryNumber.toCharArray();
        int odd = 0;
        int even = 0;
        for (int i = 0; i < digits.length; i++){
            if (digits[i] == '1'){
                if (i%2 == 0){
                    even++;
                } else {
                    odd++;
                }
            }
        }
        return Math.abs(even - odd) % 3 == 0;
    }

    public static void readInput () {
        IsBinaryNumberMultipleOf3 ques = new IsBinaryNumberMultipleOf3();
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String[] ts = new String[n];
        for (int i = 0; i < n; i++) {
            String x = in.nextLine();
            boolean is = ques.solution(x);
            int res = is? 1: 0;
            System.out.println(res);
        }
    }


    public static void main(String[] args) {
        IsBinaryNumberMultipleOf3 ques = new IsBinaryNumberMultipleOf3();
        boolean is = ques.solution("0110000001001011000111110001010110001111000101110100010001111111111101000001001010101011100100");
        System.out.println(is? 1: 0);

        is = ques.solution("100100000111111101010010010011010101110110");
        System.out.println(is? 1: 0);

        is = ques.solution("101");
        System.out.println(is? 1: 0);

        is = ques.solution("011");
        System.out.println(is? 1: 0);

        is = ques.solution("100");
        System.out.println(is? 1: 0);
    }
}
