import java.util.Map;
import java.util.HashMap;

%%
%int
%state HORA
%state PAGINA
%state BASURA

%{
	public int locales = 0;
	public int externas = 0;
	public int totales = 0;
	public int hipertexto = 0;
	public int media = 0;
	public int [] horas = new int[24];
	Map<String,Integer> mapa = new HashMap<String,Integer>();
%}
%%

//Tengo que leer la pagina web el dia en el que se envio si es media o
//texto y guardar pagina en un map

<YYINITIAL>{
	([a-zA-Z0-9]+".lcc.uma.es")|"150.214.108."[0-9]+ {
		locales++;
		totales++;
		yybegin (HORA);
	}
	[a-zA-Z0-9]+("."[a-zA-Z0-9]+)+ {
		externas++;
		totales++;
		yybegin (HORA);
	}
	
	<<EOF>> {
		StringBuilder sb = new StringBuilder();
		sb.append("Numero totales de busquedas totales:"+totales+" locales:"+locales+" externas:"+externas+"\n");
		sb.append("Se han buscado graficos:"+media+" y hipertexto:"+hipertexto+"\n");
		sb.append("El historico de horarios es el siguiente:\n");
		for(int i=0;i<24;i++){
			sb.append(i+":"+horas[i]+"\n");
		}
		//sb.append(horas.toString()+"\n");
		sb.append("y las paginas visitadas son:\n");
		sb.append(mapa.toString());
		System.out.print(sb.toString()+"\n");
		return 0;
	}
	[^] {}
}
<HORA>{
	[0-9]{4}\:[0-9]{2} {
		String correcto = yytext().substring(5,yytext().length());
		horas[Integer.parseInt(correcto)]++;
		yybegin (PAGINA);
	}
	[^] {}
}
<PAGINA>{
	
	(\/[^\ \n]+".gif")|(\/[^\ \n]+".jpg") {
		media++;
		if(mapa.containsKey(yytext())){
			mapa.merge(yytext(),1,Integer::sum);
		}else{
			mapa.put(yytext(),1);
		}
		yybegin (BASURA);
	}
	(\/[^\ \n]+".html") {
		hipertexto++;
		if(mapa.containsKey(yytext())){
			mapa.merge(yytext(),1,Integer::sum);
		}else{
			mapa.put(yytext(),1);
		}
		yybegin (BASURA);
	}
	(\/[\ ]*[^\n\ ]+) {
		if(mapa.containsKey(yytext())){
			mapa.merge(yytext(),1,Integer::sum);
		}else{
			mapa.put(yytext(),1);
		}
		yybegin (BASURA);
	}
	[^] {}

}

<BASURA>{
	[^\n]+ {}
	[\n] {
		yybegin (YYINITIAL);
	}
}


