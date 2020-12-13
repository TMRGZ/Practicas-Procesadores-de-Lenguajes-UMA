/**
 * Esto en JFlex
 */
public class lex {
    int yylex() {

    }
}

public class Automatizacion {
    static int token;
    static int NUM = 257;
    static int POR = 258;
    static int MAS = 259;
    static int AP = 260;
    static int CP = 261;
    static int EOF = 0;

    public static void main() {
        token = yylex();
        s();
        if (token != EOF) {
            error();
        }
    }

    public static void s() {

    }

    public static void e() {
        switch (token) {
        case AP:

            break;
        case NOM:
            t();
            eprima();
            break;
        default:
            error();
            break;
        }
    }

    protected static void eprima() {
        switch (token) {
        case MAS:
            if (token == MAS) {
                token = yylex();
            } else {
                error();
            }
            t();
            eprima();
            break;
        case CP:
        case EOF:
            break;
        default:
            error();
        }
    }

    protected static void t() {

    }

    private static void tprima() {

    }

    protected static void f() {
        switch (token) {
        case AP:
            if (token == AP) {
                token = yylex();
            } else {
                error();
            }
            e();
            if (token == CP) {
                token = yylex();
            } else {
                error();
            }
            break;
        case NUM:
            if (token == CP) {
                token = yylex();
            } else {
                error();
            }
            break;

        default:
            break;
        }
    }
}