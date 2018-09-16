package symbolic;

import java.util.Map;

/**
 * A variable object.
 *
 * A variable object has an identifier
 * i.e. "x". When a variable is evaluated,
 * it returns the variable itself or it's
 * corresponding expression in the map of variables
 * supplied.
 *
 */

public class Variable extends Atom{
    String ident;

    /**
     * Create a new Variable object.
     *
     * @param ident the identifier of this variable
     */
    public Variable(String ident){
        this.ident = ident;
    }

    /**
     * Evaluate this variable
     * @param variables map of variables
     * @return if variable exists in the map, return the
     * symbolic expression associated with it. otherwise,
     * return the variable itself.
     */

    public Sexpr eval(Map<String, Sexpr> variables){
        return Symbolic.var(ident, variables);
    }

    /**
     * Get the name of this variable.
     * The name of a variable is its identifier.
     *
     * @return the identifier of this variable
     */
    public String getName(){
        return this.ident;
    }

    /**
     * Check whether this expression is a variable.
     *
     * @return true since this is a variable
     */
    public boolean isVariable(){
        return true;
    }

    /**
     * Get the evaluation-priority of this
     * expression.
     * @return the integer 10
     */

    @Override
    public int priority() {
        return 10;
    }
}
