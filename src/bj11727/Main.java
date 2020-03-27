package bj11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] tile;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input=Integer.parseInt(br.readLine());
        tile =new long[input+2];
        dp(input+1);
        System.out.println(tile[input+1]);
    }
    public static void dp(int max) {
        tile[0] = 0;
        tile[1] = 1;
        for (int i=2; i<=max; i++) {
            tile[i]=(tile[i-1]+ tile[i-2]*2)%10007;
        }
    }
}