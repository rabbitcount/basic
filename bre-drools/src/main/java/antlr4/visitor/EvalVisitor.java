package antlr4.visitor;

import antlr4.ExprBaseVisitor;
import antlr4.ExprParser;
import antlr4.ExprVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaoxiang on 2016/10/27.
 */
public class EvalVisitor extends ExprBaseVisitor<Integer> {

    private String message;

    public EvalVisitor(String message) {
        this.message = message;
    }

    /** "memory" for our calculator; variable/value pairs go here */
    Map<String, Integer> memory = new HashMap<String, Integer>();

    /** expr NEWLINE */
    public Integer visitPrintExpr(ExprParser.PrintExprContext ctx) {
        Integer value = visit(ctx.expr());
        System.out.println(value);
        return 0;
    }

    /** ID '=' expr NEWLINE */
    public Integer visitAssign(ExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    /** expr op=('*'|'/') expr */
    public Integer visitMulDiv(ExprParser.MulDivContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == ExprParser.MUL) {
            return left * right;
        }
        return left / right;
    }

    /** expr op=('+'|'-') expr */
    public Integer visitAddSub(ExprParser.AddSubContext ctx) {
        int left = visit(ctx.expr(0)); // get value of left subexpression
        int right = visit(ctx.expr(1)); // get value of right subexpression
        if ( ctx.op.getType() == ExprParser.ADD ) return left + right;
        return left - right; // must be SUB
    }
    /** ID */
    public Integer visitId(ExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) {
            return memory.get(id);
        }
        return 0;
    }

    /** INT */
    public Integer visitInt(ExprParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    /** '(' expr ')' */
    public Integer visitParents(ExprParser.ParentsContext ctx) {
        return visit(ctx.expr()); // return child expr's value
    }

    public void print() {
        System.out.println(message);
    }
}
