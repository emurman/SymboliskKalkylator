package symbolic;

import java.util.Map;

/**
 * Negation operator.
 *
 * Get the negation of an expression.
 */

public class Negation extends Unary {

    /**
     * Create a new Negation operator.
     * @param argument an expression to negate
     */

    public Negation(Sexpr argument) {
        super(argument);
    }

    /**
     * Get the name of this operator.
     * @return the string "-"
     */

    @Override
    public String getName() {
        return "-";
    }

   /**
     * Evaluate this Negation.
     *
     * For details, refer to the documentation of
     * the class Symbolic.
     *
     * @param variables map of defined variables
     * @return the evaluated sin function
     */

    @Override
    public Sexpr eval(Map<String, Sexpr> variables) {
        return Symbolic.negation(argument.eval(variables));
    }
}
