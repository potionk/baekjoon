package bj11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Data[] heap;
    static int heapSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        heap = new Data[100001];
        for (int i = 0; i < 100001; i++) {
            heap[i] = new Data(Integer.MAX_VALUE, true);
        }
        heapSize = 0;
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd != 0) {
                insert(cmd);
            } else {
                Data result = delete();
                if (result.isPlus())
                    System.out.println(result.getData());
                else
                    System.out.println(-1 * result.getData());
            }
        }
    }

    public static void insert(int input) {
        heap[++heapSize] = new Data(Math.abs(input), input > 0);
        for (int i = heapSize; i > 1; i /= 2) {
            if ((heap[i].getData() < heap[i / 2].getData()) || (heap[i].getData() == heap[i / 2].getData() && !heap[i].isPlus() && heap[i / 2].isPlus()))
                swap(i, i / 2);
            else
                break;
        }
        for (int i = 1; i * 2 <= heapSize; ) {
            if (heap[i].getData() == heap[i * 2].getData() && heap[i].isPlus() && !heap[i * 2].isPlus()) {
                swap(i, i * 2);
                i = i * 2;
            } else if (heap[i].getData() == heap[i * 2 + 1].getData() && heap[i].isPlus() && !heap[i * 2 + 1].isPlus()) {
                swap(i, i * 2 + 1);
                i = i * 2 + 1;
            } else {
                break;
            }
        }

    }

    public static Data delete() {
        if (heapSize == 0)
            return new Data(0, true);
        Data deleteTarget = heap[1];
        heap[1] = heap[heapSize];
        heap[heapSize--] = new Data(Integer.MAX_VALUE, true);
        for (int index = 1; index * 2 <= heapSize; ) {
            if (!(heap[index * 2].getData() > heap[index].getData() && heap[index * 2 + 1].getData() > heap[index].getData())) {
                if (heap[index * 2].getData() > heap[index * 2 + 1].getData()) {
                    swap(index, index * 2 + 1);
                    index = index * 2 + 1;
                } else {
                    swap(index, index * 2);
                    index = index * 2;
                }
            } else
                break;
        }
        for (int i = 1; i * 2 <= heapSize; ) {
            if (heap[i].getData() == heap[i * 2].getData() && heap[i].isPlus() && !heap[i * 2].isPlus()) {
                swap(i, i * 2);
                i = i * 2;
            } else if (heap[i].getData() == heap[i * 2 + 1].getData() && heap[i].isPlus() && !heap[i * 2 + 1].isPlus()) {
                swap(i, i * 2 + 1);
                i = i * 2 + 1;
            } else {
                break;
            }
        }
        return deleteTarget;
    }

    public static void swap(int aIndex, int bIndex) {
        Data temp = heap[aIndex];
        heap[aIndex] = heap[bIndex];
        heap[bIndex] = temp;
    }
}

class Data {
    int data;

    public int getData() {
        return data;
    }

    public boolean isPlus() {
        return isPlus;
    }

    boolean isPlus;

    public Data(int data, boolean isPlus) {
        this.data = data;
        this.isPlus = isPlus;
    }
}