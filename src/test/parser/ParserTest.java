package test.parser;

import org.junit.jupiter.api.Test;
import parser.Parser;
import symbolic.Sexpr;
import test.Epsilon;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    @Test
    void parseAddition() {
        String a = "1+2";
        String b = "1+2+3+4+5";

        try {
            assertEquals(3d, new Parser(a).parse().eval(null).getValue(), Epsilon.EPSILON);
            assertEquals(15d, new Parser(b).parse().eval(null).getValue(), Epsilon.EPSILON);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void parseSubtraction() {
        String a = "3-1";
        String b = "10-2-5-10";

        try {
            assertEquals(2d, new Parser(a).parse().eval(null).getValue(), Epsilon.EPSILON);
            assertEquals(-7d, new Parser(b).parse().eval(null).getValue(), Epsilon.EPSILON);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void parseMultiplication() {
        String a = "2*3";
        String b = "10*2*4.5";
        String c = "5*0";

        try {
            assertEquals(6d, new Parser(a).parse().eval(null).getValue(), Epsilon.EPSILON);
            assertEquals(90d, new Parser(b).parse().eval(null).getValue(), Epsilon.EPSILON);
            assertEquals(0d, new Parser(c).parse().eval(null).getValue(), Epsilon.EPSILON);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void parseDivision() {
        String a = "10 \\ 3";
        String b = "-10 \\ 2";

        try {
            assertEquals(3.3333333d, new Parser(a).parse().eval(null).getValue(), Epsilon.EPSILON);
            assertEquals(-5d, new Parser(b).parse().eval(null).getValue(), Epsilon.EPSILON);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void parseUnary() {
        String a = "sin(3.1415)";
        String b = "-log(100) * exp(2)";

        try {
            assertEquals(0d, new Parser(a).parse().eval(null).getValue(), Epsilon.EPSILON);
            assertEquals(-14.7781121d, new Parser(b).parse().eval(null).getValue(), Epsilon.EPSILON);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void parseBigExpression() {
        Map<String, Sexpr> var = new HashMap<>();

        String a = "log((((((log(10 = x) * 20) = y) + y) * x) - 300))";
        String b = "((4 * 2.5 = x) - (x + 10)) \\ log(100)";

        try {
            assertEquals(2d, new Parser(a).parse().eval(var).getValue(), Epsilon.EPSILON);
            assertEquals(-5d, new Parser(b).parse().eval(var).getValue(), Epsilon.EPSILON);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}