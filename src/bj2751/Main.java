package bj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Integer> list=new LinkedList<>();
        for(int i=0; i<size; i++)
            list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);
        Object[] list2Array=list.toArray();
        for(int i=0; i<size; i++){
            System.out.println((int)list2Array[i]);
        }
    }
}