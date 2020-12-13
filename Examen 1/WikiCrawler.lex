%%
%standalone
%state GETENLACE
%{


%}
extImg = ((\.jpg)|(\.jpeg)|(\.png)|(\.svg)|(\.gif)) | ((\.JPG)|(\.JPEG)|(\.PNG)|(\.SVG)|(\.GIF))
extVid = (\.ogv)|(\.OGV)
extMus = (\.webm)

enlaceImg = \""https://commons.wikimedia.org/wiki/File:"[^\n]+{extImg}\"
enlaceVid = \""https://upload.wikimedia.org/wikipedia/commons"[^\n]+{extVid}\"

%%


<YYINITIAL> {
    (href\=) {
        yybegin(GETENLACE);
    }
    . | \n {}
}

<GETENLACE> {
    {enlaceImg} {
        //System.out.println("entra");
        if (!WikiCrawler.enlacesImagenes.contains(yytext())) {
            WikiCrawler.nImg++;
            WikiCrawler.enlacesImagenes.add(yytext());
            //System.out.println(yytext());
        }
    }

    {enlaceVid} {
        if (!WikiCrawler.enlacesVideo.contains(yytext())) {
            WikiCrawler.nVideo++;
            WikiCrawler.enlacesVideo.add(yytext());
            //System.out.println(yytext());
        }
    }

    . | \n {
        yybegin(YYINITIAL);
    }
}
