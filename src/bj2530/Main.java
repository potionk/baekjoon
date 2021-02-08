package bj2530;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] curTime = br.readLine().split(" ");
        int ovenTime = Integer.parseInt(br.readLine());
        int curHour = Integer.parseInt(curTime[0]);
        int curMin = Integer.parseInt(curTime[1]);
        int curSec = Integer.parseInt(curTime[2]);
        curSec += curMin * 60 + curHour * 3600 + ovenTime;
        curHour = (curSec / 3600) % 24;
        curSec -= (curSec / 3600) * 3600;
        curMin = (curSec / 60) % 60;
        curSec -= (curSec / 60) * 60;
        bw.write(curHour + " " + curMin + " " + curSec);
        bw.close();
        br.close();
    }
}