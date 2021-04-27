package bj10610;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();
        int result = 0;
        int NLen = N.length();
        List<Integer> resultList = new LinkedList<>();
        boolean isExistZero = false;
        for (int i = 0; i < NLen; i++) {
            char c = N.charAt(i);
            int num = c - '0';
            if (c == '0') {
                isExistZero = true;
            } else {
                result += num;
            }
            resultList.add(num);
        }
        if (isExistZero && result % 3 == 0) {
            resultList.sort(Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for (int i : resultList) {
                sb.append(i);
            }
            bw.write(sb.toString());
        } else {
            bw.write("-1");
        }
        br.close();
        bw.close();
    }
}