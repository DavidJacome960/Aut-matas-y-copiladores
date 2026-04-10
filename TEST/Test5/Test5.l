%option noyywrap
%{
    #include <stdio.h>
    #include <stdlib.h>
%}

%%
[A-Z]{4}[0-9]{6}[HM][A-Z]{2}[B-DF-HJ-NP-TV-Z]{3}[A-Z0-9]{2}   {
    printf("CURP reconocida: %s\n", yytext);
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
    printf("Ingrese CURP:\n");
    yylex();
    return 0;
}