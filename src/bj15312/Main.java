package bj15312;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] numberOfStroke = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        String jongmin = br.readLine();
        String she = br.readLine();
        int[] arr = new int[jongmin.length() + she.length()];
        for (int i = 0; i < arr.length; i += 2) {
            arr[i] = numberOfStroke[jongmin.charAt(i / 2) - 'A'];
            arr[i + 1] = numberOfStroke[she.charAt(i / 2) - 'A'];
        }
        for (int i = arr.length; i > 2; i--) {
            for (int j = 0; j < i - 1; j++) {
                arr[j] = (arr[j] + arr[j + 1]) % 10;
            }
        }
        bw.write((arr[0] % 10 + "") + (arr[1] % 10));
        br.close();
        bw.close();
    }
}
