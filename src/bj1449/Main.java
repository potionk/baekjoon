package bj1449;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inn=br.readLine();
        String input[] = br.readLine().split(" ");
        String in[] = br.readLine().split(" ");
        int itg[]=new int[in.length];
        for(int i=0; i<in.length; i++){
            itg[i]=Integer.parseInt(in[i]);
        }
        Arrays.sort(itg);

        int result = itg.length;
        int count=0;
        for (int j = 0; j < itg.length - 1; j++) {
            for (int k = j + 1; k < in.length; k++) {
                if (((itg[k]) - itg[j]) < Integer.parseInt(input[1])) {
                    count++;
                    --result;
                } else
                    break;
            }
            j+=count;
            count=0;
        }
        System.out.println(result);
    }
}