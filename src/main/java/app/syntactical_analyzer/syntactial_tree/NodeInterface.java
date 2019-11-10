package app.syntactical_analyzer.syntactial_tree;

public interface NodeInterface {

    public NodeType getType();

    public void setType(NodeType expType);

    public long getLevel();

    public void setLevel(long level);
}
