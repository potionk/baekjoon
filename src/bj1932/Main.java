package bj1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] sum = new int[num][num];
        // root
        sum[0][0] = Integer.parseInt(br.readLine());
        for (int i = 0; i < num - 1; i++) {
            String[] input = br.readLine().split(" ");
            int[] inputInt = new int[input.length];
            for (int j = 0; j < inputInt.length; j++) {
                inputInt[j] = Integer.parseInt(input[j]);
            }
            for (int j = 0; j < i + 1; j++) {
                int left=inputInt[j] + sum[i][j];
                int right=inputInt[j+1] + sum[i][j];
                if(sum[i+1][j]>0&&sum[i+1][j]<left||sum[i+1][j]==0)
                    sum[i+1][j] = left;
                if(sum[i+1][j+1]>0&&sum[i+1][j+1]<right||sum[i+1][j+1]==0)
                    sum[i+1][j+1] = right;
            }
        }
        Arrays.sort(sum[num-1]);
        System.out.println(sum[num-1][num-1]);
    }
}