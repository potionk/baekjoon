package bj10866;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] deque=new int[2000000];
        int cmdCase= Integer.parseInt(br.readLine());
        int frontIndex=99999;
        int backIndex=100000;
        int size=0;
        for(int i=0; i<cmdCase; i++){
            String[] readLine=br.readLine().split(" ");
            switch (readLine[0]){
                case "push_front":
                    deque[frontIndex--]= Integer.parseInt(readLine[1]);
                    size++;
                    break;
                case "push_back":
                    deque[backIndex++]= Integer.parseInt(readLine[1]);
                    size++;
                    break;
                case "pop_front":
                    if(size==0)
                        bw.write(-1+"\n");
                    else{
                        bw.write(deque[frontIndex+1]+"\n");
                        frontIndex++;
                        size--;
                    }
                    break;
                case "pop_back":
                    if(size==0)
                        bw.write(-1+"\n");
                    else{
                        bw.write(deque[backIndex-1]+"\n");
                        backIndex--;
                        size--;
                    }
                    break;
                case "size":
                    bw.write(size+"\n");
                    break;
                case "empty":
                    if(size==0)
                        bw.write(1+"\n");
                    else
                        bw.write(0+"\n");
                    break;
                case "front":
                    if(size==0)
                        bw.write(-1+"\n");
                    else
                        bw.write(deque[frontIndex+1]+"\n");
                    break;
                case "back":
                    if(size==0)
                        bw.write(-1+"\n");
                    else
                        bw.write(deque[backIndex-1]+"\n");
                    break;

            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}