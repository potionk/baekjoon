package bj10823;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            sb.append(input);
        }
        String[] numberArr = sb.toString().split(",");
        int result = 0;
        for (String s : numberArr) {
            result += Integer.parseInt(s);
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
