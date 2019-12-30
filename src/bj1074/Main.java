package bj1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int count=-1;
    static int row;
    static int colomn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int size=Integer.parseInt(input[0]);
        row=Integer.parseInt(input[1]);
        colomn=Integer.parseInt(input[2]);
        Main m=new Main();
        m.cal(0,0,(int)Math.pow(2,size));
    }
    void cal(int row, int colomn, int size) {
        if (this.row == row && this.colomn == colomn) {
            count++;
            System.out.println(count);
            return;
        }
        else if (this.row >= row + size) {
            count += size*size;
            return;
        }
        else if (this.colomn >= colomn + size) {
            count += size*size;
            return;
        }
        else if (size == 1) {
            count++;
            return;
        }
        size/=2;
        cal(row, colomn, size);
        cal(row, colomn + size, size);
        cal(row + size, colomn, size);
        cal(row + size, colomn + size, size);
    }
}