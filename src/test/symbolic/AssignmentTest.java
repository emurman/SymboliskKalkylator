package test.symbolic;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import symbolic.*;
import test.Epsilon;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
    @Test
    void getName() {
        Assertions.assertEquals("=", new Assignment(null, null).getName());
    }

    @Test
    void priority() {
        assertEquals(0, new Assignment(null, null).priority());
    }

    @Test
    void eval() {
        Map<String, Sexpr> var = new HashMap<>();
        Assignment a = new Assignment(new Constant(5d), new Variable("x"));
        double aVal = a.eval(var).getValue();

        assertEquals(5d, aVal, Epsilon.EPSILON);
        assertEquals(5d, var.get("x").getValue(), Epsilon.EPSILON);
    }

}