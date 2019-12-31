package bj11651;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        List<Integer> yList=new LinkedList<>();
        Map<Integer,LinkedList<Integer>> y2x=new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numbers = Integer.parseInt(br.readLine());
        for(int i=0; i<numbers; i++){
            String[] input=br.readLine().split(" ");
            int x=Integer.parseInt(input[0]);
            int y=Integer.parseInt(input[1]);
            yList.add(y);
            if(y2x.get(y)==null){
                LinkedList<Integer> list=new LinkedList<>();
                list.add(x);
                y2x.put(y,list);
            } else {
                LinkedList<Integer> list=y2x.get(y);
                list.add(x);
                y2x.put(y,list);
            }
        }
        Collections.sort(yList);
        Object[] yArray=yList.toArray();
        int recentSearch=0;
        for(int i=0; i<yArray.length; i++){
            int y = (int) yArray[i];
            if(y==recentSearch)
                continue;
            else
                recentSearch=y;
            LinkedList<Integer> x=y2x.get(y);
            if(x.size()!=1)
                Collections.sort(x);
            for(int j=0; j<x.size(); j++){
                bw.write(x.get(j)+" "+y+"\n");
                bw.flush();
            }
        }
        bw.close();
    }
}