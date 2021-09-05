package bj13163;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] nickname = br.readLine().split(" ");
            nickname[0] = "god";
            StringBuilder sb = new StringBuilder();
            for (String s : nickname) {
                sb.append(s);
            }
            bw.write(sb.toString() + "\n");
        }
        br.close();
        bw.close();
    }
}
