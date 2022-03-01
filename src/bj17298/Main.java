package bj17298;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] aArrStr = br.readLine().split(" ");
        int[] nge = new int[N];
        for (int i = 0; i < N; i++) {
            nge[i] = Integer.parseInt(aArrStr[i]);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && nge[stack.peek()] < nge[i]) {
                nge[stack.pop()] = nge[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            nge[stack.pop()] = -1;
        }
        for (int i : nge) {
            bw.write(i + " ");
        }
        br.close();
        bw.close();
    }
}