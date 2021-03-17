package bj10935;

import java.io.*;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tc = br.readLine();
        byte[] tcBytes = tc.getBytes();
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode(tcBytes);
        for (byte b : encodedBytes) {
            bw.write((char) b + "");
        }
        br.close();
        bw.close();
    }
}
