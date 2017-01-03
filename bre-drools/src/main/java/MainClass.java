import antlr4.ExprLexer;
import antlr4.ExprParser;
import antlr4.ExprVisitor;
import antlr4.visitor.EvalVisitor;
import ape.ApeLexer;
import ape.ApeParser;
import ape.visitor.ApeVisitor;
import com.google.gson.JsonObject;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.apache.commons.io.FileUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) throws IOException {
        ape();

    }

    public static void expr() throws IOException {
        int COUNT = 100;
//        FileUtils.
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("expr");
//        String inputFile = "classpath:expr";
//        InputStream is  = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.prog(); // parse; start at prog
        System.out.println(tree.toStringTree(parser)); // print tree as text

        long[] durations = new long[COUNT];

        for (int index = 0; index < COUNT; index++) {
            long start = System.currentTimeMillis();
            EvalVisitor visitor = new EvalVisitor(String.valueOf(index));
            Integer result = visitor.visit(tree);
            durations[index] = System.currentTimeMillis() - start;
        }
        Arrays.stream(durations).filter(t -> t > 100).forEach(System.out::println);
    }

    public static void ape() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("ape.expr");
        ANTLRInputStream input = new ANTLRInputStream(is);
        ApeLexer lexer = new ApeLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ApeParser parser = new ApeParser(tokens);
        ParseTree tree = parser.jsonParser(); // parse; start at prog
        System.out.println(tree.toStringTree(parser)); // print tree as text

        JsonObject data = new JsonObject();
        ApeVisitor visitor = new ApeVisitor(data);
        Object result = visitor.visit(tree);
        System.out.println(data.get("bpmCode"));

    }
}
