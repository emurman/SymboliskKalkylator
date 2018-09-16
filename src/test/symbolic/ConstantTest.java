package test.symbolic;

import org.junit.jupiter.api.Test;
import symbolic.Constant;
import test.Epsilon;

import static org.junit.jupiter.api.Assertions.*;

class ConstantTest {
    @Test
    void getName() {
        assertEquals("5.0", new Constant(5).getName());
    }

    @Test
    void eval() {
        Constant c = new Constant(5);
        assertEquals(c, c.eval(null));
    }

    @Test
    void getValue() {
        assertEquals(3d, new Constant(3).getValue(), Epsilon.EPSILON);
    }

    @Test
    void isConstant() {
        assert(new Constant(0).isConstant());
    }

    @Test
    void priority() {
        assertEquals(10, new Constant(0).priority());
    }

}