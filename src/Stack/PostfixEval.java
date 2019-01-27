package Stack;

import java.util.Stack;

public class PostfixEval {
    private String iS;
    private Stack s;
    
    public PostfixEval(String iString) {
        iS = iString;
        s = new Stack();
        String outputString = "";
        boolean fI = false;
        for (int i = 0; i < iS.length(); i++) {
            char curChar = iS.charAt(i);
            if (!isOperator(curChar)) {
                outputString += Character.toString(curChar);
                if (i == (iS.length() - 1)) {
                    while (!s.empty()) {
                        outputString += s.pop();
                    }
                }
            }
            else {
                if (fI) {
                    if (pMin(curChar) && pMin((Character)s.peek())) {
                        outputString += s.pop();
                        s.push(curChar);
                        if (i == (iS.length() - 1)) {
                            while (!s.empty()) {
                                outputString += s.pop();
                            }
                        }
                    }
                    else if (mDiv(curChar) && mDiv((Character)s.peek())) {
                        outputString += s.pop();
                        s.push(curChar);
                        if (i == (iS.length() - 1)) {
                            while (!s.empty()) {
                                outputString += s.pop();
                            }
                        }
                    }
                    else if (pMin(curChar) && mDiv((Character)s.peek())) {
                        outputString += s.pop();
                        s.push(curChar);
                        if (i == (iS.length() - 1)) {
                            while (!s.empty()) {
                                outputString += s.pop();
                            }
                        }
                    }
                    else if (mDiv(curChar) && pMin((Character)s.peek())) {
                        s.push(curChar);
                        if (i == (iS.length() - 1)) {
                            while (!s.empty()) {
                                outputString += s.pop();
                            }
                        }
                    }
                    else {
                        outputString += Character.toString(curChar);
                        if (i == (iS.length() - 1)) {
                            while (!s.empty()) {
                                outputString += s.pop();
                            }
                        }
                    }
                }
                else {
                    s.push(curChar);
                    fI = true;
                }
            }
        }
        System.out.println(outputString);
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
    
    public boolean pMin(char op) {
        switch (op) {
            case '+' : return true;
            case '-' : return true;
            default : return false;
        }
    }
    
    public boolean mDiv(char op) {
        switch (op) {
            case '*' : return true;
            case '/' : return true;
            default : return false;
        }
    }
}
