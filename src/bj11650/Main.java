package bj11650;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        List<Integer> xList=new LinkedList<>();
        Map<Integer,LinkedList<Integer>> x2y=new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numbers = Integer.parseInt(br.readLine());
        for(int i=0; i<numbers; i++){
            String[] input=br.readLine().split(" ");
            int x=Integer.parseInt(input[0]);
            int y=Integer.parseInt(input[1]);
            xList.add(x);
            if(x2y.get(x)==null){
                LinkedList<Integer> list=new LinkedList<>();
                list.add(y);
                x2y.put(x,list);
            } else {
                LinkedList<Integer> list=x2y.get(x);
                list.add(y);
                x2y.put(x,list);
            }
        }
        Collections.sort(xList);
        Object[] xArray=xList.toArray();
        int recentSearch=0;
        for(int i=0; i<xArray.length; i++){
            int x= (int) xArray[i];
            if(x==recentSearch)
                continue;
            else
                recentSearch=x;
            LinkedList<Integer> y=x2y.get(x);
            if(y.size()!=1)
                Collections.sort(y);
            for(int j=0; j<y.size(); j++){
                bw.write(x+" "+y.get(j)+"\n");
                bw.flush();
            }
        }
        bw.close();
    }
}