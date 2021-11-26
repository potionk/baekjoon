package bj14659;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        int result = -1;
        int count = 0;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < max) {
                result = Math.max(result, count + 1);
                count++;
            } else {
                count = 0;
                max = arr[i];
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
