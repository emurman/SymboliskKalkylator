package symbolic;

import java.util.Map;

/**
 * Constant is the only place from which we return a double value
 * Subclass to Atom
 */
public class Constant extends Atom{
    private double value;

    /**
     * Constuctor for Constant
     *@param value a double
     */
    public Constant(double value) {
        this.value = value;
    }
    /**
     * Get name of Constant
     *@return value converted to a string
     */
    public String getName(){
        return this.value + "";
    }
    /**
     * Evaluation for Constant
     * Nothing to evaluate
     *@return this.
     */
    public Sexpr eval(Map<String, Sexpr> variables){
        return this;
    }
    /**
     * Overrides Sexpr and return a double
     *@return value - a double
     */
    public double getValue(){
        return this.value;
    }
    /**
     * isConstant
     * @return set our state to true
     */
    public boolean isConstant(){
        return true;
    }

    /**
     * Priority
     *@return set priority of the method
     */
    @Override
    public int priority() {
        return 10;
    }
}
