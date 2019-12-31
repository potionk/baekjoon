package bj1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static boolean isBlack;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int x=Integer.parseInt(input[1]);
        int y=Integer.parseInt(input[0]);
        boolean[][] chessMap=new boolean[x][y]; // white:true, black:false
        boolean[][] chessMapRef=new boolean[x][y];
        List<Integer> countList=new ArrayList<>();
        // init map
        for(int i=0; i<y; i++){
            String readLine = br.readLine();
            for(int j=0; j<x; j++){
                if((readLine.charAt(j)+"").equals("W"))
                    chessMap[j][i]=true;
                else
                    chessMap[j][i]=false;
                chessMapRef[j][i]=printRef(); // !하면 ref2
                if(!(j==x-1&&x%2==0))
                    reverseFlag();
            }
        }

        for(int a=0; a<8+a&&a+8<=y; a++){
            for(int b=0; b<8+b&&b+8<=x; b++){
                int count1=0;
                int count2=0;
                for(int i=a; i<a+8; i++){
                    for(int j=b; j<b+8; j++){
                        if(chessMap[j][i]!=chessMapRef[j][i])
                            count1++;
                        if(chessMap[j][i]!=(!chessMapRef[j][i]))
                            count2++;
                    }
                }
                countList.add(count1);
                countList.add(count2);
            }
        }
        Collections.sort(countList);
        System.out.println(countList.get(0));
    }
    private static boolean printRef(){
        return !isBlack;
    }
    private static void reverseFlag(){
        isBlack = !isBlack;
    }
}
