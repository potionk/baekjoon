package bj11006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++) {
            String[] read = br.readLine().split(" ");
            int legs = Integer.parseInt(read[0]);
            int chicken = Integer.parseInt(read[1]);
            int unnorChic = chicken*2-legs;
            int norChic = chicken-unnorChic;
            System.out.println(unnorChic+" "+norChic);
        }
    }
}