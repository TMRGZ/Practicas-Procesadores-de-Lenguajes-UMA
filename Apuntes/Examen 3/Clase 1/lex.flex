import java.cup.runtime.*;
%%
%%
%cup

%%

"+" {return new Symbol(sym.MAS);}
"*" {return new Symbol(sym.POR);}
0 | [1-9][0-9]* {return new Symbol(sym.NUM, yytext())}