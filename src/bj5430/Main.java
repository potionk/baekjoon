package bj5430;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase= Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            char[] cmds=br.readLine().toCharArray();
            br.readLine();
            String input=br.readLine();
            String[] data=(input.substring(1,input.length()-1)).split(",");
            int startIndex=0;
            int finishIndex;
            if(data[0].equals(""))
                finishIndex=-1;
            else
                finishIndex=data.length-1;
            boolean isReverse=false;
            boolean isError=false;
            for(int j=0; j<cmds.length; j++){
                if(isError)
                    break;
                switch (cmds[j]){
                    case 'R':
                        int temp=startIndex;
                        startIndex=finishIndex;
                        finishIndex=temp;
                        isReverse=!isReverse;
                        break;
                    case 'D':
                        if(!isReverse){
                            if(startIndex>finishIndex){
                                bw.write("error\n");
                                isError=true;
                                break;
                            }
                            startIndex++;
                        } else {
                            if(startIndex<finishIndex){
                                bw.write("error\n");
                                isError=true;
                                break;
                            }
                            startIndex--;
                        }
                        break;
                }
            }
            if(!isError){
                bw.write("[");
                if(!isReverse){
                    for(int j=startIndex; j<=finishIndex; j++){
                        bw.write(data[j]);
                        if(j!=finishIndex)
                            bw.write(",");
                    }
                } else {
                    for(int j=startIndex; j>=finishIndex; j--){
                        bw.write(data[j]);
                        if(j!=finishIndex)
                            bw.write(",");
                    }
                }
                bw.write("]\n");
            }
        }
        bw.flush();
    }
}