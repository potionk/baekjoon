package bj4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력, 배열 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input[] = br.readLine().split(" ");
            int x=Integer.parseInt(input[0]);
            int y=Integer.parseInt(input[1]);
            int array[][]=new int[x][y];
            //ystem.out.println(x);
            //System.out.println(y);
            //System.out.println(array[0][0]);
            if(x==0&&y==0)
                break;
            for (int i = 0; i < Integer.parseInt(input[1]); i++) {
                String y1[]=br.readLine().split(" ");
                for(int j=0; j<y1.length; j++){
                    array[j][i]=Integer.parseInt(y1[j]);
                }
            }

            //System.out.println();
            /*
            for(int i=0; i<y; i++){
                for(int j=0; j<x; j++){
                    System.out.print(array[j][i]);
                }
                System.out.println();
            }*/

        }
    }
}