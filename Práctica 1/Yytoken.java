public class Yytoken {
    public final static int LETRA = 127;
    public final static int PALABRA = 128;
    public final static int LINEA = 10;
    public final static int FIN = 1;

    private int token;
    private String palabra;

    public Yytoken(int token) {
        this.token = token;
    }
    
    public Yytoken(int token, String palabra) {
        this.token = token;
        this.palabra = palabra;
    }

    /*public Yytoken(int token, String lexema) {
        this(token, Integer.parseInt(lexema));
    }*/

    public int getToken() {
        return token;
    }

    public int getPalabraLong() {
        return palabra.length();
    }

    public String toString() {
        return "";
    }
}
