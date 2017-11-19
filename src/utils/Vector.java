package utils;

/**
 * Class which represent a vector in two dimensions
 */
public class Vector {

    public double x;
    public double y;

    public Vector() {
        this(0, 0);
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector minus(Vector location) {
        return new Vector(this.x - location.x, this.y - location.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return this.x == vector.x && this.y == vector.y;
    }

    @Override
    public int hashCode() {
        return (int) (31 * this.x + this.y);
    }
}