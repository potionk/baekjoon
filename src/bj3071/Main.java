package bj3071;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        while (tcNum-- > 0) {
            int tc = Integer.parseInt(br.readLine());
            bw.write(calHeartSystem(tc, tc > 0) + "\n");
        }
        br.close();
        bw.close();
    }

    public static String calHeartSystem(int tc, boolean isPositive) {
        StringBuilder sb = new StringBuilder();
        if (isPositive) {
            tc++;
            while (tc >= 3) {
                sb.insert(0, convertMinusOne(tc % 3, true));
                tc /= 3;
                tc++;
            }
            sb.insert(0, convertMinusOne(tc, true));
        } else {
            tc--;
            while (tc <= -3) {
                sb.insert(0, convertMinusOne(tc % -3, false));
                tc /= 3;
                tc--;
            }
            sb.insert(0, convertMinusOne(tc, false));
        }
        return sb.toString();
    }

    public static char convertMinusOne(int i, boolean isPositive) {
        if (isPositive) {
            return switch (i) {
                case 2 -> '1';
                case 1 -> '0';
                case 0 -> '-';
                default -> ' ';
            };
        } else {
            return switch (i) {
                case 0 -> '1';
                case -1 -> '0';
                case -2 -> '-';
                default -> ' ';
            };
        }
    }
}
