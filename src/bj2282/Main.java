package bj2282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] beforeSort=new int[8];
        int[] targetIndex=new int[5];
        Map<Integer,Integer> saveIndex=new HashMap<>();
        int total=0;
        for(int i=0; i<8; i++){
            beforeSort[i]=Integer.parseInt(br.readLine());
            saveIndex.put(beforeSort[i],i);
        }
        Arrays.sort(beforeSort);
        for(int i=0; i<5; i++){
            int score=beforeSort[7-i];
            targetIndex[i]=saveIndex.get(score);
            total+=score;
        }
        System.out.println(total);
        Arrays.sort(targetIndex);
        for(int i=0; i<5; i++){
            System.out.print(targetIndex[i]+1+" ");
        }
    }
}