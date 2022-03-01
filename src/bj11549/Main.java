package bj11549;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String T = br.readLine();
        String[] abcde = br.readLine().split(" ");
        int result = 0;
        for (String s : abcde) {
            if (s.equals(T)) {
                result++;
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
