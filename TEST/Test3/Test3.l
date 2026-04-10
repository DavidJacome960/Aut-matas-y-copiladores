%option noyywrap
%{
    #include <stdio.h>
    #include <stdlib.h>
%}

%%
[a-zA-Z][a-zA-Z0-9_]*    { printf("Identificador reconocido: %s\n", yytext); }

.                        { 
                           if (yytext[0] == 27) {  
                               printf("Fin del programa.\n");
                               exit(0);
                           }
                         }

\n                       { }

%%

int main()
{
    printf("Ingrese identificadores o nombres de variables:\n");
    yylex();
    return 0;
}