package bj8989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] testData = br.readLine().split(" ");
            ClockTime[] clockTime = new ClockTime[5];
            for (int j = 0; j < 5; j++) {
                String[] time = testData[j].split(":");
                clockTime[j] = new ClockTime(Integer.parseInt(time[0]), Integer.parseInt(time[1]));
            }
            Arrays.sort(clockTime);
            int hour = clockTime[2].getHour();
            int min = clockTime[2].getMin();
            System.out.println((hour < 10 ? "0" + hour : hour) + ":" + (min < 10 ? "0" + min : min));
        }
    }
}

class ClockTime implements Comparable<ClockTime> {
    int hour;
    int min;

    public int getAngle() {
        return angle;
    }

    int angle;

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public ClockTime(int hour, int min) {
        this.hour = hour;
        this.min = min;
        int aHour = hour % 12;
        int cal = Math.abs((60 * aHour + min) - min * 12);
        this.angle = cal > 360 ? 720 - cal : cal;
    }

    @Override
    public int compareTo(ClockTime o) {
        return Integer.compare(this.getAngle(), o.getAngle());
    }
}