package test.symbolic;

import org.junit.jupiter.api.Test;
import symbolic.Constant;
import symbolic.Cos;
import test.Epsilon;

import static org.junit.jupiter.api.Assertions.*;

class CosTest {
    @Test
    void getName() {
        assertEquals("cos", new Cos(null).getName());
    }

    @Test
    void eval() {
        assertEquals(0d, new Cos(new Constant(Math.PI / 2)).eval(null).getValue(), Epsilon.EPSILON);
        assertEquals(-1d, new Cos(new Constant(Math.PI)).eval(null).getValue(), Epsilon.EPSILON);
    }
}