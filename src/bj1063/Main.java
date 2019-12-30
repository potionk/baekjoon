package bj1063;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 돌이 튀어나가는 케이스를 체크안해줬음 이거해결하면 될듯!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int kingX, kingY, stoneX, stoneY;
        kingX=charToX(input[0].charAt(0));
        kingY=input[0].charAt(1)-'0';
        stoneX=charToX(input[1].charAt(0));
        stoneY=input[1].charAt(1)-'0';
        for (int i = 0; i < Integer.parseInt(input[2]); i++) {
            String move = br.readLine();
            if(move.equals("R")&&kingX+1<=8){
                kingX++;
                if(kingX==stoneX&&kingY==stoneY){
                    if(stoneX+1<=8){
                        stoneX++;
                    }
                    else
                        kingX--;
                }
            } else if(move.equals("L")&&kingX-1>0){
                kingX--;
                if(kingX==stoneX&&kingY==stoneY){
                    if(stoneX-1>0){
                        stoneX--;
                    }
                    else
                        kingX++;
                }
            } else if(move.equals("B")&&kingY-1>0){
                kingY--;
                if(kingX==stoneX&&kingY==stoneY){
                    if(stoneY-1>0){
                        stoneY--;
                    }
                    else
                        kingY++;
                }
            } else if(move.equals("T")&&kingY+1<=8){
                kingY++;
                if(kingX==stoneX&&kingY==stoneY){
                    if(stoneY+1<=8){
                        stoneY++;
                    }
                    else
                        kingY--;
                }
            } else if(move.equals("RT")&&kingX+1<=8&&kingY+1<=8){
                kingX++;
                kingY++;
                if(kingX==stoneX&&kingY==stoneY){
                    if(stoneX+1<=8&&stoneY+1<=8){
                        stoneX++;
                        stoneY++;
                    }
                    else{
                        kingX--;
                        kingY--;
                    }
                }
            } else if(move.equals("LT")&&kingX-1>0&&kingY+1<=8){
                kingX--;
                kingY++;
                if(kingX==stoneX&&kingY==stoneY){
                    if(stoneX-1>0&&stoneY+1<=8){
                        stoneX--;
                        stoneY++;
                    }
                    else{
                        kingX++;
                        kingY--;
                    }
                }
            } else if(move.equals("RB")&&kingX+1<=8&&kingY-1>0){
                kingX++;
                kingY--;
                if(kingX==stoneX&&kingY==stoneY){
                    if(stoneX+1<=8&&stoneY-1>0){
                        stoneX++;
                        stoneY--;
                    }
                    else{
                        kingX--;
                        kingY++;
                    }
                }
            } else if(move.equals("LB")&&kingX-1>0&&kingY-1>0) {
                kingX--;
                kingY--;
                if(kingX==stoneX&&kingY==stoneY){
                    if(stoneX-1>0&&stoneY-1>0){
                        stoneX--;
                        stoneY--;
                    }
                    else{
                        kingX++;
                        kingY++;
                    }
                }
            }
            //System.out.println(XtoChar(kingX)+""+kingY);
            //System.out.println(XtoChar(stoneX)+""+stoneY);
        }

        System.out.println(XtoChar(kingX)+""+kingY);
        System.out.println(XtoChar(stoneX)+""+stoneY);


    }
    public static int charToX(char a) {
        switch (a) {
            case 'A':
                return 1;
            case 'B':
                return 2;
            case 'C':
                return 3;
            case 'D':
                return 4;
            case 'E':
                return 5;
            case 'F':
                return 6;
            case 'G':
                return 7;
            case 'H':
                return 8;

        }
        return 0;
    }
    public static char XtoChar(int x) {
        switch (x) {
            case 1:
                return 'A';
            case 2:
                return 'B';
            case 3:
                return 'C';
            case 4:
                return 'D';
            case 5:
                return 'E';
            case 6:
                return 'F';
            case 7:
                return 'G';
            case 8:
                return 'H';
        }
        return 0;
    }
}