package bj3273;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] readLine = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());
        int count = 0;
        int[] aArr = new int[n];
        for (int i = 0; i < n; i++) {
            aArr[i] = Integer.parseInt(readLine[i]);
        }
        Arrays.sort(aArr);
        int start = 0, finish = n - 1, total = aArr[start] + aArr[finish];
        while (start < finish) {
            if (total == x) {
                count++;
            }
            if (total <= x) {
                total -= aArr[start];
                start++;
                total += aArr[start];
            } else {
                total -= aArr[finish];
                finish--;
                total += aArr[finish];
            }
        }
        bw.write(count + "");
        br.close();
        bw.close();
    }
}
