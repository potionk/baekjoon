package bj1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        double X = Double.parseDouble(testCase[0]);
        double Y = Double.parseDouble(testCase[1]);
        int Z = (int) (Y * 100 / X);
        if (Z == 100 || Z == 99) {
            System.out.println(-1);
        } else {
            int low = 0;
            int high = 1000000000;
            int result = 0;
            while (low <= high) {
                int mid = (high + low) / 2;
                int Zz = ((int) (((Y + mid) * 100) / (X + mid)));
                if(Z>=Zz){
                    result=mid+1;
                    low=mid+1;
                } else {
                    high=mid-1;
                }
            }
            System.out.println(result);
        }
    }
}
