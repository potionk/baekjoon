package bj10807;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[201];
        String[] arr = br.readLine().split(" ");
        for (String s : arr) {
            count[Integer.parseInt(s) + 100]++;
        }
        bw.write(count[Integer.parseInt(br.readLine()) + 100] + "");
        br.close();
        bw.close();
    }
}
