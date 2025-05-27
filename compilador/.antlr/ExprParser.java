// Generated from d:/Repos/Academico/Octavo/Compiladores/compilador/Expr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, IF=11, WHILE=12, DO=13, PRINT=14, PROGRAM=15, MAIN=16, END=17, 
		VOID=18, VAR=19, ELSE=20, EQUAL=21, LPAREN=22, RPAREN=23, LBRACE=24, RBRACE=25, 
		LBRAQ=26, RBRAQ=27, COMMA=28, SEMI=29, ID=30, INT=31, FLOAT=32, STRING=33, 
		WS=34, COMMENT=35;
	public static final int
		RULE_all = 0, RULE_program = 1, RULE_o_vars = 2, RULE_o_funcs = 3, RULE_vars = 4, 
		RULE_variables = 5, RULE_listvar = 6, RULE_listid = 7, RULE_funcs = 8, 
		RULE_input = 9, RULE_listinput = 10, RULE_body = 11, RULE_type = 12, RULE_o_statement = 13, 
		RULE_statement = 14, RULE_assign = 15, RULE_condition = 16, RULE_elses = 17, 
		RULE_cycle = 18, RULE_f_call = 19, RULE_list_exp = 20, RULE_mas_exp = 21, 
		RULE_print = 22, RULE_exps = 23, RULE_ext = 24, RULE_expresion = 25, RULE_exp = 26, 
		RULE_mas_menos = 27, RULE_termino = 28, RULE_por_div = 29, RULE_op = 30, 
		RULE_tokenop = 31, RULE_factor = 32, RULE_opt = 33, RULE_mas = 34, RULE_idcte = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"all", "program", "o_vars", "o_funcs", "vars", "variables", "listvar", 
			"listid", "funcs", "input", "listinput", "body", "type", "o_statement", 
			"statement", "assign", "condition", "elses", "cycle", "f_call", "list_exp", 
			"mas_exp", "print", "exps", "ext", "expresion", "exp", "mas_menos", "termino", 
			"por_div", "op", "tokenop", "factor", "opt", "mas", "idcte"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'int'", "'float'", "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", 
			"'!='", "'if'", "'while'", "'do'", "'print'", "'program'", "'main'", 
			"'end'", "'void'", "'var'", "'else'", "'='", "'('", "')'", "'{'", "'}'", 
			"'['", "']'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "IF", 
			"WHILE", "DO", "PRINT", "PROGRAM", "MAIN", "END", "VOID", "VAR", "ELSE", 
			"EQUAL", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRAQ", "RBRAQ", "COMMA", 
			"SEMI", "ID", "INT", "FLOAT", "STRING", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AllContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public AllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_all; }
	}

	public final AllContext all() throws RecognitionException {
		AllContext _localctx = new AllContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			program();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(ExprParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(ExprParser.SEMI, 0); }
		public O_varsContext o_vars() {
			return getRuleContext(O_varsContext.class,0);
		}
		public O_funcsContext o_funcs() {
			return getRuleContext(O_funcsContext.class,0);
		}
		public TerminalNode MAIN() { return getToken(ExprParser.MAIN, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode END() { return getToken(ExprParser.END, 0); }
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(PROGRAM);
			setState(75);
			match(ID);
			setState(76);
			match(SEMI);
			setState(77);
			o_vars();
			setState(78);
			o_funcs();
			setState(79);
			match(MAIN);
			setState(80);
			body();
			setState(81);
			match(END);
			setState(82);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class O_varsContext extends ParserRuleContext {
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public O_varsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_o_vars; }
	}

	public final O_varsContext o_vars() throws RecognitionException {
		O_varsContext _localctx = new O_varsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_o_vars);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				vars();
				}
				break;
			case MAIN:
			case VOID:
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class O_funcsContext extends ParserRuleContext {
		public FuncsContext funcs() {
			return getRuleContext(FuncsContext.class,0);
		}
		public O_funcsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_o_funcs; }
	}

	public final O_funcsContext o_funcs() throws RecognitionException {
		O_funcsContext _localctx = new O_funcsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_o_funcs);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				funcs();
				}
				break;
			case MAIN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarsContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(ExprParser.VAR, 0); }
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public VarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars; }
	}

	public final VarsContext vars() throws RecognitionException {
		VarsContext _localctx = new VarsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_vars);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(VAR);
			setState(93);
			variables();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariablesContext extends ParserRuleContext {
		public ListidContext listid() {
			return getRuleContext(ListidContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ExprParser.SEMI, 0); }
		public ListvarContext listvar() {
			return getRuleContext(ListvarContext.class,0);
		}
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variables);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			listid();
			setState(96);
			match(T__0);
			setState(97);
			type();
			setState(98);
			match(SEMI);
			setState(99);
			listvar();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListvarContext extends ParserRuleContext {
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public ListvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listvar; }
	}

	public final ListvarContext listvar() throws RecognitionException {
		ListvarContext _localctx = new ListvarContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_listvar);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				variables();
				}
				break;
			case MAIN:
			case VOID:
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListidContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode COMMA() { return getToken(ExprParser.COMMA, 0); }
		public ListidContext listid() {
			return getRuleContext(ListidContext.class,0);
		}
		public ListidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listid; }
	}

	public final ListidContext listid() throws RecognitionException {
		ListidContext _localctx = new ListidContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_listid);
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(ID);
				setState(107);
				match(COMMA);
				setState(108);
				listid();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncsContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(ExprParser.VOID, 0); }
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(ExprParser.LPAREN, 0); }
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExprParser.RPAREN, 0); }
		public TerminalNode LBRAQ() { return getToken(ExprParser.LBRAQ, 0); }
		public O_varsContext o_vars() {
			return getRuleContext(O_varsContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode RBRAQ() { return getToken(ExprParser.RBRAQ, 0); }
		public TerminalNode SEMI() { return getToken(ExprParser.SEMI, 0); }
		public FuncsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcs; }
	}

	public final FuncsContext funcs() throws RecognitionException {
		FuncsContext _localctx = new FuncsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(VOID);
			setState(112);
			match(ID);
			setState(113);
			match(LPAREN);
			setState(114);
			input();
			setState(115);
			match(RPAREN);
			setState(116);
			match(LBRAQ);
			setState(117);
			o_vars();
			setState(118);
			body();
			setState(119);
			match(RBRAQ);
			setState(120);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InputContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ListinputContext listinput() {
			return getRuleContext(ListinputContext.class,0);
		}
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_input);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(ID);
				setState(123);
				match(T__0);
				setState(124);
				type();
				setState(125);
				listinput();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListinputContext extends ParserRuleContext {
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public ListinputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listinput; }
	}

	public final ListinputContext listinput() throws RecognitionException {
		ListinputContext _localctx = new ListinputContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_listinput);
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				input();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ExprParser.LBRACE, 0); }
		public O_statementContext o_statement() {
			return getRuleContext(O_statementContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ExprParser.RBRACE, 0); }
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(LBRACE);
			setState(135);
			o_statement();
			setState(136);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class O_statementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public O_statementContext o_statement() {
			return getRuleContext(O_statementContext.class,0);
		}
		public O_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_o_statement; }
	}

	public final O_statementContext o_statement() throws RecognitionException {
		O_statementContext _localctx = new O_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_o_statement);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case WHILE:
			case PRINT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				statement();
				setState(141);
				o_statement();
				}
				break;
			case RBRACE:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public CycleContext cycle() {
			return getRuleContext(CycleContext.class,0);
		}
		public F_callContext f_call() {
			return getRuleContext(F_callContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_statement);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				condition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				cycle();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				f_call();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(150);
				print();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(ExprParser.EQUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ExprParser.SEMI, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(ID);
			setState(154);
			match(EQUAL);
			setState(155);
			expresion();
			setState(156);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ExprParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(ExprParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExprParser.RPAREN, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(ExprParser.ELSE, 0); }
		public ElsesContext elses() {
			return getRuleContext(ElsesContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ExprParser.SEMI, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(IF);
			setState(159);
			match(LPAREN);
			setState(160);
			expresion();
			setState(161);
			match(RPAREN);
			setState(162);
			body();
			setState(163);
			match(ELSE);
			setState(164);
			elses();
			setState(165);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElsesContext extends ParserRuleContext {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ElsesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elses; }
	}

	public final ElsesContext elses() throws RecognitionException {
		ElsesContext _localctx = new ElsesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_elses);
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				body();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CycleContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(ExprParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(ExprParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExprParser.RPAREN, 0); }
		public TerminalNode DO() { return getToken(ExprParser.DO, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ExprParser.SEMI, 0); }
		public CycleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cycle; }
	}

	public final CycleContext cycle() throws RecognitionException {
		CycleContext _localctx = new CycleContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_cycle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(WHILE);
			setState(172);
			match(LPAREN);
			setState(173);
			expresion();
			setState(174);
			match(RPAREN);
			setState(175);
			match(DO);
			setState(176);
			body();
			setState(177);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class F_callContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(ExprParser.LPAREN, 0); }
		public List_expContext list_exp() {
			return getRuleContext(List_expContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExprParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(ExprParser.SEMI, 0); }
		public F_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f_call; }
	}

	public final F_callContext f_call() throws RecognitionException {
		F_callContext _localctx = new F_callContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_f_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(ID);
			setState(180);
			match(LPAREN);
			setState(181);
			list_exp();
			setState(182);
			match(RPAREN);
			setState(183);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_expContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public Mas_expContext mas_exp() {
			return getRuleContext(Mas_expContext.class,0);
		}
		public List_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_exp; }
	}

	public final List_expContext list_exp() throws RecognitionException {
		List_expContext _localctx = new List_expContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_list_exp);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
			case LPAREN:
			case ID:
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				expresion();
				setState(186);
				mas_exp();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mas_expContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(ExprParser.COMMA, 0); }
		public List_expContext list_exp() {
			return getRuleContext(List_expContext.class,0);
		}
		public Mas_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mas_exp; }
	}

	public final Mas_expContext mas_exp() throws RecognitionException {
		Mas_expContext _localctx = new Mas_expContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_mas_exp);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(COMMA);
				setState(192);
				list_exp();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(ExprParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(ExprParser.LPAREN, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExprParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(ExprParser.SEMI, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(PRINT);
			setState(197);
			match(LPAREN);
			setState(198);
			exps();
			setState(199);
			match(RPAREN);
			setState(200);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpsContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExtContext ext() {
			return getRuleContext(ExtContext.class,0);
		}
		public TerminalNode STRING() { return getToken(ExprParser.STRING, 0); }
		public ExpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exps; }
	}

	public final ExpsContext exps() throws RecognitionException {
		ExpsContext _localctx = new ExpsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_exps);
		try {
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
			case LPAREN:
			case ID:
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				expresion();
				setState(203);
				ext();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExtContext extends ParserRuleContext {
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public ExtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ext; }
	}

	public final ExtContext ext() throws RecognitionException {
		ExtContext _localctx = new ExtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_ext);
		try {
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
			case LPAREN:
			case ID:
			case INT:
			case FLOAT:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				exps();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			exp();
			setState(213);
			op();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public TerminoContext termino() {
			return getRuleContext(TerminoContext.class,0);
		}
		public Mas_menosContext mas_menos() {
			return getRuleContext(Mas_menosContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			termino();
			setState(216);
			mas_menos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mas_menosContext extends ParserRuleContext {
		public TerminoContext termino() {
			return getRuleContext(TerminoContext.class,0);
		}
		public Mas_menosContext mas_menos() {
			return getRuleContext(Mas_menosContext.class,0);
		}
		public Mas_menosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mas_menos; }
	}

	public final Mas_menosContext mas_menos() throws RecognitionException {
		Mas_menosContext _localctx = new Mas_menosContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_mas_menos);
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				match(T__3);
				setState(219);
				termino();
				setState(220);
				mas_menos();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				match(T__4);
				setState(223);
				termino();
				setState(224);
				mas_menos();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TerminoContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Por_divContext por_div() {
			return getRuleContext(Por_divContext.class,0);
		}
		public TerminoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termino; }
	}

	public final TerminoContext termino() throws RecognitionException {
		TerminoContext _localctx = new TerminoContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_termino);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			factor();
			setState(230);
			por_div();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Por_divContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Por_divContext por_div() {
			return getRuleContext(Por_divContext.class,0);
		}
		public Por_divContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_por_div; }
	}

	public final Por_divContext por_div() throws RecognitionException {
		Por_divContext _localctx = new Por_divContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_por_div);
		try {
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				match(T__5);
				setState(233);
				factor();
				setState(234);
				por_div();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(T__6);
				setState(237);
				factor();
				setState(238);
				por_div();
				}
				break;
			case T__3:
			case T__4:
			case T__7:
			case T__8:
			case T__9:
			case LPAREN:
			case RPAREN:
			case COMMA:
			case SEMI:
			case ID:
			case INT:
			case FLOAT:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OpContext extends ParserRuleContext {
		public TokenopContext tokenop() {
			return getRuleContext(TokenopContext.class,0);
		}
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_op);
		try {
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				tokenop();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TokenopContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TokenopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenop; }
	}

	public final TokenopContext tokenop() throws RecognitionException {
		TokenopContext _localctx = new TokenopContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_tokenop);
		try {
			setState(254);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				match(T__7);
				setState(248);
				exp();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				match(T__8);
				setState(250);
				exp();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(251);
				match(T__9);
				setState(252);
				exp();
				}
				break;
			case T__3:
			case T__4:
			case LPAREN:
			case RPAREN:
			case COMMA:
			case SEMI:
			case ID:
			case INT:
			case FLOAT:
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public OptContext opt() {
			return getRuleContext(OptContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			opt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ExprParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExprParser.RPAREN, 0); }
		public MasContext mas() {
			return getRuleContext(MasContext.class,0);
		}
		public IdcteContext idcte() {
			return getRuleContext(IdcteContext.class,0);
		}
		public OptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt; }
	}

	public final OptContext opt() throws RecognitionException {
		OptContext _localctx = new OptContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_opt);
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				match(LPAREN);
				setState(259);
				expresion();
				setState(260);
				match(RPAREN);
				}
				break;
			case T__3:
			case T__4:
			case ID:
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				mas();
				setState(263);
				idcte();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MasContext extends ParserRuleContext {
		public MasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mas; }
	}

	public final MasContext mas() throws RecognitionException {
		MasContext _localctx = new MasContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_mas);
		try {
			setState(270);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				match(T__3);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				match(T__4);
				}
				break;
			case ID:
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdcteContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(ExprParser.FLOAT, 0); }
		public IdcteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idcte; }
	}

	public final IdcteContext idcte() throws RecognitionException {
		IdcteContext _localctx = new IdcteContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_idcte);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7516192768L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001#\u0113\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0003\u0002W\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0003\u0003[\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0003\u0006h\b\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007n\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0081\b\t\u0001\n\u0001\n\u0003"+
		"\n\u0085\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0091\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0098\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u00aa\b\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u00be\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00c3"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00cf"+
		"\b\u0017\u0001\u0018\u0001\u0018\u0003\u0018\u00d3\b\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0003\u001b\u00e4\b\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u00f2\b\u001d"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u00f6\b\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f"+
		"\u00ff\b\u001f\u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0003!\u010a\b!\u0001\"\u0001\"\u0001\"\u0003\"\u010f\b\"\u0001"+
		"#\u0001#\u0001#\u0000\u0000$\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF\u0000"+
		"\u0002\u0001\u0000\u0002\u0003\u0001\u0000\u001e \u0109\u0000H\u0001\u0000"+
		"\u0000\u0000\u0002J\u0001\u0000\u0000\u0000\u0004V\u0001\u0000\u0000\u0000"+
		"\u0006Z\u0001\u0000\u0000\u0000\b\\\u0001\u0000\u0000\u0000\n_\u0001\u0000"+
		"\u0000\u0000\fg\u0001\u0000\u0000\u0000\u000em\u0001\u0000\u0000\u0000"+
		"\u0010o\u0001\u0000\u0000\u0000\u0012\u0080\u0001\u0000\u0000\u0000\u0014"+
		"\u0084\u0001\u0000\u0000\u0000\u0016\u0086\u0001\u0000\u0000\u0000\u0018"+
		"\u008a\u0001\u0000\u0000\u0000\u001a\u0090\u0001\u0000\u0000\u0000\u001c"+
		"\u0097\u0001\u0000\u0000\u0000\u001e\u0099\u0001\u0000\u0000\u0000 \u009e"+
		"\u0001\u0000\u0000\u0000\"\u00a9\u0001\u0000\u0000\u0000$\u00ab\u0001"+
		"\u0000\u0000\u0000&\u00b3\u0001\u0000\u0000\u0000(\u00bd\u0001\u0000\u0000"+
		"\u0000*\u00c2\u0001\u0000\u0000\u0000,\u00c4\u0001\u0000\u0000\u0000."+
		"\u00ce\u0001\u0000\u0000\u00000\u00d2\u0001\u0000\u0000\u00002\u00d4\u0001"+
		"\u0000\u0000\u00004\u00d7\u0001\u0000\u0000\u00006\u00e3\u0001\u0000\u0000"+
		"\u00008\u00e5\u0001\u0000\u0000\u0000:\u00f1\u0001\u0000\u0000\u0000<"+
		"\u00f5\u0001\u0000\u0000\u0000>\u00fe\u0001\u0000\u0000\u0000@\u0100\u0001"+
		"\u0000\u0000\u0000B\u0109\u0001\u0000\u0000\u0000D\u010e\u0001\u0000\u0000"+
		"\u0000F\u0110\u0001\u0000\u0000\u0000HI\u0003\u0002\u0001\u0000I\u0001"+
		"\u0001\u0000\u0000\u0000JK\u0005\u000f\u0000\u0000KL\u0005\u001e\u0000"+
		"\u0000LM\u0005\u001d\u0000\u0000MN\u0003\u0004\u0002\u0000NO\u0003\u0006"+
		"\u0003\u0000OP\u0005\u0010\u0000\u0000PQ\u0003\u0016\u000b\u0000QR\u0005"+
		"\u0011\u0000\u0000RS\u0005\u0000\u0000\u0001S\u0003\u0001\u0000\u0000"+
		"\u0000TW\u0003\b\u0004\u0000UW\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000"+
		"\u0000VU\u0001\u0000\u0000\u0000W\u0005\u0001\u0000\u0000\u0000X[\u0003"+
		"\u0010\b\u0000Y[\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000ZY\u0001"+
		"\u0000\u0000\u0000[\u0007\u0001\u0000\u0000\u0000\\]\u0005\u0013\u0000"+
		"\u0000]^\u0003\n\u0005\u0000^\t\u0001\u0000\u0000\u0000_`\u0003\u000e"+
		"\u0007\u0000`a\u0005\u0001\u0000\u0000ab\u0003\u0018\f\u0000bc\u0005\u001d"+
		"\u0000\u0000cd\u0003\f\u0006\u0000d\u000b\u0001\u0000\u0000\u0000eh\u0003"+
		"\n\u0005\u0000fh\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000gf\u0001"+
		"\u0000\u0000\u0000h\r\u0001\u0000\u0000\u0000in\u0005\u001e\u0000\u0000"+
		"jk\u0005\u001e\u0000\u0000kl\u0005\u001c\u0000\u0000ln\u0003\u000e\u0007"+
		"\u0000mi\u0001\u0000\u0000\u0000mj\u0001\u0000\u0000\u0000n\u000f\u0001"+
		"\u0000\u0000\u0000op\u0005\u0012\u0000\u0000pq\u0005\u001e\u0000\u0000"+
		"qr\u0005\u0016\u0000\u0000rs\u0003\u0012\t\u0000st\u0005\u0017\u0000\u0000"+
		"tu\u0005\u001a\u0000\u0000uv\u0003\u0004\u0002\u0000vw\u0003\u0016\u000b"+
		"\u0000wx\u0005\u001b\u0000\u0000xy\u0005\u001d\u0000\u0000y\u0011\u0001"+
		"\u0000\u0000\u0000z{\u0005\u001e\u0000\u0000{|\u0005\u0001\u0000\u0000"+
		"|}\u0003\u0018\f\u0000}~\u0003\u0014\n\u0000~\u0081\u0001\u0000\u0000"+
		"\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080z\u0001\u0000\u0000\u0000"+
		"\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0013\u0001\u0000\u0000\u0000"+
		"\u0082\u0085\u0003\u0012\t\u0000\u0083\u0085\u0001\u0000\u0000\u0000\u0084"+
		"\u0082\u0001\u0000\u0000\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085"+
		"\u0015\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u0018\u0000\u0000\u0087"+
		"\u0088\u0003\u001a\r\u0000\u0088\u0089\u0005\u0019\u0000\u0000\u0089\u0017"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0007\u0000\u0000\u0000\u008b\u0019"+
		"\u0001\u0000\u0000\u0000\u008c\u008d\u0003\u001c\u000e\u0000\u008d\u008e"+
		"\u0003\u001a\r\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u0091\u0001"+
		"\u0000\u0000\u0000\u0090\u008c\u0001\u0000\u0000\u0000\u0090\u008f\u0001"+
		"\u0000\u0000\u0000\u0091\u001b\u0001\u0000\u0000\u0000\u0092\u0098\u0003"+
		"\u001e\u000f\u0000\u0093\u0098\u0003 \u0010\u0000\u0094\u0098\u0003$\u0012"+
		"\u0000\u0095\u0098\u0003&\u0013\u0000\u0096\u0098\u0003,\u0016\u0000\u0097"+
		"\u0092\u0001\u0000\u0000\u0000\u0097\u0093\u0001\u0000\u0000\u0000\u0097"+
		"\u0094\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097"+
		"\u0096\u0001\u0000\u0000\u0000\u0098\u001d\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0005\u001e\u0000\u0000\u009a\u009b\u0005\u0015\u0000\u0000\u009b"+
		"\u009c\u00032\u0019\u0000\u009c\u009d\u0005\u001d\u0000\u0000\u009d\u001f"+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u000b\u0000\u0000\u009f\u00a0"+
		"\u0005\u0016\u0000\u0000\u00a0\u00a1\u00032\u0019\u0000\u00a1\u00a2\u0005"+
		"\u0017\u0000\u0000\u00a2\u00a3\u0003\u0016\u000b\u0000\u00a3\u00a4\u0005"+
		"\u0014\u0000\u0000\u00a4\u00a5\u0003\"\u0011\u0000\u00a5\u00a6\u0005\u001d"+
		"\u0000\u0000\u00a6!\u0001\u0000\u0000\u0000\u00a7\u00aa\u0003\u0016\u000b"+
		"\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa#\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0005\f\u0000\u0000\u00ac\u00ad\u0005\u0016\u0000\u0000\u00ad"+
		"\u00ae\u00032\u0019\u0000\u00ae\u00af\u0005\u0017\u0000\u0000\u00af\u00b0"+
		"\u0005\r\u0000\u0000\u00b0\u00b1\u0003\u0016\u000b\u0000\u00b1\u00b2\u0005"+
		"\u001d\u0000\u0000\u00b2%\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u001e"+
		"\u0000\u0000\u00b4\u00b5\u0005\u0016\u0000\u0000\u00b5\u00b6\u0003(\u0014"+
		"\u0000\u00b6\u00b7\u0005\u0017\u0000\u0000\u00b7\u00b8\u0005\u001d\u0000"+
		"\u0000\u00b8\'\u0001\u0000\u0000\u0000\u00b9\u00ba\u00032\u0019\u0000"+
		"\u00ba\u00bb\u0003*\u0015\u0000\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc"+
		"\u00be\u0001\u0000\u0000\u0000\u00bd\u00b9\u0001\u0000\u0000\u0000\u00bd"+
		"\u00bc\u0001\u0000\u0000\u0000\u00be)\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\u0005\u001c\u0000\u0000\u00c0\u00c3\u0003(\u0014\u0000\u00c1\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c2\u00bf\u0001\u0000\u0000\u0000\u00c2\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c3+\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u000e"+
		"\u0000\u0000\u00c5\u00c6\u0005\u0016\u0000\u0000\u00c6\u00c7\u0003.\u0017"+
		"\u0000\u00c7\u00c8\u0005\u0017\u0000\u0000\u00c8\u00c9\u0005\u001d\u0000"+
		"\u0000\u00c9-\u0001\u0000\u0000\u0000\u00ca\u00cb\u00032\u0019\u0000\u00cb"+
		"\u00cc\u00030\u0018\u0000\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cf"+
		"\u0005!\u0000\u0000\u00ce\u00ca\u0001\u0000\u0000\u0000\u00ce\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cf/\u0001\u0000\u0000\u0000\u00d0\u00d3\u0003.\u0017"+
		"\u0000\u00d1\u00d3\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d31\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d5\u00034\u001a\u0000\u00d5\u00d6\u0003<\u001e\u0000\u00d63"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u00038\u001c\u0000\u00d8\u00d9\u0003"+
		"6\u001b\u0000\u00d95\u0001\u0000\u0000\u0000\u00da\u00db\u0005\u0004\u0000"+
		"\u0000\u00db\u00dc\u00038\u001c\u0000\u00dc\u00dd\u00036\u001b\u0000\u00dd"+
		"\u00e4\u0001\u0000\u0000\u0000\u00de\u00df\u0005\u0005\u0000\u0000\u00df"+
		"\u00e0\u00038\u001c\u0000\u00e0\u00e1\u00036\u001b\u0000\u00e1\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00da\u0001"+
		"\u0000\u0000\u0000\u00e3\u00de\u0001\u0000\u0000\u0000\u00e3\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e47\u0001\u0000\u0000\u0000\u00e5\u00e6\u0003@ "+
		"\u0000\u00e6\u00e7\u0003:\u001d\u0000\u00e79\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e9\u0005\u0006\u0000\u0000\u00e9\u00ea\u0003@ \u0000\u00ea\u00eb\u0003"+
		":\u001d\u0000\u00eb\u00f2\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u0007"+
		"\u0000\u0000\u00ed\u00ee\u0003@ \u0000\u00ee\u00ef\u0003:\u001d\u0000"+
		"\u00ef\u00f2\u0001\u0000\u0000\u0000\u00f0\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f1\u00e8\u0001\u0000\u0000\u0000\u00f1\u00ec\u0001\u0000\u0000\u0000"+
		"\u00f1\u00f0\u0001\u0000\u0000\u0000\u00f2;\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f6\u0003>\u001f\u0000\u00f4\u00f6\u0001\u0000\u0000\u0000\u00f5\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f4\u0001\u0000\u0000\u0000\u00f6=\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f8\u0005\b\u0000\u0000\u00f8\u00ff\u00034"+
		"\u001a\u0000\u00f9\u00fa\u0005\t\u0000\u0000\u00fa\u00ff\u00034\u001a"+
		"\u0000\u00fb\u00fc\u0005\n\u0000\u0000\u00fc\u00ff\u00034\u001a\u0000"+
		"\u00fd\u00ff\u0001\u0000\u0000\u0000\u00fe\u00f7\u0001\u0000\u0000\u0000"+
		"\u00fe\u00f9\u0001\u0000\u0000\u0000\u00fe\u00fb\u0001\u0000\u0000\u0000"+
		"\u00fe\u00fd\u0001\u0000\u0000\u0000\u00ff?\u0001\u0000\u0000\u0000\u0100"+
		"\u0101\u0003B!\u0000\u0101A\u0001\u0000\u0000\u0000\u0102\u0103\u0005"+
		"\u0016\u0000\u0000\u0103\u0104\u00032\u0019\u0000\u0104\u0105\u0005\u0017"+
		"\u0000\u0000\u0105\u010a\u0001\u0000\u0000\u0000\u0106\u0107\u0003D\""+
		"\u0000\u0107\u0108\u0003F#\u0000\u0108\u010a\u0001\u0000\u0000\u0000\u0109"+
		"\u0102\u0001\u0000\u0000\u0000\u0109\u0106\u0001\u0000\u0000\u0000\u010a"+
		"C\u0001\u0000\u0000\u0000\u010b\u010f\u0005\u0004\u0000\u0000\u010c\u010f"+
		"\u0005\u0005\u0000\u0000\u010d\u010f\u0001\u0000\u0000\u0000\u010e\u010b"+
		"\u0001\u0000\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010d"+
		"\u0001\u0000\u0000\u0000\u010fE\u0001\u0000\u0000\u0000\u0110\u0111\u0007"+
		"\u0001\u0000\u0000\u0111G\u0001\u0000\u0000\u0000\u0013VZgm\u0080\u0084"+
		"\u0090\u0097\u00a9\u00bd\u00c2\u00ce\u00d2\u00e3\u00f1\u00f5\u00fe\u0109"+
		"\u010e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}