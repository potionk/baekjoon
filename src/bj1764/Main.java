package bj1764;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] count = br.readLine().split(" ");
        Map<String,Integer> noListen=new HashMap<>();
        List<String> noListenLookList=new LinkedList<>();
        int noListenSize=Integer.parseInt(count[0]);
        int noLookSize=Integer.parseInt(count[1]);
        for (int i = 0; i < noListenSize; i++) {
            noListen.put(br.readLine(),1);
        }
        for (int i = 0; i < noLookSize; i++) {
            String input;
            if(noListen.get(input=br.readLine())!=null)
                noListenLookList.add(input);
        }
        Collections.sort(noListenLookList);
        bw.write(noListenLookList.size()+"\n");
        Object[] noLLArray=noListenLookList.toArray();
        for(int i=0; i<noLLArray.length; i++){
            bw.write(noLLArray[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}