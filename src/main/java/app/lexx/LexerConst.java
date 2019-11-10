package app.lexx;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class LexerConst {

    public static final Pattern ALPHA_PATTERN = Pattern.compile("^[a-zA-Z]$");
    public static final Pattern DIGIT_PATTERN = Pattern.compile("^[0-9]$");
    public static final Pattern OPER_PATTERN = Pattern.compile("^=|\\+|\\-|<|\\*$");
    public static final Pattern SCOB_PATTERN = Pattern.compile("^\\{|\\}|\\(|\\)$");
    public static final Pattern TERMINAME_OPER_PATTERN = Pattern.compile("^;$");
    public static final Pattern RESERVED_WORD_PATTERN = Pattern.compile("^if|else|do|while|for$");
    public static final Map<String, TokenType> SYMBOLS = new HashMap<>();
    public static final Map<String, TokenType> WORDS = new HashMap<>();

    static {
        SYMBOLS.put("{", TokenType.LBRA);
        SYMBOLS.put("}", TokenType.RBRA);
        SYMBOLS.put("=", TokenType.EQUAL);
        SYMBOLS.put(";", TokenType.SEMICOLON);
        SYMBOLS.put("(", TokenType.LPAR);
        SYMBOLS.put(")", TokenType.RPAR);
        SYMBOLS.put("+", TokenType.PLUS);
        SYMBOLS.put("-", TokenType.MINUS);
        SYMBOLS.put("<", TokenType.LESS);
        SYMBOLS.put("*", TokenType.MUL);

        // инициализируе слова
        WORDS.put("if", TokenType.IF);
        WORDS.put("else", TokenType.ELSE);
        WORDS.put("do", TokenType.DO);
        WORDS.put("while", TokenType.WHILE);
        WORDS.put("for", TokenType.FOR);
    }

}
