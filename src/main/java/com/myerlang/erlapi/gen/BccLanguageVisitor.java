// Generated from C:/Users/gabri/Desktop/final_lenguajes/erlapi/src/main/java/com/myerlang/erlapi/grammar\BccLanguage.g4 by ANTLR 4.8
package com.myerlang.erlapi.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BccLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BccLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BccLanguageParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(BccLanguageParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link BccLanguageParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(BccLanguageParser.Var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link BccLanguageParser#fn_decl_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFn_decl_list(BccLanguageParser.Fn_decl_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link BccLanguageParser#stmt_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_block(BccLanguageParser.Stmt_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link BccLanguageParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(BccLanguageParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BccLanguageParser#lexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexpr(BccLanguageParser.LexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BccLanguageParser#nexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNexpr(BccLanguageParser.NexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BccLanguageParser#rexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRexpr(BccLanguageParser.RexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BccLanguageParser#simple_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_expr(BccLanguageParser.Simple_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BccLanguageParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(BccLanguageParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link BccLanguageParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(BccLanguageParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link BccLanguageParser#main_prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain_prog(BccLanguageParser.Main_progContext ctx);
}