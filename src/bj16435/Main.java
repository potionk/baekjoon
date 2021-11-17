package bj16435;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nl = br.readLine().split(" ");
        int n = Integer.parseInt(nl[0]);
        int l = Integer.parseInt(nl[1]);
        String[] fruitsStr = br.readLine().split(" ");
        int[] fruits = new int[n];
        for (int i = 0; i < n; i++) {
            fruits[i] = Integer.parseInt(fruitsStr[i]);
        }
        Arrays.sort(fruits);
        for (int i = 0; i < n; i++) {
            if (fruits[i] <= l) {
                l++;
            } else {
                break;
            }
        }
        bw.write(l + "");
        br.close();
        bw.close();
    }
}
