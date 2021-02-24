package bj5575;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = 3;
        while (tc-- > 0) {
            String[] info = br.readLine().split(" ");
            int workingTime = timeToSec(Integer.parseInt(info[3]), Integer.parseInt(info[4]), Integer.parseInt(info[5])) - timeToSec(Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2]));
            bw.write(secToTime(workingTime) + "\n");
        }
        br.close();
        bw.close();
    }

    public static int timeToSec(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

    public static String secToTime(int s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s / 3600).append(" ");
        s -= s / 3600 * 3600;
        sb.append(s / 60).append(" ");
        s -= s / 60 * 60;
        sb.append(s);
        return sb.toString();
    }
}