package bj2263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int[] postOrder;
    static int[] inOrder;
    static Map<Integer, Integer> postOrderIndexMap;
    static Map<Integer, Integer> inOrderIndexMap;
    static boolean[] isPOVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        postOrderIndexMap=new HashMap<>();
        inOrderIndexMap=new HashMap<>();
        int size= Integer.parseInt(br.readLine());
        String[] inOrderStr=br.readLine().split(" ");
        inOrder=new int[size];
        String[] postOrderStr=br.readLine().split(" ");
        postOrder=new int[size];
        isPOVisited=new boolean[size];
        for(int i=0; i<size; i++){
            postOrder[i]= Integer.parseInt(postOrderStr[i]);
            inOrder[i]= Integer.parseInt(inOrderStr[i]);
            postOrderIndexMap.put(postOrder[i], i);
            inOrderIndexMap.put(inOrder[i], i);
        }
        int root=postOrder[postOrder.length-1];
        System.out.print(root+" ");
        isPOVisited[postOrder.length-1] = true;
        inPost2pre(0, inOrderIndexMap.get(root)-1);
        inPost2pre(inOrderIndexMap.get(root)+1, inOrder.length-1);
    }
    public static void inPost2pre(int inStart, int inEnd){
        if(inStart>inEnd)
            return;
        int max=-1;
        for(int i=inStart; i<=inEnd; i++){
            int t;
            if((t=postOrderIndexMap.get(inOrder[i]))>max)
                max=t;
        }
        int root=postOrder[max];
        if(!isPOVisited[max]) {
            System.out.print(root+" ");
            isPOVisited[max] = true;
        } else
            return;
        inPost2pre(inStart, inOrderIndexMap.get(root)-1);
        inPost2pre(inOrderIndexMap.get(root)+1, inEnd);
    }
}