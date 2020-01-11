package bj1476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int earth= Integer.parseInt(input[0]);
        int sun= Integer.parseInt(input[1]);
        int moon= Integer.parseInt(input[2]);
        int e=1, s=1, m=1;
        int count=1;
        while(true){
            if(earth==e&&sun==s&&moon==m){
                System.out.println(count);
                break;
            } else {
                e++;
                s++;
                m++;
                if(e>15)
                    e=1;
                if(s>28)
                    s=1;
                if(m>19)
                    m=1;
                count++;
            }
        }
    }
}