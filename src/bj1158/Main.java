package bj1158;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] testCase = br.readLine().split(" ");
        int N = Integer.parseInt(testCase[0]);
        int K = Integer.parseInt(testCase[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int index = -1;
        bw.write("<");
        for (int i = 0; i < N; i++) {
            index = (index + K) % list.size();
            int rem = list.remove(index);
            index--;
            if (i != N - 1)
                bw.write(rem + ", ");
            else
                bw.write(rem + "");
        }
        bw.write(">");
        bw.flush();
    }
}