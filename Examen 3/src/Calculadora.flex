import java_cup.runtime.*;
%%
%cup


%%

"+"                 { return new Symbol(sym.MAS, yytext()); }
"*"                 { return new Symbol(sym.POR, yytext()); }
"/"                 { return new Symbol(sym.DIV, yytext()); }
"-"                 { return new Symbol(sym.MENOS, yytext()); }
"("                 { return new Symbol(sym.LP, yytext()); }
")"                 { return new Symbol(sym.RP, yytext()); }
0 | [1-9][0-9]*     { return new Symbol(sym.NUMERO, yytext()); }
\r|\n               { return new Symbol(sym.EOLN, yytext()); }
""                  { }
[^]                 { }