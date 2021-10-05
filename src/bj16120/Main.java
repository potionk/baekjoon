package bj16120;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] tc = br.readLine().toCharArray();
        int count = 0;
        Stack<Character> stack = new Stack<>();
        boolean ppap = true;
        for (char c : tc) {
            if (c == 'P') {
                count++;
                if (count >= 4 && stack.peek() == 'A') {
                    for (int i = 0; i < 3; i++) {
                        stack.pop();
                    }
                    count -= 3;
                }
                stack.push(c);
            } else {
                if (count >= 2 && stack.peek() != 'A') {
                    count++;
                    stack.push(c);
                } else {
                    ppap = false;
                    break;
                }
            }
        }
        if (count == 1 && ppap) {
            bw.write("PPAP");
        } else {
            bw.write("NP");
        }
        br.close();
        bw.close();
    }
}