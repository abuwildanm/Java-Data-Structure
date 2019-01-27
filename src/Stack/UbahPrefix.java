package Stack;

public class UbahPrefix {
    private String iS;
    private StackPrefix s;
    private char[] infix;
    private String prefix;
    
    public UbahPrefix(String arg) {
        iS = arg;
        s = new StackPrefix();
        infix = new char[arg.length() + 1];
        prefix = "";
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
        s.push(')'); //awalan stack
        infix[0] = '(';
        String temp = "";
        
        for (int i = 0; i < iS.length(); i++) { //perulangan buat memasukkan infix
            infix[i+1] = iS.charAt(i);
        } 
        
        for (int i = infix.length - 1; i >= 0; i--) { //perulangan untuk scan infix
            if (infix[i] == '(') {
//                s.push('(');
                while ((char)s.peek() != ')') {
                    temp += s.pop();
                }
                s.pop();
            }
            else if (infix[i] == ')') {
                s.push(')');
//                while ((char)s.peek() != '(') {
//                    prefix += s.pop();
//                }
//                s.pop();
            }
            else if (!isOperator(infix[i])) {
                temp += infix[i];
            }
            else if (isOperator(infix[i])) {
                if (getPriority(s.peek()) <= getPriority(infix[i])) { //jika prioritas operator peek lebih tinggi daripada operator yang di-scan
                    temp += s.pop();
                    s.push(infix[i]);
                }
                else {
                    s.push(infix[i]);
                }
                
            }
            
            s.print("Isi Stack " + (i+1));
            System.out.println("Isi Prefix " + (i+1) + " : " + prefix);
            System.out.println("");
        }
        
        for (int i = 0; i < temp.length(); i++) {
            prefix = temp.charAt(i) + prefix;
        }
        
        System.out.println("Notasi Infix   : " + String.copyValueOf(infix));
        System.out.println("Notasi Prefix : " + prefix);
    }
    
    public static void main(String[] args) {
        UbahPrefix p = new UbahPrefix("(1+2)*(3-4)");
        p.print();
    }
}
