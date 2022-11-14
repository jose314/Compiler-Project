package wci.frontend.python.tokens;

import wci.frontend.Source;
import wci.frontend.python.PythonTokenType;
import wci.frontend.python.PythonToken;

import static wci.frontend.python.PythonTokenType.IDENTIFIER;
import static wci.frontend.python.PythonTokenType.RESERVED_WORDS;

/**
 * <h1>pythonWordToken</h1>
 *
 * <p> python word tokens (identifiers and reserved words).</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class PythonWordToken extends PythonToken
{
    /**
     * Constructor.
     * @param source the source from where to fetch the token's characters.
     * @throws Exception if an error occurred.
     */
    public PythonWordToken(Source source)
        throws Exception
    {
        super(source);
    }

    /**
     * Extract a python word token from the source.
     * @throws Exception if an error occurred.
     */
    protected void extract()
        throws Exception
    {
        StringBuilder textBuffer = new StringBuilder();
        char currentChar = currentChar();

        // Get the word characters (letter or digit).  The scanner has
        // already determined that the first character is a letter.
        while (Character.isLetterOrDigit(currentChar)) {
            textBuffer.append(currentChar);
            currentChar = nextChar();  // consume character
        }

        text = textBuffer.toString();

        // Is it a reserved word or an identifier?
        type = (RESERVED_WORDS.contains(text.toLowerCase()))
               ? PythonTokenType.valueOf(text.toUpperCase())  // reserved word
               : IDENTIFIER;                                  // identifier
    }
}
