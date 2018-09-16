package test.symbolic;

import org.junit.jupiter.api.Test;
import symbolic.Constant;
import symbolic.Subtraction;
import test.Epsilon;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionTest {
    @Test
    void getName() {
        assertEquals("-", new Subtraction(null, null).getName());
    }

    @Test
    void priority() {
        assertEquals(2, new Subtraction(null, null).priority());
    }

    @Test
    void eval() {
        Subtraction a = new Subtraction(new Constant(3), new Constant(5));
        Subtraction b = new Subtraction(new Constant(-2), new Constant(-8));

        double aResult = a.eval(null).getValue();
        double bResult = b.eval(null).getValue();

        assertEquals(-2d, aResult, Epsilon.EPSILON);
        assertEquals(6d, bResult, Epsilon.EPSILON);
    }
}