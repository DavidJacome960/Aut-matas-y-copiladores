package KeywordsIdentifiers;

import java.util.regex.*;
import java.util.*;

public class KeywordsIdentifiers {

    // Tipos de token
    enum TokenType {
        JAVADOC, BLOCKCOMMENT, LINECOMMENT, COMMENT, STRINGLIT, KEYWORD, IDENTIFIER, WHITESPACE, UNKNOWN, OPERATOR, SEPARATOR,
        CHARLIT, FLOATLIT, BINARYLIT, OCTALLIT, INTEGERLIT, HEXADECIMALLIT
    }

    // Record para representar un Token (Java 16+)
    record Token(TokenType type, String lexeme, int column, int line) {
        public String toString() {
            return String.format("[L%-3d C%-3d] %-18s → \"%s\"", line, column, type, lexeme);
        }
    }

    // Patrón de keywords (todas las palabras reservadas de Java)
    static final String KW_PATTERN
            = "\\b(abstract|assert|boolean|break|byte|case|catch|char|"
            + "class|const|continue|default|do|double|else|enum|extends|"
            + "final|finally|float|for|if|implements|import|instanceof|"
            + "int|interface|long|new|package|private|protected|public|"
            + "return|short|static|super|switch|synchronized|this|throw|"
            + "throws|try|void|volatile|while|true|false|null)\\b";

    // Patrón MASTER con grupos nombrados
    static final Pattern MASTER = Pattern.compile(
            // 1. Comentarios primero (no producen tokens de salida)
            "(?<JAVADOC>/\\*\\*[\\s\\S]*?\\*/)|"
            + "(?<BLOCKCOMMENT>/\\*[\\s\\S]*?\\*/)|"
            + "(?<LINECOMMENT>//[^\\n]*)|"
            // 2. Literales de cadena y char (contienen cualquier carácter)
            + "(?<STRINGLIT>\"([^\"\\\\]|\\\\.)*\")|"
            + "(?<CHARLIT>'([^'\\\\]|\\\\.)')|"
            // 3. Literales numéricos (FLOAT > HEX/BIN/OCT > INT)
            + "(?<FLOATLIT>[0-9][0-9_]*\\.[0-9][0-9_]*([eE][+-]?[0-9]+)?[fFdD]?)|"
            + "(?<HEXADECIMALLIT>0[xX][0-9a-fA-F][0-9a-fA-F_]*[lL]?)|"
            + "(?<BINARYLIT>0[bB][01][01_]*[lL]?)|"
            + "(?<OCTALLIT>0[0-7]+[lL]?)|"
            + "(?<INTEGERLIT>0|[1-9][0-9_]*[lL]?)|"
            // 4. Keywords antes que dentificadores
            + "(?<KEYWORD>" + KW_PATTERN + ")|"
            + "(?<IDENTIFIER>[a-zA-Z_$][a-zA-Z0-9_$]*)|"
            // 5. Operadores compuestos antes que simples
            + "(?<OPERATOR>==|!=|<=|>=|&&|\\|\\||<<|>>>|>>|\\+\\+|--|\\+=|-=|\\*=|/=|[+\\-*/%<>=!&|^~?:])|"
            // 6. Separadores
            + "(?<SEPARATOR>[(){}\\[\\];,.])|"
            // 7. Whitespace (descartar)
            + "(?<WHITESPACE>[ \\t\\r\\n]+)",
            Pattern.MULTILINE
    );

    // Método de Tokenización
    public static List<Token> tokenize(String source) {
        List<Token> tokens = new ArrayList<>();
        Matcher m = MASTER.matcher(source);
        int line = 1, pos = 0;
        while (m.find()) {
            if (m.start() > pos) {
                String unknown = source.substring(pos, m.start());
                int columnError = pos - source.lastIndexOf('\n', pos);
                System.err.printf("Error léxico [L%d, C%d]: \"%s\"%n", line, columnError, unknown);
                tokens.add(new Token(TokenType.UNKNOWN, unknown, line, columnError));
            }
            int column = m.start() - source.lastIndexOf('\n', m.start());
            String lexeme = m.group();
            if (m.group("WHITESPACE") != null) {
                line += lexeme.chars().filter(c -> c == '\n').count();
            }else if (m.group("JAVADOC") != null) {
                tokens.add(new Token(TokenType.JAVADOC, lexeme, column, line));
                line += lexeme.chars().filter(c -> c == '\n').count();
            }else if (m.group("BLOCKCOMMENT") != null) {
                tokens.add(new Token(TokenType.COMMENT, lexeme, column, line));
                line += lexeme.chars().filter(c -> c == '\n').count();
            }else if (m.group("LINECOMMENT") != null) {
                tokens.add(new Token(TokenType.LINECOMMENT, lexeme,column, line));
                line += lexeme.chars().filter(c -> c == '\n').count();
            }else if (m.group("STRINGLIT") != null) {
                tokens.add(new Token(TokenType.STRINGLIT, lexeme,column, line));
                line += lexeme.chars().filter(c -> c == '\n').count();
            }else if (m.group("CHARLIT") != null) {
                tokens.add(new Token(TokenType.CHARLIT, lexeme,column, line));
                line += lexeme.chars().filter(c -> c == '\n').count();
            }else if (m.group("FLOATLIT") != null) {
                tokens.add(new Token(TokenType.FLOATLIT, lexeme,column, line));
                line += lexeme.chars().filter(c -> c == '\n').count();
            }else if (m.group("HEXADECIMALLIT") != null) {
                tokens.add(new Token(TokenType.HEXADECIMALLIT, lexeme,column, line));
                line += lexeme.chars().filter(c -> c == '\n').count();
            }else if (m.group("BINARYLIT") != null) {
                tokens.add(new Token(TokenType.BINARYLIT, lexeme,column, line));
                line += lexeme.chars().filter(c -> c == '\n').count();
            }else if (m.group("OCTALLIT") != null) {
                tokens.add(new Token(TokenType.OCTALLIT, lexeme,column, line));
                line += lexeme.chars().filter(c -> c == '\n').count();
            }else if (m.group("INTEGERLIT") != null) {
                tokens.add(new Token(TokenType.INTEGERLIT, lexeme,column, line));
                line += lexeme.chars().filter(c -> c == '\n').count();
            }else if (m.group("KEYWORD") != null) {
                tokens.add(new Token(TokenType.KEYWORD, lexeme,column, line));
                line += lexeme.chars().filter(c -> c == '\n').count();
            }else if (m.group("IDENTIFIER") != null) {
                tokens.add(new Token(TokenType.IDENTIFIER, lexeme,column, line));
                line += lexeme.chars().filter(c -> c == '\n').count();
            }else if (m.group("OPERATOR") != null) {
                tokens.add(new Token(TokenType.OPERATOR, lexeme,column, line));
                line += lexeme.chars().filter(c -> c == '\n').count();
            }else if (m.group("SEPARATOR") != null) {
                tokens.add(new Token(TokenType.SEPARATOR, lexeme,column, line));
                line += lexeme.chars().filter(c -> c == '\n').count();
            }
            pos = m.end();
        }
        if (pos < source.length()) {
            String unknown = source.substring(pos);
            int columnError = pos - source.lastIndexOf('\n', pos);
            System.err.printf("Error léxico [L%d, C%d]: \"%s\"%n",line, columnError, unknown);
            tokens.add(new Token(TokenType.UNKNOWN, unknown, line, columnError));
        }
        return tokens;
    }

    public static void main(String[] args) {
        String source = """
            /** JavaDoc comment */
            /*
            Hola mundo
            */
            public class Prueba {
                public static void main(String[] args) {
                    int x = 0xFF;    // hex
                    double pi = 3.14;
                    String s = "mundo";
                    if (x == 255 && pi > 0.0) { x++; }
                    @  // ← error léxico intencional
                }
            } 0b10101 0X3f5a 073 73
            """;
        tokenize(source).forEach(System.out::println);
    }
}