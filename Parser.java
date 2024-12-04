import java.util.List;

public class Parser {
    private List<List<Token>> tokens;  
    private Scanner scanner

    // Constructor that initializes the 2D tokens list
    public Parser(List<List<Token>> tokens) {
        this.tokens = tokens; 
    }

    public ParseTreeNode parseSentence(){
        tokens = scanner.nextToken();
    }

    private ParseTreeNode parseComplexSentence(){
        //insert nested if-else statement to check 

        //ParseTreeNode left = parseAtomicSentence();
    }

    private ParseTreeNode parseAtomicSentence(){
        //insert nested if-else statement to check 

        //return node;
    }
}
