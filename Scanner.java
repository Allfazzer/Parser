import java.util.List;

public class Scanner {
    // Tokens as an array of arrays (each array represents a logical expression)
    private final List<List<Token>> tokens = List.of(
        // ~P ∨ Q
        List.of(
            new Token("keyword", "NOT"),
            new Token("identifier", "P"),
            new Token("operator", "OR"),
            new Token("identifier", "Q")
        ),

        // P ∧ Q
        List.of(
            new Token("identifier", "P"),
            new Token("operator", "AND"),
            new Token("identifier", "Q")
        ),

        // (P ∨ Q) ∧ ~R
        List.of(
            new Token("open_parenthesis", "("),
            new Token("identifier", "P"),
            new Token("operator", "OR"),
            new Token("identifier", "Q"),
            new Token("close_parenthesis", ")"),
            new Token("operator", "AND"),
            new Token("keyword", "NOT"),
            new Token("identifier", "R")
        ),

        // NOT (P ⇒ Q)
        List.of(
            new Token("keyword", "NOT"),
            new Token("open_parenthesis", "("),
            new Token("identifier", "P"),
            new Token("operator", "IMPLIES"),
            new Token("identifier", "Q"),
            new Token("close_parenthesis", ")")
        ),

        // P ⇔ (Q ∨ R)
        List.of(
            new Token("identifier", "P"),
            new Token("operator", "EQUIVALENT"),
            new Token("open_parenthesis", "("),
            new Token("identifier", "Q"),
            new Token("operator", "OR"),
            new Token("identifier", "R"),
            new Token("close_parenthesis", ")")
        ),

        // ~((P ∨ Q) ∧ R)
        List.of(
            new Token("keyword", "NOT"),
            new Token("open_parenthesis", "("),
            new Token("open_parenthesis", "("),
            new Token("identifier", "P"),
            new Token("operator", "OR"),
            new Token("identifier", "Q"),
            new Token("close_parenthesis", ")"),
            new Token("operator", "AND"),
            new Token("identifier", "R"),
            new Token("close_parenthesis", ")")
        )
    );

    // Method to get the tokens
    public List<List<Token>> getTokens() {
        return tokens;
    }
}