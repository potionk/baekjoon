package bj10984;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            int classes = Integer.parseInt(br.readLine());
            int credit=0;
            double grade=0;
            for(int j=0; j<classes; j++){
                String[] data=br.readLine().split(" ");
                credit+= Integer.parseInt(data[0]);
                grade+= Double.parseDouble(data[0])*Double.parseDouble(data[1]);
            }
            grade=Math.round(grade/credit*10.0)/10.0;
            System.out.println(credit+" "+grade);
        }
    }
}