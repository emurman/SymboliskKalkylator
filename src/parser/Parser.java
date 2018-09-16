package parser;

import symbolic.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Parser {
    StreamTokenizer st;

    /**
     * parser.Parser method
     *@param takes a string of input and reads its into a Byte array stream, which allows us to us the outdated function streamTokenizer to read each token.
     */
    public Parser(String input) {
        InputStream stream = null;
        try {
            stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
            st = new StreamTokenizer(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        st.quoteChar('/');
        st.ordinaryChar('-');
        st.eolIsSignificant(true);
    }

    /**
     * parse our current stream
     *@return statement which controls if the string is an assigment or a command.
     */
    public Sexpr parse() throws IOException{
        return statement();
    }

    /**
     * Statement, our statement is our input stream
     * If the stream equals any of our predefined commands we will go into command() method
     * Otherwise the stream must be an assigment
     *@return result as either a command() or assignment()
     */
    private Sexpr statement() throws IOException {
        Sexpr result = command();

        if (result == null) {
            st.pushBack();
            result = assignment();

            if (st.ttype != st.TT_EOF) {
                throw new SyntaxErrorException("Unexpected " + (char) st.ttype);
            }
        }

        return result;
    }
    /**
     * Command predefined user commands within the system
     * If we have taken this path it must be either a vars or quit command
     * @return either a vars() which prints our all variables with their values or Quit() which ends the program
     * @return otherwise it returns null and we proceed with assignement as in statement()
     */
    private Sexpr command() throws IOException {
        st.nextToken();
        if (st.ttype == st.TT_WORD) {
            if (st.sval.equals("vars")) {
                return new Vars();
            } else if (st.sval.equals("quit")) {
                return new Quit();
            }
        }

        return null;
    }
    /**
     * assignement decides whether we have an expression
     * If we have an expression we will read that next token if the next token is an = sign we will instead do
     * a new Assignment operation
     * @return an expression() and a new Assignment(Sexpr, string)
     */
    private Sexpr assignment() throws IOException {
        Sexpr assign = expression();
        st.nextToken();
        while (st.ttype == '=') {
            assign = new Assignment(assign, identifier());
            st.nextToken();
        }
        st.pushBack();
        return assign;
    }

    /**
     * Expression reads a term and after wards reads addition or substraction before returning the sum
     * @return a Sexpr of the sum of expressions and terms
     */
    private Sexpr expression() throws IOException {
        Sexpr sum = term();
        st.nextToken();
        while (st.ttype == '+' || st.ttype == '-') {
            if (st.ttype == '+') {
                sum = new Addition(sum, term());
            } else {
                sum = new Subtraction(sum, term());
            }
            st.nextToken();
        }
        st.pushBack();
        return sum;
    }
    /**
     * Term, a term consist of mulitplication and division and reads any factors contained within
     * we will conclude all those operation before moving on in accordance with the mathematical  Order of Operation
     *@return a Sexpr product
     */
    private Sexpr term() throws IOException {
        Sexpr prod = factor();
        st.nextToken();
        /**
         * TODO
         * fixa /-tecken
         *
         */
        while (st.ttype == '*' || st.ttype == '\\') {
            if (st.ttype == '*') {
                prod = new Multiplication(prod, factor());
            } else {
                prod = new Division(prod, factor());
            }
            st.nextToken();
        }
        st.pushBack();
        return prod;
    }

    /**
     * A factor can be any of the primarys
     *@return a primary()
     */
    private Sexpr factor() throws IOException {
        return primary();
    }

    /**
     * A primary consist of the highest priority mathematical operations
     * If the primary is a number it must be a consants
     * Otherwise it must be a word
     * If it is a word and if it is anyone of our identified operations those will be run
     * if it is not a number and not an identified word is must be a variable.
     *@return a Sexpr result
     */
    private Sexpr primary() throws IOException {
        Sexpr result;
        st.nextToken();

        if (st.ttype == '(') {
            result = assignment();
            if (st.nextToken() != ')') {
                throw new SyntaxErrorException("expected ')'");
            }
        } else if (st.ttype == st.TT_NUMBER) {
            st.pushBack();
            result = number();
        } else if (st.ttype == st.TT_WORD) {
            st.pushBack();
            result = identifier();
        } else if (st.ttype == '-') {
            return new Negation(primary());
        } else {
            throw new SyntaxErrorException("Unexpected " + (char) st.ttype);
        }

        return result;
    }
    /**
     * Identifier - identifies if the word is any of our predefined operations
     * If such we will return that specific operation
     * otherwise the word must be a variable
     *@return a operation or a variable
     */
    private Sexpr identifier() throws IOException {
        if (st.nextToken() != st.TT_WORD) {
            throw new SyntaxErrorException("Expected identifier");
        }

        if (st.sval.equals("sin")) {
            return new Sin(primary());
        } else if (st.sval.equals("cos")) {
            return new Cos(primary());
        } else if (st.sval.equals("log")) {
            return new Log(primary());
        } else if (st.sval.equals("exp")) {
            return new Exp(primary());
        } else {
            return new Variable(st.sval);
        }
    }
    /**
     * If the next token is a number we will return the constant of the number
     *@return constant
     */
    private Sexpr number() throws IOException {
        if (st.nextToken() != st.TT_NUMBER) {
            throw new SyntaxErrorException("Expected number");
        }
        return new Constant(st.nval);
    }
}
