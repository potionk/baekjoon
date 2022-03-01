package bj14470;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        if (a < 0) {
            bw.write((-1 * a * c + d + b * e) + "\n");
        } else if (a > 0) {
            bw.write(((b - a) * e) + "\n");
        } else {
            bw.write((d + b * e) + "\n");
        }
        br.close();
        bw.close();
    }
}
