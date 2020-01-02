package bj10942;

import java.io.*;

public class Main {
    static int[] input;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] readData=br.readLine().split(" ");
        input=new int[readData.length];
        for(int i=0; i<readData.length; i++){
            input[i]=Integer.parseInt(readData[i]);
        }
        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            String[] question=br.readLine().split(" ");
            bw.write((isPalindrome(Integer.parseInt(question[0]),Integer.parseInt(question[1]))?1:0)+"\n");
        }
        bw.close();
    }
    static boolean isPalindrome(int startIndex, int finishIndex) {
        int length=startIndex-1+(finishIndex-startIndex+1)/2;
        for (int i = startIndex-1; i < length; i++) {
            if (input[i] != input[finishIndex - (i-startIndex+1) - 1])
                return false;
        }
        return true;
    }
}