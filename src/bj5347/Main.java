package bj5347;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        for(int i=0; i<tcNum; i++){
            String[] tc = br.readLine().split(" ");
            int a = Integer.parseInt(tc[0]);
            int b = Integer.parseInt(tc[1]);
            int e = euclidean(a, b);
            bw.write((a / e) * b+"\n");
        }
        bw.flush();
    }

    public static int euclidean(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return euclidean(b, a % b);
    }
}
