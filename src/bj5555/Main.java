package bj5555;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine();
        int targetLen = target.length();
        int tc = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < tc; i++) {
            int thisCount = 0;
            String input = br.readLine();
            int inputLen = input.length();
            if (inputLen != 1) {
                input = input + input.substring(0, targetLen - 1);
            }
            int idx = 0;
            int next;
            while ((next = input.indexOf(target, idx)) != -1) {
                thisCount++;
                idx = next + 1;
            }
            if (thisCount > 0) {
                count++;
            }
        }
        bw.write(count + "\n");
        bw.close();
    }
}