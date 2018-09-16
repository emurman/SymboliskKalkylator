package test.symbolic;

import org.junit.jupiter.api.Test;
import symbolic.Constant;
import symbolic.Exp;
import test.Epsilon;

import static org.junit.jupiter.api.Assertions.*;

class ExpTest {
    @Test
    void getName() {
        assertEquals("exp", new Exp(null).getName());
    }

    @Test
    void eval() {
        for (int i = 0; i < 3; i++) {
            assertEquals(Math.exp(i), new Exp(new Constant(i)).eval(null).getValue(), Epsilon.EPSILON);
        }
    }

}