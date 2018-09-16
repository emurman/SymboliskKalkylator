import parser.Parser;
import parser.SyntaxErrorException;
import symbolic.Sexpr;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Calculator {
    /**
     * Main method initializes our calculator
     *@param takes a array of strings and parse each string a a time and conclude what operation to do based on that.
     * For every input the calculator output a result depending on the input
     * Global commands are vars and quit
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = null;
        Parser p;

        System.out.println("Welcome to the symbolic calculator");
        Map<String, Sexpr> variables = new TreeMap<>();

        while (true) {
            try {
                System.out.print("? ");
                input = scan.nextLine();

                p = new Parser(input);

                Sexpr result = p.parse().eval(variables);

                if (result.isQuit()) {
                    System.out.println("Bye Bye ;) ");
                    System.exit(0);
                }

                if (result.getName().equals("vars")) {
                    variables.forEach((s, exp) -> System.out.println(s + " : " + exp));
                } else {
                    System.out.println(result);
                    variables.put("ans", result);
                }
            } catch (SyntaxErrorException e) {
                System.out.print("*** Syntax Error: ");
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.err.println("IO Exception!");
            }
        }

    }
}
