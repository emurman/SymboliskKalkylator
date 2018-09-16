package symbolic;

import java.util.Map;

/**
 * Addition extends our class binary and does addition operation
 */
public class Addition extends Binary {


    /**
     * Constructor for Addition
     * @param left a Sexpr
     * @param right a Sexpr
     */
    public Addition(Sexpr left, Sexpr right) {
        super(left, right);
    }

    /**
     * Getname overrides and return the string symbol in our Sexpr
     * @return a + since it is a addition operation
     */
    @Override
    public String getName() {
        return "+";
    }
    /**
     * priority of addition is overridden and set to 1.
     * @return priority 1
     */
    @Override
    public int priority() {
        return 1;
    }

    /**
     *Our Sexpr for addition evaluation
     * @param a variables mapped to a String and Sexpr
     * @return a evalulation between the left and right variables
     */
    @Override
    public Sexpr eval(Map<String, Sexpr> variables) {
        return Symbolic.add(left.eval(variables), right.eval(variables));
    }
}
