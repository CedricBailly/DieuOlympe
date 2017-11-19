package utils;

/**
 * Class which represent a vector in two dimensions
 */
public class Vector {

    public int x;
    public int y;

    public Vector() {
        this(0, 0);
    }

    public Vector(int i, int i1) {
        this.x = x;
        this.y = y;
    }

    public Vector minus(Vector location) {
        return new Vector(this.x - location.x, this.y - location.y);
    }
}