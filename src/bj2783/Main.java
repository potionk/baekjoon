package bj2783;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] seven25=br.readLine().split(" ");
        int testCase= Integer.parseInt(br.readLine());
        double[] price=new double[testCase+1];
        int index=0;
        price[index++]=Double.parseDouble(seven25[0])/Double.parseDouble(seven25[1]);
        for(int i=0; i<testCase; i++){
            String[] other=br.readLine().split(" ");
            price[index++]=Double.parseDouble(other[0])/Double.parseDouble(other[1]);
        }
        Arrays.sort(price);
        System.out.println(String.format("%.2f", price[0]*1000));
    }
}