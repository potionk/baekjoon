package bj1159;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        Map<Character, Integer> player=new HashMap<>();
        for(int i=0; i<num; i++){
            char[] input=br.readLine().toCharArray();
            player.merge(input[0], 1, Integer::sum);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=97; i<97+26; i++){
            if(player.get((char)i)!=null&&player.get((char)i)>=5)
                sb.append((char)i);
        }
        if(!sb.toString().equals("")){
            System.out.println(sb.toString());
        } else
            System.out.println("PREDAJA");

    }
}