package test.symbolic;

import org.junit.jupiter.api.Test;
import symbolic.Quit;

import static org.junit.jupiter.api.Assertions.*;

class QuitTest {
    @Test
    void getName() {
        assertEquals("quit", new Quit().getName());
    }

    @Test
    void isQuit() {
        assert(new Quit().isQuit());
    }

}