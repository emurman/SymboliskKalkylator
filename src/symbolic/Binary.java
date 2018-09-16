package symbolic;

/**
 * Binary is subclass to Sexpr
 * is Superclass to Binary operation (add, sub, multi, div , assign)
 */
public abstract class Binary extends Sexpr {
    Sexpr left;
    Sexpr right;

    /**
     * Binary constructor
     *@param left a Sexpr
     *@param right a Sexpr
     */
    public Binary(Sexpr left, Sexpr right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Overrides string method
     * assigns ( ) based on priority
     *@return a built string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (left.priority() < this.priority()) {
            sb.append("(")
                    .append(left.toString())
                    .append(")");
        } else {
            sb.append(left.toString());
        }

        sb.append(" ")
                .append(getName())
                .append(" ");

        if (right.priority() < this.priority()) {
            sb.append("(")
                    .append(right.toString())
                    .append(")");
        } else {
            sb.append(right.toString());
        }

        return sb.toString();
    }
}
