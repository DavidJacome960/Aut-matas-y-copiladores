%option noyywrap
%{
    #include <stdio.h>
    #include <stdlib.h>
%}

%%
[a-z]{2}[0-9]{6}@uaeh\.edu\.mx   {
    printf("Correo institucional reconocido: %s\n", yytext);
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
    printf("Ingrese correo institucional:\n");
    yylex();
    return 0;
}