package Calculadora;



import java.io.FileReader;
import java.io.PrintStream;

public class Calculadora {
    public static PrintStream out;

    public static void main(String[] argv) {
        try {
            String fileName = argv[0];
            parser p = new parser(new Yylex(new FileReader(fileName)));
            try {
                System.out.println(p.parse().value);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Caught an exception.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

