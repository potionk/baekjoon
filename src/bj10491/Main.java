package bj10491;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            input = input.toLowerCase() + " a";
            if (input.split("problem").length == 1) {
                bw.write("no\n");
            } else {
                bw.write("yes\n");
            }
        }
        bw.close();
    }
}