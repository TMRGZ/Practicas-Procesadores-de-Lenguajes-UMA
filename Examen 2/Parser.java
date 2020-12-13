import java.io.FileReader;
import java.io.IOException;
import java.io.FileReader;

class Parser {
	private static int token;
	private static Yylex lex;

	private static int yylex() {
		int token = 0;
		try {
			token = lex.yylex();
		} catch (IOException e) {
			System.out.println("IOException");
			System.exit(0);
		}
		return token;
	}

	public static void main(String[] arg) {
		if (arg.length > 0) {
			try {
				lex = new Yylex(new FileReader(arg[0]));
				axioma();
			} catch (IOException e) {
			}
		}
	}

	/// .... A completar .....
	public static void axioma() {
		if (token != Yytoken.EOF){
			token = yylex();
			Yytoken.regla(0);
			listaSent();
		}
	}

	public static void listaSent() {
		if (token == Yytoken.IDENT || token==Yytoken.WHILE || token==Yytoken.DO || token==Yytoken.ALL) {
			Yytoken.regla(1);
			token = yylex();
			sent();
		} 
		if (token == Yytoken.CLL || token==Yytoken.EOF) {
			token = yylex();
			Yytoken.regla(2);
		} 
	}

	public static void sent() {
		//System.out.println(token);

		if (token == Yytoken.WHILE) {
			Yytoken.regla(3);
			cond();
		}

		if (token == Yytoken.IDENT) {
			Yytoken.regla(4);
			var();
		}

		if (token == Yytoken.DO) {
			Yytoken.regla(5);
			sent();
		}

		if (token == Yytoken.AP) {
			Yytoken.regla(6);
		}
	}

	public static void cond() {
		
	}

	public static void var() {
		//System.out.println(token);
		token = yylex();
		if (token == Yytoken.IDENT) {
			Yytoken.regla(8);
		}

		if (token == Yytoken.NUMERO) {
			Yytoken.regla(9);
		}
	}

}