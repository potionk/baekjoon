package bj3192;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] square;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<3; i++){
            String[] readline=br.readLine().split(" ");
            for(int j=0; j<3; j++){
                square[i][j]= Integer.parseInt(readline[j]);
            }
        }
        dfs(0);

    }
    public static void dfs(int i){

    }
}