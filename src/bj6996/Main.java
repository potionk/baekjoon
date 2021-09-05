package bj6996;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T= Integer.parseInt(br.readLine());
        while(T-->0){
            String[] tc=br.readLine().split(" ");
            int[] aCount=new int[26], bCount=new int[26];
            char[] a=tc[0].toCharArray(), b=tc[1].toCharArray();
            boolean anagram=true;
            if(a.length!=b.length){
                anagram=false;
            } else {
                for(char c:a){
                    aCount[c-'a']++;
                }
                for(char c:b){
                    bCount[c-'a']++;
                }
                for(int i=0; i<26; i++){
                    if(aCount[i]!=bCount[i]){
                        anagram=false;
                        break;
                    }
                }
            }
            if(anagram){
                bw.write(tc[0] +" & "+tc[1] + " are anagrams.\n");
            } else {
                bw.write(tc[0] +" & "+tc[1] + " are NOT anagrams.\n");
            }
        }
        br.close();
        bw.close();
    }
}
