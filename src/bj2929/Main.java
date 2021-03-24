package bj2929;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String code = br.readLine();
        int len = code.length();
        List<Integer> upperCaseIdxList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (isUpperCase(code.charAt(i))) {
                upperCaseIdxList.add(i);
            }
        }
        int upperCaseSize = upperCaseIdxList.size();
        if (upperCaseSize == 1) {
            bw.write("0");
        } else {
            int result = 0;
            for (int i = 1; i < upperCaseSize; i++) {
                int diff = upperCaseIdxList.get(i) - upperCaseIdxList.get(i - 1);
                result += (4 - diff % 4) % 4;
            }
            System.out.println(result + "");
        }
        br.close();
        bw.close();
    }

    public static boolean isUpperCase(char c) {
        return 65 <= c && c <= 90;
    }
}
