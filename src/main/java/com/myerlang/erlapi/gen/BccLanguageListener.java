// Generated from C:/Users/gabri/Desktop/final_lenguajes/erlapi/src/main/java/com/myerlang/erlapi/grammar\BccLanguage.g4 by ANTLR 4.8
package com.myerlang.erlapi.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BccLanguageParser}.
 */
public interface BccLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BccLanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(BccLanguageParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link BccLanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(BccLanguageParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link BccLanguageParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(BccLanguageParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link BccLanguageParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(BccLanguageParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link BccLanguageParser#fn_decl_list}.
	 * @param ctx the parse tree
	 */
	void enterFn_decl_list(BccLanguageParser.Fn_decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link BccLanguageParser#fn_decl_list}.
	 * @param ctx the parse tree
	 */
	void exitFn_decl_list(BccLanguageParser.Fn_decl_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link BccLanguageParser#stmt_block}.
	 * @param ctx the parse tree
	 */
	void enterStmt_block(BccLanguageParser.Stmt_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BccLanguageParser#stmt_block}.
	 * @param ctx the parse tree
	 */
	void exitStmt_block(BccLanguageParser.Stmt_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BccLanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(BccLanguageParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link BccLanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(BccLanguageParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link BccLanguageParser#lexpr}.
	 * @param ctx the parse tree
	 */
	void enterLexpr(BccLanguageParser.LexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BccLanguageParser#lexpr}.
	 * @param ctx the parse tree
	 */
	void exitLexpr(BccLanguageParser.LexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BccLanguageParser#nexpr}.
	 * @param ctx the parse tree
	 */
	void enterNexpr(BccLanguageParser.NexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BccLanguageParser#nexpr}.
	 * @param ctx the parse tree
	 */
	void exitNexpr(BccLanguageParser.NexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BccLanguageParser#rexpr}.
	 * @param ctx the parse tree
	 */
	void enterRexpr(BccLanguageParser.RexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BccLanguageParser#rexpr}.
	 * @param ctx the parse tree
	 */
	void exitRexpr(BccLanguageParser.RexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BccLanguageParser#simple_expr}.
	 * @param ctx the parse tree
	 */
	void enterSimple_expr(BccLanguageParser.Simple_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BccLanguageParser#simple_expr}.
	 * @param ctx the parse tree
	 */
	void exitSimple_expr(BccLanguageParser.Simple_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BccLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(BccLanguageParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link BccLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(BccLanguageParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link BccLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(BccLanguageParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BccLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(BccLanguageParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BccLanguageParser#main_prog}.
	 * @param ctx the parse tree
	 */
	void enterMain_prog(BccLanguageParser.Main_progContext ctx);
	/**
	 * Exit a parse tree produced by {@link BccLanguageParser#main_prog}.
	 * @param ctx the parse tree
	 */
	void exitMain_prog(BccLanguageParser.Main_progContext ctx);
}