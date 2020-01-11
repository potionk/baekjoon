package bj10845;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] stack=new int[10000];
        int cmdCase= Integer.parseInt(br.readLine());
        int frontIndex=0;
        int backIndex=0;
        for(int i=0; i<cmdCase; i++){
            String[] readLine=br.readLine().split(" ");
            switch (readLine[0]){
                case "push":
                    stack[backIndex++]= Integer.parseInt(readLine[1]);
                    break;
                case "pop":
                    if(backIndex-frontIndex==0)
                        bw.write(-1+"\n");
                    else{
                        bw.write(stack[frontIndex]+"\n");
                        frontIndex++;
                    }
                    break;
                case "size":
                    bw.write(backIndex-frontIndex+"\n");
                    break;
                case "empty":
                    if(backIndex-frontIndex==0)
                        bw.write(1+"\n");
                    else
                        bw.write(0+"\n");
                    break;
                case "front":
                    if(backIndex-frontIndex==0)
                        bw.write(-1+"\n");
                    else
                        bw.write(stack[frontIndex]+"\n");
                    break;
                case "back":
                    if(backIndex-frontIndex==0)
                        bw.write(-1+"\n");
                    else
                        bw.write(stack[backIndex-1]+"\n");
                    break;

            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}