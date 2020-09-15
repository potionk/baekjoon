package bj1544;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcNum = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < tcNum; i++) {
            String str = br.readLine();
            boolean isFind = false;
            if (set.contains(str)) {
                continue;
            } else {
                int strLen = str.length();
                for (int j = 1; j < strLen; j++) {
                    if (set.contains(str.substring(j) + str.substring(0, j))) {
                        isFind = true;
                        break;
                    }
                }
            }
            if (!isFind) {
                set.add(str);
            }
        }
        System.out.println(set.size());
    }
}
