package test.symbolic;

import org.junit.jupiter.api.Test;
import symbolic.Vars;

import static org.junit.jupiter.api.Assertions.*;

class VarsTest {
    @Test
    void getName() {
        assertEquals("vars", new Vars().getName());
    }

    @Test
    void eval() {
        Vars v = new Vars();
        assertEquals(v, v.eval(null));
    }

}