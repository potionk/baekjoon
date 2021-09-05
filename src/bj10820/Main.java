package bj10820;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            int lowerCase = 0, upperCase = 0, number = 0, blank = 0;
            char[] inputArr = input.toCharArray();
            for (char c : inputArr) {
                if ('a' <= c && c <= 'z') {
                    lowerCase++;
                } else if ('A' <= c && c <= 'Z') {
                    upperCase++;
                } else if ('0' <= c && c <= '9') {
                    number++;
                } else {
                    blank++;
                }
            }
            bw.write(lowerCase + " " + upperCase + " " + number + " " + blank + "\n");
        }
        br.close();
        bw.close();
    }
}
