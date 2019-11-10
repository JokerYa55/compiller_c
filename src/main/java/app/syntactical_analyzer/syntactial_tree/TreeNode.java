package app.syntactical_analyzer.syntactial_tree;

import app.lexx.Token;
import app.lexx.TokenType;

public class TreeNode implements NodeInterface {

    private Token token;
    // Левый операнд
    private NodeInterface lNode;
    // Правый операнд
    private NodeInterface rNode;
    // Дополнительный операнд для if
    private NodeInterface dNode;
    // Ссылка на родительский элемент
    private NodeInterface parrentNode;
    // Уровень в дереве
    private long level;
    // Значение перации
    private long valNode;
    // Тип узла OPER - Операция ????
    private TokenType tokenType;

    @Override
    public NodeType getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Token getnToken() {
        return token;
    }

    public void setnToken(Token nToken) {
        this.token = nToken;
    }

    public NodeInterface getlNode() {
        return lNode;
    }

    public void setlNode(NodeInterface lNode) {
        this.lNode = lNode;
    }

    public NodeInterface getrNode() {
        return rNode;
    }

    public void setrNode(NodeInterface rNode) {
        this.rNode = rNode;
    }

    public NodeInterface getdNode() {
        return dNode;
    }

    public void setdNode(NodeInterface dNode) {
        this.dNode = dNode;
    }

    public NodeInterface getParrentNode() {
        return parrentNode;
    }

    public void setParrentNode(NodeInterface parrentNode) {
        this.parrentNode = parrentNode;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getValNode() {
        return valNode;
    }

    public void setValNode(long valNode) {
        this.valNode = valNode;
    }

    @Override
    public void setType(NodeType expType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
