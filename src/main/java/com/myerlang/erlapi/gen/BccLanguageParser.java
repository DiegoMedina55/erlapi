// Generated from C:/Users/gabri/Desktop/final_lenguajes/erlapi/src/main/java/com/myerlang/erlapi/grammar\BccLanguage.g4 by ANTLR 4.8
package com.myerlang.erlapi.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BccLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, MULOP=8, SUMOP=9, 
		COMPARISONOP=10, ASSIGNOP=11, DATATYPE=12, FUNCTION=13, VAR=14, PRINT=15, 
		INPUT=16, WHEN=17, IF=18, UNLESS=19, WHILE=20, REPEAT=21, RETURN=22, UNTIL=23, 
		LOOP=24, DO=25, ELSE=26, AND=27, OR=28, FOR=29, NEXT=30, BREAK=31, NOT=32, 
		BOOL=33, SUBS=34, ADD=35, END=36, NUM=37, FID=38, ID=39, ESP=40, LINE_COMMENT=41;
	public static final int
		RULE_prog = 0, RULE_var_decl = 1, RULE_fn_decl_list = 2, RULE_stmt_block = 3, 
		RULE_stmt = 4, RULE_lexpr = 5, RULE_nexpr = 6, RULE_rexpr = 7, RULE_simple_expr = 8, 
		RULE_term = 9, RULE_factor = 10, RULE_main_prog = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "var_decl", "fn_decl_list", "stmt_block", "stmt", "lexpr", "nexpr", 
			"rexpr", "simple_expr", "term", "factor", "main_prog"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "','", "'('", "')'", "';'", "'{'", "'}'", null, null, null, 
			null, null, "'function'", "'var'", "'print'", "'input'", "'when'", "'if'", 
			"'unless'", "'while'", "'repeat'", "'return'", "'until'", "'loop'", "'do'", 
			"'else'", "'and'", "'or'", "'for'", "'next'", "'break'", "'not'", null, 
			"'--'", "'++'", "'end'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "MULOP", "SUMOP", "COMPARISONOP", 
			"ASSIGNOP", "DATATYPE", "FUNCTION", "VAR", "PRINT", "INPUT", "WHEN", 
			"IF", "UNLESS", "WHILE", "REPEAT", "RETURN", "UNTIL", "LOOP", "DO", "ELSE", 
			"AND", "OR", "FOR", "NEXT", "BREAK", "NOT", "BOOL", "SUBS", "ADD", "END", 
			"NUM", "FID", "ID", "ESP", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "BccLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BccLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public Main_progContext main_prog() {
			return getRuleContext(Main_progContext.class,0);
		}
		public List<Fn_decl_listContext> fn_decl_list() {
			return getRuleContexts(Fn_decl_listContext.class);
		}
		public Fn_decl_listContext fn_decl_list(int i) {
			return getRuleContext(Fn_decl_listContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BccLanguageVisitor ) return ((BccLanguageVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION) {
				{
				{
				setState(24);
				fn_decl_list();
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
			main_prog();
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

	public static class Var_declContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(BccLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(BccLanguageParser.ID, i);
		}
		public List<TerminalNode> DATATYPE() { return getTokens(BccLanguageParser.DATATYPE); }
		public TerminalNode DATATYPE(int i) {
			return getToken(BccLanguageParser.DATATYPE, i);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).exitVar_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BccLanguageVisitor ) return ((BccLanguageVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(ID);
			setState(33);
			match(T__0);
			setState(34);
			match(DATATYPE);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(35);
				match(T__1);
				setState(36);
				match(ID);
				setState(37);
				match(T__0);
				setState(38);
				match(DATATYPE);
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Fn_decl_listContext extends ParserRuleContext {
		public Var_declContext PARAMS;
		public Var_declContext LOCAL_VAR;
		public TerminalNode FUNCTION() { return getToken(BccLanguageParser.FUNCTION, 0); }
		public TerminalNode FID() { return getToken(BccLanguageParser.FID, 0); }
		public TerminalNode DATATYPE() { return getToken(BccLanguageParser.DATATYPE, 0); }
		public Stmt_blockContext stmt_block() {
			return getRuleContext(Stmt_blockContext.class,0);
		}
		public TerminalNode VAR() { return getToken(BccLanguageParser.VAR, 0); }
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public Fn_decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fn_decl_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).enterFn_decl_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).exitFn_decl_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BccLanguageVisitor ) return ((BccLanguageVisitor<? extends T>)visitor).visitFn_decl_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fn_decl_listContext fn_decl_list() throws RecognitionException {
		Fn_decl_listContext _localctx = new Fn_decl_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fn_decl_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(FUNCTION);
			setState(45);
			match(FID);
			setState(46);
			match(T__0);
			setState(47);
			match(DATATYPE);
			setState(48);
			match(T__2);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(49);
				((Fn_decl_listContext)_localctx).PARAMS = var_decl();
				}
			}

			setState(52);
			match(T__3);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(53);
				match(VAR);
				setState(54);
				((Fn_decl_listContext)_localctx).LOCAL_VAR = var_decl();
				setState(55);
				match(T__4);
				}
			}

			setState(59);
			stmt_block();
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

	public static class Stmt_blockContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Stmt_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).enterStmt_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).exitStmt_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BccLanguageVisitor ) return ((BccLanguageVisitor<? extends T>)visitor).visitStmt_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stmt_blockContext stmt_block() throws RecognitionException {
		Stmt_blockContext _localctx = new Stmt_blockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stmt_block);
		int _la;
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(T__5);
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(62);
					stmt();
					}
					}
					setState(65); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << INPUT) | (1L << WHEN) | (1L << IF) | (1L << UNLESS) | (1L << WHILE) | (1L << REPEAT) | (1L << RETURN) | (1L << UNTIL) | (1L << LOOP) | (1L << DO) | (1L << FOR) | (1L << NEXT) | (1L << BREAK) | (1L << SUBS) | (1L << ADD) | (1L << ID))) != 0) );
				setState(67);
				match(T__6);
				}
				break;
			case PRINT:
			case INPUT:
			case WHEN:
			case IF:
			case UNLESS:
			case WHILE:
			case REPEAT:
			case RETURN:
			case UNTIL:
			case LOOP:
			case DO:
			case FOR:
			case NEXT:
			case BREAK:
			case SUBS:
			case ADD:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				stmt();
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

	public static class StmtContext extends ParserRuleContext {
		public Token ALONEWHILE;
		public Token ALONEUNTIL;
		public Token DOWHILE;
		public Token DOUNTIL;
		public Token RIGHT_INC;
		public Token RIGHT_DEC;
		public Token LEFT_INC;
		public Token LEFT_DEC;
		public TerminalNode PRINT() { return getToken(BccLanguageParser.PRINT, 0); }
		public List<LexprContext> lexpr() {
			return getRuleContexts(LexprContext.class);
		}
		public LexprContext lexpr(int i) {
			return getRuleContext(LexprContext.class,i);
		}
		public TerminalNode INPUT() { return getToken(BccLanguageParser.INPUT, 0); }
		public TerminalNode ID() { return getToken(BccLanguageParser.ID, 0); }
		public TerminalNode WHEN() { return getToken(BccLanguageParser.WHEN, 0); }
		public TerminalNode DO() { return getToken(BccLanguageParser.DO, 0); }
		public List<Stmt_blockContext> stmt_block() {
			return getRuleContexts(Stmt_blockContext.class);
		}
		public Stmt_blockContext stmt_block(int i) {
			return getRuleContext(Stmt_blockContext.class,i);
		}
		public TerminalNode IF() { return getToken(BccLanguageParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(BccLanguageParser.ELSE, 0); }
		public TerminalNode UNLESS() { return getToken(BccLanguageParser.UNLESS, 0); }
		public TerminalNode WHILE() { return getToken(BccLanguageParser.WHILE, 0); }
		public TerminalNode RETURN() { return getToken(BccLanguageParser.RETURN, 0); }
		public TerminalNode UNTIL() { return getToken(BccLanguageParser.UNTIL, 0); }
		public TerminalNode LOOP() { return getToken(BccLanguageParser.LOOP, 0); }
		public TerminalNode REPEAT() { return getToken(BccLanguageParser.REPEAT, 0); }
		public TerminalNode NUM() { return getToken(BccLanguageParser.NUM, 0); }
		public TerminalNode FOR() { return getToken(BccLanguageParser.FOR, 0); }
		public TerminalNode NEXT() { return getToken(BccLanguageParser.NEXT, 0); }
		public TerminalNode BREAK() { return getToken(BccLanguageParser.BREAK, 0); }
		public TerminalNode ASSIGNOP() { return getToken(BccLanguageParser.ASSIGNOP, 0); }
		public TerminalNode ADD() { return getToken(BccLanguageParser.ADD, 0); }
		public TerminalNode SUBS() { return getToken(BccLanguageParser.SUBS, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BccLanguageVisitor ) return ((BccLanguageVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stmt);
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(PRINT);
				setState(73);
				lexpr();
				setState(74);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(INPUT);
				setState(77);
				match(ID);
				setState(78);
				match(T__4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(WHEN);
				setState(80);
				match(T__2);
				setState(81);
				lexpr();
				setState(82);
				match(T__3);
				setState(83);
				match(DO);
				setState(84);
				stmt_block();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				match(IF);
				setState(87);
				match(T__2);
				setState(88);
				lexpr();
				setState(89);
				match(T__3);
				setState(90);
				match(DO);
				setState(91);
				stmt_block();
				setState(92);
				match(ELSE);
				setState(93);
				stmt_block();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(95);
				match(UNLESS);
				setState(96);
				match(T__2);
				setState(97);
				lexpr();
				setState(98);
				match(T__3);
				setState(99);
				match(DO);
				setState(100);
				stmt_block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(102);
				((StmtContext)_localctx).ALONEWHILE = match(WHILE);
				setState(103);
				match(T__2);
				setState(104);
				lexpr();
				setState(105);
				match(T__3);
				setState(106);
				match(DO);
				setState(107);
				stmt_block();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(109);
				match(RETURN);
				setState(110);
				lexpr();
				setState(111);
				match(T__4);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(113);
				((StmtContext)_localctx).ALONEUNTIL = match(UNTIL);
				setState(114);
				match(T__2);
				setState(115);
				lexpr();
				setState(116);
				match(T__3);
				setState(117);
				match(DO);
				setState(118);
				stmt_block();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(120);
				match(LOOP);
				setState(121);
				stmt_block();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(122);
				match(DO);
				setState(123);
				stmt_block();
				setState(124);
				((StmtContext)_localctx).DOWHILE = match(WHILE);
				setState(125);
				match(T__2);
				setState(126);
				lexpr();
				setState(127);
				match(T__3);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(129);
				match(DO);
				setState(130);
				stmt_block();
				setState(131);
				((StmtContext)_localctx).DOUNTIL = match(UNTIL);
				setState(132);
				match(T__2);
				setState(133);
				lexpr();
				setState(134);
				match(T__3);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(136);
				match(REPEAT);
				setState(137);
				match(NUM);
				setState(138);
				match(T__0);
				setState(139);
				stmt_block();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(140);
				match(FOR);
				setState(141);
				match(T__2);
				setState(142);
				lexpr();
				setState(143);
				match(T__4);
				setState(144);
				lexpr();
				setState(145);
				match(T__4);
				setState(146);
				lexpr();
				setState(147);
				match(T__3);
				setState(148);
				match(DO);
				setState(149);
				stmt_block();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(151);
				match(NEXT);
				setState(152);
				match(T__4);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(153);
				match(BREAK);
				setState(154);
				match(T__4);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(155);
				match(ID);
				setState(156);
				match(ASSIGNOP);
				setState(157);
				lexpr();
				setState(158);
				match(T__4);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(160);
				match(ID);
				setState(163);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ADD:
					{
					setState(161);
					((StmtContext)_localctx).RIGHT_INC = match(ADD);
					}
					break;
				case SUBS:
					{
					setState(162);
					((StmtContext)_localctx).RIGHT_DEC = match(SUBS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(165);
				match(T__4);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(168);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ADD:
					{
					setState(166);
					((StmtContext)_localctx).LEFT_INC = match(ADD);
					}
					break;
				case SUBS:
					{
					setState(167);
					((StmtContext)_localctx).LEFT_DEC = match(SUBS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(170);
				match(ID);
				setState(171);
				match(T__4);
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

	public static class LexprContext extends ParserRuleContext {
		public List<NexprContext> nexpr() {
			return getRuleContexts(NexprContext.class);
		}
		public NexprContext nexpr(int i) {
			return getRuleContext(NexprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(BccLanguageParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(BccLanguageParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(BccLanguageParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(BccLanguageParser.OR, i);
		}
		public LexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).enterLexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).exitLexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BccLanguageVisitor ) return ((BccLanguageVisitor<? extends T>)visitor).visitLexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LexprContext lexpr() throws RecognitionException {
		LexprContext _localctx = new LexprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_lexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			nexpr();
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND) {
					{
					{
					setState(175);
					match(AND);
					setState(176);
					nexpr();
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OR) {
					{
					{
					setState(182);
					match(OR);
					setState(183);
					nexpr();
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
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

	public static class NexprContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(BccLanguageParser.NOT, 0); }
		public LexprContext lexpr() {
			return getRuleContext(LexprContext.class,0);
		}
		public RexprContext rexpr() {
			return getRuleContext(RexprContext.class,0);
		}
		public NexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).enterNexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).exitNexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BccLanguageVisitor ) return ((BccLanguageVisitor<? extends T>)visitor).visitNexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NexprContext nexpr() throws RecognitionException {
		NexprContext _localctx = new NexprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_nexpr);
		try {
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(NOT);
				setState(192);
				match(T__2);
				setState(193);
				lexpr();
				setState(194);
				match(T__3);
				}
				break;
			case T__2:
			case BOOL:
			case SUBS:
			case ADD:
			case NUM:
			case FID:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				rexpr();
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

	public static class RexprContext extends ParserRuleContext {
		public List<Simple_exprContext> simple_expr() {
			return getRuleContexts(Simple_exprContext.class);
		}
		public Simple_exprContext simple_expr(int i) {
			return getRuleContext(Simple_exprContext.class,i);
		}
		public TerminalNode COMPARISONOP() { return getToken(BccLanguageParser.COMPARISONOP, 0); }
		public RexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).enterRexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).exitRexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BccLanguageVisitor ) return ((BccLanguageVisitor<? extends T>)visitor).visitRexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RexprContext rexpr() throws RecognitionException {
		RexprContext _localctx = new RexprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_rexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			simple_expr();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMPARISONOP) {
				{
				setState(200);
				match(COMPARISONOP);
				setState(201);
				simple_expr();
				}
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

	public static class Simple_exprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> SUMOP() { return getTokens(BccLanguageParser.SUMOP); }
		public TerminalNode SUMOP(int i) {
			return getToken(BccLanguageParser.SUMOP, i);
		}
		public Simple_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).enterSimple_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).exitSimple_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BccLanguageVisitor ) return ((BccLanguageVisitor<? extends T>)visitor).visitSimple_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_exprContext simple_expr() throws RecognitionException {
		Simple_exprContext _localctx = new Simple_exprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_simple_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			term();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SUMOP) {
				{
				{
				setState(205);
				match(SUMOP);
				setState(206);
				term();
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MULOP() { return getTokens(BccLanguageParser.MULOP); }
		public TerminalNode MULOP(int i) {
			return getToken(BccLanguageParser.MULOP, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BccLanguageVisitor ) return ((BccLanguageVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			factor();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULOP) {
				{
				{
				setState(213);
				match(MULOP);
				setState(214);
				factor();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FactorContext extends ParserRuleContext {
		public Token RIGHT_INC;
		public Token RIGHT_DEC;
		public Token LEFT_INC;
		public Token LEFT_DEC;
		public LexprContext ALONE_EXPR;
		public TerminalNode NUM() { return getToken(BccLanguageParser.NUM, 0); }
		public TerminalNode BOOL() { return getToken(BccLanguageParser.BOOL, 0); }
		public TerminalNode ID() { return getToken(BccLanguageParser.ID, 0); }
		public TerminalNode ADD() { return getToken(BccLanguageParser.ADD, 0); }
		public TerminalNode SUBS() { return getToken(BccLanguageParser.SUBS, 0); }
		public List<LexprContext> lexpr() {
			return getRuleContexts(LexprContext.class);
		}
		public LexprContext lexpr(int i) {
			return getRuleContext(LexprContext.class,i);
		}
		public TerminalNode FID() { return getToken(BccLanguageParser.FID, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BccLanguageVisitor ) return ((BccLanguageVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_factor);
		int _la;
		try {
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				match(NUM);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				match(BOOL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(222);
				match(ID);
				setState(225);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ADD:
					{
					setState(223);
					((FactorContext)_localctx).RIGHT_INC = match(ADD);
					}
					break;
				case SUBS:
					{
					setState(224);
					((FactorContext)_localctx).RIGHT_DEC = match(SUBS);
					}
					break;
				case T__1:
				case T__3:
				case T__4:
				case MULOP:
				case SUMOP:
				case COMPARISONOP:
				case AND:
				case OR:
					break;
				default:
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(229);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ADD:
					{
					setState(227);
					((FactorContext)_localctx).LEFT_INC = match(ADD);
					}
					break;
				case SUBS:
					{
					setState(228);
					((FactorContext)_localctx).LEFT_DEC = match(SUBS);
					}
					break;
				case ID:
					break;
				default:
					break;
				}
				setState(231);
				match(ID);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(232);
				match(ID);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(233);
				match(T__2);
				setState(234);
				((FactorContext)_localctx).ALONE_EXPR = lexpr();
				setState(235);
				match(T__3);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(237);
				match(FID);
				setState(238);
				match(T__2);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << NOT) | (1L << BOOL) | (1L << SUBS) | (1L << ADD) | (1L << NUM) | (1L << FID) | (1L << ID))) != 0)) {
					{
					setState(239);
					lexpr();
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(240);
						match(T__1);
						setState(241);
						lexpr();
						}
						}
						setState(246);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(249);
				match(T__3);
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

	public static class Main_progContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(BccLanguageParser.END, 0); }
		public TerminalNode VAR() { return getToken(BccLanguageParser.VAR, 0); }
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Main_progContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).enterMain_prog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BccLanguageListener ) ((BccLanguageListener)listener).exitMain_prog(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BccLanguageVisitor ) return ((BccLanguageVisitor<? extends T>)visitor).visitMain_prog(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Main_progContext main_prog() throws RecognitionException {
		Main_progContext _localctx = new Main_progContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_main_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(252);
				match(VAR);
				setState(253);
				var_decl();
				setState(254);
				match(T__4);
				}
			}

			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << INPUT) | (1L << WHEN) | (1L << IF) | (1L << UNLESS) | (1L << WHILE) | (1L << REPEAT) | (1L << RETURN) | (1L << UNTIL) | (1L << LOOP) | (1L << DO) | (1L << FOR) | (1L << NEXT) | (1L << BREAK) | (1L << SUBS) | (1L << ADD) | (1L << ID))) != 0)) {
				{
				{
				setState(258);
				stmt();
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(264);
			match(END);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u010d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"\65\n\4\3\4\3\4\3\4\3\4\3\4\5\4<\n\4\3\4\3\4\3\5\3\5\6\5B\n\5\r\5\16\5"+
		"C\3\5\3\5\3\5\5\5I\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00a6\n\6\3\6\3\6\3\6\5\6\u00ab"+
		"\n\6\3\6\3\6\5\6\u00af\n\6\3\7\3\7\3\7\7\7\u00b4\n\7\f\7\16\7\u00b7\13"+
		"\7\3\7\3\7\7\7\u00bb\n\7\f\7\16\7\u00be\13\7\5\7\u00c0\n\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u00c8\n\b\3\t\3\t\3\t\5\t\u00cd\n\t\3\n\3\n\3\n\7\n\u00d2"+
		"\n\n\f\n\16\n\u00d5\13\n\3\13\3\13\3\13\7\13\u00da\n\13\f\13\16\13\u00dd"+
		"\13\13\3\f\3\f\3\f\3\f\3\f\5\f\u00e4\n\f\3\f\3\f\5\f\u00e8\n\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00f5\n\f\f\f\16\f\u00f8\13\f"+
		"\5\f\u00fa\n\f\3\f\5\f\u00fd\n\f\3\r\3\r\3\r\3\r\5\r\u0103\n\r\3\r\7\r"+
		"\u0106\n\r\f\r\16\r\u0109\13\r\3\r\3\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\2\2\2\u012e\2\35\3\2\2\2\4\"\3\2\2\2\6.\3\2\2\2\bH\3\2\2\2\n"+
		"\u00ae\3\2\2\2\f\u00b0\3\2\2\2\16\u00c7\3\2\2\2\20\u00c9\3\2\2\2\22\u00ce"+
		"\3\2\2\2\24\u00d6\3\2\2\2\26\u00fc\3\2\2\2\30\u0102\3\2\2\2\32\34\5\6"+
		"\4\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36 \3\2\2"+
		"\2\37\35\3\2\2\2 !\5\30\r\2!\3\3\2\2\2\"#\7)\2\2#$\7\3\2\2$+\7\16\2\2"+
		"%&\7\4\2\2&\'\7)\2\2\'(\7\3\2\2(*\7\16\2\2)%\3\2\2\2*-\3\2\2\2+)\3\2\2"+
		"\2+,\3\2\2\2,\5\3\2\2\2-+\3\2\2\2./\7\17\2\2/\60\7(\2\2\60\61\7\3\2\2"+
		"\61\62\7\16\2\2\62\64\7\5\2\2\63\65\5\4\3\2\64\63\3\2\2\2\64\65\3\2\2"+
		"\2\65\66\3\2\2\2\66;\7\6\2\2\678\7\20\2\289\5\4\3\29:\7\7\2\2:<\3\2\2"+
		"\2;\67\3\2\2\2;<\3\2\2\2<=\3\2\2\2=>\5\b\5\2>\7\3\2\2\2?A\7\b\2\2@B\5"+
		"\n\6\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\7\t\2\2FI\3"+
		"\2\2\2GI\5\n\6\2H?\3\2\2\2HG\3\2\2\2I\t\3\2\2\2JK\7\21\2\2KL\5\f\7\2L"+
		"M\7\7\2\2M\u00af\3\2\2\2NO\7\22\2\2OP\7)\2\2P\u00af\7\7\2\2QR\7\23\2\2"+
		"RS\7\5\2\2ST\5\f\7\2TU\7\6\2\2UV\7\33\2\2VW\5\b\5\2W\u00af\3\2\2\2XY\7"+
		"\24\2\2YZ\7\5\2\2Z[\5\f\7\2[\\\7\6\2\2\\]\7\33\2\2]^\5\b\5\2^_\7\34\2"+
		"\2_`\5\b\5\2`\u00af\3\2\2\2ab\7\25\2\2bc\7\5\2\2cd\5\f\7\2de\7\6\2\2e"+
		"f\7\33\2\2fg\5\b\5\2g\u00af\3\2\2\2hi\7\26\2\2ij\7\5\2\2jk\5\f\7\2kl\7"+
		"\6\2\2lm\7\33\2\2mn\5\b\5\2n\u00af\3\2\2\2op\7\30\2\2pq\5\f\7\2qr\7\7"+
		"\2\2r\u00af\3\2\2\2st\7\31\2\2tu\7\5\2\2uv\5\f\7\2vw\7\6\2\2wx\7\33\2"+
		"\2xy\5\b\5\2y\u00af\3\2\2\2z{\7\32\2\2{\u00af\5\b\5\2|}\7\33\2\2}~\5\b"+
		"\5\2~\177\7\26\2\2\177\u0080\7\5\2\2\u0080\u0081\5\f\7\2\u0081\u0082\7"+
		"\6\2\2\u0082\u00af\3\2\2\2\u0083\u0084\7\33\2\2\u0084\u0085\5\b\5\2\u0085"+
		"\u0086\7\31\2\2\u0086\u0087\7\5\2\2\u0087\u0088\5\f\7\2\u0088\u0089\7"+
		"\6\2\2\u0089\u00af\3\2\2\2\u008a\u008b\7\27\2\2\u008b\u008c\7\'\2\2\u008c"+
		"\u008d\7\3\2\2\u008d\u00af\5\b\5\2\u008e\u008f\7\37\2\2\u008f\u0090\7"+
		"\5\2\2\u0090\u0091\5\f\7\2\u0091\u0092\7\7\2\2\u0092\u0093\5\f\7\2\u0093"+
		"\u0094\7\7\2\2\u0094\u0095\5\f\7\2\u0095\u0096\7\6\2\2\u0096\u0097\7\33"+
		"\2\2\u0097\u0098\5\b\5\2\u0098\u00af\3\2\2\2\u0099\u009a\7 \2\2\u009a"+
		"\u00af\7\7\2\2\u009b\u009c\7!\2\2\u009c\u00af\7\7\2\2\u009d\u009e\7)\2"+
		"\2\u009e\u009f\7\r\2\2\u009f\u00a0\5\f\7\2\u00a0\u00a1\7\7\2\2\u00a1\u00af"+
		"\3\2\2\2\u00a2\u00a5\7)\2\2\u00a3\u00a6\7%\2\2\u00a4\u00a6\7$\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00af\7\7"+
		"\2\2\u00a8\u00ab\7%\2\2\u00a9\u00ab\7$\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9"+
		"\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\7)\2\2\u00ad\u00af\7\7\2\2\u00ae"+
		"J\3\2\2\2\u00aeN\3\2\2\2\u00aeQ\3\2\2\2\u00aeX\3\2\2\2\u00aea\3\2\2\2"+
		"\u00aeh\3\2\2\2\u00aeo\3\2\2\2\u00aes\3\2\2\2\u00aez\3\2\2\2\u00ae|\3"+
		"\2\2\2\u00ae\u0083\3\2\2\2\u00ae\u008a\3\2\2\2\u00ae\u008e\3\2\2\2\u00ae"+
		"\u0099\3\2\2\2\u00ae\u009b\3\2\2\2\u00ae\u009d\3\2\2\2\u00ae\u00a2\3\2"+
		"\2\2\u00ae\u00aa\3\2\2\2\u00af\13\3\2\2\2\u00b0\u00bf\5\16\b\2\u00b1\u00b2"+
		"\7\35\2\2\u00b2\u00b4\5\16\b\2\u00b3\u00b1\3\2\2\2\u00b4\u00b7\3\2\2\2"+
		"\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00c0\3\2\2\2\u00b7\u00b5"+
		"\3\2\2\2\u00b8\u00b9\7\36\2\2\u00b9\u00bb\5\16\b\2\u00ba\u00b8\3\2\2\2"+
		"\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c0"+
		"\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00b5\3\2\2\2\u00bf\u00bc\3\2\2\2\u00c0"+
		"\r\3\2\2\2\u00c1\u00c2\7\"\2\2\u00c2\u00c3\7\5\2\2\u00c3\u00c4\5\f\7\2"+
		"\u00c4\u00c5\7\6\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c8\5\20\t\2\u00c7\u00c1"+
		"\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\17\3\2\2\2\u00c9\u00cc\5\22\n\2\u00ca"+
		"\u00cb\7\f\2\2\u00cb\u00cd\5\22\n\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3"+
		"\2\2\2\u00cd\21\3\2\2\2\u00ce\u00d3\5\24\13\2\u00cf\u00d0\7\13\2\2\u00d0"+
		"\u00d2\5\24\13\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3"+
		"\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\23\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6"+
		"\u00db\5\26\f\2\u00d7\u00d8\7\n\2\2\u00d8\u00da\5\26\f\2\u00d9\u00d7\3"+
		"\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\25\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00fd\7\'\2\2\u00df\u00fd\7#\2\2"+
		"\u00e0\u00e3\7)\2\2\u00e1\u00e4\7%\2\2\u00e2\u00e4\7$\2\2\u00e3\u00e1"+
		"\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00fd\3\2\2\2\u00e5"+
		"\u00e8\7%\2\2\u00e6\u00e8\7$\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3\2\2"+
		"\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00fd\7)\2\2\u00ea\u00fd"+
		"\7)\2\2\u00eb\u00ec\7\5\2\2\u00ec\u00ed\5\f\7\2\u00ed\u00ee\7\6\2\2\u00ee"+
		"\u00fd\3\2\2\2\u00ef\u00f0\7(\2\2\u00f0\u00f9\7\5\2\2\u00f1\u00f6\5\f"+
		"\7\2\u00f2\u00f3\7\4\2\2\u00f3\u00f5\5\f\7\2\u00f4\u00f2\3\2\2\2\u00f5"+
		"\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00fa\3\2"+
		"\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00f1\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\u00fd\7\6\2\2\u00fc\u00de\3\2\2\2\u00fc\u00df\3\2"+
		"\2\2\u00fc\u00e0\3\2\2\2\u00fc\u00e7\3\2\2\2\u00fc\u00ea\3\2\2\2\u00fc"+
		"\u00eb\3\2\2\2\u00fc\u00ef\3\2\2\2\u00fd\27\3\2\2\2\u00fe\u00ff\7\20\2"+
		"\2\u00ff\u0100\5\4\3\2\u0100\u0101\7\7\2\2\u0101\u0103\3\2\2\2\u0102\u00fe"+
		"\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0107\3\2\2\2\u0104\u0106\5\n\6\2\u0105"+
		"\u0104\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2"+
		"\2\2\u0108\u010a\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010b\7&\2\2\u010b"+
		"\31\3\2\2\2\31\35+\64;CH\u00a5\u00aa\u00ae\u00b5\u00bc\u00bf\u00c7\u00cc"+
		"\u00d3\u00db\u00e3\u00e7\u00f6\u00f9\u00fc\u0102\u0107";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}