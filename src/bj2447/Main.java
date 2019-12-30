package bj2447;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int cal=0;
        while(input!=1){
            input/=3;
            cal++;
        }

        List<String> list=new ArrayList<>();
        list.add("***");
        list.add("* *");
        list.add("***");

        while(--cal>0){
            List<String> update=new ArrayList<>();
            for(int i=0; i<3; i++){
                String[] temp=new String[list.size()];
                for(int j=0; j<temp.length; j++){
                    temp[j]="";
                }
                for(int j=0; j<3; j++){
                    for(int k=0; k<list.size(); k++){
                        if(i==1&&j==1){
                            StringBuffer sb=new StringBuffer();
                            for(int p=0; p<list.size(); p++){
                                sb.append(" ");
                            }
                            temp[k]+=sb.toString();
                        }
                        else{
                            temp[k]+=list.get(k);
                        }
                    }
                }
                for(int j=0; j<list.size(); j++){
                    update.add(temp[j]);
                }
            }
            list=update;
        }

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
