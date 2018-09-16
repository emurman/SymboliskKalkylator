package symbolic;

/**
 * our abstract class atom extends Sexpr
 *
 */
public abstract class  Atom extends Sexpr {

    /**
     * To string
     *@return a name
     */
    public String toString(){
        return getName();
    }
}
