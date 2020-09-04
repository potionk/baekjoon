package bj15904;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        char[] findTarget = {'U', 'C', 'P', 'C'};
        int findNum = 0, len = input.length();
        for (int i = 0; i < len; i++) {
            if (findNum == 4) {
                break;
            }
            if (input.charAt(i) == findTarget[findNum]) {
                findNum++;
            }
        }
        if (findNum == 4) {
            bw.write("I love UCPC\n");
        } else {
            bw.write("I hate UCPC\n");
        }
        bw.flush();
    }
}