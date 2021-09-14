package bj3107;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipv6 = br.readLine().split(":");
        String[] originalIpv6 = new String[8];
        if (ipv6[0].equals("") && ipv6[1].equals("")) {
            ipv6 = Arrays.copyOfRange(ipv6, 1, ipv6.length);
        }
        for (int i = 0, inputIdx = 0; i < ipv6.length; i++, inputIdx++) {
            if (!ipv6[i].equals("")) {
                originalIpv6[inputIdx] = ipv6[i];
            } else {
                inputIdx += 8 - ipv6.length;
            }
        }
        for (int i = 0; i < 8; i++) {
            originalIpv6[i] = restoreZero(originalIpv6[i]);
        }
        for (int i = 0; i < 7; i++) {
            bw.write(originalIpv6[i] + ":");
        }
        bw.write(originalIpv6[7]);
        br.close();
        bw.close();
    }


    public static String restoreZero(String s) {
        if (s == null) {
            return "0000";
        }
        int sLen = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4 - sLen; i++) {
            sb.insert(0, "0");
        }
        sb.append(s);
        return sb.toString();
    }
}
