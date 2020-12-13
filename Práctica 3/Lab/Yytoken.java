package Lab;

import java.io.PrintStream;

class Yytoken {
	
	// Constantes enteras para los tokens
	public final static int EOF=-1;
	public final static int NUMERO =1;         
	public final static int IDENT=2;
	public final static int WHILE=3;
	public final static int DO=4;
	public final static int IGUAL=5;
	public final static int MENOR=6;
	public final static int PYC=7;
	public final static int AP=8;
	public final static int CP=9;
	public final static int ALL=10;
	public final static int MENOS=12;
	public final static int CLL=11;
	public final static int MAS=13;
	public final static int POR=14;
	public final static int DIV=15;

	// Constantes cadenas de caracteres para los tokens
	private final static String[] tokens = {
		    "EOF",
			"NUMERO",         
		    "IDENT",
		    "WHILE",
		    "DO",
		    "IGUAL",
		    "MENOR",
		    "PYC",
		    "AP",
		    "CP",
		    "ALL",
		    "CLL"
		};

	// Constantes de cadenas de caracteres para escribir las reglas
	private final static String[] reglas = {
	        "axioma -> listaSent EOF",
	        "listaSent -> sent listaSent",
	        "listaSent ->",
	        "sent -> WHILE AP cond AP sent",
	        "sent -> DO sent WHILE AP cond CP PYC",
	        "sent -> IDENT IGUAL var PYC",
	        "sent -> ALL listaSent CLL",
	        "sent -> DO sent WHILE AP cond CP PYC",
	        "cond -> var MENOR var",
	        "var -> IDENT",
	        "var -> NUMERO"
	};

	// Para escribir una regla en el canal de salida
	public static void regla(int i) {
		if (i<0 || i>reglas.length) {
			System.out.println("ERROR");
		} else {
			System.out.println(reglas[i]);
		}
	}

	//Para escribir un mensaje de error en el canal de salida
	public static void error(int i) {
		if (i<0 || i>tokens.length) {
			i=0;
		}
		System.out.println("ERROR token = "+tokens[i]);
		System.exit(0);
	}

	
}