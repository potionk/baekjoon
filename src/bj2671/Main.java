package bj2671;

import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        boolean isValid = Pattern.matches("((10)0+1+|01)+", input);
        if (isValid) {
            bw.write("SUBMARINE\n");
        } else {
            bw.write("NOISE\n");
        }
        bw.close();
    }
}