package GeeksForGeeks.HowManyIlands;

import java.util.Objects;

public class Indices {
    int x;
    int y;

    @Override
    public String toString() {
        return "{" + x + ", " + y + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Indices indices = (Indices) o;
        return x == indices.x &&
                y == indices.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Indices(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
