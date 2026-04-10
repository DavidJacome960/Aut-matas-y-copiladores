%option noyywrap
%{
    #include <stdio.h>
    #include <stdlib.h>
%}

%%
[0-9]+"."[0-9]+    { printf("Numero decimal reconocido: %s\n", yytext); }

.                  { 
                     if (yytext[0] == 27) {  
                        printf("Fin del programa.\n");
                        exit(0);
                     }
                   }

\n                 {  }

%%

int main()
{
    printf("Ingrese numeros decimales (ej: 3.14):\n");
    yylex();
    return 0;
}