package bj1296;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String minsik = br.readLine();
        int[] minsikLove = countLove(minsik);
        int womenNum = Integer.parseInt(br.readLine());
        String[] women = new String[womenNum];
        int max = Integer.MIN_VALUE;
        String result = "";
        for (int i = 0; i < womenNum; i++) {
            women[i] = br.readLine();
        }
        Arrays.sort(women);
        for (int i = 0; i < womenNum; i++) {
            int love = calLove(minsikLove, countLove(women[i]));
            if (love > max) {
                max = love;
                result = women[i];
            }
        }
        System.out.println(result);
    }

    public static int[] countLove(String name) {
        int size = name.length();
        int[] count = new int[4];
        for (int i = 0; i < size; i++) {
            switch (name.charAt(i)) {
                case 'L':
                    count[0]++;
                    break;
                case 'O':
                    count[1]++;
                    break;
                case 'V':
                    count[2]++;
                    break;
                case 'E':
                    count[3]++;
                    break;
            }
        }
        return count;
    }

    public static int calLove(int[] minsik, int[] woman) {
        int[] total = new int[4];
        for (int i = 0; i < 4; i++) {
            total[i] = minsik[i] + woman[i];
        }
        int result = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                result *= total[i] + total[j];
            }
        }
        return result % 100;
    }
}
