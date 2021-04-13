package bj15059;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] A = br.readLine().split(" ");
        String[] R = br.readLine().split(" ");
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += Math.max((Integer.parseInt(R[i]) - Integer.parseInt(A[i])), 0);
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
