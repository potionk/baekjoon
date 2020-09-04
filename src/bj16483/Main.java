package bj16483;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double T = Double.parseDouble(br.readLine());
        bw.write(Math.round((T * T) / 4) + "\n");
        bw.flush();
    }
}
