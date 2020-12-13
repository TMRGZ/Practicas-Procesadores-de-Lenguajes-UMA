

%%
%standalone
%{
	public int filas = 0;
	public int palabras = 0;
	public int caracteres = 0;
%}
%%
<YYINITIAL>{
	<<EOF>> {
		//Muestro los resultados
		System.out.print("Filas: "+filas+" Palabras: "+palabras+" Caracteres: "+caracteres+"\n");
		return 0;
	}
	//En Este estado leo filas palabras y caracteres
	[\n] {
		filas++;
		caracteres++;
	}
	//Para todo lo demas menos los espacios y los saltos son palabras
	[^\ \n]+ {
		palabras++;
		caracteres+=yytext().length();
	}
	[\ ] {
		caracteres++;
	}
}