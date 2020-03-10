package bj1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int zero =0;
    static int one =0;
    static int image[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        image =new int[size][size];
        for(int i=0; i<size; i++){
            char[] input=br.readLine().toCharArray();
            for(int j=0; j<size; j++){
                image[i][j]=input[j]-48;
            }
        }
        compress(0,0, size);
    }
    public static void compress(int row, int colomn, int size) {
        int a= image[row][colomn];
        boolean status=false;
        for(int i=row; i<size+row; i++){
            if(!status&&size!=1) {
                for (int j = colomn; j < size+colomn; j++) {
                    if (image[i][j] != a) {
                        status=true;
                        break;
                    }
                }
            }
        }
        if(!status||size==1){
            switch (a){
                case 0:
                    System.out.print(0);
                    return;
                case 1:
                    System.out.print(1);
                    return;
            }
        }
        size/=2;
        System.out.print("(");
        compress(row, colomn, size);
        compress(row, colomn + size, size);
        compress(row + size, colomn, size);
        compress(row + size, colomn + size, size);
        System.out.print(")");
    }
}