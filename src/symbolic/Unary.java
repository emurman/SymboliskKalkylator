package symbolic;

/**
 * A Unary object is any operator
 * or function that has exactly one parameter,
 * for instance sin, cos, log, etc.
 */

public abstract class Unary extends Sexpr {
    /**
     * The argument of this operator
     */
    Sexpr argument;

    /**
     * Create a new Unary object. Takes another
     * symbolic expression as a parameter.
     * @param argument the argument of this unary function
     */
    public Unary(Sexpr argument) {
        this.argument = argument;
    }

    /**
     * Override toString() method, always putting
     * parenthesis. For example, "sin(1)"; "-(2)",
     * etc.
     *
     * @return the string representation of this object
     */

    public String toString() {
        return getName() + "(" + argument.toString() + ")";
    }

    /**
     * Get the evaluation-priority of this
     * expression.
     * @return the integer 0
     */

    public int priority() {
        return 0;
    }
}
