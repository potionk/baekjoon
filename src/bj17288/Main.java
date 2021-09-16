package bj17288;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] tc = br.readLine().toCharArray();
        int answer = 0;
        int count = 1;
        int before = tc[0];
        for (int i = 1; i < tc.length; i++) {
            if (before + 1 == tc[i]) {
                count++;
            } else {
                count = 1;
            }
            before = tc[i];
            if (count == 3) {
                answer++;
            } else if (count > 3) {
                answer--;
                count = 0;
            }
        }
        bw.write(answer + "");
        br.close();
        bw.close();
    }
}
