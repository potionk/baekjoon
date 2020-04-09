package bj11723;

import java.io.*;
import java.util.Arrays;

public class Main {
    static boolean[] set;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        set=new boolean[21];
        int testCase= Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            String[] cmd=br.readLine().split(" ");
            switch (cmd[0]){
                case "add":
                    add(Integer.parseInt(cmd[1]));
                    break;
                case "remove":
                    remove(Integer.parseInt(cmd[1]));
                    break;
                case "check":
                    check(Integer.parseInt(cmd[1]));
                    break;
                case "toggle":
                    toggle(Integer.parseInt(cmd[1]));
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }
        bw.flush();
    }
    static void add(int input){
        set[input]=true;
    }

    static void remove(int input){
        set[input]=false;
    }

    static void check(int input) throws IOException {
        if(set[input])
            bw.write(1+"\n");
        else
            bw.write(0+"\n");
    }

    static void toggle(int input){
        set[input]=!set[input];
    }

    static void all(){
        Arrays.fill(set, true);
    }

    static void empty(){
        Arrays.fill(set, false);
    }
}