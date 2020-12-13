

%%
%standalone

%%

<YYINITIAL>{
	[aA][^]*[oO] {
		System.out.print(yytext().substring(1,yytext().length()-1)+"\n");
	}
	
	[^] {}
}
