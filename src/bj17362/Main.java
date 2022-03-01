package bj17362;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        switch (Integer.parseInt(br.readLine()) % 8) {
            case 1 -> bw.write("1");
            case 0, 2 -> bw.write("2");
            case 3, 7 -> bw.write("3");
            case 4, 6 -> bw.write("4");
            default -> bw.write("5");
        }
        br.close();
        bw.close();
    }
}
