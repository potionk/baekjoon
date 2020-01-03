package bj1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result=0;
        int[][] set = new int[6][10];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                set[i][j] = 1;
            }
        }
        char[] roomNumber = br.readLine().toCharArray();
        if(roomNumber.length==7){
            System.out.println(6);
            return;
        }
        for (int i = 0; i < roomNumber.length; i++) {
            int roomNumInt = roomNumber[i] - 48;
            int setIndex = 0;
            while ((!(roomNumInt==6 && set[setIndex][9]==1 && set[setIndex][roomNumInt]!=1))&&(!(roomNumInt==9 && set[setIndex][6]==1 && set[setIndex][roomNumInt]!=1))&&set[setIndex][roomNumInt] != 1) {
                setIndex++;
            }
            if(roomNumInt==6 && set[setIndex][9]==1 && set[setIndex][roomNumInt]!=1)
                set[setIndex][9] = 0;
            else if(roomNumInt==9 && set[setIndex][6]==1 && set[setIndex][roomNumInt]!=1)
                set[setIndex][6] = 0;
            else
                set[setIndex][roomNumInt] = 0;
        }
        for(int i=0; i<6; i++){
            for(int j=0; j<10; j++){
                if(set[i][j]!=1){
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}