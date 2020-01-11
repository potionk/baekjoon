package bj2863;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ab=br.readLine().split(" ");
        String[] cd=br.readLine().split(" ");
        double a= Double.parseDouble(ab[0]);
        double b= Double.parseDouble(ab[1]);
        double c= Double.parseDouble(cd[0]);
        double d= Double.parseDouble(cd[1]);
        double[] result=new double[4];
        result[0]=a/c+b/d;
        result[1]=c/d+a/b;
        result[2]=d/b+c/a;
        result[3]=b/a+d/c;
        double maxResult=-1;
        int maxResultIndex=0;
        for(int i=0; i<result.length; i++){
            if(result[i]>maxResult) {
                maxResult = result[i];
                maxResultIndex = i;
            }
        }
        System.out.println(maxResultIndex);
    }
}