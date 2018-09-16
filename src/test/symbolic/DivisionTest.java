package test.symbolic;

import org.junit.jupiter.api.Test;
import symbolic.Constant;
import symbolic.Division;
import test.Epsilon;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    @Test
    void getName() {
        assertEquals("/", new Division(null, null).getName());
    }

    @Test
    void priority() {
        assertEquals(4, new Division(null, null).priority());
    }

    @Test
    void eval() {
        Division a = new Division(new Constant(10), new Constant(2));
        Division b = new Division(new Constant(-5), new Constant(-2));

        double aResult = a.eval(null).getValue();
        double bResult = b.eval(null).getValue();

        assertEquals(5d, aResult, Epsilon.EPSILON);
        assertEquals(2.5d, bResult, Epsilon.EPSILON);
    }

}