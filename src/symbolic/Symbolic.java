package symbolic;

import java.util.Map;

public class Symbolic {

    /**
     * Unary functions.
     *
     * Each function below behaves the same way:
     *
     * Check whether the argument of the unary
     * function is a constant. If it is, compute
     * its value using Math library. Otherwise, return a
     * new object of the type associated with the method.
     *
     * @param arg the argument of the function
     * @return the computed value, or a new object if it
     * cannot be computed
     */

    public static Sexpr sin(Sexpr arg) {
        return (arg.isConstant()) ?
                new Constant(Math.sin(arg.getValue())) : new Sin(arg);
    }
    public static Sexpr cos(Sexpr arg) {
        return (arg.isConstant()) ?
                new Constant(Math.cos(arg.getValue())) : new Cos(arg);
    }
    public static Sexpr exp(Sexpr arg) {
        return (arg.isConstant()) ?
                new Constant(Math.exp(arg.getValue())) : new Exp(arg);
    }
        public static Sexpr log(Sexpr arg) {
        return (arg.isConstant()) ?
                new Constant(Math.log10(arg.getValue())) : new Log(arg);
    }
    public static Sexpr negation(Sexpr arg) {
        return (arg.isConstant()) ?
                new Constant(-arg.getValue()) : new Negation(arg);
    }

    /**
     * Binary functions
     *
     * Every function below behaves the same way:
     *
     * Check if both arguments to the binary operation
     * are constants. If they are, compute the value of
     * the operations. Otherwise, return a new object
     * of the type associated with the method.
     *
     * @param left the left hand side argument of the function
     * @param right  the right hand side argument of the function
     * @return the computed value, or a new object if it
     * cannot be computed
     */

    public static Sexpr add(Sexpr left, Sexpr right) {
       if (left.isConstant() && right.isConstant()) {
           return new Constant(left.getValue() + right.getValue());
       } else {
           return new Addition(left, right);
       }
    }

    public static Sexpr sub(Sexpr left, Sexpr right) {
        if (left.isConstant() && right.isConstant()) {
           return new Constant(left.getValue() - right.getValue());
       } else {
           return new Subtraction(left, right);
       }
    }

    public static Sexpr mult(Sexpr left, Sexpr right) {
         if (left.isConstant() && right.isConstant()) {
           return new Constant(left.getValue() * right.getValue());
       } else {
           return new Multiplication(left, right);
       }
    }

     public static Sexpr div(Sexpr left, Sexpr right) {
         if (left.isConstant() && right.isConstant()) {
           return new Constant(left.getValue() / right.getValue());
       } else {
           return new Division(left, right);
       }
    }

    public static Sexpr assign(Sexpr left, Sexpr right, Map<String,Sexpr> variables){
        variables.put(right.getName(), left);
        return left;
    }

    /**
     * Variable function
     *
     * While evaluating an identifier, simply
     * check if the identifier exists in the
     * map of variables. If it does, return
     * the expression associated with the
     * identifier. Otherwise, return
     * a new Variable object.
     *
     * @param ident the identifier
     * @param variables map of defined variables
     * @return an expression if the identifier is
     * found, otherwise a new Variable object.
     */
    public static Sexpr var(String ident, Map<String,Sexpr> variables){
        if (variables.containsKey(ident))
            return variables.get(ident);
        else{
            return new Variable(ident);
        }
    }

}
