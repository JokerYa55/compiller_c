package app.syntactical_analyzer.syntactial_tree;

import app.lexx.Token;
import app.lexx.TokenType;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

public class LexerTreeBuilder {

    private static final Logger LOG = Logger.getLogger(LexerTreeBuilder.class.getName());

    private final ProgramBlock mainBlock = new ProgramBlock("main");
    private final Stack<ProgramBlock> blockStack = new Stack<>();
    private int currentIndex = -1;
    private List<Token> listToken;
    private int blockNum = 0;

    public ProgramBlock build(List<Token> listToken) {
        this.listToken = listToken;
        getNextToken();
        return mainBlock;
    }

    private void getNextToken() {
        currentIndex++;
        Token token = listToken.get(currentIndex);
        switch (token.getSymType()) {
            case LBRA:
                //Создаем новый блок
                if (blockStack.size() > 0) {
                    ProgramBlock newBlock = new ProgramBlock("block_" + blockNum);
                    blockStack.push(newBlock);
                    blockNum++;
                }
                getNextToken();
                break;
            case ID:
                getExp();
                getNextToken();
                break;
            default:;
        }
    }

    /**
     * Получаем операнд
     *
     * @return
        */
    private List<Token> getExp() {
        List<Token> result = new ArrayList<>();
        while (listToken.get(currentIndex).getSymType() != TokenType.SEMICOLON) {
            result.add(listToken.get(currentIndex));
            currentIndex++;
        }
        LOG.info(String.format("result = %s", result));
        mainBlock.addNode(node)
        return result;
    }

    /**
     * Разбираем выражения
     *
     * @param tokenList
     * @return
     */
    private TreeNode compileExp(List<Token> tokenList) {
        TreeNode result = new TreeNode();
        return result;
    }
}
