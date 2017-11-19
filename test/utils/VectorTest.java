package utils;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorTest {

    private Vector vector;

    @Before
    public void init() {
        this.vector = new Vector(4, 4);
    }

    @Test
    public void testMinus() {
        Vector vec = new Vector(2, 2);
        assertEquals(vec, this.vector.minus(vec));
        assertEquals(this.vector, this.vector.minus(new Vector()));
    }

    @Test
    public void testEquals() {
        assertEquals(this.vector, new Vector(4, 4));
    }
}
