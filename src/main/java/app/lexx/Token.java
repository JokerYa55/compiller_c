package app.lexx;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Token {

    private String val = null; // Значение токена
    private TokenType symType = null; // Тип токена

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public TokenType getSymType() {
        return symType;
    }

    public void setSymType(TokenType symType) {
        this.symType = symType;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(this);
        return json;
    }

}
