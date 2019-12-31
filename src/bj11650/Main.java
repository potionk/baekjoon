package bj11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
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
                Collections.sort(list);
                x2y.put(x,list);
            }
        }
        Collections.sort(xList);
        for(int i=0; i<xList.size(); i++){
            System.out.print(xList.get(i)+" ");
            for()
        }
    }
}

/*
5
3 4
1 1
1 -1
2 2
3 3
 */