package bj1919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabetFirst=new int[26];
        int[] alphabetSecond=new int[26];
        char[] first=br.readLine().toCharArray();
        char[] second=br.readLine().toCharArray();
        int deleteNum=0;
        for (char value : first) {
            int index = (int) value - 97;
            alphabetFirst[index]++;
        }
        for (char c : second) {
            int index = (int) c - 97;
            alphabetSecond[index]++;
        }
        for(int i=0; i<26; i++){
            if(alphabetFirst[i]>alphabetSecond[i])
                deleteNum+=alphabetFirst[i]-alphabetSecond[i];
            else if(alphabetFirst[i]<alphabetSecond[i])
                deleteNum+=alphabetSecond[i]-alphabetFirst[i];
        }
        System.out.println(deleteNum);
    }
}