package bj7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Main {
    static Set<Long> queue;
    static Map<Long, Integer> count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        count=new HashMap<>();
        for(int i=0; i<testCase; i++){
            queue=new HashSet<>();
            int cmdSize= Integer.parseInt(br.readLine());
            for(int j=0; j<cmdSize; j++){
                String[] input=br.readLine().split(" ");
                if(input[0].equals("I")){
                    insert(Long.parseLong(input[1]));
                } else if(input[0].equals("D")){
                    if(Integer.parseInt(input[1])==-1)
                        delete(true);
                    else
                        delete(false);
                }
            }
            if(queue.size()==0)
                System.out.println("EMPTY");
            else
                System.out.println(getMax()+" "+getMin());
        }

    }
    public static void insert(long x){
        if(count.get(x)==null){
            queue.add(x);
            count.put(x, 1);
        }
        else {
            count.put(x, count.get(x)+1);
        }
    }
    public static void delete(boolean isMin){
        if(queue.size()<=0)
            return;
        if(isMin){
            long minData=getMin();
            if(count.get(minData)==1){
                queue.remove(minData);
                count.remove(minData);
            }
            else{
                count.put(minData, count.get(minData)-1);
            }
        }
        else{
            long maxData=getMax();
            if(count.get(maxData)==1){
                queue.remove(maxData);
                count.remove(maxData);
            }
            else
                count.put(maxData, count.get(maxData)-1);
        }
    }
    public static long getMin(){
        return Collections.min(queue);
    }

    public static long getMax(){
        return Collections.max(queue);
    }
}