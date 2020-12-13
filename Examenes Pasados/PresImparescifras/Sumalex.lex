import java.util.List;
import java.util.ArrayList;

%%
%standalone
%{
	List<String> numero1 = new ArrayList<String>();
	List<String> numero2 = new ArrayList<String>();
	List<String> numero3 = new ArrayList<String>();
	List<String> numero4 = new ArrayList<String>();
%}
%%
<YYINITIAL>{
	//En este punto van los numeros con cifras pares y ademas son pares
	[1-9]([0-9]{2})*[02468] {
		numero1.add(yytext());
	}

	([1-9]([0-9])*[02468])|[02468] {
		numero2.add(yytext());
	}
	//En este punto van los numeros con cifras impares y ademas son pares
	[1-9]([0-9]{2})*[13579] {
		numero3.add(yytext());
	}

	([1-9]([0-9])*[12579])|[13579] {
		numero4.add(yytext());
	}
	
	[0]+[0-9]* {
	
	}

	<<EOF>> {
		System.out.print(numero1.toString()+"\n");
		System.out.print(numero2.toString()+"\n");
		System.out.print(numero3.toString()+"\n");
		System.out.print(numero4.toString()+"\n");
		return 0;
	}
	[^] {}
}