package Stack;

public class NotasiPolish {
    private StackPolish s = new StackPolish();
    private String prefix = "", postfix = "";
    
    public boolean isOperator(char op) {
        switch (op) {
            case '+' : case '-' : case '*' : case '/' : case '^' : return true;
            default : return false;
        }
    }
    
    public int getPriority(Object op) {
        switch ((char)op) {
            case '+' : case '-' : return 3;
            case '*' : case '/' : return 2;
            case '^' : return 1;
            default : return 99;
        }
    }
    
    public String toPrefix(String inf) {
        inf = "(" + inf; s.push(')'); String temp = "";
        
        for (int i = inf.length()-1; i >= 0; i--) {
            char infix = inf.charAt(i);
            
            if (infix == '(') {
                while ((char)s.peek() != ')') { temp += s.pop(); }
                s.pop();
            }
            else if (infix == ')') { s.push(')'); }
            else if (!isOperator(infix)) { temp += infix; }
            else if (isOperator(infix)) {
                if (getPriority(s.peek()) <= getPriority(infix)) {
                    temp += s.pop();
                    s.push(infix);
                }
                else { s.push(infix); }
            }
        }
        
        for (int i = 0; i < temp.length(); i++) {
            prefix = temp.charAt(i) + prefix;
        }
        
        return prefix;
    }
    
    public String toPostfix(String inf) {
        inf = inf + ")"; s.push('(');
        
        for (int i = 0; i < inf.length(); i++) {
            char infix = inf.charAt(i);
            
            if (infix == '(') { s.push('('); }
            else if (infix == ')') {
                while ((char)s.peek() != '(') { postfix += s.pop(); }
                s.pop();
            }
            else if (!isOperator(infix)) { postfix += infix; }
            else if (isOperator(infix)) {
                if (getPriority(s.peek()) <= getPriority(infix)) {
                    postfix += s.pop();
                    s.push(infix);
                }
                else { s.push(infix); }
            }
        }
        
        return postfix;
    }
    
    public double hitungPostfix(String post) {
        post = post + ")";
//        double hasil = 0;
        for (int i = 0; i < post.length(); i++) {
            char postfix = post.charAt(i);
            
            if (!isOperator(postfix)) { s.push(Double.valueOf(postfix)); }
            else {
                double operand1 = (double)s.pop();
                double operand2 = (double)s.pop();
                double hasil;
                switch (postfix) {
                    case '+' : hasil = operand1 + operand2; break;
                    case '-' : hasil = operand1 - operand2; break;
                    case '*' : hasil = operand1 * operand2; break;
                    case '/' : hasil = operand1 / operand2; break;
                    case '^' : hasil = (int)Math.pow(operand1, operand2); break;
                    default : hasil = 0; break;
                }
                s.push(hasil);
            }
        }
        return (double)s.pop();
    }

    public static void main(String[] args) {
        NotasiPolish p = new NotasiPolish();
        
        System.out.println("1. Konversi Infix");
        String infix = "(1+2)*(3-4)";
        System.out.println("Notasi Infix   : " + infix);
        String prefix = p.toPrefix(infix);
        System.out.println("Notasi Prefix  : " + prefix);
        String postfix = p.toPostfix(infix);
        System.out.println("Notasi Postfix : " + postfix);
        System.out.println("");
        
        System.out.println("2. Hitung Postfix");
        double hitungPostfix = p.hitungPostfix(postfix);
        System.out.println("Hasil dari postfix " + postfix + " adalah " + hitungPostfix);
    }
}