package bj1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int minusOne=0;
    static int zero=0;
    static int one=0;
    static int array[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        array=new int[size][size];
        for(int i=0; i<size; i++){
            String input[] = br.readLine().split(" ");
            for(int j=0; j<size; j++){
                array[i][j]=Integer.parseInt(input[j]);
            }
        }
        Main m=new Main();
        m.cal(0,0, size);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }
    void cal(int row, int colomn, int size) {
        int a=array[row][colomn];
        boolean status=false;
        for(int i=row; i<size+row; i++){
            if(status==false&&size!=1) {
                for (int j = colomn; j < size+colomn; j++) {
                    if (array[i][j] != a) {
                        status=true;
                        break;
                    }
                }
            }
        }
        if(status==false||size==1){
            switch (a){
                case -1:
                    minusOne++;
                    return;
                case 0:
                    zero++;
                    return;
                case 1:
                    one++;
                    return;
            }
        }
        size/=3;
        cal(row, colomn, size);
        cal(row, colomn + size, size);
        cal(row, colomn + size * 2, size);

        cal(row + size, colomn, size);
        cal(row + size, colomn + size, size);
        cal(row + size, colomn + size * 2, size);

        cal(row + size*2, colomn, size);
        cal(row + size*2, colomn+ size, size);
        cal(row + size*2, colomn+ size * 2, size);
    }
}