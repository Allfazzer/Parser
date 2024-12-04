import java.util.List;

public class Parser {
    private List<List<Token>> tokens;  
    private Scanner scanner
    private int currentIndex;    // Tracks the current token index

    // Constructor
    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.currentIndex = 0;  // Start at the first token
    }

    // Parse a sentence (entry point for parsing)
    public ParseTreeNode parseSentence() {
        return parseComplexSentence();
    }

    // Parse a complex sentence (handles logical connectives)
    private ParseTreeNode parseComplexSentence() {
        if (currentToken().getType() == Token.Type.NOT) {
            // Handle NOT connective
            consume();  // Consume "NOT"
            ParseTreeNode child = parseComplexSentence();
            return new ParseTreeNode("NOT", child, null);
        }

        // Parse the left-hand side of the expression
        ParseTreeNode left = parseAtomicSentence();

        // Check for logical connectives (AND, OR, IMPLIES, EQUIVALENT)
        if (currentToken().getType() == Token.Type.AND ||
            currentToken().getType() == Token.Type.OR ||
            currentToken().getType() == Token.Type.IMPLIES ||
            currentToken().getType() == Token.Type.EQUIVALENT) {
            String operator = currentToken().getValue();
            consume();  // Consume the operator
            ParseTreeNode right = parseComplexSentence();
            return new ParseTreeNode(operator, left, right);
        }

        return left; 
    }

    // Parse an atomic sentence
    private ParseTreeNode parseAtomicSentence() {
        Token token = currentToken();

        if (token.getType() == Token.Type.TRUE || token.getType() == Token.Type.FALSE || token.getType() == Token.Type.VAR) {
            // Base case: TRUE, FALSE, or a variable
            consume();  // Consume the token
            return new ParseTreeNode(token.getValue());
        }

        if (token.getType() == Token.Type.LPAREN) {
            // Handle expressions within parentheses
            consume();  // Consume "("
            ParseTreeNode subExpression = parseComplexSentence();
            if (currentToken().getType() == Token.Type.RPAREN) {
                consume();  // Consume ")"
                return subExpression;
            } else {
                //Throw something for error
            }
        }

       //Throw something for error
    }

    // Utility method to get the current token
    private Token currentToken() {
        if (currentIndex < tokens.size()) {
            return tokens.get(currentIndex);
        }
        //return new Token
    }

    // Utility method to consume the current token and advance to the next
    private void consume() {
        currentIndex++;
    }
}

}
