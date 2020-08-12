package bj1373;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> binToOctal = new HashMap<String, String>() {{
            put("000", "0");
            put("001", "1");
            put("010", "2");
            put("011", "3");
            put("100", "4");
            put("101", "5");
            put("110", "6");
            put("111", "7");
        }};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tc = br.readLine();
        int tcLen = tc.length();
        if (tc.length() % 3 == 1) {
            tc = "00" + tc;
            tcLen += 2;
        } else if (tc.length() % 3 == 2) {
            tc = "0" + tc;
            tcLen += 1;
        }

        for (int i = 0; i < tcLen; i += 3) {
            bw.write(binToOctal.get(tc.substring(i, i + 3)));
        }
        bw.flush();
    }
}
