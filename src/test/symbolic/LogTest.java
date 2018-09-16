package test.symbolic;

import org.junit.jupiter.api.Test;
import symbolic.Constant;
import symbolic.Log;
import test.Epsilon;

import static org.junit.jupiter.api.Assertions.*;

class LogTest {
    @Test
    void getName() {
        assertEquals("log", new Log(null).getName());
    }

    @Test
    void eval() {
        assertEquals(0, new Log(new Constant(1)).eval(null).getValue(), Epsilon.EPSILON);
        assertEquals(1, new Log(new Constant(10)).eval(null).getValue(), Epsilon.EPSILON);
        assertEquals(4, new Log(new Constant(10000)).eval(null).getValue(), Epsilon.EPSILON);
    }
}