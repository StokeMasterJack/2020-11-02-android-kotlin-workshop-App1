package akw.app1;

import java.util.Objects;

public class Box2 {

    private int length;
    private int width;

    public Box2(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getHeight() {
        return length;
    }

    public void setHeight(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Box2{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box2 box2 = (Box2) o;
        return length == box2.length &&
                width == box2.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }
}
