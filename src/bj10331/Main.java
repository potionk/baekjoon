package bj10331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();
        int m = calExpr(expr, 'm');
        int l = calExpr(expr, 'l');
        int tc = Integer.parseInt(br.readLine());
        if (tc == m) {
            if (tc == l) {
                System.out.println("U");
            } else {
                System.out.println("M");
            }
        } else if (tc == l) {
            System.out.println("L");
        } else {
            System.out.println("I");
        }
    }

    public static int calExpr(String expr, char mode) {
        Stack<Character> result = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (mode == 'm') {
                switch (c) {
                    case '+':
                        while (!operator.isEmpty()) {
                            result.push(operator.pop());
                        }
                        operator.push(c);
                        break;
                    case '*':
                        while (!operator.isEmpty() && operator.peek() == '*') {
                            result.push(operator.pop());
                        }
                        operator.push(c);
                        break;
                    default:
                        result.push(c);
                }
            } else {
                if (c == '+' || c == '*') {
                    while (!operator.isEmpty()) {
                        result.push(operator.pop());
                    }
                    operator.push(c);

                } else {
                    result.push(c);
                }
            }
            if (i == expr.length() - 1) {
                while (operator.size() != 0)
                    result.push(operator.pop());
            }
        }
        Object[] result2Array = result.toArray();
        Stack<Integer> resultStack = new Stack<>();
        for (Object o : result2Array) {
            int b;
            int a;
            switch ((char) o) {
                case '+':
                    b = resultStack.pop();
                    a = resultStack.pop();
                    resultStack.push(a + b);
                    break;
                case '*':
                    b = resultStack.pop();
                    a = resultStack.pop();
                    resultStack.push(a * b);
                    break;
                default:
                    resultStack.push((char) o - 48);
            }
        }
        return resultStack.get(0);
    }
}
