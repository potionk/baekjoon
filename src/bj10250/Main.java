package bj10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            String[] input=br.readLine().split(" ");
            int height= Integer.parseInt(input[0]);
            int width= Integer.parseInt(input[1]);
            int guestNum= Integer.parseInt(input[2]);
            int curHeight=1, curWidth=1;
            for(int j=1; j<guestNum; j++){
                if(curHeight+1>height){
                    curHeight=1;
                    curWidth++;
                } else
                    curHeight++;
            }
            String curWidthStr;
            if(curWidth<10)
                curWidthStr="0"+curWidth;
            else
                curWidthStr=curWidth+"";
            System.out.println(curHeight+""+curWidthStr);
        }
    }
}