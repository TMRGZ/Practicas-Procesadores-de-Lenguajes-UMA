import java_cup.runtime.*;
%%
%cup
%state COMENTARIOBLOQUE

comentarioUnaLinea = "//"[^\r\n]*
entero = 0|[1-9][0-9]*
real = 0|[0-9][1-9]*\.[0-9]+(E-[1-9])?
identificador = [a-zA-Z][a-zA-Z0-9]*

%%
<YYINITIAL>{
    // Sentencias
    while					                { return new Symbol(sym.WHILE);  }
    do					                    { return new Symbol(sym.DO);  }
    if                                      { return new Symbol(sym.IF); }
    else                                    { return new Symbol(sym.ELSE); }
    for                                     { return new Symbol(sym.FOR); }
    to                                      { return new Symbol(sym.TO); }
    in                                      { return new Symbol(sym.IN);}
    downto                                  { return new Symbol(sym.DOWNTO); }
    step                                    { return new Symbol(sym.STEP); }
    print                                   { return new Symbol(sym.PRINT); }
    // Tipos
    int                                     { return new Symbol(sym.INT, yytext()); }
    float                                   { return new Symbol(sym.FLOAT , yytext()); }
    char                                    { return new Symbol(sym.CHAR, yytext()); }
    string                                  { return new Symbol(sym.STRING, yytext()); }
    // Operadores
    \*    		                            { return new Symbol(sym.POR); }
    %                                       { return new Symbol(sym.MOD); }
    \/    		                            { return new Symbol(sym.DIV); }
    -    		                            { return new Symbol(sym.MENOS); }
    \+    		                            { return new Symbol(sym.MAS); }
    \?                                      { return new Symbol(sym.IGACION); }
    :                                       { return new Symbol(sym.DOSPUN); }
    \?:                                     { return new Symbol(sym.ELVIS); }
    \.length                                { return new Symbol(sym.LENGTH); }
    // Incrementos
    \++                                     { return new Symbol(sym.MASMAS); }
    --                                      { return new Symbol(sym.MENOSMENOS); }
    \+\=                                    { return new Symbol(sym.MASIGUAL);}
    -\=                                     { return new Symbol(sym.MENOSIGUAL);}
    \*\=                                    { return new Symbol(sym.PORIGUAL);}
    \/\=                                    { return new Symbol(sym.DIVIGUAL);}
    // Parentesis
    \(    		                            { return new Symbol(sym.AP); }
    \)    		                            { return new Symbol(sym.CP); }
    // Llaves
    \{                                      { return new Symbol(sym.ALL); }
    \}                                      { return new Symbol(sym.CLL); }
    // Corchetes
    \[                                      { return new Symbol(sym.ACOR); }
    \]                                      { return new Symbol(sym.CCOR); }
    // Operadores logicos
    \<                                      { return new Symbol(sym.LT); }
    \>                                      { return new Symbol(sym.GT); }
    \<\=                                    { return new Symbol(sym.LE); }
    \>\=                                    { return new Symbol(sym.GE); }
    \=\=                                    { return new Symbol(sym.EQ); }
    \=                                      { return new Symbol(sym.IGUAL); }
    \!\=                                    { return new Symbol(sym.NE); }
    \!                                      { return new Symbol(sym.NOT); }
    &&                                      { return new Symbol(sym.AND); }
    \|\|                                    { return new Symbol(sym.OR); }
    // Separadores
    ;                                       { return new Symbol(sym.PYC); }
    ,                                       { return new Symbol(sym.COMA); }
    // Valores
    {entero}				                { return new Symbol(sym.ENTERO, yytext() ); }
    {real}                                   { return new Symbol(sym.REAL, yytext()); }
    '([^])'                                 { return new Symbol(sym.LETRA, yytext());}
     "'\\"[^]"'"                            { return new Symbol(sym.LETRA, yytext());}
    "'\\u"[^)]+"'"                          { return new Symbol(sym.UNICODE, yytext().substring(3, yytext().length()-1));}
    \"[^);,]*\"                                { return new Symbol(sym.TEXTO, yytext()); }
    // Nombres
    {identificador}		                    { return new Symbol(sym.IDENT, yytext() ); }
    // Comentarios
    "/*"                                    { yybegin(COMENTARIOBLOQUE);}
    {comentarioUnaLinea}                    { }


    // Fin archivo
    [^]						                {  }
}
<COMENTARIOBLOQUE>{
    "/*"                                    { System.out.println("ERROR: Anidamiento de comentarios"); }
    "*/"                                    { yybegin(YYINITIAL);}

    [^]                                     { }
}


