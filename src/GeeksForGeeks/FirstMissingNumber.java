package GeeksForGeeks;

//    Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing number is to be found.
//
//    Input:
//    The first line of input contains an integer T denoting the number of test cases. For each test case first line contains N(size of array). The subsequent line contains N-1 array elements.
//
//    Output:
//    Print the missing number in array.
//
//    Constraints:
//            1 ≤ T ≤ 200
//            1 ≤ N ≤ 107
//            1 ≤ C[i] ≤ 107
//
//    Example:
//    Input:
//            2
//            5
//            1 2 3 5
//            10
//            1 2 3 4 5 6 7 8 10
//
//    Output:
//            4
//            9
public class FirstMissingNumber {

    //            1 2 3 5
    public int solution(int a[]){
        int missingNum = 0;
        for (int i = 0; i < a.length ; i++){
            missingNum -= a[i];            //  -1, -2, -3, -5
            missingNum += i + 1;           //  0, 0, 0, -1
        }
        missingNum += a.length + 1;

        return missingNum;
    }

    public static void main(String[] args) {
        FirstMissingNumber f = new FirstMissingNumber();
        int[] a = {1 ,2 ,3 ,5};
        int n = f.solution(a);
        System.out.println(n);

        int[] b = {1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,10};
        n = f.solution(b);
        System.out.println(n);
    }
}
