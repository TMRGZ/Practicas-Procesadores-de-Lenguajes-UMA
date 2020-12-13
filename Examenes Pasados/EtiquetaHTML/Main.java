import java.io.FileReader;
import java.io.IOException;

public class Main {
   
    
    
    public static void main(String arg[]) {
    
        if (arg.length>0) {
            try {
                Yylex lex = new Yylex(new FileReader(arg[0]));
               
		while (  (lex.yylex()) > 0  ) {
                    
                }
	    } catch (IOException e) {
	    }
        }
    }

}
