package bj20233;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int aDayCost = (T - 30) * x;
        int bDayCost = (T - 45) * y;
        if (aDayCost < 0) {
            aDayCost = 0;
        }
        if (bDayCost < 0) {
            bDayCost = 0;
        }
        bw.write((a + aDayCost * 21) + " " + ((b + bDayCost * 21)));
        br.close();
        bw.close();
    }
}
