package Stack;

public class UbahPostfix {
    private String iS;
    private StackPostfix s;
    private char[] infix;
    private String postfix;
    
    public UbahPostfix(String arg) {
        iS = arg;
        s = new StackPostfix();
        infix = new char[arg.length() + 1];
        postfix = "";
    }
    
    public boolean isOperator(char op) {
        switch (op) {
            case '+' : return true;
            case '-' : return true;
            case '*' : return true;
            case '/' : return true;
            case '^' : return true;
            default : return false;
        }
    }
    
    public int getPriority(Object op) {
        switch ((char)op) {
            case '+' : return 3;
            case '-' : return 3;
            case '*' : return 2;
            case '/' : return 2;
            case '^' : return 1;
            default : return 99;
        }
    }
    
    public void print() {
        s.push('('); //awalan stack
        
        for (int i = 0; i < iS.length(); i++) { //perulangan buat memasukkan infix
            infix[i] = iS.charAt(i);
        } 
        infix[iS.length()] = ')';
        
        for (int i = 0; i < infix.length; i++) { //perulangan untuk scan infix
            if (infix[i] == '(') {
                s.push('(');
            }
            else if (infix[i] == ')') {
                while ((char)s.peek() != '(') {
                    postfix += s.pop();
                }
                s.pop();
            }
            else if (!isOperator(infix[i])) {
                postfix += infix[i];
            }
            else if (isOperator(infix[i])) {
                if (getPriority(s.peek()) <= getPriority(infix[i])) { //jika prioritas operator peek lebih tinggi daripada operator yang di-scan
                    postfix += s.pop();
                    s.push(infix[i]);
                }
                else {
                    s.push(infix[i]);
                }
                
            }
            
//            s.print("Isi Stack " + (i+1));
//            System.out.println("Isi Postfix " + (i+1) + " : " + postfix);
//            System.out.println("");
        }
        
        System.out.println("Notasi Infix   : " + String.copyValueOf(infix));
        System.out.println("Notasi Postfix : " + postfix);
    }
    
    public static void main(String[] args) {
        UbahPostfix p = new UbahPostfix("A+(B*C-(D/E^F)*G)*H");
        p.print();
    }
}
