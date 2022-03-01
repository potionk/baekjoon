package bj2852;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int aScore = 0, bScore = 0;
        int aWinTime = 0, bWinTime = 0;
        int aGoalTime = -1, bGoalTime = -1;
        for (int i = 0; i <= tc; i++) {
            String[] info;
            if (i != tc) {
                info = br.readLine().split(" ");
            } else {
                info = new String[]{"48:00"};
            }
            if (info[0].equals("1")) {
                aScore++;
                if (aScore > bScore && aGoalTime == -1) {
                    aGoalTime = timeToSec(info[1]);
                }
                if (aScore == bScore) {
                    bWinTime += timeToSec(info[1]) - bGoalTime;
                    bGoalTime = -1;
                }
            } else if (info[0].equals("2")) {
                bScore++;
                if (bScore > aScore && bGoalTime == -1) {
                    bGoalTime = timeToSec(info[1]);
                }
                if (aScore == bScore) {
                    aWinTime += timeToSec(info[1]) - aGoalTime;
                    aGoalTime = -1;
                }
            } else {
                if (aScore > bScore) {
                    aWinTime += timeToSec(info[0]) - aGoalTime;
                } else if (aScore < bScore) {
                    bWinTime += timeToSec(info[0]) - bGoalTime;
                }
            }
        }
        bw.write(secToTime(aWinTime) + "\n");
        bw.write(secToTime(bWinTime) + "\n");
        br.close();
        bw.close();
    }

    public static int timeToSec(String s) {
        String[] time = s.split(":");
        int min = Integer.parseInt(time[0]);
        int sec = Integer.parseInt(time[1]);
        return min * 60 + sec;
    }

    public static String secToTime(int sec) {
        return unifyForm(sec / 60) + ":" + unifyForm(sec % 60);
    }

    public static String unifyForm(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return "" + i;
    }
}
