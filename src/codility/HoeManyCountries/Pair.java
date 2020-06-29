package codility.HoeManyCountries;

import java.util.Objects;

public class Pair {
    int i;
    int j;
    int color;

    public Pair(int i, int j, int color) {
        this.i = i;
        this.j = j;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "i=" + i +
                ", j=" + j +
                ", color=" + color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return i == pair.i &&
                j == pair.j &&
                color == pair.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j, color);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

}
