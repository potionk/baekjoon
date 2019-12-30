package bj2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list=new LinkedList<>();
        int total=0;
        int min = Integer.parseInt(br.readLine());
        int max = Integer.parseInt(br.readLine());
        for(int i=min; i<=max; i++){
            boolean isPrimeNum = true;
            for (int k = 2; k < i; k++) {
                if (i % k == 0) {
                    isPrimeNum = false;
                    break;
                }
            }
            if (i!=1&&isPrimeNum) {
                total += i;
                list.add(i);
            }
        }
        if(total==0)
            System.out.println(-1);
        else {
            System.out.println(total);
            Collections.sort(list);
            System.out.println(list.get(0));
        }
    }
}