package bj7585;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String line = br.readLine();
            int lineLen = line.length();
            if (line.equals("#")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean isIllegal = false;
            for (int i = 0; i < lineLen; i++) {
                char c = line.charAt(i);
                if (c == '{' || c == '[' || c == '(') {
                    stack.add(c);
                } else if (c == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        isIllegal = true;
                        break;
                    }
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isIllegal = true;
                        break;
                    }
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        isIllegal = true;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                isIllegal = true;
            }
            bw.write(isIllegal ? "Illegal\n" : "Legal\n");
        }
        br.close();
        bw.close();
    }
}
