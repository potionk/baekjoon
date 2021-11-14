package bj11508;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] milkProducts = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            milkProducts[i] = Integer.parseInt(br.readLine());
            result += milkProducts[i];
        }
        Arrays.sort(milkProducts);
        for (int i = n - 1; i - 2 >= 0; i -= 3) {
            result -= milkProducts[i - 2];
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
