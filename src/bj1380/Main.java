package bj1380;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int scenarioIdx = 1;
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            String[] students = new String[num];
            for (int i = 0; i < num; i++) {
                students[i] = br.readLine();
            }
            boolean[] isImpound = new boolean[num];
            for (int i = 0; i < num * 2 - 1; i++) {
                String[] tc = br.readLine().split(" ");
                int idx = Integer.parseInt(tc[0]) - 1;
                isImpound[idx] = !isImpound[idx];
            }
            for (int i = 0; i < num; i++) {
                if (isImpound[i]) {
                    System.out.println(scenarioIdx++ + " " + students[i]);
                }
            }
        }
    }
}
