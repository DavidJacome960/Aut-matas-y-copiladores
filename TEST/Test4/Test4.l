%option noyywrap
%{
    #include <stdio.h>
    #include <stdlib.h>
%}

%%
([A-Z]{3}|[A-Z]{4})[0-9]{6}[A-Z0-9]{3}   { 
    printf("RFC reconocido: %s\n", yytext); 
}

.   { 
      if (yytext[0] == 27) {  // ESC
          printf("Fin del programa.\n");
          exit(0);
      }
    }

\n  { /* Ignorar enter */ }

%%

int main()
{
    printf("Ingrese RFC's:\n");
    yylex();
    return 0;
}