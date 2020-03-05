package bj2263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int[] postOrder;
    static int[] inOrder;
    static Map<Integer, Integer> inOrderIndexMap;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inOrderIndexMap=new HashMap<>();
        size= Integer.parseInt(br.readLine());
        String[] inOrderStr=br.readLine().split(" ");
        inOrder=new int[size];
        String[] postOrderStr=br.readLine().split(" ");
        postOrder=new int[size];
        for(int i=0; i<size; i++){
            postOrder[i]= Integer.parseInt(postOrderStr[i]);
            inOrder[i]= Integer.parseInt(inOrderStr[i]);
            inOrderIndexMap.put(inOrder[i], i);
        }
        int root=postOrder[postOrder.length-1];
        System.out.print(root+" ");
        int left=inOrderIndexMap.get(root);
        inPost2pre(0, inOrderIndexMap.get(root)-1,0, left-1);
        inPost2pre(inOrderIndexMap.get(root)+1, inOrder.length-1,inOrderIndexMap.get(root), size-2);
    }
    public static void inPost2pre(int inStart, int inEnd, int postStart, int postEnd){
        if(inStart>inEnd||postStart>postEnd)
            return;
        int root=postOrder[postEnd];
        System.out.print(root+" ");
        int left=inOrderIndexMap.get(root)-inStart;
        inPost2pre(inStart, inOrderIndexMap.get(root)-1,postStart, postStart+left-1);
        inPost2pre(inOrderIndexMap.get(root)+1, inEnd, postStart+left, postEnd-1);
    }
}