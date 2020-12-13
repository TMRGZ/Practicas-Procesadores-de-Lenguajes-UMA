import java.util.List;
import java.util.ArrayList;

%%

%standalone
%{
	List<String> listaa = new ArrayList<String>();
	List<String> listab = new ArrayList<String>();
	List<String> listac = new ArrayList<String>();
	List<String> listad = new ArrayList<String>();
	List<String> listae = new ArrayList<String>();
%}
%%

<YYINITIAL>{

	<<EOF>> {
		System.out.print(listaa.toString()+"\n");
		System.out.print(listab.toString()+"\n");
		System.out.print(listac.toString()+"\n");
		System.out.print(listad.toString()+"\n");
		System.out.print(listae.toString()+"\n");
		return 0;
	}

	[a-zA-Z]*[aeiouAEIOU]{2}[a-zA-Z]*[aeiouAEIOU] | 
	[a-zA-Z]*[aeiouAEIOU]{2} {
		listac.add(yytext());
	}


	//Palabras que tengan dos vocales seguidas pero no acabe en vocal
	[a-zA-Z]*[aeiouAEIOU]{2}[a-zA-Z]* {
		listaa.add(yytext());
	}
	
	[a-zA-Z]*[aeiouAEIOU] {
		listab.add(yytext());
	}
	
	[a-zA-Z]+ {
		listad.add(yytext());
	}
	
	[^\ \n]+ {
		listae.add(yytext());
	}

}
