package app.syntactical_analyzer.syntactial_tree;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().create();
        String jsonText = gson.toJson(this);
        JSONObject json = null;
        JSONParser parser = null;
        try {
            json = (JSONObject) parser.parse(jsonText);
        } catch (ParseException ex) {
            Logger.getLogger(ProgramBlock.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json.toJSONString();
    }

    
}
