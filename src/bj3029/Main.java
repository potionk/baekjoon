package bj3029;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int currentTime = timeToSec(br.readLine().split(":"));
        int bombTime = timeToSec(br.readLine().split(":"));
        if (bombTime <= currentTime) {
            bombTime += 24 * 60 * 60;
        }
        bombTime -= currentTime;
        bw.write(secToTime(bombTime));
        br.close();
        bw.close();
    }

    public static int timeToSec(String[] time) {
        return Integer.parseInt(time[0]) * 60 * 60 + Integer.parseInt(time[1]) * 60 + Integer.parseInt(time[2]);
    }

    public static String secToTime(int time) {
        StringBuilder sb = new StringBuilder();
        sb.append(unifyFormat(time / 3600)).append(":");
        time %= 3600;
        sb.append(unifyFormat(time / 60)).append(":");
        time %= 60;
        sb.append(unifyFormat(time));
        return sb.toString();
    }

    public static String unifyFormat(int input) {
        if (input < 10) {
            return "0" + input;
        } else {
            return input + "";
        }
    }
}
