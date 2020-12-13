import java.util.Arrays;

public class Generator {
    public static int IFGOTO = -35;
    public static int GOTO = -36;
    public static int LABEL = -37;
    public static int CAST = -38;
    public static int ASIG = -39;
    public static int OBJETO = -40;

    private static int indiceTemp = 0;
    private static int indiceLabel = 0;

    public static String nuevaTemp() {
        return "_t" + indiceTemp++;
    }

    public static String nuevaLabel() {
        return "L" + indiceLabel++;
    }

    public static String salida(int inst, String arg1, String arg2, String res) {
        return salida(inst, arg1, arg2, res, false);
    }

    public static String salida(int inst, String arg1, String arg2, String res, boolean desCast) {
        StringBuilder nArg1 = new StringBuilder();
        StringBuilder nArg2 = new StringBuilder();
        StringBuilder nnRes = new StringBuilder();

        //System.out.println("Argumentos divididos");
        String[] arrayArg1 = new String[0];
        String[] arrayArg2;
        String[] arrayRes = new String[0];

        //System.out.println("Arrays sin formato");
        String mArg1 = arg1;
        String mArg2 = arg2;
        String mRes = res;


        if (arg1 != null) {
            arrayArg1 = arg1.split(":");

            if (arrayArg1.length > 1) {
                for (int i = 0; i < arrayArg1.length; i++) {
                    nArg1.append(arrayArg1[i]);
                    if (i % 2 == 0) nArg1.append("[");
                }
                nArg1.append("]");
                arg1 = nArg1.toString();
            }
        }

        if (arg2 != null) {
            arrayArg2 = arg2.split(":");

            if (arrayArg2.length > 1) {
                for (int i = 0; i < arrayArg2.length; i++) {
                    nArg2.append(arrayArg2[i]);
                    if (i % 2 == 0) nArg2.append("[");
                }
                nArg2.append("]");
                arg2 = nArg2.toString();
            }

        }

        if (res != null) {
            arrayRes = res.split(":");

            if (arrayRes.length > 1) {
                for (int i = 0; i < arrayRes.length; i++) {
                    nnRes.append(arrayRes[i]);
                    if (i % 2 == 0) nnRes.append("[");
                }
                nnRes.append("]");
                res = nnRes.toString();
            }
        }

        if (inst == sym.MAS || inst == sym.MENOS || inst == sym.POR || inst == sym.DIV) {
            String op = " ";

            String salida = res == null ? Generator.nuevaTemp() : res;


            // Inicio autocasteo
            if (!desCast) {
                int nOp = TablaSimbolos.operacionReal(arg1, arg2);

                if (nOp != 0) {
                    op = "r ";

                    if (nOp == 1) {
                        arg1 = Generator.salida(Generator.CAST, "float", arg1, null);

                    } else if (nOp == 2) {
                        arg2 = Generator.salida(Generator.CAST, "float", arg2, null);

                    }

                    if (res == null) {
                        TablaSimbolos.putRegistro(salida, "float");
                    }


                } else {
                    if (res == null) {
                        TablaSimbolos.putRegistro(salida, "int");
                    }
                }
            }
            // Fin autocasteo

            String signo = null;

            switch (inst) {
                case sym.MAS:
                    signo = " +";
                    break;
                case sym.MENOS:
                    signo = " -";
                    break;
                case sym.POR:
                    signo = " *";
                    break;
                case sym.DIV:
                    signo = " /";
                    break;
            }
            PLXC.out.println("\t" + salida + " = " + arg1 + signo + op + arg2 + ";");
            return salida;

        } else if (inst == sym.PRINT) {
            //System.out.println(TablaSimbolos.tipo(res));

            if (TablaSimbolos.tipo(res).equals("char") || TablaSimbolos.casteos.keySet().contains(res) && TablaSimbolos.casteos.get(res).equals("char")) {
                if (TablaSimbolos.casteos.keySet().contains(res) && TablaSimbolos.casteos.get(res).equals("int")){
                    if (TablaSimbolos.tipoValor(res).equals("")) {
                        PLXC.out.println("\t" + "print " + res + ";");
                    } else {
                        PLXC.out.println("\t" + "print " + (int) res.charAt(1) + ";");
                    }
                } else {
                    if (TablaSimbolos.tipoValor(res).equals("")) {
                        PLXC.out.println("\t" + "printc " + res + ";");
                    } else {
                        PLXC.out.println("\t" + "printc " + (int) res.charAt(1) + ";");
                    }
                }

            } else {
                PLXC.out.println("\t" + "print " + res + ";");
            }


        } else if (inst == sym.MOD) {
            String temp1 = Generator.salida(sym.DIV, arg1, arg2, null, true);
            String temp2 = Generator.salida(sym.POR, temp1, arg2, null, true);
            String result = Generator.salida(sym.MENOS, arg1, temp2, null, true);
            TablaSimbolos.putRegistro(result, "int");

            return result;
        } else if (inst == IFGOTO) {
            PLXC.out.println("\tif (" + arg1 + arg2 + ") goto " + res + ";");
        } else if (inst == GOTO) {
            PLXC.out.println("\tgoto " + res + ";");
        } else if (inst == LABEL) {
            PLXC.out.println(res + ":");
        } else if (inst == sym.MINUS) {
            String salida = Generator.nuevaTemp();
            PLXC.out.println("\t" + salida + " = -" + arg1 + ";");
            return salida;
        } else if (inst == sym.ENTERO) {
            PLXC.out.println("\t" + res + " = " + arg1);
        } else if (inst == sym.IDENT) {
            if (TablaSimbolos.es("int", arrayRes[0]) && TablaSimbolos.es("float", arrayArg1[0])) {
                System.out.println("Variables no concuerdan");
            } else if (arrayRes.length > 1 && TablaSimbolos.getMatriz(arrayArg1[0]).split(":").length > 1 && arrayRes[1].equals(TablaSimbolos.getMatriz(arrayArg1[0]).split(":")[1])) { // Son matrices del mismo tamano
                Generator.salida(Generator.ASIG, TablaSimbolos.getMatriz(arrayArg1[0]), null, arrayRes[0]);
            }
            PLXC.out.println("\t" + res + TablaSimbolos.get(mRes) + " = " + arg1 + ";");

        } else if (inst == sym.MASMAS || inst == sym.MENOSMENOS) { // PrePosIncremento
            String op = inst == sym.MASMAS ? " +" : " -";
            String incr = "1";

            if (TablaSimbolos.tipo(res).equals("float")) {
                op = op + "r ";
                incr = incr + ".0";
            }

            PLXC.out.println("\t" + res + " = " + res + op + incr + ";");
        } else if (inst == sym.MASIGUAL || inst == sym.MENOSIGUAL || inst == sym.PORIGUAL || inst == sym.DIVIGUAL) {
            String salida = null;

            switch (inst) {
                case sym.MASIGUAL:
                    salida = Generator.salida(sym.MAS, arg1, arg2, res);
                    break;
                case sym.MENOSIGUAL:
                    salida = Generator.salida(sym.MENOS, arg1, arg2, res);
                    break;
                case sym.PORIGUAL:
                    salida = Generator.salida(sym.POR, arg1, arg2, res);
                    break;
                case sym.DIVIGUAL:
                    salida = Generator.salida(sym.DIV, arg1, arg2, res);
                    break;
            }
            return salida;

        } else if (inst == CAST) { // Casteos
            if (TablaSimbolos.tipo(arg2).equals(arg1)) { // Si mismos tipos no hacer nada
                return arg2;
            }
            String salida;


            if (TablaSimbolos.tipoValor(arg2).equals("char")) {
                TablaSimbolos.putRegistro(arg2, "int");
                TablaSimbolos.casteos.put(arg2, "int");
                salida = arg2;
                salida = (int) salida.charAt(1) + "";
            } else if (arg1.equals("char")) {
                salida = arg2;
                TablaSimbolos.casteos.put(salida, "char");
                //TablaSimbolos.putRegistro(salida, arg1);
            } else {
                salida = Generator.nuevaTemp();
                PLXC.out.println("\t" + salida + " = (" + arg1 + ") " + arg2 + ";");
                TablaSimbolos.putRegistro(salida, arg1);
            }


            return salida;

        } else if (inst == ASIG) {
            String salidaResultado = mRes;

            if (TablaSimbolos.tipo(arrayRes[0]).equals(TablaSimbolos.tipo(arrayArg1[0]))) { // Son iguales
                if (arrayRes.length > 1) { // Resultado es una matriz
                    Generator.salida(sym.IDENT, mArg1, null, salidaResultado);

                } else { // Resultado es una variable
                    salidaResultado = mRes;

                    String[] origen = TablaSimbolos.getMatriz(arrayArg1[0]).split(":");
                    String[] destino = TablaSimbolos.getMatriz(arrayRes[0]).split(":");

                    if (origen.length > 1 && destino.length > 1) { // Son arrays

                        if (origen.length != destino.length || Integer.parseInt(origen[1]) > Integer.parseInt(destino[1])) {
                            System.out.println("Origen " + Arrays.toString(origen) + " Destino " + Arrays.toString(destino));
                            System.out.println(Integer.parseInt(origen[1]) < Integer.parseInt(destino[1]));
                            System.out.println("Arrays no compatibles");
                        } else {
                            String traspaso = Generator.nuevaTemp();
                            TablaSimbolos.putRegistro(traspaso, TablaSimbolos.getTipo(origen[0]));

                            for (int i = 0; i < Integer.parseInt(origen[1]); i++) {
                                Generator.salida(sym.IDENT, origen[0] + ":" + i, null, traspaso);
                                Generator.salida(sym.IDENT, traspaso, null, destino[0] + ":" + i);
                            }
                        }
                    } else if (TablaSimbolos.tipoValor(mArg1).equals("char")) {
                        mArg1 = String.valueOf((int) mArg1.toCharArray()[1]);
                    }


                    Generator.salida(sym.IDENT, mArg1, null, salidaResultado);
                }
            } else if (TablaSimbolos.tipo(arrayRes[0]).equals("float") && TablaSimbolos.tipo(arrayArg1[0]).equals("int")) { // Castear de int a float

                if (TablaSimbolos.getMatriz(arrayRes[0]).split(":").length >= 1) { // Meter en array
                    if (TablaSimbolos.getMatriz(arrayArg1[0]).split(":").length == 1) { // Metes un valor
                        salidaResultado = Generator.salida(Generator.CAST, TablaSimbolos.getTipo(arrayRes[0]), arrayArg1[0], null);

                    } else { // Metes un array
                        System.out.println("ERROR: No se pueden castear arrays");
                        System.out.println(Arrays.toString(arrayArg1));
                        System.out.println(Arrays.toString(arrayRes));
                    }

                    Generator.salida(sym.IDENT, salidaResultado, null, mRes);
                } else { // Meter en variable
                    salidaResultado = Generator.salida(Generator.CAST, TablaSimbolos.getTipo(arrayRes[0]), arrayArg1[0], null);

                    Generator.salida(sym.IDENT, salidaResultado, null, arrayRes[0]);
                }

            } else if (TablaSimbolos.tipo(arrayRes[0]).equals("char") || TablaSimbolos.tipo(arrayArg1[0]).equals("char")){
                salidaResultado = arrayRes[0];
                if (!TablaSimbolos.casteos.keySet().contains(arrayArg1[0])){
                    System.out.println("ERROR: No ha sido casteado");
                }

                Generator.salida(sym.IDENT, arrayArg1[0], null, salidaResultado);
            }



            else {
                System.out.println("#ERROR: No se puede castear");
                System.out.println("Destino:" + arrayRes[0] + " origen:" + arrayArg1[0]);
                System.out.println(TablaSimbolos.registro);
                System.out.println(TablaSimbolos.linkedList);
                salidaResultado = "";
            }

            return salidaResultado;

        } else if (inst == Generator.OBJETO) {
            String salida;

            if (arrayArg1.length > 1) {
                salida = Generator.nuevaTemp();
                TablaSimbolos.putRegistro(salida, TablaSimbolos.getTipo(arrayArg1[0]));
                Generator.salida(sym.IDENT, mArg1, null, salida);
            } else {
                salida = arg1 + TablaSimbolos.get(arg1);
            }

            return salida;
        }
        return "";
    }

    public static void comprobacionRango(String[] array) {
        if (array.length > 1) {
            PLXC.out.println("# Comprobacion de rango");
            String labelError = Generator.nuevaLabel();
            String labelBuena = Generator.nuevaLabel();

            Generator.salida(Generator.IFGOTO, array[1] + " < ", "0", labelError);
            Generator.salida(Generator.IFGOTO, TablaSimbolos.getMatriz(array[0]).split(":")[1] + " < ", array[1], labelError);
            Generator.salida(Generator.IFGOTO, TablaSimbolos.getMatriz(array[0]).split(":")[1] + " == ", array[1], labelError);
            Generator.salida(Generator.GOTO, null, null, labelBuena);
            Generator.salida(Generator.LABEL, null, null, labelError);
            PLXC.out.println("\terror;");
            PLXC.out.println("\thalt;");
            Generator.salida(Generator.LABEL, null, null, labelBuena);
        }
    }
}
