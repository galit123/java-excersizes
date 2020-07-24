package UbimoTest;

import java.util.*;


// Ubimo home assignment
public class Items implements Comparator<String>{
    private Map<String, Integer> items = new HashMap<String, Integer>() ;
    private Queue<String> queue = new PriorityQueue<String>(5, this );

    public int compare(String o1, String o2) {
        if ((o1 instanceof String) && (o2 instanceof String)) {
            int n1 = getValue((String) o1);
            int n2 = getValue((String) o2);
            return n2 - n1;
        }
        return 0;
    }

    // Adds a new element
    // Time complexity: O(log(n))
    public Items add(String key){
        if (items.containsKey(key)){             // O(1)
            items.put(key, items.get(key) + 1);  // O(1)
            queue.remove(key);                   // O(log(n))

        } else {
            items.put(key, 1);                   // O(1)
        }
        queue.add(key);                          // O(log(n))
                                                 //
                                                 // total: O(log(n))
        return this;
    }

    // Returns the current value of an item
    // Time complexity: O(log(1))
    public int getValue(String key){
        if (items.containsKey(key)) {            // O(1)
            return items.get(key);               // O(1)
        } else {
            return 0;
        }
                                                 // total: O(1)
    }

    // Removes item from the collection
    // Time complexity: O(log(n))
    public boolean remove(String key){
        if (items.containsKey(key)){             // O(1)
            items.remove(key);                   // O(1)
            queue.remove(key);                   // O(log(n))
            return true;
        }

        return false;                            // total: O(log(n))
    }

    // Returns the top of the priority queue
    // Best case: O(1)
    // Worst case: O(n)
    public List<String> getMaxValues(){
        List<String> res = new ArrayList<String>();
        int topValue = 0;
        int curValue = 0;
        for (int i = 0; !queue.isEmpty() && curValue == topValue; i++){
            String next = queue.poll();
            curValue = getValue(next);
            if (topValue == 0) {
                topValue = curValue;
            }
            if (topValue == curValue) {
                res.add(next);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Items items = new Items();
        items.add("a")
                .add("b")
                .add("b")
                .add("c")
                .add("a");

        List<String> res = items.getMaxValues();
        System.out.println(res);


    }
}
