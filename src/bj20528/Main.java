package bj20528;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        String[] tc = br.readLine().split(" ");
        boolean isPosible = true;
        char c = tc[0].charAt(0);
        for (int i = 1; i < tcNum; i++) {
            if (tc[i].charAt(0) != c) {
                isPosible = false;
                break;
            }
        }
        bw.write(isPosible ? "1" : "0");
        br.close();
        bw.close();
    }
}
