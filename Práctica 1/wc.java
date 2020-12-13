import java.io.FileReader;
import java.io.IOException;

public class wc {
    protected static int contLetra = 0;
    protected static int contPalabras = 0;
    protected static int contLineas = 0;

    public static void addLetra(int num) {
        contLetra+=num;
    }

    public static void addLetra() {
        contLetra++;;
    }

    public static void addPalabra() {
        contPalabras++;
    }

    public static void addLinea() {
        contLineas++;
    }

    public static int getLetras() {
        return contLetra;
    }

    public static int getPalabras() {
        return contPalabras;
    }

    public static int getLineas() {
        return contLineas;
    }

    public static void reset() {
        contLineas = 0;
        contPalabras = 0;
        contLetra = 0;
    }

    public static void main(String arg[]) {
        if (arg.length > 0) {
            try {
                Yylex lex = new Yylex(new FileReader(arg[0]));
                Yytoken yytoken = null;
                while ((yytoken = lex.yylex()) != null) {
                    if (yytoken.getToken() == Yytoken.PALABRA) {
                        wc.addPalabra();
                        wc.addLetra(yytoken.getPalabraLong());
                    } else if (yytoken.getToken() == Yytoken.LINEA) {
                        wc.addLinea();
                        wc.addLetra();
                    } else if (yytoken.getToken() == Yytoken.FIN){
                        wc.addLetra();
                    } else if(yytoken.getToken() == Yytoken.LETRA) {
                        wc.addLetra();
                    }
                }
                System.out.println((wc.getLineas()) + "    " + wc.getPalabras() + "    " + wc.getLetras() + " " + arg[0]);
            } catch (IOException e) {
            }
        }
    }

}
