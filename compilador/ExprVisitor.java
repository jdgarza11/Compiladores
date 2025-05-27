// Generated from Expr.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#all}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAll(ExprParser.AllContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ExprParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#o_vars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitO_vars(ExprParser.O_varsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#o_funcs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitO_funcs(ExprParser.O_funcsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#vars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVars(ExprParser.VarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariables(ExprParser.VariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#listvar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListvar(ExprParser.ListvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#listid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListid(ExprParser.ListidContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#funcs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncs(ExprParser.FuncsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(ExprParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#listinput}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListinput(ExprParser.ListinputContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(ExprParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(ExprParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#o_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitO_statement(ExprParser.O_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ExprParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(ExprParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(ExprParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#elses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElses(ExprParser.ElsesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#cycle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycle(ExprParser.CycleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#f_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_call(ExprParser.F_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#list_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_exp(ExprParser.List_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#mas_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMas_exp(ExprParser.Mas_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(ExprParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#exps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExps(ExprParser.ExpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#ext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExt(ExprParser.ExtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(ExprParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(ExprParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#mas_menos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMas_menos(ExprParser.Mas_menosContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#termino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermino(ExprParser.TerminoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#por_div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPor_div(ExprParser.Por_divContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(ExprParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#tokenop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTokenop(ExprParser.TokenopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(ExprParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#opt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpt(ExprParser.OptContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#mas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMas(ExprParser.MasContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#idcte}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdcte(ExprParser.IdcteContext ctx);
}