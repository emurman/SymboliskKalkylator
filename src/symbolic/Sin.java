package symbolic;

import java.util.Map;

/**
 * Sin operator.
 *
 * Perform the sin function on an argument.
 */

public class Sin extends Unary {

    /**
     * Create a new Sin object. Takes another
     * expression as its parameter.
     * @param argument the parameter to this sin function
     */

    public Sin(Sexpr argument) {
        super(argument);
    }

    /**
     * Get the name of this function.
     * @return the string "sin"
     */

    @Override
    public String getName() {
        return "sin";
    }

    /**
     * Evaluate this Sin.
     *
     * For details, refer to the documentation of
     * the class Symbolic.
     *
     * @param variables map of defined variables
     * @return the evaluated sin function
     */

    @Override
    public Sexpr eval(Map<String, Sexpr> variables) {
        return Symbolic.sin(argument.eval(variables));
    }
}
