package bj10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Student[] students = new Student[testCase];
        for (int i = 0; i < testCase; i++) {
            String[] rl = br.readLine().split(" ");
            students[i] = new Student(rl[0], Integer.parseInt(rl[1]), Integer.parseInt(rl[2]), Integer.parseInt(rl[3]));
        }
        Arrays.sort(students);
        for (int i = 0; i < testCase; i++) {
            System.out.println(students[i].getName());
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int k, e, m;

    public String getName() {
        return name;
    }

    public Student(String name, int k, int e, int m) {
        this.name = name;
        this.k = k;
        this.e = e;
        this.m = m;
    }

    @Override
    public int compareTo(Student o) {
        if (o.k < this.k) {
            return -1;
        } else if (o.k > this.k) {
            return 1;
        } else {
            if (o.e > this.e) {
                return -1;
            } else if (o.e < this.e) {
                return 1;
            } else {
                if (o.m < this.m) {
                    return -1;
                } else if (o.m > this.m) {
                    return 1;
                } else {
                    return this.name.compareTo(o.name);
                }
            }
        }
    }
}