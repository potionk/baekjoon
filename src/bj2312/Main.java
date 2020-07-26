package bj2312;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Integer, Integer> count;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        for(int i=0; i<tcNum; i++){
            int tc = Integer.parseInt(br.readLine());
            count=new HashMap<>();
            total=0;
            sb(tc);
            int insu=2;
            while(total!=0){
                if(count.get(insu)!=null){
                    bw.write(insu+" "+count.get(insu)+"\n");
                    total-=count.get(insu);
                }
                insu++;
            }
        }
        bw.flush();
    }

    public static int sb(int a) {
        if (a == 1)
            return 1;
        int i = 2;
        while (a % i != 0) {
            i++;
        }
        if (count.get(i) == null) {
            count.put(i, 1);
            total++;
        } else {
            count.put(i, count.get(i) + 1);
            total++;
        }
        return sb(a / i);
    }
}