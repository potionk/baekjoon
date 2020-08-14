package bj18301;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc=br.readLine().split(" ");
        double n1=Double.parseDouble(tc[0])+1;
        double n2=Double.parseDouble(tc[1])+1;
        double n12=Double.parseDouble(tc[2])+1;
        System.out.println((int)(n1*n2/n12)-1);
    }
}