package bj15659;

import java.io.*;
import java.util.Stack;

public class Main {
    static int[] operand; // 피연산자
    static int[] operator; // 연산
    static int size;
    static int min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        String[] operandStr = br.readLine().split(" ");
        String[] operatorStr = br.readLine().split(" ");
        operand = new int[operandStr.length];
        operator = new int[4];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            operand[i] = Integer.parseInt(operandStr[i]);
        }
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(operatorStr[i]);
        }
        dfs(1, operand[0] + "");
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int index, String resultStr) {
        if (index < size) {
            for (int i = 0; i < 4; i++) {
                StringBuilder sb = new StringBuilder();
                if (operator[i] > 0) {
                    switch (i) {
                        case 0:
                            sb.append(resultStr).append("+").append(operand[index]);
                            break;
                        case 1:
                            sb.append(resultStr).append("-").append(operand[index]);
                            break;
                        case 2:
                            sb.append(resultStr).append("*").append(operand[index]);
                            break;
                        case 3:
                            sb.append(resultStr).append("/").append(operand[index]);
                            break;
                    }
                    if (index == size - 1) {
                        Stack<Character> stack = infixToPrefix(sb.toString());
                        int result = calPrefix(stack);
                        if (result != Integer.MIN_VALUE) {
                            max = Math.max(max, result);
                            min = Math.min(min, result);
                        }
                    }
                    --operator[i];
                    dfs(index + 1, sb.toString());
                    ++operator[i];
                }
            }
        }
    }

    public static Stack<Character> infixToPrefix(String infixStr) {
        char[] infix = infixStr.toCharArray();
        Stack<Character> result = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (int i = 0; i < infix.length; i++) {
            switch (infix[i]) {
                case '+':
                case '-':
                    while (!operator.isEmpty()) {
                        result.push(operator.pop());
                    }
                    operator.push(infix[i]);
                    break;
                case '/':
                case '*':
                    while (!operator.isEmpty() && (operator.peek() == '/' || operator.peek() == '*')) {
                        result.push(operator.pop());
                    }
                    operator.push(infix[i]);
                    break;
                default:
                    result.push(infix[i]);
            }
            if (i == infix.length - 1) {
                while (operator.size() != 0)
                    result.push(operator.pop());
            }
        }
        return result;
    }

    public static int calPrefix(Stack<Character> prefix) {
        Object[] prefixArrObj = prefix.toArray();
        char[] prefixArr = new char[prefixArrObj.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prefixArrObj.length; i++) {
            prefixArr[i] = (char) prefixArrObj[i];
        }
        for (char c : prefixArr) {
            int b;
            int a;
            switch (c) {
                case '+':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case '-':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case '*':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case '/':
                    b = stack.pop();
                    a = stack.pop();
                    if (b == 0)
                        return Integer.MIN_VALUE;
                    stack.push(a / b);
                    break;
                default:
                    stack.push(c - 48);
            }
        }
        return stack.get(0);
    }
}
