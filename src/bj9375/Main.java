package bj9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> closet=new HashMap<>();
        int num = Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++){
            int result=1;
            int clothes=Integer.parseInt(br.readLine());
            for(int j=0; j<clothes; j++){
                String[] readClothes=br.readLine().split(" ");
                String clothesClass=readClothes[1];
                if(closet.get(clothesClass)==null){
                    closet.put(clothesClass,1);
                } else {
                    int res=closet.get(clothesClass);
                    closet.put(clothesClass,++res);
                }
            }
            for (String key : closet.keySet()) {
                result*=closet.get(key)+1;
            }
            System.out.println(result-1);
            closet.clear();
        }
    }
}