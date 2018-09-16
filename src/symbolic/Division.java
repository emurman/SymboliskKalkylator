package symbolic;

import java.util.Map;

/**
 * Divison is a subclass to Binary
 */
public class Division extends Binary {

    /**
     * Constructor for Divison
     *@param left a Sexpr
     *@param right a Sexpr
     */
    public Division(Sexpr left, Sexpr right) {
        super(left, right);
    }

    /**
     * get name for division
     * Overrides and set name to /
     *@return  a string of the sign /
     */
    @Override
    public String getName() {
        return "/";
    }

    /**
     * Priority for division operation
     * Set the priority
     *@return int of priority
     */
    @Override
    public int priority() {
        return 4;
    }

    /**
     * Evaluation for division
     * @param a variables of mapped strings and Sexpr
     *@return a division evaluation of the current left and right value
     */
    @Override
    public Sexpr eval(Map<String, Sexpr> variables) {
        return Symbolic.div(left.eval(variables), right.eval(variables));
    }
}
