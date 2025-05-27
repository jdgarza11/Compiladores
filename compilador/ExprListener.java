// Generated from Expr.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#all}.
	 * @param ctx the parse tree
	 */
	void enterAll(ExprParser.AllContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#all}.
	 * @param ctx the parse tree
	 */
	void exitAll(ExprParser.AllContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ExprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ExprParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#o_vars}.
	 * @param ctx the parse tree
	 */
	void enterO_vars(ExprParser.O_varsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#o_vars}.
	 * @param ctx the parse tree
	 */
	void exitO_vars(ExprParser.O_varsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#o_funcs}.
	 * @param ctx the parse tree
	 */
	void enterO_funcs(ExprParser.O_funcsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#o_funcs}.
	 * @param ctx the parse tree
	 */
	void exitO_funcs(ExprParser.O_funcsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#vars}.
	 * @param ctx the parse tree
	 */
	void enterVars(ExprParser.VarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#vars}.
	 * @param ctx the parse tree
	 */
	void exitVars(ExprParser.VarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#variables}.
	 * @param ctx the parse tree
	 */
	void enterVariables(ExprParser.VariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#variables}.
	 * @param ctx the parse tree
	 */
	void exitVariables(ExprParser.VariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#listvar}.
	 * @param ctx the parse tree
	 */
	void enterListvar(ExprParser.ListvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#listvar}.
	 * @param ctx the parse tree
	 */
	void exitListvar(ExprParser.ListvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#listid}.
	 * @param ctx the parse tree
	 */
	void enterListid(ExprParser.ListidContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#listid}.
	 * @param ctx the parse tree
	 */
	void exitListid(ExprParser.ListidContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#funcs}.
	 * @param ctx the parse tree
	 */
	void enterFuncs(ExprParser.FuncsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#funcs}.
	 * @param ctx the parse tree
	 */
	void exitFuncs(ExprParser.FuncsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(ExprParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(ExprParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#listinput}.
	 * @param ctx the parse tree
	 */
	void enterListinput(ExprParser.ListinputContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#listinput}.
	 * @param ctx the parse tree
	 */
	void exitListinput(ExprParser.ListinputContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(ExprParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(ExprParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ExprParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ExprParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#o_statement}.
	 * @param ctx the parse tree
	 */
	void enterO_statement(ExprParser.O_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#o_statement}.
	 * @param ctx the parse tree
	 */
	void exitO_statement(ExprParser.O_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ExprParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ExprParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ExprParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ExprParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(ExprParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(ExprParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#elses}.
	 * @param ctx the parse tree
	 */
	void enterElses(ExprParser.ElsesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#elses}.
	 * @param ctx the parse tree
	 */
	void exitElses(ExprParser.ElsesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#cycle}.
	 * @param ctx the parse tree
	 */
	void enterCycle(ExprParser.CycleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#cycle}.
	 * @param ctx the parse tree
	 */
	void exitCycle(ExprParser.CycleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#f_call}.
	 * @param ctx the parse tree
	 */
	void enterF_call(ExprParser.F_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#f_call}.
	 * @param ctx the parse tree
	 */
	void exitF_call(ExprParser.F_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#list_exp}.
	 * @param ctx the parse tree
	 */
	void enterList_exp(ExprParser.List_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#list_exp}.
	 * @param ctx the parse tree
	 */
	void exitList_exp(ExprParser.List_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#mas_exp}.
	 * @param ctx the parse tree
	 */
	void enterMas_exp(ExprParser.Mas_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#mas_exp}.
	 * @param ctx the parse tree
	 */
	void exitMas_exp(ExprParser.Mas_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(ExprParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(ExprParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#exps}.
	 * @param ctx the parse tree
	 */
	void enterExps(ExprParser.ExpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#exps}.
	 * @param ctx the parse tree
	 */
	void exitExps(ExprParser.ExpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#ext}.
	 * @param ctx the parse tree
	 */
	void enterExt(ExprParser.ExtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#ext}.
	 * @param ctx the parse tree
	 */
	void exitExt(ExprParser.ExtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(ExprParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(ExprParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(ExprParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(ExprParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#mas_menos}.
	 * @param ctx the parse tree
	 */
	void enterMas_menos(ExprParser.Mas_menosContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#mas_menos}.
	 * @param ctx the parse tree
	 */
	void exitMas_menos(ExprParser.Mas_menosContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#termino}.
	 * @param ctx the parse tree
	 */
	void enterTermino(ExprParser.TerminoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#termino}.
	 * @param ctx the parse tree
	 */
	void exitTermino(ExprParser.TerminoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#por_div}.
	 * @param ctx the parse tree
	 */
	void enterPor_div(ExprParser.Por_divContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#por_div}.
	 * @param ctx the parse tree
	 */
	void exitPor_div(ExprParser.Por_divContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(ExprParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(ExprParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#tokenop}.
	 * @param ctx the parse tree
	 */
	void enterTokenop(ExprParser.TokenopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#tokenop}.
	 * @param ctx the parse tree
	 */
	void exitTokenop(ExprParser.TokenopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(ExprParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(ExprParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#opt}.
	 * @param ctx the parse tree
	 */
	void enterOpt(ExprParser.OptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#opt}.
	 * @param ctx the parse tree
	 */
	void exitOpt(ExprParser.OptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#mas}.
	 * @param ctx the parse tree
	 */
	void enterMas(ExprParser.MasContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#mas}.
	 * @param ctx the parse tree
	 */
	void exitMas(ExprParser.MasContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#idcte}.
	 * @param ctx the parse tree
	 */
	void enterIdcte(ExprParser.IdcteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#idcte}.
	 * @param ctx the parse tree
	 */
	void exitIdcte(ExprParser.IdcteContext ctx);
}