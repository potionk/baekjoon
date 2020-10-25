package bj2495;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String readLine;
        while ((readLine = br.readLine()) != null) {
            char[] input = readLine.toCharArray();
            int inputLen = input.length;
            int count = 1;
            for (int i = 0; i < inputLen - 1; i++) {
                char t = input[i];
                int thisCount = 1;
                while (i + 1 < inputLen && input[i + 1] == t) {
                    thisCount++;
                    count = Math.max(thisCount, count);
                    i++;
                }
            }
            bw.write(count + "\n");
        }
        bw.close();
    }
}