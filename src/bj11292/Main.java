package bj11292;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            StringBuilder maxName = new StringBuilder();
            double max = -1;
            for (int i = 0; i < n; i++) {
                String[] info = br.readLine().split(" ");
                double tall = Double.parseDouble(info[1]);
                if (max < tall) {
                    maxName = new StringBuilder(info[0]);
                    max = tall;
                } else if (max == tall) {
                    maxName.append(" ").append(info[0]);
                }
            }
            bw.write(maxName.toString() + "\n");
        }
        br.close();
        bw.close();
    }
}
