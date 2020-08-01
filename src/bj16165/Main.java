package bj16165;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, ArrayList<String>> teamInfo=new HashMap<>();
        Map<String, String> memberInfo=new HashMap<>();
        String[] testCase=br.readLine().split(" ");
        int teams= Integer.parseInt(testCase[0]);
        int quiz= Integer.parseInt(testCase[1]);
        for(int i=0; i<teams; i++){
            String teamName=br.readLine();
            int members= Integer.parseInt(br.readLine());
            ArrayList<String> team=new ArrayList<>();
            for(int j=0; j<members; j++){
                String member=br.readLine();
                team.add(member);
                memberInfo.put(member, teamName);
            }
            Collections.sort(team);
            teamInfo.put(teamName, team);
        }
        for(int i=0; i<quiz; i++){
            String q=br.readLine();
            int mode= Integer.parseInt(br.readLine());
            if(mode==1){
                bw.write(memberInfo.get(q)+"\n");
            } else {
                ArrayList<String> selectTeam=teamInfo.get(q);
                for (String s : selectTeam) {
                    bw.write(s+"\n");
                }
            }
        }
        bw.flush();
    }
}
