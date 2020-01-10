package bj10828;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] stack=new int[10000];
        int cmdCase= Integer.parseInt(br.readLine());
        int index=0;
        for(int i=0; i<cmdCase; i++){
            String[] readLine=br.readLine().split(" ");
            switch (readLine[0]){
                case "push":
                    stack[index++]= Integer.parseInt(readLine[1]);
                    break;
                case "top":
                    if(index==0)
                        bw.write(-1+"\n");
                    else
                        bw.write(stack[index-1]+"\n");
                    break;
                case "size":
                    bw.write(index+"\n");
                    break;
                case "empty":
                    if(index==0)
                        bw.write(1+"\n");
                    else
                        bw.write(0+"\n");
                    break;
                case "pop":
                    if(index==0)
                        bw.write(-1+"\n");
                    else{
                        bw.write(stack[index-1]+"\n");
                        index--;
                    }

                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}