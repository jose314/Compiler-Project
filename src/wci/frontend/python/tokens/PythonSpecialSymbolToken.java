package wci.frontend.python.tokens;

import wci.frontend.Source;
import wci.frontend.python.PythonToken;

import static wci.frontend.python.PythonErrorCode.INVALID_CHARACTER;
import static wci.frontend.python.PythonTokenType.ERROR;
import static wci.frontend.python.PythonTokenType.SPECIAL_SYMBOLS;

/**
 * <h1>PascalSpecialSymbolToken</h1>
 *
 * <p> Pascal special symbol tokens.</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class PythonSpecialSymbolToken extends PythonToken
{
    /**
     * Constructor.
     * @param source the source from where to fetch the token's characters.
     * @throws Exception if an error occurred.
     */
    public PythonSpecialSymbolToken(Source source)
        throws Exception
    {
        super(source);
    }

    /**
     * Extract a Pascal special symbol token from the source.
     * @throws Exception if an error occurred.
     */
    protected void extract()
        throws Exception
    {
        char currentChar = currentChar();

        text = Character.toString(currentChar);
        type = null;

        switch (currentChar) {

            // Single-character special symbols.
            case ',':
            case ';':  case '\'': case '(':  case ')':
            case '[':  case ']':  case '{':  case '}':  
            case '?':  case '#':  case '~': 
            case ':':
           	
            
            	
            	
            	
            {
                nextChar();  // consume character
                break;
            }

            // : or :=
           /* case ':': {
                currentChar = nextChar();  // consume ':';

                if (currentChar == '=') {
                    text += currentChar;
                    nextChar();  // consume '='
                }

                break;
            }*/ //Not in python

            // < or <= or <>
            case '<': {
                currentChar = nextChar();  // consume '<';

                if (currentChar == '=') {
                    text += currentChar;
                    nextChar();  // consume '='
                }
                else if (currentChar == '>') {
                    text += currentChar;
                    nextChar();  // consume '>'
                }
                
                else if (currentChar =='<') {
                	currentChar = nextChar();
                	if (currentChar == '=') {
                		text += "<=";
                		nextChar();
                	}
                	
                	else if(currentChar != '=') {
                		text += "<";
                		nextChar();
                	}
                	
                	
                }

                break;
            }

            // > or >=
            case '>': {
                currentChar = nextChar();  // consume '>';

                if (currentChar == '=') {
                    text += currentChar;
                    nextChar();  // consume '='
                }
                
                else if (currentChar =='>') {
                	currentChar = nextChar();
                	if (currentChar == '=') {
                		text += ">=";
                		nextChar();
                	}
                	
                	else if(currentChar != '=') {
                		text += ">";
                		nextChar();
                	}
                	
                	
                
                }

                break;
            }

            
            // + or +=
            case '+': { 
                currentChar = nextChar();  // consume '<';

                if (currentChar == '=') {
                    text += currentChar;
                    nextChar();  // consume '='
                }
                
                break;
            }
            
            // - or -=
            case '-': { 
                currentChar = nextChar();  // consume '<';

                if (currentChar == '=') {
                    text += currentChar;
                    nextChar();  // consume '='
                }
                
                break;
            }
            
     
            
   
            
            // % or %=
            case '%': { 
                currentChar = nextChar();  // consume '<';

                if (currentChar == '=') {
                    text += currentChar;
                    nextChar();  // consume '='
                }
                
                break;
            } 
            
            // & or &=
            case '&': { 
                currentChar = nextChar();  // consume '<';

                if (currentChar == '=') {
                    text += currentChar;
                    nextChar();  // consume '='
                }
                
                break;
            }
            
            // | or |=
            case '|': { 
                currentChar = nextChar();  // consume '<';

                if (currentChar == '=') {
                    text += currentChar;
                    nextChar();  // consume '='
                }
                
                break;
            }
            
            // ^ or ^=
            case '^': { 
                currentChar = nextChar();  // consume '<';

                if (currentChar == '=') {
                    text += currentChar;
                    nextChar();  // consume '='
                }
                
                break;
            }
            
            // = or ==
            case '=': { 
                currentChar = nextChar();  // consume '<';

                if (currentChar == '=') {
                    text += currentChar;
                    nextChar();  // consume '='
                }
                
                break;
            }
            
            // ! or !=
            case '!': { 
                currentChar = nextChar();  // consume '<';

                if (currentChar == '=') {
                    text += currentChar;
                    nextChar();  // consume '='
                }
                
                break;
            }
            
            
            // . or ..
            case '.': { 
                currentChar = nextChar();  // consume '<';

                if (currentChar == '.') {
                    text += currentChar;
                    nextChar();  // consume '='
                }
                
                break;
            }
            
            // * or **
            case '*': { 
                currentChar = nextChar();  // consume '<';

                if (currentChar == '*') {
                    text += currentChar;
                    nextChar();  // consume '='
                }
                
                break;
            }
            
            
            // / or //=
            case '/': { 
                currentChar = nextChar();  // consume '<';

                if (currentChar == '/') {
                    text += currentChar;
                    nextChar();  // consume '='
                }
                
                break;
            }
            
            
            
            
            

            default: {
                nextChar();  // consume bad character
                type = ERROR;
                value = INVALID_CHARACTER;
            }
        }

        // Set the type if it wasn't an error.
        if (type == null) {
            type = SPECIAL_SYMBOLS.get(text);
        }
    }
}
