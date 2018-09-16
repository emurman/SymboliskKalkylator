package symbolic;

import java.util.Map;

/**
 * Cos is subclass ot Unary
 */
public class Cos extends Unary {

    /**
     * Constructor for Cos
     *@param a Sexpr argument
     */
    public Cos(Sexpr argument) {
        super(argument);
    }

    /**
     * get name for Cos
     * Overrides and return string cos
     *@return cos
     */
    @Override
    public String getName() {
        return "cos";
    }

    /**
     * Evaluation for cos
     *
     *@param takes a variable of a mapped string and Sexpr
     *@return a cos  evaluation
     */
    @Override
    public Sexpr eval(Map<String, Sexpr> variables) {
        return Symbolic.cos(argument.eval(variables));
    }
}
