package bj10157;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] xy = br.readLine().split(" ");
        int C = Integer.parseInt(xy[0]);
        int R = Integer.parseInt(xy[1]);
        int K = Integer.parseInt(br.readLine());
        int max = C * R;
        if (K > max) {
            bw.write("0");
        } else {
            int[] border = {R + 1, C + 1, 0, 1};
            int count = 1;
            int arrow = 0; // 0: 위, 1: 오른쪽, 2: 아래, 3: 왼쪽
            int x = 1, y = 1;
            while (count <= max) {
                if (count == K) {
                    bw.write(x + " " + y);
                    break;
                }
                switch (arrow) {
                    case 0 -> {
                        if (y + 1 < border[arrow]) {
                            y++;
                        } else {
                            x++;
                            border[arrow]--;
                            arrow = (arrow + 1) % 4;
                        }
                    }
                    case 1 -> {
                        if (x + 1 < border[arrow]) {
                            x++;
                        } else {
                            y--;
                            border[arrow]--;
                            arrow = (arrow + 1) % 4;
                        }
                    }
                    case 2 -> {
                        if (y - 1 > border[arrow]) {
                            y--;
                        } else {
                            x--;
                            border[arrow]++;
                            arrow = (arrow + 1) % 4;
                        }
                    }
                    case 3 -> {
                        if (x - 1 > border[arrow]) {
                            x--;
                        } else {
                            y++;
                            border[arrow]++;
                            arrow = (arrow + 1) % 4;
                        }
                    }
                }
                count++;
            }
        }
        br.close();
        bw.close();
    }
}
