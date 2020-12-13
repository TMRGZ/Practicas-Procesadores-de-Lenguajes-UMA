import java.util.Map;
import java.util.HashMap;

%%
%standalone
%state MUESTRA
%state BASURA
%{
	Map<String,String> mapa = new HashMap<String,String>();
%}
%%

<YYINITIAL>{
	//Cuando lea la etiqueta <title> o <TITLE> me meto en otro estado
	"<title>"|"<TITLE>" {
	
		mapa.put("&aacute","á");
		mapa.put("&eacute","é");
		mapa.put("&iacute","í");
		mapa.put("&oacute","ó");
		mapa.put("&uacute","ú");
		mapa.put("&Aacute","Á");
		mapa.put("&Eacute","É");
		mapa.put("&Iacute","Í");
		mapa.put("&Oacute","Ó");
		mapa.put("&Uacute","Ú");
		mapa.put("&ntilde","ñ");
		mapa.put("&Ntilde","Ñ");
	
	
		//Me voy al estado de mostrar
		yybegin (MUESTRA);
	}
	[^] {}
}
<MUESTRA>{
	//Todo lo que haya lo muestro
	[^\<\&\u000A]+ {
		System.out.print(yytext());
	}
	//Si leo la etiqueta de salida me voy a un estado basura
	"</title>"|"</TITLE>" {
		System.out.print("\n");
		yybegin (BASURA);
	}
	\&[a-zA-Z]+\; {
		//He leido un caracter especial
		String resultado = mapa.get(yytext().substring(0,yytext().length()-1));
		System.out.print(resultado);
	}
	"<"\/?[a-zA-Z_0-9]+">" {}
	[^] {}
}
<BASURA>{
	[^] {}
}
