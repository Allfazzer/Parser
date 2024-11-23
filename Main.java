import java.util.List;

public class Main { 
    public static void main(String[] args) {
        // Initialize a Scanner
        Scanner scanner =  new Scanner();

        // Retrieve the tokens from the scanner
        List <List<Token>> tokens = scanner.getTokens();

        // Initialize Parser
        Parser parser = new Parser(tokens);
    }
}