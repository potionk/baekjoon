package bj9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, LinkedList<String>> closet=new HashMap<>();
        int num = Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++){
            int result=0;
            int clothes=Integer.parseInt(br.readLine());
            for(int j=0; j<clothes; j++){
                String[] readClothes=br.readLine().split(" ");
                String clothesName=readClothes[0];
                String clothesClass=readClothes[1];
                if(closet.get(clothesClass)==null){
                    LinkedList<String> list=new LinkedList<>();
                    list.add(clothesName);
                    closet.put(clothesClass,list);
                } else {
                    LinkedList<String> list=closet.get(clothesClass);
                    list.add(clothesName);
                    closet.put(clothesClass,list);
                }
            }
            for(int j=1; j<closet.size(); j++){

            }
            result+=closet.size();
            System.out.println(result);
            closet.clear();
        }
    }
}

/*
2
3
hat headgear
sunglasses eyewear
turban headgear
3
mask face
sunglasses face
makeup face
 */