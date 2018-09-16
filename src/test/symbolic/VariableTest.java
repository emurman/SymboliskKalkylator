package test.symbolic;

import org.junit.jupiter.api.Test;
import symbolic.Constant;
import symbolic.Sexpr;
import symbolic.Variable;
import test.Epsilon;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VariableTest {
    @Test
    void eval() {
        Map<String, Sexpr> var = new HashMap<>();
        var.put("x", new Constant(5));

        assertEquals(5d, new Variable("x").eval(var).getValue(), Epsilon.EPSILON);
    }

    @Test
    void getName() {
        assertEquals("x", new Variable("x").getName());
    }

    @Test
    void isVariable() {
        assert(new Variable(null).isVariable());
    }
}