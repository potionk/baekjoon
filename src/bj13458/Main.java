package bj13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        double[] taker=new double[N];
        String[] takerStr=br.readLine().split(" ");
        for(int i=0; i<N; i++){
            taker[i]= Double.parseDouble(takerStr[i]);
        }
        String[] max=br.readLine().split(" ");
        int mainMax= Integer.parseInt(max[0]);
        int subMax= Integer.parseInt(max[1]);
        long total=0;
        for(int i=0; i<N; i++){
            taker[i]-=mainMax;
            total++;
            taker[i]/=subMax;
            if(taker[i]>0)
                total+=(int)Math.ceil(taker[i]);
        }
        System.out.println(total);
    }
}
