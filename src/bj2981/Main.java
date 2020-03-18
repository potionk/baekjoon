package bj2981;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        int[] data=new int[testCase];
        for(int i=0; i<testCase; i++){
            data[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(data);
        int gcd = data[1]-data[0];
        for(int i=2; i<testCase; i++){
            gcd = euclidean(gcd, data[i]-data[i-1]);
        }
        HashMap<Integer,Integer> map=calAliquot(gcd);
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(int a:list)
            System.out.print(a+" ");
    }
    public static int euclidean(int a, int b){
        if(a%b==0)
            return b;
        else
            return euclidean(b,a%b);
    }
    public static HashMap<Integer, Integer> calAliquot(int a){
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(a,1);
        for(int i=2; i<=Math.sqrt(a); i++){
            if(a%i==0){
                map.put(i,1);
                map.put(a/i,1);
            }
        }
        return map;
    }
}