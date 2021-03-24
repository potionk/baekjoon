package bj3447;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            while (input.contains("BUG")) {
                input = input.replace("BUG", "");
            }
            bw.write(input + "\n");
        }
        br.close();
        bw.close();
    }
}