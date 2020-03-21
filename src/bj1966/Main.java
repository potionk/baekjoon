package bj1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            String[] input=br.readLine().split(" ");
            int N= Integer.parseInt(input[0]);
            int M= Integer.parseInt(input[1]);
            int count=1;
            String[] priorityStr=br.readLine().split(" ");
            int[] priority=new int[priorityStr.length];
            for(int j=0; j<priorityStr.length; j++){
                priority[j]= Integer.parseInt(priorityStr[j]);
            }
            LinkedList<QueueData> queue=new LinkedList<>();
            for(int j=0; j<N; j++){
                queue.add(new QueueData(j, priority[j]));
            }
            Arrays.sort(priority);
            int priorityIndex=priority.length-1;
            while(!queue.isEmpty()){
                QueueData pollData=queue.poll();
                if(pollData.getPriority()==priority[priorityIndex]){
                    if(pollData.getData()==M){
                        System.out.println(count);
                        break;
                    } else {
                        count++;
                        priorityIndex--;
                    }
                } else {
                    queue.add(pollData);
                }
            }
        }
    }
}

class QueueData{
    int data;
    int priority;
    public int getData() {
        return data;
    }

    public int getPriority() {
        return priority;
    }
    public QueueData(int data, int priority){
        this.data=data;
        this.priority=priority;
    }
}