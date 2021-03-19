package bj15080;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] aTime = br.readLine().split(" : ");
        String[] bTime = br.readLine().split(" : ");
        int a = Integer.parseInt(aTime[0]) * 3600 + Integer.parseInt(aTime[1]) * 60 + Integer.parseInt(aTime[2]);
        int b = Integer.parseInt(bTime[0]) * 3600 + Integer.parseInt(bTime[1]) * 60 + Integer.parseInt(bTime[2]);
        b += 24 * 3600;
        int result = Math.abs(a - b);
        if (result > 24 * 3600) {
            result -= 24 * 3600;
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}