package symbolic;

import java.util.Map;

/**
 * Log operator.
 *
 * Perform the Log function on an argument.
 * Uses the base 10.
 */

public class Log extends Unary {

    /**
     * Create a new Log object. Takes another
     * expression as its parameter.
     *
     * @param argument the parameter to this log function
     */

    public Log(Sexpr argument) {
        super(argument);
    }

    /**
     * Get the name of this operator.
     *
     * @return the string "log"
     */

    @Override
    public String getName() {
        return "log";
    }

    /**
     * Evaluate this Log.
     *
     * For details, refer to the documentation of
     * the class Symbolic.
     *
     * @param variables map of defined variables
     * @return the evaluated sin function
     */

    @Override
    public Sexpr eval(Map<String, Sexpr> variables) {
        return Symbolic.log(argument.eval(variables));
    }
}
