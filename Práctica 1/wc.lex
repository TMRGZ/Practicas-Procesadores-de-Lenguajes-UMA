

%%

%%

 
[^" "\t\n]+ { 
                return new Yytoken(Yytoken.PALABRA, yytext());
           }  
\n         { 
                return new Yytoken(Yytoken.LINEA);
           }  
.          {
                return new Yytoken(Yytoken.FIN);
            } 