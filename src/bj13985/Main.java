package bj13985;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] question = br.readLine().split(" = ");
        String[] ab = question[0].split(" \\+ ");
        if (Long.parseLong(ab[0]) + Long.parseLong(ab[1]) == Long.parseLong(question[1])) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        br.close();
        bw.close();
    }
}
