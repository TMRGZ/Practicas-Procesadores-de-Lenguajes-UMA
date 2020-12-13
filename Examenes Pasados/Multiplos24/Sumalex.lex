import java.util.List;
import java.util.ArrayList;

%%
%standalone
%{
	List<String> lista1 = new ArrayList<String>();
	List<String> lista2 = new ArrayList<String>();
	List<String> lista3 = new ArrayList<String>();
	
%}
%%

<YYINITIAL>{
	//Expresion regular creada para detectar multiplos de 4
	[0-9]*(([13579][26])|([02468][048])|(00))|[048] {
		lista1.add(yytext());
	}
	//Expresion para detectar multiplos de 2 pero no de 4
	[0-9]*[02468] {
		lista2.add(yytext());
	}
	//Expresion para detectar los no multiplos de 2
	[0-9]+ {
		lista3.add(yytext());
	}
	
	<<EOF>> {
		System.out.print(lista1.toString()+"\n");
		System.out.print(lista2.toString()+"\n");
		System.out.print(lista3.toString()+"\n");
		return 0;
	}
	
	[^] {}
}
