package bj1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int mrSang[]=new int[2];
        for(int i=0; i<input.length; i++){
            char temp[]=new char[3];
            temp[0]=input[i].charAt(2);
            temp[1]=input[i].charAt(1);
            temp[2]=input[i].charAt(0);
            mrSang[i]=Integer.parseInt(temp[0]+""+temp[1]+""+temp[2]);
        }
        if(mrSang[0]>mrSang[1])
            System.out.println(mrSang[0]);
        else
            System.out.println(mrSang[1]);
    }
}

class Tree{
    int index;
//    Tree
}