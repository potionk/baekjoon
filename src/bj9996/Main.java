package bj9996;

import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String pattern = ("^" + br.readLine() + "$").replace("*", "[a-z]*");
        for (int i = 0; i < N; i++) {
            bw.write(Pattern.matches(pattern, br.readLine()) ? "DA\n" : "NE\n");
        }
        br.close();
        bw.close();
    }
}
