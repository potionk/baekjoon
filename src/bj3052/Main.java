package bj3052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,Integer> hashmap=new HashMap<>();
        for(int i=0; i<10; i++){
            int input = Integer.parseInt(br.readLine());
            hashmap.put(input%42,0);
        }
        System.out.println(hashmap.size());
    }
}