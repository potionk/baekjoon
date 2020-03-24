package bj1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] heap;
    static int heapSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        heap = new int[100001];
        for(int i=0; i<100001; i++){
            heap[i]=Integer.MAX_VALUE;
        }
        heapSize = 0;
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd != 0) {
                insert(cmd);
            } else {
                System.out.println(delete());
            }
        }
    }

    public static void insert(int input) {
        heap[++heapSize] = input;
        for (int i = heapSize; i > 1; i /= 2) {
            if (heap[i] < heap[i / 2])
                swap(i, i / 2);
            else
                break;
        }
    }

    public static int delete(){
        if(heapSize==0)
            return 0;
        int deleteTarget=heap[1];
        heap[1]=heap[heapSize];
        heap[heapSize--]=Integer.MAX_VALUE;
        for (int index=1; index*2<=heapSize;){
            if(!(heap[index*2]>heap[index]&&heap[index*2+1]>heap[index])){
                if(heap[index*2]>heap[index*2+1]){
                    swap(index, index*2+1);
                    index=index*2+1;
                } else {
                    swap(index, index*2);
                    index=index*2;
                }
            } else
                break;
        }
        return deleteTarget;
    }

    public static void swap(int aIndex, int bIndex) {
        int temp = heap[aIndex];
        heap[aIndex] = heap[bIndex];
        heap[bIndex] = temp;
    }
}