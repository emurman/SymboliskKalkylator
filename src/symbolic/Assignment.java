package symbolic;

import java.util.Map;

/**
 * Assignment extends binary is used to read expression and identifeir
 */
public class Assignment extends Binary{

    /**
     * Assignment
     *@param left a Sexpr
     *@param right a Sexpr
     */
    public Assignment(Sexpr left, Sexpr right){
        super(left,right);
    }

    /**
     * Get name for assignemnt operations
     * @return a = since we assign a value to something
     */
    public String getName(){
        return "=";
    }

    /**
     * Priority
     *@return an overriden priority value
     */
    @Override
    public int priority() {
        return 0;
    }

    /** Evaluation for assignment
     * assert that the right value is a variables (non constant and not identifier )
     * @param a variables of our mapped strings and Sexpr
     *@return a assignment
     */
    public Sexpr eval(Map<String,Sexpr> variables){
        assert(right.isVariable());
        return Symbolic.assign(left.eval(variables),right, variables);
    }

}
