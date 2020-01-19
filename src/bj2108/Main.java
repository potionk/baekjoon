package bj2108;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,Integer> countMap=new HashMap<>();
        int size = Integer.parseInt(br.readLine());
        List<Integer> list=new LinkedList<>();
        for(int i=0; i<size; i++)
            list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);
        Object[] list2Array=list.toArray();
        int total=0;
        for(int i=0; i<list2Array.length; i++){
            total+=(int)list2Array[i];
            if(countMap.get((int)list2Array[i])==null){
                countMap.put((int)list2Array[i],1);
            } else {
                countMap.put((int)list2Array[i],countMap.get((int)list2Array[i])+1);
            }
        }
        int max=-1;
        int maxValue=-1;
        boolean isTwo=false;
        int[] keys=new int[countMap.size()];
        int index=0;
        for (int key : countMap.keySet()) {
            keys[index++]=key;
        }
        Arrays.sort(keys);
        for(int i=0; i<keys.length; i++){
            int c=countMap.get(keys[i]);
            if(c>max){
                maxValue=keys[i];
                max=c;
                isTwo=true;
            } else if(isTwo&&c==max){
                maxValue=keys[i];
                isTwo=false;
            }
        }
        System.out.println((int)(Math.round((double)total/(double)size)));
        System.out.println(list2Array[list2Array.length/2]);
        System.out.println(maxValue);
        System.out.println((int)list2Array[list2Array.length-1]-(int)list2Array[0]);
    }
}