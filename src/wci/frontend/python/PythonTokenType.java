package wci.frontend.python;

import wci.frontend.TokenType;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * <h1>PythonTokenType</h1>
 *
 * <p>Python token types.</p>
 */
public enum PythonTokenType implements TokenType
    {
    // Should add the reserved words that are in PascalTokenType.java
    // Reserved words: (https://flexiple.com/python/python-reserved-words/#section1)
    AND ,
    AS ,
    ASSERT ,
    BEGIN ,
    BREAK ,
    CLASS ,
    CONTINUE ,
    DEF ,
    DEL ,
    ELIF ,
    ELSE ,
    EXCEPT ,
    FALSE ,
    FINALLY ,
    FOR ,
    FORM ,
    GLOBAL ,
    IF ,
    IMPORT ,
    IN ,
    IS ,
    LAMBDA ,
    NONE ,
    NONLOCAL ,
    not ,
    or ,
    PASS ,
    PROCEDURE ,
    RAISE ,
    RETURN ,
    TRUE ,
    TRY ,
    WHILE ,
    WITH ,
    YIELD ,

    // Special symbols: (https://www.w3schools.com/python/python_operators.asp)
    ADD("+") ,
    AMPERSAND("&") ,
    SUBTRACT("-") ,
    MULTIPLY("*") ,
    DIVIDE("/") ,
    ADD_EQUAL("+=") ,
    SUBTRACT_EQUAL("-=") ,
    MULTIPLY_EQUAL("*=") ,
    DIVIDE_EQUAL("/=") ,
    MODULUS_EQUAL("%=)") ,
    FLOOR_DIVIDE_EQUAL("//=)") ,
    EXPONENT_EQUAL("**=)") ,
    AND_EQUAL("&=") ,
    OR_EQUAL("|=)") ,
    XOR_EQUAL("^=") ,
    RIGHT_SHIFT_EQUAL(">>=") ,
    LEFT_SHIFT_EQUAL("<<=") ,
    DOT(".") ,
    COMMA(",") ,
    EXCLAMATION_MARK("!") ,
    QUESTION_MARK("?") ,
    HASHTAG("#") ,
    SEMICOLON(";") ,
    COLON(":") ,
    SINGLE_QUOTE("'") ,
    EQUAL("==") ,
    NOT("~") ,
    NOT_EQUAL("!=") ,
    LESS_THAN("<") ,
    LESS_OR_EQUAL("<=") ,
    GREATER_OR_EQUAL(">=") ,
    GREATER_THAN(">") ,
    LEFT_PARENTHESIS("(") ,
    RIGHT_PARENTHESIS(")") ,
    LEFT_BRACKET("[") ,
    RIGHT_BRACKET("]") ,
    LEFT_BRACE("{") ,
    RIGHT_BRACE("}") ,
    XOR("^") ,
    LEFT_SHIFT("<<") ,
    RIGHT_SHIFT(">>") ,
    DOT_DOT(".."),
    MODULUS("%") ,
    EXPONENT("**") ,
    FLOOR_DIVIDE("//") ,
    OR("|") ,

    IDENTIFIER ,
    INTEGER ,
    REAL ,
    STRING ,
    ERROR ,
    END_OF_FILE ;

    private static final int FIRST_RESERVED_INDEX = AND.ordinal();
    private static final int LAST_RESERVED_INDEX  = WITH.ordinal();

    private static final int FIRST_SPECIAL_INDEX = ADD.ordinal();
    private static final int LAST_SPECIAL_INDEX  = DOT_DOT.ordinal();

    private String text;  // token text

    /**
     * Constructor.
     */
    PythonTokenType()
    {
        this.text = this.toString().toLowerCase();
    }

    /**
     * Constructor.
     * @param text the token text.
     */
    PythonTokenType(String text)
    {
        this.text = text;
    }

    /**
     * Getter.
     * @return the token text.
     */
    public String getText()
    {
        return text;
    }

    // Set of lower-cased Python reserved word text strings.
    public static HashSet<String> RESERVED_WORDS = new HashSet<String>();
    static {
        PythonTokenType values[] = PythonTokenType.values();
        for (int i = FIRST_RESERVED_INDEX; i <= LAST_RESERVED_INDEX; ++i) {
            RESERVED_WORDS.add(values[i].getText().toLowerCase());
        }
    }

    // Hash table of Python special symbols.  Each special symbol's text
    // is the key to its Python token type.
    public static Hashtable<String, PythonTokenType> SPECIAL_SYMBOLS =
        new Hashtable<String, PythonTokenType>();
    static {
        PythonTokenType values[] = PythonTokenType.values();
        for (int i = FIRST_SPECIAL_INDEX; i <= LAST_SPECIAL_INDEX; ++i) {
            SPECIAL_SYMBOLS.put(values[i].getText(), values[i]);
        }
    }
}
