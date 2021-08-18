import java.util.ArrayList;

public class Lexer {
    
    private enum Lexem {
        IDENT, INT_LIT, LPAREN, RPAREN,
        ADD_OP, SUB_OP, MUL_OP, DIV_OP, GT_OP, 
        LT_OP, EQ_OP, ASSIGN_OP
    }

    private class Triple {

        private Lexem lexem;
        private String value;
        private int id;

        public Triple(Lexem lexem, String value){
            this.lexem = lexem;
            this.id = correspondingId(lexem);
            this.value = value;
        }

        public Lexem getLexem(){
            return this.lexem;
        }
        public int getId(){
            return this.id;
        }
        public String getValue(){
            return this.value;
        }

    }

    private int correspondingId(Lexem lexem){
        switch(lexem){
            case IDENT: return 1;
            case INT_LIT: return 2;
            case LPAREN: return 3;
            case RPAREN: return 4;
            case ADD_OP: return 5;
            case SUB_OP: return 6;
            case MUL_OP: return 7;
            case DIV_OP: return 8;
            case GT_OP: return 9;
            case LT_OP: return 10;
            case EQ_OP: return 11;
            case ASSIGN_OP: return 12;
            default: return -1;
        }
    }

    private ArrayList<Triple> getTriples(String expression){

        expression = expression.replaceAll("\\(", "\\( ");
        expression = expression.replaceAll("\\)", " \\)");

        String[] parts = expression.split(" ");
        ArrayList<Triple> triples = new ArrayList<>();

        for(String part : parts){
            switch(part){
                case "(":
                    triples.add(new Triple(Lexem.LPAREN, part));
                break;
                case ")":
                    triples.add(new Triple(Lexem.RPAREN, part));
                break;
                case "+":
                    triples.add(new Triple(Lexem.ADD_OP, part));
                break;
                case "-":
                    triples.add(new Triple(Lexem.SUB_OP, part));
                break;
                case "*":
                    triples.add(new Triple(Lexem.MUL_OP, part));
                break;
                case "/":
                    triples.add(new Triple(Lexem.DIV_OP, part));
                break;
                case ">":
                    triples.add(new Triple(Lexem.GT_OP, part));
                break;
                case "<":
                    triples.add(new Triple(Lexem.LT_OP, part));
                break;
                case "==":
                    triples.add(new Triple(Lexem.EQ_OP, part));
                break;
                case "=":
                    triples.add(new Triple(Lexem.ASSIGN_OP, part));
                break;
                default: 
                    try {
                        Integer.parseInt(part);
                        triples.add(new Triple(Lexem.INT_LIT, part));
                    } catch(NumberFormatException error) {
                        triples.add(new Triple(Lexem.IDENT, part));
                    }
                break;
            }
        }
        return triples;
    }

    public String analyzeExpression(String expression){

        String results = "";
        ArrayList<Triple> triples = getTriples(expression);

        for(Triple triple : triples){
            results += "(\'" + triple.getValue() + "\', ";
            results += triple.getLexem() + ", ";
            results += triple.getId() + ")\n";
        }

        return results;
    }

}
