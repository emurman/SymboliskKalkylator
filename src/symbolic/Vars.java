package symbolic;

import java.util.Map;

/**
 * Vars command.
 * When the literal 'vars' is entered into
 * the calculator, display all currently assigned
 * variables.
 */

public class Vars extends Command{
    /**
     * Get the name of this command.
     * @return the name of this command
     */
    public String getName(){
        return "vars";
    }

    /**
     * Evaluating this command doesn't make any
     * sense; the object itself is returned.
     * @param variables map of variables
     * @return this object
     */
    public Sexpr eval(Map<String,Sexpr> variables){
        return this;
    }
}
