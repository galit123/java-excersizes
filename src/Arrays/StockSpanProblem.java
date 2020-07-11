package Arrays;

import java.util.Stack;

public class StockSpanProblem {

//    The stock span problem is a financial problem where we have a series of n daily price
//    quotes for a stock and we need to calculate the span of stock’s price for all n days.
//    The span Si of the stock’s price on a given day i is defined as the maximum number of
//    consecutive days just before the given day, for which the price of the stock on the current
//    day is less than or equal to its price on the given day.
//    For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
//    then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
//    Input:
//      N is the size of the array.
//
//    Output:
//      For each testcase, print the span values for all days.
//    Constraints:
//      1 ≤ N ≤ 200
//      1 ≤ C[i] ≤ 800
//
//    Example:
//    Input:
//            100 80 60 70 60 75 85
//            10 4 5 90 120 80
//    Output:
//            1 1 1 2 1 4 6
//            1 1 2 4 5 1
    public int[] solution(int[] p){
        int[] res = new int[p.length];
        res[0] = 1;
        for (int i = 1; i < p.length; i++){
            if (p[i] < p[i-1]){
                res[i] = 1;
            } else {
                int s = 0;
                int j = i;
                while (j >= 0 && p[j] <= p[i]){
                    s++;
                    j--;
                }
                res[i] = s;
            }
        }
        return res;
    }
    void calculateSpan(int price[], int n, int S[])
    {
        // Create a stack and push index of first element
        // to it
        Stack<Integer> st = new Stack<>();
        st.push(0);

        // Span value of first element is always 1
        S[0] = 1;

        // Calculate span values for rest of the elements
        for (int i = 1; i < n; i++) {

            // Pop elements from stack while stack is not
            // empty and top of stack is smaller than
            // price[i]
            while (!st.empty() && price[st.peek()] <= price[i])
                st.pop();

            // If stack becomes empty, then price[i] is
            // greater than all elements on left of it, i.e.,
            // price[0], price[1], ..price[i-1]. Else price[i]
            // is greater than elements after top of stack
            S[i] = (st.empty()) ? (i + 1) : (i - st.peek());

            // Push this element to stack
            st.push(i);
        }
    }
    public static void main(String[] args) {
        StockSpanProblem ssp = new StockSpanProblem();
        int[] a =  {100, 80, 60, 70, 60, 75, 85};
        int[] res = ssp.solution(a);
        MyArrays.printArr(res);

        int S[] = new int[a.length];
        ssp.calculateSpan(a, a.length, S);
        MyArrays.printArr(S);

        int[] b =  {10, 4, 5, 90, 120, 80};
        res = ssp.solution(b);
        MyArrays.printArr(res);

        int S1[] = new int[b.length];
        ssp.calculateSpan(b, b.length, S1);
        MyArrays.printArr(S1);

    }
}
