package test.symbolic;

import org.junit.jupiter.api.Test;
import symbolic.Constant;
import symbolic.Multiplication;
import test.Epsilon;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {
    @Test
    void getName() {
        assertEquals("*", new Multiplication(null, null).getName());
    }

    @Test
    void priority() {
        assertEquals(3, new Multiplication(null, null).priority());
    }

    @Test
    void eval() {
        Multiplication a = new Multiplication(new Constant(3), new Constant(-5));
        Multiplication b = new Multiplication(new Constant(-2), new Constant(-3));
        Multiplication c = new Multiplication(new Constant(45), new Constant(0));

        double aResult = a.eval(null).getValue();
        double bResult = b.eval(null).getValue();
        double cResult = c.eval(null).getValue();

        assertEquals(-15d, aResult, Epsilon.EPSILON);
        assertEquals(6d, bResult, Epsilon.EPSILON);
        assertEquals(0d, cResult, Epsilon.EPSILON);
    }

}