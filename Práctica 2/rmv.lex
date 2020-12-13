%%
%standalone
%state DEFVAR
%state STRINGVAR
%state STRINGREP

%{
String var = new String();
String valor = new String();
%}

varDolar = \$[a-zA-Z_][a-zA-Z0-9_]*

%%

<YYINITIAL> {
    [_a-zA-Z][a-zA-Z0-9_]*\= {
        var = yytext().substring(0, yylength()-1);
        //System.out.println("Inicio DEFVAR con var=" + var);
        yybegin(DEFVAR);
    }
    
    {varDolar} {
        System.out.print(TablaSimbolos.get(yytext()));
    }

    \" {
        //System.out.println("Inicio STRINGREP");
        System.out.print(yytext());
        yybegin(STRINGREP);
    }

    .|\n {
        System.out.print(yytext());
    }
}

<STRINGREP> {
    \" {
        System.out.print(yytext());
        yybegin(YYINITIAL);
    }

    [^\"\$] {
        System.out.print(yytext());
    }

    {varDolar} {
        System.out.print(TablaSimbolos.get(yytext()));
    }
}


<DEFVAR> {
    [^;\n\"\$]+(\\;)* {
        valor += yytext();
        //System.out.println("Valor = " + valor);
    }

    {varDolar} {
        valor += TablaSimbolos.get(yytext());
        //System.out.println("Valor concatenado = " + valor);
    }

    \" {
        //System.out.println("Inicio STRINGVAR");
        yybegin(STRINGVAR);
    }

    ;|\n {
        TablaSimbolos.put(var, valor);
        //System.out.println("Put con key=" + var + " valor=" + valor);
        valor = "";
        yybegin(YYINITIAL);
    }
}

<STRINGVAR> {
    \" {
        yybegin(DEFVAR);
    }

    [^\n\"\$]* {
        valor += yytext();
        //System.out.println("Valor es= " + valor);
    }

    (\")[^\n\"]+(\") {
        valor += yytext();
        //System.out.println("Valor es= " + valor);
    }

    {varDolar} {
        //System.out.println("El valor de " + yytext() + " es " + TablaSimbolos.get(yytext()));
        //System.out.println("Valor es=" + valor);
        valor += TablaSimbolos.get(yytext());
        //System.out.println("Valor concatenado es=" + valor);
    }
}
