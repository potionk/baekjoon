package bj6764;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] fishMoving = new int[4];
        for (int i = 0; i < 4; i++) {
            fishMoving[i] = Integer.parseInt(br.readLine());
        }
        int height = 0;
        boolean isMoving = false;
        for (int i = 1; i < 4; i++) {
            if (fishMoving[i] > fishMoving[i - 1]) {
                height++;
                isMoving = true;
            } else if (fishMoving[i] < fishMoving[i - 1]) {
                height--;
                isMoving = true;
            }
        }
        if (height == 3) {
            bw.write("Fish Rising");
        } else if (height == -3) {
            bw.write("Fish Diving");
        } else if (height == 0 && !isMoving) {
            bw.write("Fish At Constant Depth");
        } else {
            bw.write("No Fish");
        }
        br.close();
        bw.close();
    }
}
