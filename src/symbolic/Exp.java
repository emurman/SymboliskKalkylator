package symbolic;

import java.util.Map;

/**
 * Exp is a subclass to unary
 * to Exponential calculations
 */
public class Exp extends Unary {

    /**
     * Constructor for Exp
     *@param argument Sexpr
     */
    public Exp(Sexpr argument) {
        super(argument);
    }
    /**
     * Get name for Exponentionall operations
     * Overrides getname and set it to Exp
     *@return a string exp
     */
    @Override
    public String getName() {
        return "exp";
    }

    /**
     * Evaluate Exp operations
     *@param a variables of mapped string and Sexpr
     *@return a evaluated exp.
     */
    @Override
    public Sexpr eval(Map<String, Sexpr> variables) {
        return Symbolic.exp(argument.eval(variables));
    }
}
