package GeeksForGeeks;

public class IsBinaryNumberMultipleOf3 {
//  0000   0   +
//  0001   1
//  0010   2
//  0011   3   +
//  0100   4
//  0101   5
//  0110   6   +
//  0111   7
//  1000   8
//  1001   9   +
//  1010   10
//  1011   11
//  1100   12  +
//  1101   13
//  1110   14
//  1111   15  +

    public boolean solution(String binaryNumber){
        System.out.print(binaryNumber);
        char[] digits = binaryNumber.toCharArray();
        int num = 0;
        for (int i = 0; i < digits.length; i++){
            if (digits[i] == '1'){
                num += Math.pow(2, (digits.length - i - 1));
            }
        }

        System.out.println(" = " + num);
        return num % 3 == 0;
    }


    public static void main(String[] args) {
        IsBinaryNumberMultipleOf3 ques = new IsBinaryNumberMultipleOf3();
        boolean is = ques.solution("0000");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("0001");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("0010");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("0011");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("0100");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("0101");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("0110");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("0111");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("1000");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("1001");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("1010");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("1011");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("1100");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("1101");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("1110");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");

        is = ques.solution("1111");
        System.out.println(" is " + (is? "": "not") + " Multiple of 3");
    }
}
