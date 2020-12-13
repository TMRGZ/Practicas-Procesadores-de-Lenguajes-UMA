import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TablaSimbolos {
    public static LinkedList<HashMap<String, String>> linkedList = new LinkedList<>();
    public static HashMap<String, String> registro = new HashMap<>();
    public static HashMap<String, String> casteos = new HashMap<>();
    public static String[] tiposSoportados = {"int", "float", "char"};


    public TablaSimbolos() {
    }


    public static void put(String st, String t, boolean sustituir) {
        String[] entrada = st.split(":");
        String aMeter = entrada[0];

        if (!sustituir){
            if (esta(getNivel().keySet(), aMeter) && !getNivel().get(st).equals("")) {
                System.out.println("# ERROR: Variable \"" + aMeter + "\" ya ha sido declarada");
            } else if (entrada.length > 1 && !getTipo(entrada[1]).equals("")) {
                System.out.println("# ERROR: No se puede iniciar un array con una variable");
            }
        }
        getNivel().put(st, t);
    }

    public static void put(String st, String t) {
        put(st, t, false);
    }

    public static boolean esta(Set<String> set, String buscado) {
        for (String s : set) {
            String actual = s.split(":")[0];

            if (actual.equals(buscado)) return true;
        }
        return false;
    }

    public static String get(String st) {
        if (linkedList.isEmpty()) linkedList.addLast(new HashMap<>());

        String aBuscar = st.split(":")[0];
        aBuscar = aBuscar.replaceAll("_[0-9][1-9]*", "");

        int cont = linkedList.size();
        boolean enc = false;
        ListIterator listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            HashMap<String, String> temp = (HashMap<String, String>) listIterator.previous();

            if (esta(temp.keySet(), aBuscar)) {
                enc = true;
                break;
            }
            cont--;
        }

        if (!enc && st.split(":").length == 1 && !st.startsWith("_") && tipoValor(st).equals("") ) {
            System.out.println("error;");
            System.out.println("# Variable no declarada");

            System.out.println(st);
            System.out.println(linkedList);

            return "";
        } else {
            return cont <= 1 ? "" : "_" + cont;
        }
    }

    public static String getMatriz(String st) {
        if (linkedList.isEmpty()) linkedList.addLast(new HashMap<>());

        String res = "";
        String stAux = st.split(":")[0];
        stAux = stAux.replaceAll("_" + linkedList.size(), "");

        ListIterator listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            HashMap<String, String> temp = (HashMap<String, String>) listIterator.previous();

            for (String s : temp.keySet()) {
                if (s.split(":")[0].equals(stAux)) {
                    return s;
                }
            }
        }
        return res;
    }

    public static String getConcat(String st) {
        if (linkedList.isEmpty()) {
            linkedList.addLast(new HashMap<>());
        }
        int cont = linkedList.size();

        boolean enc = false;

        ListIterator listIterator = linkedList.listIterator(linkedList.size());


        while (listIterator.hasPrevious()) {
            HashMap<String, Integer> temp = (HashMap<String, Integer>) listIterator.previous();

            for (String s : temp.keySet()) {
                String sC = cont > 1 ? s + "_" + cont : s;

                if (sC.equals(st)) {
                    enc = true;
                    break;
                }
            }
            cont--;
        }

        if (!enc) {
            System.out.println("error;");
            System.out.println("# Variable no declarada");
            //System.out.println(st);
            //System.out.println(linkedList);
        }

        return st;
    }

    public static String getTipo(String st) {
        if (linkedList.isEmpty()) linkedList.addLast(new HashMap<>());

        String res = "";
        String stAux = st.split(":")[0];
        stAux = stAux.replaceAll("_" + linkedList.size(), "");

        ListIterator listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            HashMap<String, String> temp = (HashMap<String, String>) listIterator.previous();

            if (esta(temp.keySet(), stAux)) {
                res = getTipo(temp, stAux);
                break;
            }
        }
        return res;
    }

    public static String tipo(String string){
        String res = "";

        for (String tipo : tiposSoportados) {
            if (es(tipo, string)){
                res =  tipo;
            }
        }

        return res;
    }

    private static String getTipo(HashMap<String, String> temp, String st) {
        for (String s : temp.keySet()) {
            if (s.split(":")[0].equals(st)) {
                return temp.get(s);
            }
        }

        return null;
    }

    public static void putRegistro(String st, String t) {
        registro.put(st, t);
    }

    public static String getRegistro(String st) {
        return registro.keySet().contains(st) ? registro.get(st) : "";
    }

    public static int operacionReal(String e1, String e2) {
        if (es("float", e1) && !es("float", e2)) {
            return 2;
        } else if (!es("float", e1) && es("float", e2)) {
            return 1;
        } else if (es("float", e1) && es("float", e2)) {
            return 3;
        } else {
            return 0;
        }
    }

    public static boolean es(String tipo, String string) {
        return TablaSimbolos.getTipo(string.split(":")[0]).equals(tipo) || TablaSimbolos.getRegistro(string.split(":")[0]).equals(tipo) || tipoValor(string.split(":")[0]).equals(tipo);
    }

    public static String tipoValor(String st) {
        String esFloat = "[+-]?([0-9][1-9]*\\.[0-9]+([Ee]-[1-9])?)";
        Pattern pFloat = Pattern.compile(esFloat);
        Matcher mFloat = pFloat.matcher(st);

        String esInt = "0|([+-]?[1-9][0-9]*)";
        Pattern pInt = Pattern.compile(esInt);
        Matcher mInt = pInt.matcher(st);

        String esChar = "'\\\\?(.)'";
        Pattern pChar = Pattern.compile(esChar);
        Matcher mChar = pChar.matcher(st);

        String res = "";


        if (mFloat.find() && mFloat.group().equals(st)) {
            res = "float";
        } else if (mInt.find() && mInt.group().equals(st)) {
            res = "int";
        } else if (mChar.find() && mChar.group().equals(st)){
            res = "char";
        }
        return res;
    }

    public static HashMap<String, String> getNivel() {
        if (linkedList.isEmpty()) {
            linkedList.addLast(new HashMap<>());
        }

        return linkedList.getLast();
    }

    public static void quitarNivel() {
        linkedList.removeLast();
    }

    public static void anadirNivel() {
        if (linkedList.isEmpty()) {
            linkedList.addLast(new HashMap<>());
        }

        linkedList.addLast(new HashMap<>());
    }

}
