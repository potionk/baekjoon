package bj14405;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = br.readLine().toCharArray();
        boolean isError = false;
        for (int i = 0; i < input.length; i++) {
            int nextIdx = sectionCheck(input, i);
            if (nextIdx == -1) {
                bw.write("NO");
                isError = true;
                break;
            } else {
                i += nextIdx;
            }
        }
        if (!isError) {
            bw.write("YES");
        }
        br.close();
        bw.close();
    }

    public static int sectionCheck(char[] input, int startIdx) {
        char[][] expectancy = {{'i'}, {'a'}, {'h', 'u'}};
        int idx = -1;
        switch (input[startIdx]) {
            case 'p' -> idx = 0;
            case 'k' -> idx = 1;
            case 'c' -> idx = 2;
        }
        if (idx != -1 && startIdx + expectancy[idx].length < input.length) {
            for (int i = 1; i <= expectancy[idx].length; i++) {
                if (input[startIdx + i] != expectancy[idx][i - 1]) {
                    return -1;
                }
            }
            return expectancy[idx].length;
        } else {
            return -1;
        }
    }
}
