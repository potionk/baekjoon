package bj2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[]=new String[3];
        for(int i=0; i<input.length; i++){
            input[i]=br.readLine();
        }
        int count[]=new int[10];
        int result=Integer.parseInt(input[0])*Integer.parseInt(input[1])*Integer.parseInt(input[2]);
        String r=result+"";
        for(int i=0; i<r.length(); i++){
            switch (r.charAt(i)){
                case '0':
                    count[0]++;
                    break;
                case '1':
                    count[1]++;
                    break;
                case '2':
                    count[2]++;
                    break;
                case '3':
                    count[3]++;
                    break;
                case '4':
                    count[4]++;
                    break;
                case '5':
                    count[5]++;
                    break;
                case '6':
                    count[6]++;
                    break;
                case '7':
                    count[7]++;
                    break;
                case '8':
                    count[8]++;
                    break;
                case '9':
                    count[9]++;
                    break;
            }
        }
        for(int i=0; i<count.length; i++){
            System.out.println(count[i]);
        }
    }
}