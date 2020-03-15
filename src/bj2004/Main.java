package bj2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int twoCount, fiveCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        int n = Integer.parseInt(testCase[0]);
        int m = Integer.parseInt(testCase[1]);
        twoCount = 0;
        fiveCount = 0;
        calFiveCount(n, true);
        calTwoCount(n, true);
        calFiveCount(m, false);
        calTwoCount(m, false);
        calFiveCount(n-m, false);
        calTwoCount(n-m, false);
        if(twoCount>=fiveCount)
            System.out.println(fiveCount);
        else if(fiveCount<0||twoCount<0)
            System.out.println(0);
        else
            System.out.println(twoCount);
    }

    public static void calFiveCount(int input, boolean mode) {
        for (long i = 2; input / i >= 1; i *= 2)
            if(mode)
                fiveCount += input / i;
            else
                fiveCount -= input / i;
    }

    public static void calTwoCount(int input, boolean mode) {
        for (long i = 5; input / i >= 1; i *= 5){
            if(mode)
                twoCount += input / i;
            else
                twoCount -= input / i;
        }
    }
}