package app.lexx;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lexer {

    private static final Logger LOG = LoggerFactory.getLogger(Lexer.class);
    private final Reader fileIn;
    private final List<Token> tokenList = new ArrayList<>();
    private char currentCh;

    public Lexer(Reader file) {
        this.fileIn = file;
        this.currentCh = getChar();
        nextToken();
    }

    private Token nextToken() {
        Token res = new Token();
        try {
            while ((this.currentCh != 65535)) {
                //log.debug("ch = " + (int) this.currentCh);
                if (this.currentCh == 0) {
                    res.setSymType(TokenType.EOF);
                    res.setVal(this.currentCh + "");
                } else if (isAlpha(currentCh + "")) {
                    String ident = "";
                    while (isAlpha(currentCh + "")) {
                        ident = ident + this.currentCh;
                        this.currentCh = getChar();
                        LOG.debug("this.currentCh : {}", this.currentCh);
                    }
                    if (isWord(ident)) {
                        res = new Token();
                        res.setSymType(LexerConst.WORDS.get(ident));
                        res.setVal(ident);
                        tokenList.add(res);
                        LOG.debug("word : {}", ident);
                        //this.currentCh = getChar();
                    } else {
                        res = new Token();
                        res.setSymType(TokenType.ID);
                        res.setVal(ident);
                        tokenList.add(res);
                        LOG.debug("Alpha : {}", res.getSymType());
                        //this.currentCh = getChar();
                    }

                } else if (isDigit(currentCh + "")) {
                    String ident = "";
                    while (isDigit(currentCh + "")) {
                        ident = ident + this.currentCh;
                        this.currentCh = getChar();
                    }
                    res = new Token();
                    res.setSymType(TokenType.NUM);
                    res.setVal(ident);
                    tokenList.add(res);
                    LOG.debug("Digit : {}", res.getSymType());
                } else if (isOper(currentCh + "")) {
                    res = new Token();
                    res.setSymType(LexerConst.SYMBOLS.get(currentCh + "")
                    );
                    res.setVal(currentCh + "");
                    tokenList.add(res);
                    LOG.debug("Oper : " + res.getSymType());
                    this.currentCh = getChar();
                } else if (isScob(currentCh + "")) {
                    res = new Token();
                    res.setSymType(LexerConst.SYMBOLS.get(currentCh + ""));
                    res.setVal(currentCh + "");
                    tokenList.add(res);
                    LOG.debug("Скобка : ",res.getSymType());
                    this.currentCh = getChar();
                } else if (isEndOper(currentCh + "")) {
                    res = new Token();
                    res.setSymType(LexerConst.SYMBOLS.get(currentCh + ""));
                    res.setVal(currentCh + "");
                    tokenList.add(res);
                    LOG.debug("End oper : {}", res.getSymType());
                    this.currentCh = getChar();
                } else {
                    this.currentCh = getChar();
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return res;
    }

    private char getChar() {
        char res = 0;
        try {
            res = (char) this.fileIn.read();
        } catch (IOException ex) {
            LOG.error(ex.getMessage());
        }
        return res;
    }

    // Функции проверки типа токена
    private boolean isDigit(String ch) {
        boolean flag = false;
        Matcher m = LexerConst.DIGIT_PATTERN.matcher(ch);
        flag = m.matches();
        return flag;
    }

    private boolean isAlpha(String ch) {
        boolean flag = false;
        Matcher m = LexerConst.ALPHA_PATTERN.matcher(ch);
        flag = m.matches();
        return flag;
    }

    private boolean isOper(String ch) {
        boolean flag = false;
        Matcher m = LexerConst.OPER_PATTERN.matcher(ch);
        flag = m.matches();
        return flag;
    }

    private boolean isScob(String ch) {
        boolean flag = false;
        Matcher m = LexerConst.SCOB_PATTERN.matcher(ch);
        flag = m.matches();
        return flag;
    }

    private boolean isEndOper(String ch) {
        boolean flag = false;
        Matcher m = LexerConst.TERMINAME_OPER_PATTERN.matcher(ch);
        flag = m.matches();
        return flag;
    }

    private boolean isWord(String ch) {
        boolean flag = false;
        Matcher m = LexerConst.RESERVED_WORD_PATTERN.matcher(ch);
        flag = m.matches();
        return flag;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }
}
