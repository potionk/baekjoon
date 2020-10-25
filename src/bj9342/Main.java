package bj9342;

import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        String input;
        for (int i = 0; i < tc; i++) {
            input = br.readLine();
            boolean isValid = Pattern.matches("[A-F]?A+F+C+[A-F]?", input);
            if (isValid) {
                bw.write("Infected!\n");
            } else {
                bw.write("Good\n");
            }
        }
        bw.close();
    }
}