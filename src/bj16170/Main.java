package bj16170;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat time = new SimpleDateFormat("yyyy\nMM\ndd");
        System.out.println(time.format(new Date()));
    }
}