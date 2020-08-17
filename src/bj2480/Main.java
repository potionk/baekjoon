package bj2480;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] diceLogStr = br.readLine().split(" ");
        int[] diceLog = new int[3];
        for (int i = 0; i < 3; i++) {
            diceLog[i] = Integer.parseInt(diceLogStr[i]);
        }
        Arrays.sort(diceLog);
        if (diceLog[0] == diceLog[1]) {
            if (diceLog[1] == diceLog[2]) {
                System.out.println(10000 + diceLog[0] * 1000);
            } else {
                System.out.println(1000 + diceLog[0] * 100);
            }
        } else if (diceLog[1] == diceLog[2]) {
            System.out.println(1000 + diceLog[1] * 100);
        } else {
            System.out.println(diceLog[2] * 100);
        }
    }
}