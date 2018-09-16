package test.symbolic;

import org.junit.jupiter.api.Test;
import symbolic.Constant;
import symbolic.Sin;
import test.Epsilon;

import static org.junit.jupiter.api.Assertions.*;

class SinTest {
   @Test
    void getName() {
        assertEquals("sin", new Sin(null).getName());
    }

    @Test
    void eval() {
        assertEquals(1d, new Sin(new Constant(Math.PI / 2)).eval(null).getValue(), Epsilon.EPSILON);
        assertEquals(0d, new Sin(new Constant(Math.PI)).eval(null).getValue(), Epsilon.EPSILON);
    }

}