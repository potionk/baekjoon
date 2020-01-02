package bj3040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dwarf=new int[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total=0;
        for(int i=0; i<9; i++){
            dwarf[i]=Integer.parseInt(br.readLine());
            total+=dwarf[i];
        }
        int gap=total-100;
        for(int i=0; i<9; i++){
            for(int j=i+1; j<9; j++){
                if(dwarf[i]+dwarf[j]==gap){
                    printSevenDwarf(i,j);
                    return;
                }
            }
        }
    }
    public static void printSevenDwarf(int except1, int except2){
        for(int i=0; i<9; i++){
            if(i==except1||i==except2)
                continue;
            System.out.println(dwarf[i]);
        }
    }
}