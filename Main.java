public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        String results = lexer.analyzeExpression("a = (aux - 2) * 200 / 19");
        System.out.print(results);
    }
}