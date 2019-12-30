package bj2864;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] read = br.readLine().split(" ");
        StringBuilder minValA=new StringBuilder();
        StringBuilder maxValA=new StringBuilder();
        StringBuilder minValB=new StringBuilder();
        StringBuilder maxValB=new StringBuilder();
        for(int i=0; i<read[0].length(); i++){
            String readC= String.valueOf(read[0].charAt(i));
            if("5".equals(readC)){
                minValA.append("5");
                maxValA.append("6");
            } else if("6".equals(readC)){
                minValA.append("5");
                maxValA.append("6");
            } else {
                minValA.append(readC);
                maxValA.append(readC);
            }
        }

        for(int i=0; i<read[1].length(); i++){
            String readC= String.valueOf(read[1].charAt(i));
            if("5".equals(readC)){
                minValB.append("5");
                maxValB.append("6");
            } else if("6".equals(readC)){
                minValB.append("5");
                maxValB.append("6");
            } else {
                minValB.append(readC);
                maxValB.append(readC);
            }
        }

        System.out.println(Integer.parseInt(minValA.toString())+Integer.parseInt(minValB.toString()));
        System.out.println(Integer.parseInt(maxValA.toString())+Integer.parseInt(maxValB.toString()));
    }
}