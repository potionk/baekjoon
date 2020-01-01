package bj11656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] sortTarget=new String[input.length()];
        for(int i=0; i<sortTarget.length; i++){
            sortTarget[i]=input.substring(i);
        }
        Arrays.sort(sortTarget);
        for(int i=0; i<sortTarget.length; i++){
            System.out.println(sortTarget[i]);
        }
    }
}