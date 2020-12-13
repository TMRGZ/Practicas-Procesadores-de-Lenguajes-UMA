package Feb2014;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class TablaSimbolos {
    public static LinkedList<HashMap<String, String>> linkedList = new LinkedList<>();


    public TablaSimbolos() {
    }

    public static void put(String st, String t) {
        if (getNivel().keySet().contains(st)){
            System.out.println("# ERROR: Variable \"" + st + "\" ya ha sido declarada");
        }

        getNivel().put(st, t);
    }

    public static String get(String st) {
        if (linkedList.isEmpty()) {
            linkedList.addLast(new HashMap<>());
        }
        int cont = linkedList.size();

        boolean enc = false;

        ListIterator listIterator = linkedList.listIterator(linkedList.size());


        while (listIterator.hasPrevious()) {
            HashMap<String, Integer> temp = (HashMap<String, Integer>) listIterator.previous();

            if (temp.keySet().contains(st)) {
                enc = true;
                break;
            }
            cont--;
        }

        if (!enc) {
            System.out.println("error;");
            System.out.println("# Variable no declarada");
            //System.out.println(st);
            //System.out.println(linkedList);

            return "";
        } else {
            return cont <= 1 ? "" : "_" + cont;
        }
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

    public static void quitarNivel() {
        linkedList.removeLast();
    }

    public static void anadirNivel() {
        linkedList.addLast(new HashMap<>());
    }

    public static HashMap<String, String> getNivel() {
        if (linkedList.isEmpty()) {
            linkedList.addLast(new HashMap<>());
        }

        return linkedList.getLast();
    }

}
