package bj4796;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        int caseNum = 1;
        while (!(input = br.readLine()).equals("0 0 0")) {
            String[] LPV = input.split(" ");
            int L = Integer.parseInt(LPV[0]);
            int P = Integer.parseInt(LPV[1]);
            int V = Integer.parseInt(LPV[2]);
            int result = 0;
            result += (V / P) * L;
            V -= (V / P) * P;
            result += Math.min(V, L);
            bw.write("Case " + caseNum++ + ": " + result + "\n");
        }
        br.close();
        bw.close();
    }
}
