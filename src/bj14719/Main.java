package bj14719;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int[] back;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int width = Integer.parseInt(size[1]);
        back = new int[width];
        int total = 0;
        String[] info = br.readLine().split(" ");
        for (int j = 0; j < width; j++) {
            back[j] += Integer.parseInt(info[j]);
            total += back[j];
        }
        rain(width - 1);
        int result = 0;
        for (int i = 0; i < width; i++) {
            result += back[i];
        }
        System.out.println(result - total);
    }

    private static void rain(int finish) {
        for (int i = 0; i <= finish - 2; i++) {
            for (int j = i + 2; j <= finish; j++) {
                int targetHeight = Math.min(back[i], back[j]);
                for (int k = i + 1; k < j; k++) {
                    back[k] = Math.max(targetHeight, back[k]);
                }
            }
        }
    }
}