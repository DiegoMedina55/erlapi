// Generated from C:/Users/gabri/Desktop/final_lenguajes/erlapi/src/main/java/com/myerlang/erlapi/grammar\Erlang.g4 by ANTLR 4.8
package com.myerlang.erlapi.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ErlangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, TokAtom=64, TokVar=65, TokFloat=66, 
		TokInteger=67, TokChar=68, TokString=69, AttrName=70, Comment=71, WS=72;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
			"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
			"T__57", "T__58", "T__59", "T__60", "T__61", "T__62", "TokAtom", "TokVar", 
			"TokFloat", "TokInteger", "TokChar", "TokString", "AttrName", "Comment", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'-'", "'('", "')'", "':'", "'/'", "'::'", "','", "'{'", 
			"'}'", "';'", "'when'", "'|'", "'..'", "'['", "']'", "'...'", "'#'", 
			"'fun'", "'->'", "'<<'", "'>>'", "'*'", "'catch'", "'='", "'!'", "'orelse'", 
			"'andalso'", "'begin'", "'end'", "'||'", "'<-'", "'<='", "'if'", "'case'", 
			"'of'", "'receive'", "'after'", "'try'", "'+'", "'bnot'", "'not'", "'div'", 
			"'rem'", "'band'", "'and'", "'bor'", "'bxor'", "'bsl'", "'bsr'", "'or'", 
			"'xor'", "'++'", "'--'", "'=='", "'/='", "'=<'", "'<'", "'>='", "'>'", 
			"'=:='", "'=/='", "':-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "TokAtom", "TokVar", "TokFloat", "TokInteger", 
			"TokChar", "TokString", "AttrName", "Comment", "WS"
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


	public ErlangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Erlang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2J\u01ee\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3"+
		"$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3"+
		"(\3(\3(\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3.\3"+
		".\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3"+
		"\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3"+
		"\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\39\3:\3:\3:\3;\3;\3<"+
		"\3<\3<\3=\3=\3>\3>\3>\3>\3?\3?\3?\3?\3@\3@\3@\3A\3A\7A\u016e\nA\fA\16"+
		"A\u0171\13A\3A\3A\3A\3A\5A\u0177\nA\3A\7A\u017a\nA\fA\16A\u017d\13A\3"+
		"A\5A\u0180\nA\3B\3B\7B\u0184\nB\fB\16B\u0187\13B\3C\5C\u018a\nC\3C\6C"+
		"\u018d\nC\rC\16C\u018e\3C\3C\6C\u0193\nC\rC\16C\u0194\3C\3C\5C\u0199\n"+
		"C\3C\6C\u019c\nC\rC\16C\u019d\5C\u01a0\nC\3D\5D\u01a3\nD\3D\6D\u01a6\n"+
		"D\rD\16D\u01a7\3D\3D\6D\u01ac\nD\rD\16D\u01ad\5D\u01b0\nD\3E\3E\5E\u01b4"+
		"\nE\3E\3E\3E\3E\3E\5E\u01bb\nE\3F\3F\3F\3F\5F\u01c1\nF\3F\7F\u01c4\nF"+
		"\fF\16F\u01c7\13F\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\5G\u01d8"+
		"\nG\3H\3H\7H\u01dc\nH\fH\16H\u01df\13H\3H\5H\u01e2\nH\3H\3H\3H\3H\3I\6"+
		"I\u01e9\nI\rI\16I\u01ea\3I\3I\2\2J\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083"+
		"C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\3\2\17\4\2BBc|\6\2"+
		"\62;B\\aac|\3\2^^\4\2))^^\4\2C\\aa\6\2\62;C\\aac|\3\2\62;\4\2GGgg\4\2"+
		"--//\5\2\62;C\\c|\4\2\f\f\17\17\4\2$$^^\5\2\13\f\17\17\"\"\2\u0206\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2"+
		"o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3"+
		"\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\3\u0093\3\2\2\2\5\u0095\3\2\2\2\7\u0097"+
		"\3\2\2\2\t\u0099\3\2\2\2\13\u009b\3\2\2\2\r\u009d\3\2\2\2\17\u009f\3\2"+
		"\2\2\21\u00a2\3\2\2\2\23\u00a4\3\2\2\2\25\u00a6\3\2\2\2\27\u00a8\3\2\2"+
		"\2\31\u00aa\3\2\2\2\33\u00af\3\2\2\2\35\u00b1\3\2\2\2\37\u00b4\3\2\2\2"+
		"!\u00b6\3\2\2\2#\u00b8\3\2\2\2%\u00bc\3\2\2\2\'\u00be\3\2\2\2)\u00c2\3"+
		"\2\2\2+\u00c5\3\2\2\2-\u00c8\3\2\2\2/\u00cb\3\2\2\2\61\u00cd\3\2\2\2\63"+
		"\u00d3\3\2\2\2\65\u00d5\3\2\2\2\67\u00d7\3\2\2\29\u00de\3\2\2\2;\u00e6"+
		"\3\2\2\2=\u00ec\3\2\2\2?\u00f0\3\2\2\2A\u00f3\3\2\2\2C\u00f6\3\2\2\2E"+
		"\u00f9\3\2\2\2G\u00fc\3\2\2\2I\u0101\3\2\2\2K\u0104\3\2\2\2M\u010c\3\2"+
		"\2\2O\u0112\3\2\2\2Q\u0116\3\2\2\2S\u0118\3\2\2\2U\u011d\3\2\2\2W\u0121"+
		"\3\2\2\2Y\u0125\3\2\2\2[\u0129\3\2\2\2]\u012e\3\2\2\2_\u0132\3\2\2\2a"+
		"\u0136\3\2\2\2c\u013b\3\2\2\2e\u013f\3\2\2\2g\u0143\3\2\2\2i\u0146\3\2"+
		"\2\2k\u014a\3\2\2\2m\u014d\3\2\2\2o\u0150\3\2\2\2q\u0153\3\2\2\2s\u0156"+
		"\3\2\2\2u\u0159\3\2\2\2w\u015b\3\2\2\2y\u015e\3\2\2\2{\u0160\3\2\2\2}"+
		"\u0164\3\2\2\2\177\u0168\3\2\2\2\u0081\u017f\3\2\2\2\u0083\u0181\3\2\2"+
		"\2\u0085\u0189\3\2\2\2\u0087\u01a2\3\2\2\2\u0089\u01b1\3\2\2\2\u008b\u01bc"+
		"\3\2\2\2\u008d\u01ca\3\2\2\2\u008f\u01d9\3\2\2\2\u0091\u01e8\3\2\2\2\u0093"+
		"\u0094\7\60\2\2\u0094\4\3\2\2\2\u0095\u0096\7/\2\2\u0096\6\3\2\2\2\u0097"+
		"\u0098\7*\2\2\u0098\b\3\2\2\2\u0099\u009a\7+\2\2\u009a\n\3\2\2\2\u009b"+
		"\u009c\7<\2\2\u009c\f\3\2\2\2\u009d\u009e\7\61\2\2\u009e\16\3\2\2\2\u009f"+
		"\u00a0\7<\2\2\u00a0\u00a1\7<\2\2\u00a1\20\3\2\2\2\u00a2\u00a3\7.\2\2\u00a3"+
		"\22\3\2\2\2\u00a4\u00a5\7}\2\2\u00a5\24\3\2\2\2\u00a6\u00a7\7\177\2\2"+
		"\u00a7\26\3\2\2\2\u00a8\u00a9\7=\2\2\u00a9\30\3\2\2\2\u00aa\u00ab\7y\2"+
		"\2\u00ab\u00ac\7j\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7p\2\2\u00ae\32\3"+
		"\2\2\2\u00af\u00b0\7~\2\2\u00b0\34\3\2\2\2\u00b1\u00b2\7\60\2\2\u00b2"+
		"\u00b3\7\60\2\2\u00b3\36\3\2\2\2\u00b4\u00b5\7]\2\2\u00b5 \3\2\2\2\u00b6"+
		"\u00b7\7_\2\2\u00b7\"\3\2\2\2\u00b8\u00b9\7\60\2\2\u00b9\u00ba\7\60\2"+
		"\2\u00ba\u00bb\7\60\2\2\u00bb$\3\2\2\2\u00bc\u00bd\7%\2\2\u00bd&\3\2\2"+
		"\2\u00be\u00bf\7h\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7p\2\2\u00c1(\3\2"+
		"\2\2\u00c2\u00c3\7/\2\2\u00c3\u00c4\7@\2\2\u00c4*\3\2\2\2\u00c5\u00c6"+
		"\7>\2\2\u00c6\u00c7\7>\2\2\u00c7,\3\2\2\2\u00c8\u00c9\7@\2\2\u00c9\u00ca"+
		"\7@\2\2\u00ca.\3\2\2\2\u00cb\u00cc\7,\2\2\u00cc\60\3\2\2\2\u00cd\u00ce"+
		"\7e\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7e\2\2\u00d1"+
		"\u00d2\7j\2\2\u00d2\62\3\2\2\2\u00d3\u00d4\7?\2\2\u00d4\64\3\2\2\2\u00d5"+
		"\u00d6\7#\2\2\u00d6\66\3\2\2\2\u00d7\u00d8\7q\2\2\u00d8\u00d9\7t\2\2\u00d9"+
		"\u00da\7g\2\2\u00da\u00db\7n\2\2\u00db\u00dc\7u\2\2\u00dc\u00dd\7g\2\2"+
		"\u00dd8\3\2\2\2\u00de\u00df\7c\2\2\u00df\u00e0\7p\2\2\u00e0\u00e1\7f\2"+
		"\2\u00e1\u00e2\7c\2\2\u00e2\u00e3\7n\2\2\u00e3\u00e4\7u\2\2\u00e4\u00e5"+
		"\7q\2\2\u00e5:\3\2\2\2\u00e6\u00e7\7d\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9"+
		"\7i\2\2\u00e9\u00ea\7k\2\2\u00ea\u00eb\7p\2\2\u00eb<\3\2\2\2\u00ec\u00ed"+
		"\7g\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef\7f\2\2\u00ef>\3\2\2\2\u00f0\u00f1"+
		"\7~\2\2\u00f1\u00f2\7~\2\2\u00f2@\3\2\2\2\u00f3\u00f4\7>\2\2\u00f4\u00f5"+
		"\7/\2\2\u00f5B\3\2\2\2\u00f6\u00f7\7>\2\2\u00f7\u00f8\7?\2\2\u00f8D\3"+
		"\2\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7h\2\2\u00fbF\3\2\2\2\u00fc\u00fd"+
		"\7e\2\2\u00fd\u00fe\7c\2\2\u00fe\u00ff\7u\2\2\u00ff\u0100\7g\2\2\u0100"+
		"H\3\2\2\2\u0101\u0102\7q\2\2\u0102\u0103\7h\2\2\u0103J\3\2\2\2\u0104\u0105"+
		"\7t\2\2\u0105\u0106\7g\2\2\u0106\u0107\7e\2\2\u0107\u0108\7g\2\2\u0108"+
		"\u0109\7k\2\2\u0109\u010a\7x\2\2\u010a\u010b\7g\2\2\u010bL\3\2\2\2\u010c"+
		"\u010d\7c\2\2\u010d\u010e\7h\2\2\u010e\u010f\7v\2\2\u010f\u0110\7g\2\2"+
		"\u0110\u0111\7t\2\2\u0111N\3\2\2\2\u0112\u0113\7v\2\2\u0113\u0114\7t\2"+
		"\2\u0114\u0115\7{\2\2\u0115P\3\2\2\2\u0116\u0117\7-\2\2\u0117R\3\2\2\2"+
		"\u0118\u0119\7d\2\2\u0119\u011a\7p\2\2\u011a\u011b\7q\2\2\u011b\u011c"+
		"\7v\2\2\u011cT\3\2\2\2\u011d\u011e\7p\2\2\u011e\u011f\7q\2\2\u011f\u0120"+
		"\7v\2\2\u0120V\3\2\2\2\u0121\u0122\7f\2\2\u0122\u0123\7k\2\2\u0123\u0124"+
		"\7x\2\2\u0124X\3\2\2\2\u0125\u0126\7t\2\2\u0126\u0127\7g\2\2\u0127\u0128"+
		"\7o\2\2\u0128Z\3\2\2\2\u0129\u012a\7d\2\2\u012a\u012b\7c\2\2\u012b\u012c"+
		"\7p\2\2\u012c\u012d\7f\2\2\u012d\\\3\2\2\2\u012e\u012f\7c\2\2\u012f\u0130"+
		"\7p\2\2\u0130\u0131\7f\2\2\u0131^\3\2\2\2\u0132\u0133\7d\2\2\u0133\u0134"+
		"\7q\2\2\u0134\u0135\7t\2\2\u0135`\3\2\2\2\u0136\u0137\7d\2\2\u0137\u0138"+
		"\7z\2\2\u0138\u0139\7q\2\2\u0139\u013a\7t\2\2\u013ab\3\2\2\2\u013b\u013c"+
		"\7d\2\2\u013c\u013d\7u\2\2\u013d\u013e\7n\2\2\u013ed\3\2\2\2\u013f\u0140"+
		"\7d\2\2\u0140\u0141\7u\2\2\u0141\u0142\7t\2\2\u0142f\3\2\2\2\u0143\u0144"+
		"\7q\2\2\u0144\u0145\7t\2\2\u0145h\3\2\2\2\u0146\u0147\7z\2\2\u0147\u0148"+
		"\7q\2\2\u0148\u0149\7t\2\2\u0149j\3\2\2\2\u014a\u014b\7-\2\2\u014b\u014c"+
		"\7-\2\2\u014cl\3\2\2\2\u014d\u014e\7/\2\2\u014e\u014f\7/\2\2\u014fn\3"+
		"\2\2\2\u0150\u0151\7?\2\2\u0151\u0152\7?\2\2\u0152p\3\2\2\2\u0153\u0154"+
		"\7\61\2\2\u0154\u0155\7?\2\2\u0155r\3\2\2\2\u0156\u0157\7?\2\2\u0157\u0158"+
		"\7>\2\2\u0158t\3\2\2\2\u0159\u015a\7>\2\2\u015av\3\2\2\2\u015b\u015c\7"+
		"@\2\2\u015c\u015d\7?\2\2\u015dx\3\2\2\2\u015e\u015f\7@\2\2\u015fz\3\2"+
		"\2\2\u0160\u0161\7?\2\2\u0161\u0162\7<\2\2\u0162\u0163\7?\2\2\u0163|\3"+
		"\2\2\2\u0164\u0165\7?\2\2\u0165\u0166\7\61\2\2\u0166\u0167\7?\2\2\u0167"+
		"~\3\2\2\2\u0168\u0169\7<\2\2\u0169\u016a\7/\2\2\u016a\u0080\3\2\2\2\u016b"+
		"\u016f\t\2\2\2\u016c\u016e\t\3\2\2\u016d\u016c\3\2\2\2\u016e\u0171\3\2"+
		"\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0180\3\2\2\2\u0171"+
		"\u016f\3\2\2\2\u0172\u017b\7)\2\2\u0173\u0176\7^\2\2\u0174\u0177\n\4\2"+
		"\2\u0175\u0177\7^\2\2\u0176\u0174\3\2\2\2\u0176\u0175\3\2\2\2\u0177\u017a"+
		"\3\2\2\2\u0178\u017a\n\5\2\2\u0179\u0173\3\2\2\2\u0179\u0178\3\2\2\2\u017a"+
		"\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017e\3\2"+
		"\2\2\u017d\u017b\3\2\2\2\u017e\u0180\7)\2\2\u017f\u016b\3\2\2\2\u017f"+
		"\u0172\3\2\2\2\u0180\u0082\3\2\2\2\u0181\u0185\t\6\2\2\u0182\u0184\t\7"+
		"\2\2\u0183\u0182\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185"+
		"\u0186\3\2\2\2\u0186\u0084\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u018a\7/"+
		"\2\2\u0189\u0188\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018c\3\2\2\2\u018b"+
		"\u018d\t\b\2\2\u018c\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018c\3\2"+
		"\2\2\u018e\u018f\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0192\7\60\2\2\u0191"+
		"\u0193\t\b\2\2\u0192\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0192\3\2"+
		"\2\2\u0194\u0195\3\2\2\2\u0195\u019f\3\2\2\2\u0196\u0198\t\t\2\2\u0197"+
		"\u0199\t\n\2\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019b\3\2"+
		"\2\2\u019a\u019c\t\b\2\2\u019b\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d"+
		"\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a0\3\2\2\2\u019f\u0196\3\2"+
		"\2\2\u019f\u01a0\3\2\2\2\u01a0\u0086\3\2\2\2\u01a1\u01a3\7/\2\2\u01a2"+
		"\u01a1\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a5\3\2\2\2\u01a4\u01a6\t\b"+
		"\2\2\u01a5\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a8\u01af\3\2\2\2\u01a9\u01ab\7%\2\2\u01aa\u01ac\t\13"+
		"\2\2\u01ab\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01b0\3\2\2\2\u01af\u01a9\3\2\2\2\u01af\u01b0\3\2"+
		"\2\2\u01b0\u0088\3\2\2\2\u01b1\u01ba\7&\2\2\u01b2\u01b4\7^\2\2\u01b3\u01b2"+
		"\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01bb\n\f\2\2\u01b6"+
		"\u01b7\7^\2\2\u01b7\u01b8\t\b\2\2\u01b8\u01b9\t\b\2\2\u01b9\u01bb\t\b"+
		"\2\2\u01ba\u01b3\3\2\2\2\u01ba\u01b6\3\2\2\2\u01bb\u008a\3\2\2\2\u01bc"+
		"\u01c5\7$\2\2\u01bd\u01c0\7^\2\2\u01be\u01c1\n\4\2\2\u01bf\u01c1\7^\2"+
		"\2\u01c0\u01be\3\2\2\2\u01c0\u01bf\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2\u01c4"+
		"\n\r\2\2\u01c3\u01bd\3\2\2\2\u01c3\u01c2\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5"+
		"\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c8\3\2\2\2\u01c7\u01c5\3\2"+
		"\2\2\u01c8\u01c9\7$\2\2\u01c9\u008c\3\2\2\2\u01ca\u01d7\7/\2\2\u01cb\u01cc"+
		"\7u\2\2\u01cc\u01cd\7r\2\2\u01cd\u01ce\7g\2\2\u01ce\u01d8\7e\2\2\u01cf"+
		"\u01d0\7e\2\2\u01d0\u01d1\7c\2\2\u01d1\u01d2\7n\2\2\u01d2\u01d3\7n\2\2"+
		"\u01d3\u01d4\7d\2\2\u01d4\u01d5\7c\2\2\u01d5\u01d6\7e\2\2\u01d6\u01d8"+
		"\7m\2\2\u01d7\u01cb\3\2\2\2\u01d7\u01cf\3\2\2\2\u01d8\u008e\3\2\2\2\u01d9"+
		"\u01dd\7\'\2\2\u01da\u01dc\n\f\2\2\u01db\u01da\3\2\2\2\u01dc\u01df\3\2"+
		"\2\2\u01dd\u01db\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01e1\3\2\2\2\u01df"+
		"\u01dd\3\2\2\2\u01e0\u01e2\7\17\2\2\u01e1\u01e0\3\2\2\2\u01e1\u01e2\3"+
		"\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\7\f\2\2\u01e4\u01e5\3\2\2\2\u01e5"+
		"\u01e6\bH\2\2\u01e6\u0090\3\2\2\2\u01e7\u01e9\t\16\2\2\u01e8\u01e7\3\2"+
		"\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb"+
		"\u01ec\3\2\2\2\u01ec\u01ed\bI\2\2\u01ed\u0092\3\2\2\2\34\2\u016f\u0176"+
		"\u0179\u017b\u017f\u0185\u0189\u018e\u0194\u0198\u019d\u019f\u01a2\u01a7"+
		"\u01ad\u01af\u01b3\u01ba\u01c0\u01c3\u01c5\u01d7\u01dd\u01e1\u01ea\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}