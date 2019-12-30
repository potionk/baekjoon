package bj4344;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        for(int i=0; i<size; i++){
            String input[] = br.readLine().split(" ");
            int count=0;
            int total=0;
            for(int j=1; j<=Integer.parseInt(input[0]); j++){
                total+=Integer.parseInt(input[j]);
            }
            double av=(double)total/Double.parseDouble(input[0]);
            for(int j=1; j<=Integer.parseInt(input[0]); j++){
                if(av<Integer.parseInt(input[j]))
                    count++;
            }
            System.out.println(String.format("%.3f", ((double)count/Double.parseDouble(input[0]))*100)+"%");
        }
    }
}