package test.symbolic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import symbolic.Constant;
import symbolic.Negation;
import test.Epsilon;

import static org.junit.jupiter.api.Assertions.*;

class NegationTest {
    @Test
    void getName() {
        Assertions.assertEquals("-", new Negation(null).getName());
    }

    @Test
    void eval() {
        assertEquals(-3, new Negation(new Constant(3)).eval(null).getValue(), Epsilon.EPSILON);
        assertEquals(3, new Negation(new Constant(-3)).eval(null).getValue(), Epsilon.EPSILON);
        assertEquals(-3, new Negation(
                new Negation(
                new Constant(-3)))
                .eval(null).getValue(), Epsilon.EPSILON);
    }

}