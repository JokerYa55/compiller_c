package app.main;

import app.lexx.Lexer;
import app.syntactical_analyzer.syntactial_tree.LexerTreeBuilder;
import java.io.File;
import java.io.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) {
        try (FileReader fin = new FileReader(args[0])) {
            File file = new File(args[0]);
            LOG.info("compile file: {} {}", args[0], file.length());
            Lexer lex = new Lexer(fin);
            LOG.info("tokens = {}", lex.getTokenList());
            // Запускаем 
            LexerTreeBuilder lexerBuilder = new LexerTreeBuilder();
            lexerBuilder.build(lex.getTokenList());
        } catch (Exception e) {            
            LOG.error(e.getMessage());
        }
    }
    
}
