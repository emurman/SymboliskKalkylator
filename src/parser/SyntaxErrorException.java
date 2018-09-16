package parser;

public class SyntaxErrorException extends RuntimeException {
    public SyntaxErrorException() {
        super();
    }
    /**
     * Displays a message of what triggered the exception
     */
    public SyntaxErrorException(String msg) {
        super(msg);
    }
}
