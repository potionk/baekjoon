package bj10930;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tc = br.readLine();
        MessageDigest md;
        md = MessageDigest.getInstance("SHA-256");
        md.update(tc.getBytes());
        byte[] result = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            sb.append(String.format("%02x", b));
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
