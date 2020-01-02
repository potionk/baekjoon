package bj2897;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // init
        String[] size = br.readLine().split(" ");
        int[] search;
        int[] result=new int[5];
        int ySize=Integer.parseInt(size[0]);
        int xSize=Integer.parseInt(size[1]);
        char[][] map = new char[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            String readline = br.readLine();
            for(int j=0; j<readline.length(); j++){
                map[i][j]=readline.charAt(j);
            }
        }
        // search
        for (int i = 0; i < ySize-1; i++) {
            for(int j=0; j<xSize-1; j++){
                search=new int[3];
                search[checkElem(map[i][j])]++;
                search[checkElem(map[i][j+1])]++;
                search[checkElem(map[i+1][j])]++;
                search[checkElem(map[i+1][j+1])]++;
                if(search[2]==4)
                    result[0]++;
                else if(search[2]==3&&search[1]==1)
                    result[1]++;
                else if(search[2]==2&&search[1]==2)
                    result[2]++;
                else if(search[2]==1&&search[1]==3)
                    result[3]++;
                else if(search[1]==4)
                    result[4]++;
            }
        }
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
    static int checkElem(char input){
        switch (input){
            case '#': // 빌딩
                return 0;
            case 'X': // 주차된 차
                return 1;
            case '.': //
                return 2;
        }
        return -1;
    }
}