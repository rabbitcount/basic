package ape.visitor;

import ape.ApeBaseVisitor;
import ape.ApeParser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class ApeVisitor extends ApeBaseVisitor<Object> {

    private JsonObject data;

    private String bpmCode = "CO161210";

    public ApeVisitor(JsonObject data) {
        this.data = data;
    }

    @Override
    public Object visitMakeParser(ApeParser.MakeParserContext ctx) {
        if(ctx.Identifier().getText().equals("setJSON")) {
            String key = visit(ctx.JSONNAME()).toString();
            data.addProperty(key, bpmCode);
            return key;
        }
        return null;
    }

}
