package bj11586;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        char[][] jiyoung=new char[size][size];
        for(int y=0; y<size; y++){
            String read=br.readLine();
            for(int x=0; x<read.length(); x++){
                jiyoung[y][x]=read.charAt(x);
            }
        }
        int mode=Integer.parseInt(br.readLine());
        switch (mode){
            case 1:
                for(int y=0; y<size; y++){
                    for(int x=0; x<size; x++){
                        System.out.print(jiyoung[y][x]);
                    }
                    System.out.println();
                }
                break;
            case 2:
                for(int y=0; y<size; y++){
                    for(int x=size-1; x>=0; x--){
                        System.out.print(jiyoung[y][x]);
                    }
                    System.out.println();
                }
                break;
            case 3:
                for(int y=size-1; y>=0; y--){
                    for(int x=0; x<size; x++){
                        System.out.print(jiyoung[y][x]);
                    }
                    System.out.println();
                }
                break;

        }
    }
}