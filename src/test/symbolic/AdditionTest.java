package test.symbolic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import symbolic.Addition;
import symbolic.Constant;
import test.Epsilon;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {
    @Test
    void getName() {
        Assertions.assertEquals("+", new Addition(null, null).getName());
    }

    @Test
    void priority() {
        assertEquals(1, new Addition(null, null).priority());
    }

    @Test
    void eval() {
        Addition a = new Addition(new Constant(3), new Constant(5));
        Addition b = new Addition(new Constant(-2), new Constant(-8));

        double aResult = a.eval(null).getValue();
        double bResult = b.eval(null).getValue();

        assertEquals(8d, aResult, Epsilon.EPSILON);
        assertEquals(-10d, bResult, Epsilon.EPSILON);
    }
}