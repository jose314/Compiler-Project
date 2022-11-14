package wci.frontend.python;

import wci.frontend.*;
import wci.intermediate.*;
import wci.message.*;

import static wci.frontend.python.PythonTokenType.*;
import static wci.frontend.python.PythonErrorCode.*;
import static wci.intermediate.symtabimpl.SymTabKeyImpl.*;
import static wci.message.MessageType.PARSER_SUMMARY;

/**
 * <h1>PascalParserTD</h1>
 *
 * <p>The top-down Pascal parser.</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class PythonParserTD extends Parser
{
    protected static PythonErrorHandler errorHandler = new PythonErrorHandler();

    /**
     * Constructor.
     * @param scanner the scanner to be used with this parser.
     */
    public PythonParserTD(Scanner scanner)
    {
        super(scanner);
    }

    /**
     * Parse a Pascal source program and generate the symbol table
     * and the intermediate code.
     */
    public void parse()
        throws Exception
    {
        Token token;
        long startTime = System.currentTimeMillis();

        try {
            // Loop over each token until the end of file.
            while (!((token = nextToken()) instanceof EofToken)) {
                TokenType tokenType = token.getType();

                // Cross reference only the identifiers.
                if (tokenType == IDENTIFIER) {
                    String name = token.getText().toLowerCase();

                    // If it's not already in the symbol table,
                    // create and enter a new entry for the identifier.
                    SymTabEntry entry = symTabStack.lookup(name);
                    if (entry == null) {
                        entry = symTabStack.enterLocal(name);
                    }

                    // Append the current line number to the entry.
                    entry.appendLineNumber(token.getLineNumber());
                }

                else if (tokenType == ERROR) {
                    errorHandler.flag(token, (PythonErrorCode) token.getValue(),
                                      this);
                }
            }

            // Send the parser summary message.
            float elapsedTime = (System.currentTimeMillis() - startTime)/1000f;
            sendMessage(new Message(PARSER_SUMMARY,
                                    new Number[] {token.getLineNumber(),
                                                  getErrorCount(),
                                                  elapsedTime}));
        }
        catch (java.io.IOException ex) {
            errorHandler.abortTranslation(IO_ERROR, this);
        }
    }

    /**
     * Return the number of syntax errors found by the parser.
     * @return the error count.
     */
    public int getErrorCount()
    {
        return errorHandler.getErrorCount();
    }
}
