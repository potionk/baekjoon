package bj2812;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = br.readLine().split(" ");
        int K = Integer.parseInt(nk[1]);
        char[] T = br.readLine().toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : T) {
            while (K > 0 && !deque.isEmpty() && deque.peekLast() < c) {
                deque.pollLast();
                K--;
            }
            deque.offerLast(c);
        }
        int len = deque.size() - K;
        int i = 0;
        while (!deque.isEmpty()) {
            if (i == len) {
                break;
            }
            i++;
            bw.write(deque.poll());
        }
        br.close();
        bw.close();
    }
}