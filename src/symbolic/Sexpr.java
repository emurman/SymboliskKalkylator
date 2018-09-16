package symbolic;

import java.util.Map;

/**
 * Abstract class Sexpr (=symbolic expression).
 *
 * The base class of all operators, functions,
 * constants, variables and commands.
 *
 */

public abstract class Sexpr {

    /**
     * Abstract method to get the name
     * of every symbolic expression.
     *
     * Must be defined in every class
     * extending this class.
     * @return the name of this expression
     */
    public abstract String getName();

    /**
     * Evaluate this symbolic expression
     * using a Map object containing defined
     * variables.
     *
     * @param variables map of defined variables
     * @return the evaluated expression
     */
    public abstract Sexpr eval(Map<String, Sexpr> variables);

    /**
     * Get the value of this expression.
     *
     * Default implementation throws an exception.
     * Must be specialized if it is to be used.
     *
     * @return the value of this expression.
     */

    public double getValue() {
        throw new NoValueException();
    }

    /**
     * Get the evaluation priority of
     * this expression. Default is 0.
     * @return the priority of this
     * expression.
     */

    public int priority() {
        return 0;
    }

    /**
     * Check whether this expression is
     * a constant. Defaults to false.
     *
     * @return false
     */

    public boolean isConstant() {
        return false;
    }

    /**
     * Check whether this expression is
     * a variable. Defaults to false.
     *
     * @return false
     */

    public boolean isVariable(){
        return false;
    }

    /**
     * Check whether this expression is
     * a Quit command. Defaults to false.
     *
     * @return false
     */

    public boolean isQuit(){
        return false;
    }
}
