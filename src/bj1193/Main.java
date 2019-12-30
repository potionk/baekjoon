package bj1193;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        List<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        int temp=0;
        for(int i=0, j=1; temp<input; i++, j+=2){
            list.add(list.get(j-1)+5+4*i);
            temp=list.get(j)+5+4*i;
            list.add(temp);
        }
        int find=0;
        for(int i=list.size()-1; i>0; i-=2){
            if(i-2>0&&input<list.get(i)&&input>list.get(i-2)){
                find=i-2;
            }
            else if(input==list.get(i))
                find=i;
        }
        int a=1; // 분자
        int b=find+1; // 분모
        int point=input;
        boolean flag=false; //false:왼쪽아래로 진행, true:오른쪽 위로 진행
        int finish=list.get(find);
//        System.out.println(point+" "+finish); // 입력값, 인덱스
        while(point!=finish){
            if(!flag){
                if(a==find+1){
                    flag=true;
                    a=find+2;
                    b=1;
                }
                else{
                    a++;
                    b--;
                }
            }
            else{
                a--;
                b++;
            }
            finish++;
        }
        System.out.println(a+"/"+b);
    }
}