package symbolic;

import java.util.Map;

/**
 * Quit command.
 * When the literal 'quit' is entered into
 * the calculator, exit the program.
 */

public class Quit extends Command {

    /**
     * Get the name of this command.
     * @return the string "quit"
     */

    public String getName(){
        return "quit";
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

    /**
     * Check whether this expression is
     * a Quit command.
     *
     * It is.
     *
     * @return true
     */

    public boolean isQuit(){
        return true;
    }
}
