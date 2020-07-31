package bj1406;

import java.io.*;
import java.util.Stack;

public class Main {
    static Stack<Character> left;
    static Stack<Character> right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        left = new Stack<>();
        right = new Stack<>();
        String txt = br.readLine();
        int txtSize = txt.length();
        for (int i = 0; i < txtSize; i++) {
            left.add(txt.charAt(i));
        }
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] cmd = br.readLine().split(" ");
            if (cmd.length > 1) {
                builtInCmd(cmd[0].charAt(0), cmd[1].charAt(0));
            } else {
                builtInCmd(cmd[0].charAt(0), 'n');
            }
        }
        stackToResult();
    }

    public static void builtInCmd(char cmd, char arg) {
        switch (cmd) {
            case 'L':
                if (left.size() != 0) {
                    right.add(left.pop());
                }
                break;
            case 'D':
                if (right.size() != 0) {
                    left.add(right.pop());
                }
                break;
            case 'B':
                if (left.size() != 0) {
                    left.pop();
                }
                break;
            case 'P':
                left.add(arg);
                break;
        }
    }

    public static void stackToResult() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Character character : left) {
            bw.write(character);
        }
        int rightSize = right.size();
        for (int i = 0; i < rightSize; i++) {
            bw.write(right.pop());
        }
        bw.flush();
    }
}
