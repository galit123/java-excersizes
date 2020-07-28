package NovaTest.HowManyCountries;

import java.util.Objects;

public class Pair {
    public int i;
    public int j;
    int color;

    public Pair(int i, int j, int color) {
        this.i = i;
        this.j = j;
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
}
