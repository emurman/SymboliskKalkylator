package symbolic;

import java.util.Map;

/**
 * Multiplication operator.
 *
 * Multiply two expressions.
 */

public class Multiplication extends Binary {

    /**
     * Create a new Multiplication operator.
     * @param left left hand side of the subtraction
     * @param right right hand side of the subtraction
     */

    public Multiplication(Sexpr left, Sexpr right) {
        super(left, right);
    }

    /**
     * Get the name of this operator.
     *
     * @return the string "*"
     */

    @Override
    public String getName() {
        return "*";
    }

    /**
     * Get the evaluation-priority of this
     * operator.
     *
     * @return the integer 2
     */


    @Override
    public int priority() {
        return 3;
    }

    /**
     * Evaluate this Multiplication.
     * <p>
     * For details, refer to the documentation of
     * the class Symbolic.
     *
     * @param variables map of defined variables
     * @return the evaluated sin function
     */

    @Override
    public Sexpr eval(Map<String, Sexpr> variables) {
        return Symbolic.mult(left.eval(variables), right.eval(variables));
    }
}