package bj2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int whitePaper=0;
    static int bludPaper=0;
    static int paper[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        paper =new int[size][size];
        for(int i=0; i<size; i++){
            String input[] = br.readLine().split(" ");
            for(int j=0; j<size; j++){
                paper[i][j]=Integer.parseInt(input[j]);
            }
        }
        cal(0,0, size);
        System.out.println(whitePaper);
        System.out.println(bludPaper);
    }
    public static void cal(int row, int colomn, int size) {
        int a= paper[row][colomn];
        boolean status=false;
        for(int i=row; i<size+row; i++){
            if(!status&&size!=1) {
                for (int j = colomn; j < size+colomn; j++) {
                    if (paper[i][j] != a) {
                        status=true;
                        break;
                    }
                }
            }
        }
        if(!status||size==1){
            switch (a){
                case 0:
                    whitePaper++;
                    return;
                case 1:
                    bludPaper++;
                    return;
            }
        }
        size/=2;
        cal(row, colomn, size);
        cal(row, colomn + size, size);
        cal(row + size, colomn, size);
        cal(row + size, colomn + size, size);
    }
}