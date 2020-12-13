import java.io.FileReader;
import java.io.IOException;

class Calculadora {
    private static String[] reglas = {
            "E -> TE'",
            "E' -> +TE'",
            "E' -> EPSILON",
            "T -> RT'",
            "T' -> -RT'",
            "T' -> EPSILON",
            "R -> VR'",
            "R' -> *VR'",
            "R' -> EPSILON",
            "V -> WV'",
            "V' -> /WV'",
            "V' -> EPSILON",
            "W -> (E)",
            "W -> n"
    };

    private static boolean mirar = false;
    private static StringBuilder sb = new StringBuilder();
    private static Symbol simbolo;
    private static Yylex lex;

    private static Symbol leer() {
        int token = 0;
        try {
            simbolo = lex.yylex();
            if (simbolo == null) {
                simbolo = new Symbol(Symbol.EOF, null);
            }
        } catch (IOException e) {
            System.out.println("IOException");
            System.exit(0);
        }
        return simbolo;
    }

    private static void error() {
        System.out.println("ERROR: Ultimo token leido: " + simbolo.lexema());
        System.exit(1);
    }


    public static void main(String[] arg) {
        if (arg.length > 0) {
            try {
                lex = new Yylex(new FileReader(arg[0]));
                /// .... A completar .....
                simbolo = leer();

                while (simbolo.token() != Symbol.EOF) {
                    sb = new StringBuilder();
                    if (simbolo.token() != Symbol.EOLN) System.out.println(e());
                    simbolo = leer();
                }

            } catch (IOException e) {
            }
        }
    }


    /*************************************************************************
     *********************** A implementar por el alumno *********************
     *************************************************************************/

/// .... A completar .....
    public static int e() {
        int s = 0;

        switch (simbolo.token()) {
            case Symbol.AP:
            case Symbol.NUMERO:
                if (mirar)
                    System.out.println(reglas[0] + "    " + sb.toString());
                int v = t();
                s = ep(v);

                //System.out.println(v);
                break;
            case Symbol.MENOS:
                simbolo = leer();
                sb.append("-");
                //s = -e();
                v = -t();
                s = ep(v);
                //System.out.println(v);
                break;
            default:
                System.out.println("Regla E");
                error();
                break;
        }
        return s;
    }

    public static int ep(int i) {
        int s = 0;

        switch (simbolo.token()) {
            case Symbol.MAS:
                if (mirar)
                    System.out.println(reglas[1] + "    " + sb.toString());
                sb.append("+");
                simbolo = leer();
                //System.out.print("+");
                int tv = t();
                s = ep(i + tv);
                break;
            case Symbol.CP:
            case Symbol.NUMERO:
            case Symbol.AP:
                s = i;
                if (mirar)
                    System.out.println(reglas[2] + "    " + sb.toString());
                break;
            case Symbol.EOLN:
            case Symbol.EOF:
                s = i;
                break;

            default:
                System.out.println("Regla EP");
                error();
                break;
        }
        return s;
    } // Suma

    public static int t() {
        int s = 0;

        switch (simbolo.token()) {
            case Symbol.AP:
            case Symbol.NUMERO:
                if (mirar)
                    System.out.println(reglas[3] + "    " + sb.toString());
                int v = r();
                s = tp(v);
                break;
            case Symbol.MENOS:
                simbolo = leer();
                sb.append("-");
                v = -r();
                s = tp(v);

                break;
            default:
                System.out.println("Regla T");
                error();
                break;
        }

        return s;
    }

    public static int tp(int i) {
        int s = 0;

        switch (simbolo.token()) {
            case Symbol.MENOS:
                sb.append("-");
                if (mirar)
                    System.out.println(reglas[4] + "    " + sb.toString());
                simbolo = leer();
                //System.out.print("-");
                int rv = r();
                s = tp(i - rv);
                break;
            case Symbol.CP:
            case Symbol.MAS:
            case Symbol.NUMERO:
            case Symbol.AP:
                s = i;
                if (mirar)
                    System.out.println(reglas[5] + "    " + sb.toString());
                break;
            case Symbol.EOLN:
            case Symbol.EOF:
                s = i;
                break;

            default:
                System.out.println("Regla TP");
                error();
                break;
        }
        return s;
    } // Resta

    public static int r() {
        int s = 0;

        switch (simbolo.token()) {
            case Symbol.AP:
            case Symbol.NUMERO:
                if (mirar)
                    System.out.println(reglas[6] + "    " + sb.toString());
                int v = v();
                s = rp(v);
                break;
            case Symbol.MENOS:
                simbolo = leer();
                sb.append("-");
                v = -v();
                s = rp(v);
                break;
            default:
                System.out.println("Regla R");
                error();
                break;
        }

        return s;
    }

    public static int rp(int i) {
        int s = 0;

        switch (simbolo.token()) {
            case Symbol.POR:
                sb.append("*");
                if (mirar)
                    System.out.println(reglas[7] + "    " + sb.toString());
                simbolo = leer();
                //System.out.print("/");
                int vv = v();
                s = rp(i * vv);
                break;
            case Symbol.DIV:
            case Symbol.CP:
            case Symbol.MENOS:
            case Symbol.MAS:
            case Symbol.NUMERO:
            case Symbol.AP:
                s = i;
                if (mirar)
                    System.out.println(reglas[8] + "    " + sb.toString());
                break;
            case Symbol.EOLN:
            case Symbol.EOF:
                s = i;
                break;

            default:
                System.out.println("Regla RP");
                error();
                break;
        }
        return s;
    } // Division

    public static int v() {
        int s = 0;

        switch (simbolo.token()) {
            case Symbol.AP:
            case Symbol.NUMERO:
                if (mirar)
                    System.out.println(reglas[9] + "    " + sb.toString());
                int v = w();
                s = vp(v);
                break;
            case Symbol.MENOS:
                simbolo = leer();
                sb.append("-");
                v = -w();
                s = vp(v);
                break;
            default:
                System.out.println("Regla V");
                error();
                break;
        }
        return s;
    }

    public static int vp(int i) {
        int s = 0;

        switch (simbolo.token()) {
            case Symbol.DIV:
                sb.append("/");
                if (mirar)
                    System.out.println(reglas[10] + "    " + sb.toString());
                simbolo = leer();
                //System.out.print("*");
                int wv = w();
                s = vp(i / wv);
                break;
            case Symbol.POR:
            case Symbol.MENOS:
            case Symbol.MAS:
            case Symbol.CP:
            case Symbol.NUMERO:
            case Symbol.AP:
                s = i;
                if (mirar)
                    System.out.println(reglas[11] + "    " + sb.toString());
                break;
            case Symbol.EOLN:
            case Symbol.EOF:
                s = i;
                break;

            default:
                System.out.println("Regla VP");
                error();
                break;
        }
        return s;
    }

    public static int w() {
        int s = 0;

        switch (simbolo.token()) {
            case Symbol.AP:
                sb.append("(");
                if (mirar)
                    System.out.println(reglas[12] + "    " + sb.toString());
                simbolo = leer();
                int v = e();

                if (simbolo.token() == Symbol.CP) {
                    sb.append(")");
                    if (mirar)
                        System.out.println(reglas[12] + "    " + sb.toString());
                    simbolo = leer();
                }

                s = v;
                break;
            case Symbol.NUMERO:
                sb.append(simbolo.lexema());
                if (mirar)
                    System.out.println(reglas[13] + "    " + sb.toString());
                s = Integer.parseInt(simbolo.lexema());
                simbolo = leer();

                break;
            case Symbol.MENOS:
                simbolo = leer();
                sb.append("-");
                s = -w();
                break;
            default:
                System.out.println("Regla W");
                error();
                break;
        }
        return s;
    }


}
