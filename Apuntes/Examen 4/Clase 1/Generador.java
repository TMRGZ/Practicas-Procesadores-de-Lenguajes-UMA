/**
 * Generador
 */
public class Generador {
    private static int indiceTemp = 1;
    
    public static String nuevaTemp() {
        return "_t" + indiceTemp++;
    }

    public static void salida(int INST, String arg1, String arg2, String res) {
        if (INST == Gem.SUMA) {
            System.out.println(res + "=" + arg1 + "+" + "arg2");
        }
    }
    
}