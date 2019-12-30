package bj1914;

public class Main {
    public static void main(String[] args) {
        Main test = new Main();
        System.out.println("3개 1번 기둥에서 3번 기둥으로");
        test.move(3, '1', '3', '2');
    }
    public void move(int number, char from, char to, char temp) { //이거까지만했음
        if (number == 1)
            System.out.println(from + "->" + to);
        else {
            move(number - 1, from, temp, to);
            System.out.println(from + "->" + to);
            move(number - 1, temp, to, from);
        }
    }
}

//System.out.println("3개 1번 기둥에서 3번 기둥으로");

//package bj1914;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        Main test = new Main();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int c=Integer.parseInt(br.readLine());
//        int count=(int)Math.pow(2, c);
//        System.out.println(--count);
//        test.move(c, '1', '2', '3');
//    }
//    public void move(int number, char from, char temp, char to) {
//        if (number == 1) {
//            System.out.println(from + " " + to);
//        }
//        else {
//            move(number - 1, from, to, temp);
//            System.out.println(from + " " + to);
//            move(number - 1, temp, from, to);
//        }
//    }
//}