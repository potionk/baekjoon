package bj10936;

import java.io.*;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tc = br.readLine();
        byte[] tcBytes = tc.getBytes();
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(tcBytes);
        for (byte b : decodedBytes) {
            bw.write((char) b + "");
        }
        br.close();
        bw.close();
    }
}