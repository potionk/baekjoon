package bj10101;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] angles = new int[3];
        int total = 0;
        for (int i = 0; i < 3; i++) {
            angles[i] = Integer.parseInt(br.readLine());
            total += angles[i];
        }
        if (total != 180) {
            System.out.println("Error");
        } else {
            Arrays.sort(angles);
            if (angles[0] == angles[1]) {
                if (angles[1] == 60) {
                    System.out.println("Equilateral");
                } else {
                    System.out.println("Isosceles");
                }
            } else if (angles[1] == angles[2]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}