// Generated from Ape.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ApeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, Identifier=3, ID=4, INT=5, JSONNAME=6, NEWLINE=7, WS=8;
	public static final int
		RULE_jsonParser = 0;
	public static final String[] ruleNames = {
		"jsonParser"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'(\"'", "'\")'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "Identifier", "ID", "INT", "JSONNAME", "NEWLINE", "WS"
	};
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
	public String getGrammarFileName() { return "Ape.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ApeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class JsonParserContext extends ParserRuleContext {
		public JsonParserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonParser; }
	 
		public JsonParserContext() { }
		public void copyFrom(JsonParserContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MakeParserContext extends JsonParserContext {
		public TerminalNode Identifier() { return getToken(ApeParser.Identifier, 0); }
		public TerminalNode JSONNAME() { return getToken(ApeParser.JSONNAME, 0); }
		public MakeParserContext(JsonParserContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ApeVisitor ) return ((ApeVisitor<? extends T>)visitor).visitMakeParser(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonParserContext jsonParser() throws RecognitionException {
		JsonParserContext _localctx = new JsonParserContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_jsonParser);
		try {
			_localctx = new MakeParserContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(2);
			match(Identifier);
			setState(3);
			match(T__0);
			setState(4);
			match(JSONNAME);
			setState(5);
			match(T__1);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\n\n\4\2\t\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\2\2\3\2\2\2\b\2\4\3\2\2\2\4\5\7\5\2\2\5\6\7\3\2\2\6"+
		"\7\7\b\2\2\7\b\7\4\2\2\b\3\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}