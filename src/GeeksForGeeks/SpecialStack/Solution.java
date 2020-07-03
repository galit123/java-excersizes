package GeeksForGeeks.SpecialStack;

public class Solution {
    public static void main(String[] args) {
        SpecialStack s = new SpecialStack();
        int[] a = {18, 19, 15, 29, 12, 22, 10};

        int i = 0;
        while (i < a.length){
            s.push(a[i]); // min 18
            System.out.println("push: " + a[i] + " min: "+ s.getMin() +  " size: " + s.getSize() + " isEmpty: " + s.isEmpty());
            i++;
        }

        while (!s.isEmpty()){
            int x = s.pop();
            System.out.println("pop: " + x + " min "+ s.getMin()+  " size: " + s.getSize() + " isEmpty: " + s.isEmpty());
        }
     }
}
