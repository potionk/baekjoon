package bj8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list=new ArrayList<>();
        Map<Integer,String> hashmap=new HashMap<>();
        String input[] = br.readLine().split(" ");
        for(int i=0; i<Integer.parseInt(input[0]); i++){
            String prize= br.readLine();
            String prizeSplit[]=prize.split(" ");
            if(list.size()==0){
                list.add(prize);
            }
            else{
                int index=0;
                for(int j=0; j<list.size(); j++){
                    String loadData[]=list.get(j).split(" ");
                    if(Integer.parseInt(loadData[1])<=Integer.parseInt(prizeSplit[1])){
                        if(Integer.parseInt(loadData[1])==Integer.parseInt(prizeSplit[1])){
                            if(Integer.parseInt(loadData[2])<=Integer.parseInt(prizeSplit[2])){
                                if(Integer.parseInt(loadData[2])==Integer.parseInt(prizeSplit[2])){
                                    if(Integer.parseInt(loadData[3])<Integer.parseInt(prizeSplit[3])){
                                        index=j;
                                        break;
                                    }
                                }
                                else{
                                    index=j;
                                    break;
                                }

                            }
                        }
                        else{
                            index=j;
                            break;
                        }
                    }
                    index=list.size();
                }
                list.add(index,prize);
            }
        }
        int tempidx=0;
        for(int i=0; i<list.size(); i++){
            String data[]=list.get(i).split(" ");
            tempidx=i;
            hashmap.put(Integer.parseInt(data[0]),(i+1)+" "+list.get(i));
            while(i+1<list.size()&&((list.get(i).split(" "))[1]+(list.get(i).split(" "))[2]+(list.get(i).split(" "))[3]).equals(((list.get(i+1).split(" "))[1]+(list.get(i+1).split(" "))[2]+(list.get(i+1).split(" "))[3]))){
                String nextData[]=list.get(i+1).split(" ");
                hashmap.put(Integer.parseInt(nextData[0]),(tempidx+1)+" "+list.get(++i));
            }
        }
        String res[]=hashmap.get(Integer.parseInt(input[1])).split(" ");
        System.out.println(res[0]);
    }
}
