package bj12791;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, ArrayList<String>> database=new HashMap<>();
        String[] davidBowie=("1967 DavidBowie\n" +
                "1969 SpaceOddity\n" +
                "1970 TheManWhoSoldTheWorld\n" +
                "1971 HunkyDory\n" +
                "1972 TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars\n" +
                "1973 AladdinSane\n" +
                "1973 PinUps\n" +
                "1974 DiamondDogs\n" +
                "1975 YoungAmericans\n" +
                "1976 StationToStation\n" +
                "1977 Low\n" +
                "1977 Heroes\n" +
                "1979 Lodger\n" +
                "1980 ScaryMonstersAndSuperCreeps\n" +
                "1983 LetsDance\n" +
                "1984 Tonight\n" +
                "1987 NeverLetMeDown\n" +
                "1993 BlackTieWhiteNoise\n" +
                "1995 1.Outside\n" +
                "1997 Earthling\n" +
                "1999 Hours\n" +
                "2002 Heathen\n" +
                "2003 Reality\n" +
                "2013 TheNextDay\n" +
                "2016 BlackStar").split("\n");
        for (String s : davidBowie) {
            String[] t = s.split(" ");
            if (database.get(Integer.parseInt(t[0])) == null) {
                ArrayList<String> list = new ArrayList<>();
                list.add(t[1]);
                database.put(Integer.parseInt(t[0]), list);
            } else {
                ArrayList<String> list = database.get(Integer.parseInt(t[0]));
                list.add(t[1]);
                database.put(Integer.parseInt(t[0]), list);
            }
        }
        int tc= Integer.parseInt(br.readLine());
        for(int i=0; i<tc; i++){
            String[] input=br.readLine().split(" ");
            int start= Integer.parseInt(input[0]);
            int finish= Integer.parseInt(input[1]);
            int count=0;
            for(int j=start; j<=finish; j++){
                if(database.get(j)!=null){
                    ArrayList<String> list = database.get(j);
                    for (String s : list) bw.write(j + " " + s + "\n");
                    count+=list.size();
                }
            }
            System.out.println(count);
            bw.flush();
        }
    }
}
