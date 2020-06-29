package codility.IsAdjacent;

public class Item implements  Comparable<Item>{
    int inx;
    int value;

    public Item(int inx, int value) {
        this.inx = inx;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "inx=" + inx +
                ", value=" + value +
                '}';
    }

    public int getInx() {
        return inx;
    }

    public void setInx(int inx) {
        this.inx = inx;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Item o) {
        return value - o.value;
    }
}
