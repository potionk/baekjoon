package bj10431;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int P = Integer.parseInt(br.readLine());
        while (P-- > 0) {
            String[] tc = br.readLine().split(" ");
            int tcNum = Integer.parseInt(tc[0]);
            int count = 0;
            int[] students = new int[20];
            for (int i = 0; i < students.length; i++) {
                students[i] = Integer.parseInt(tc[i + 1]);
            }
            for (int i = 1; i < 20; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = i - 1; j >= 0; j--) {
                    if (students[i] < students[j]) {
                        min = Math.min(min, j);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    int temp = students[i];
                    for (int k = i - 1; k >= min; k--) {
                        students[k + 1] = students[k];
                        count++;
                    }
                    students[min] = temp;
                }
            }
            bw.write(tcNum + " " + count + "\n");
        }
        br.close();
        bw.close();
    }
}
