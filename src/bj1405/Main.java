package bj1405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int num=Integer.parseInt(input[0]);
        int numOfCase=1;
        double simpleRate=0;
        for(int i=0; i<num; i++){
            numOfCase*=4;
        }
        System.out.println(numOfCase);
        int e=0;
        int w=0;
        int n=0;
        int s=0;
        int startX=num+1;
        int startY=num+1;
//        for(int i=0; i<numOfCase; i++){
//
//        }
        int whileCount=num;
        while(whileCount-->0){
            for(int a=0; a<4; a++){

            }
        }
        int[][] map=new int[num*2+1][num*2+1];
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}