package app.syntactical_analyzer.syntactial_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProgramBlock {

    private static final Logger LOG = Logger.getLogger(ProgramBlock.class.getName());

    private final List<TreeNode> operList = new ArrayList<>();
    private String blockName;

    public ProgramBlock(String blockName) {
        this.blockName = blockName;
    }

    
    
    public long addNode(TreeNode node) {
        operList.add(node);
        return operList.indexOf(node);
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

}
