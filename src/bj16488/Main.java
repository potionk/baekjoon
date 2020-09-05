package bj16488;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        bw.write(Long.parseLong(tc[0]) * Long.parseLong(tc[0]) * Long.parseLong(tc[1]) + "\n");
        bw.flush();
    }
}
