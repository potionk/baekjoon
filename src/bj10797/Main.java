package bj10797;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        String day=br.readLine();
        String[] cars=br.readLine().split(" ");
        for(int i=0; i<cars.length; i++){
            if(cars[i].equals(day))
                count++;
        }
        System.out.println(count);
    }
}