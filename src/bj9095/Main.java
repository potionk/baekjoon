package bj9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,List> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        list.add("1");
        map.put(1,list);
        list=new ArrayList<>();
        list.add("1,1");
        list.add("2");
        map.put(2,list);
        list=new ArrayList<>();
        list.add("1,1,1");
        list.add("2,1");
        list.add("1,2");
        list.add("3");
        map.put(3,list);

        for(int i=4; i<=11; i++){
            list=new ArrayList<>();
            for(int j=0; j<map.get(i-1).size(); j++){
                list.add("1,"+map.get(i-1).get(j));
                list.add(map.get(i-1).get(j)+",1");
            }

            for(int j=0; j<map.get(i-2).size(); j++){
                list.add("2,"+map.get(i-2).get(j));
                list.add(map.get(i-2).get(j)+",2");
            }

            for(int j=0; j<map.get(i-3).size(); j++){
                list.add("3,"+map.get(i-3).get(j));
                list.add(map.get(i-3).get(j)+",3");
            }

            for(int j=0, listLength=list.size(); j<listLength; j++){
                for(int k=j+1, len=listLength; k<len; k++){
                    if(list.get(j).equals(list.get(k))){
                        list.remove(k);
                        k--;
                        len--;
                        listLength--;
                    }
                }
            }
            map.put(i,list);
        }
        int count=Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            int findTarget=Integer.parseInt(br.readLine());
            System.out.println(map.get(findTarget).size());
        }
    }
}