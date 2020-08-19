package bj16489;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        double a = Double.parseDouble(tc[0]);
        double b = Double.parseDouble(tc[1]);
        double c = Double.parseDouble(tc[2]);
        BigDecimal S = getS(a, b, c);
        System.out.println(S);
        BigDecimal R = getR(a, b, c, S);
        System.out.println(R);
        BigDecimal r = get_r(a, b, c, S);
        System.out.println(r);
        BigDecimal d = get_d(R, r);
        if (d.compareTo(BigDecimal.valueOf(0.000000005)) < 0) {
            System.out.println(0);
        } else {
            System.out.println(d);
        }
        System.out.println(r.add(R));
    }

    public static BigDecimal getS(double a, double b, double c) {
        BigDecimal t = new BigDecimal(4 * a * a * b * b - (a * a + b * b - c * c) * (a * a + b * b - c * c) + "");
        BigDecimal tt = BigDecimal.ONE.divide(BigDecimal.valueOf(16), 20, RoundingMode.HALF_EVEN);
        return sqrt((tt.multiply(t)));
    }

    public static BigDecimal get_r(double a, double b, double c, BigDecimal S) {
        return S.multiply(BigDecimal.valueOf(2)).divide(BigDecimal.valueOf(a + b + c), 20, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal getR(double a, double b, double c, BigDecimal S) {
        return BigDecimal.valueOf(a * b * c).divide(S.multiply(BigDecimal.valueOf(4)), 20, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal get_d(BigDecimal R, BigDecimal r) {
        BigDecimal b = R.multiply(R.subtract(r.multiply(BigDecimal.valueOf(2))));
        return sqrt(b.compareTo(BigDecimal.ZERO) >= 0 ? b : BigDecimal.ZERO);
    }

    public static BigDecimal sqrt(BigDecimal value) {
        if (value.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        BigDecimal x = BigDecimal.valueOf(Math.sqrt(value.doubleValue()));
        return x.add(BigDecimal.valueOf(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
    }
}