package bj17413;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tc = br.readLine();
        Stack<Character> stack = new Stack<>();
        int tcLen = tc.length();
        boolean isIgnoreMode = false;
        for (int i = 0; i < tcLen; i++) {
            if (tc.charAt(i) == '<') {
                bw.write(stack2String(stack)+"");
                isIgnoreMode = true;
                bw.write('<' + "");
                continue;
            } else if (tc.charAt(i) == '>') {
                isIgnoreMode = false;
                bw.write('>' + "");
                continue;
            }
            if (!isIgnoreMode) {
                if (tc.charAt(i) == ' ') {
                    bw.write(stack2String(stack)+" ");
                } else {
                    stack.push(tc.charAt(i));
                }
            } else {
                bw.write(tc.charAt(i) + "");
            }
        }
        bw.write(stack2String(stack)+"");
        bw.flush();
    }
    public static String stack2String(Stack<Character> stack){
        StringBuilder sb=new StringBuilder();
        int stackSize = stack.size();
        for (int j = 0; j < stackSize; j++) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
