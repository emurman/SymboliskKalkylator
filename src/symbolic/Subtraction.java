package symbolic;

import java.util.Map;

/**
 * Subtraction operator.
 *
 * Subtracts two expressions from each other.
 */

public class Subtraction extends Binary {

    /**
     * Create a new Subtraction object using
     * two other expressions.
     * @param left left hand side of the subtraction
     * @param right right hand side of the subtraction
     */
    public Subtraction(Sexpr left, Sexpr right) {
        super(left, right);
    }

    /**
     * Get the name of this operator.
     *
     * @return the string "-"
     */

    @Override
    public String getName() {
        return "-";
    }

    /**
     * Get the evaluation-priority of this
     * operator.
     * @return the integer 2
     */

    @Override
    public int priority() {
        return 2;
    }

    /**
     * Evaluate this Subtraction.
     *
     * For details, refer to the documentation of
     * the class Symbolic.
     *
     * @param variables map of defined variables
     * @return the evaluated subtraction
     */

    @Override
    public Sexpr eval(Map<String, Sexpr> variables) {
        return Symbolic.sub(left.eval(variables), right.eval(variables));
    }
}