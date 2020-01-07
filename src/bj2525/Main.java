package bj2525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] curTime=br.readLine().split(" ");
        int ovenTime= Integer.parseInt(br.readLine());
        int curHour=Integer.parseInt(curTime[0]);
        int curMin=Integer.parseInt(curTime[1]);
        curMin+=ovenTime;
        if(curMin>60){
            curHour+=curMin/60;
            curMin=curMin%60;
            curHour=curHour%24;
        }
        System.out.println(curHour+" "+curMin);
    }
}