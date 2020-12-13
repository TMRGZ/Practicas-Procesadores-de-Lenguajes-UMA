%%
%standalone
%state DEFVAR
%state DEFVARCAD
%state STRINGREP
%state REP

%{
String var = new String();
String valor = new String();
String accstr = new String();
%}
IDVar = [_a-zA-Z][a-zA-Z0-9_]*[" "]*\=
VALClass = (class)[" "][a-zA-Z][a-zA-Z0-9]*
salida = (System\.out\.println[" "]*) | (System\.out\.print[" "]*)


%%

<YYINITIAL> {
    {VALClass} {
        System.out.print(yytext() + "_rmj");
    }

    {salida} {
        System.out.print(yytext());
        yybegin(REP);
    }

    [^(](String)[" "] {
        //System.out.print(yytext());
        yybegin(DEFVAR);
    }

    {IDVar} {
        yybegin(DEFVARCAD);
    }

    .|\n {
        System.out.print(yytext());
    }
}

<STRINGREP> {
    
    \" | \"[" "]*\+ {
        System.out.print(accstr);
        accstr = "";
        //System.out.print("srs");
        yybegin(REP);
    }

    (\\\")*[^\"\+]+(\\\")* {
        accstr+=yytext();
    }

}

<DEFVAR> {
    {IDVar} {
        var = yytext().substring(0, yylength()-1).trim();
    }

    \"+[^\"]*\"+ {
        valor += yytext().substring(1, yylength()-1);
    }

    [_a-zA-Z][a-zA-Z0-9_]* {
        valor += TablaSimbolos.get(yytext());
    }

    ; {
        TablaSimbolos.put(var, valor);
        valor = "";
        yybegin(YYINITIAL);
    }

    . {}
}


<DEFVARCAD> {
    [_a-zA-Z][a-zA-Z0-9_]* {
        valor += TablaSimbolos.get(yytext());
    }

    \"+(\\\")*[^\"]*(\\\")*\"+ {
        valor += yytext().substring(1, yylength()-1);
    }

    ; {
        TablaSimbolos.put(var, valor);
        valor = "";
        yybegin(YYINITIAL);
    }

    . {}
}

<REP> {
    \); {
        System.out.print("\"" + yytext());
        yybegin(YYINITIAL);
    }

    (\()\" {
        //System.out.print("sre");
        System.out.print(yytext());
        yybegin(STRINGREP);
    }

    \" {
        //System.out.print("sre");
        yybegin(STRINGREP);
    }

    \([_a-zA-Z][a-zA-Z0-9_]* {
        //System.out.println("Variable: " + yytext());
        System.out.print("(\"" + TablaSimbolos.get(yytext().substring(1)));
    }

    [_a-zA-Z][a-zA-Z0-9_]* {
        System.out.print(TablaSimbolos.get(yytext()));
    }

    \+ | [" "] {}

    . {
        System.out.print(yytext());
    }
}