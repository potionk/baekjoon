package bj3952;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < tcNum; i++) {
            String data = br.readLine();
            int dataLen = data.length();
            int N = Integer.parseInt(br.readLine());
            String[] target = br.readLine().split(" ");
            int curIdx = 0;
            for (int j = 0; j < N; j++) {
                int next = Integer.parseInt(target[j]);
                if (next < 0) {
                    next += dataLen;
                }
                curIdx = (curIdx + next) % dataLen;
                bw.write(data.charAt(curIdx));
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}