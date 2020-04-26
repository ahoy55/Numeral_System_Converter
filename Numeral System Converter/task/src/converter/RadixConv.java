package converter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class RadixConv {
    String arr = "0123456789abcdefghijklmnopqrstuvwxyz.";
    private static Logger log = Logger.getLogger(RadixConv.class.getName());

    public void converter(int sourceBase, String number, int newBase) {
        if (sourceBase == 1) {
            int a = number.length();
            if (newBase == 10) System.out.println(a);
            else {
                removeFrac(convertToAny(String.valueOf(a), newBase));
            }
        } else {
            if (newBase == 1) {
                int a = (int) Double.parseDouble(convertToTen(sourceBase, number));
                System.out.println("1".repeat(a));
            } else {
                String result = convertToAny(convertToTen(sourceBase, number), newBase);
                removeFrac(result);
            }
        }
    }

    public void removeFrac(String number) {
        try {
            double num = Double.parseDouble(number);
            double fPart = num - (long) num;
            if (fPart == 0) System.out.println((long) num);
            else
                System.out.println(number);
        } catch (Exception e) {
            System.out.println(number);
        }
    }

    public String convertToAny(String number, int newBase) {
        List<Integer> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        double num = Double.parseDouble(number);
        String iPart = Long.toString((long) num, newBase);
        double sum = num - (long) num;
        str.append(iPart).append(".");
        for (int i = 0; i < 5; i++) {
            sum = sum * newBase;
            list.add((int) sum);
            sum -= (int) sum;
        }
        for (int i : list) {
            str.append(arr.charAt(i));
        }
        log.info("convertToAny" + str.toString());
        return str.toString();

    }

    public String convertToTen(int sourceBase, String number) {
        if (sourceBase == 10) return number;
        else {
            List<Integer> numbs = new ArrayList<>();
            for (int i = 0; i < number.length(); i++) {
                for (char c : arr.toCharArray()) {
                    if (number.toCharArray()[i] == c) {
                        numbs.add(arr.indexOf(c));
                    }
                }
            }
            String[] splitter = number.split("\\.");
            String[] str = splitter[0].split("");

            int sq = str.length - 1;
            double sum = 0.d;

            for (int i : numbs) {
                if (i != 36) {
                    sum += i * (Math.pow(sourceBase, sq));
                    sq--;
                }
            }
            log.info("convertToTen" + sum);
            return Double.toString(sum);
        }
    }
}
