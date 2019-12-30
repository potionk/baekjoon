package bj1463;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> resultMap = new HashMap<>();
        int input = sc.nextInt();
        resultMap.put(1,0);
        resultMap.put(2,1);
        resultMap.put(3,1);
        for(int i=4; i<=input; i++){
            int op=i;
            int count=0;
            if(op%3==0){
                if(resultMap.get(op/3)<=resultMap.get(op-1)) {
                    op /= 3;
                    count++;
                } else if(resultMap.get(op/3)+1>resultMap.get(op-2)){
                    op-=2;
                    count+=2;
                } else {
                    op--;
                    count++;
                }
            } else if(op%2==0){
                if(resultMap.get(op/2)<=resultMap.get(op-1)){
                    op/=2;
                    count++;
                }
                else{
                    op--;
                    count++;
                }
            } else{
                op--;
                count++;
            }
            count+=resultMap.get(op);
            resultMap.put(i,count);
        }
        System.out.println(resultMap.get(input));
    }
}
