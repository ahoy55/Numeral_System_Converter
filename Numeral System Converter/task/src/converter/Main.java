package converter;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String valstr;
    static String res;
    static int sys = 0;
    static int consys = 0;
    static String arr = "0123456789abcdefghijklmnopqrstuvwxyz.";

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Sys = ");
            sys = scan.nextInt();

            Scanner scan1 = new Scanner(System.in);
            System.out.print("\nVal = ");
            if (scan1.hasNextLine()) valstr = scan1.nextLine();

            Scanner scan2 = new Scanner(System.in);
            System.out.print("\nConsys = ");
            consys = scan2.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        startCon(valstr, sys, consys);
    }

    //=====================================================================================
    static void startCon(String valstr, int sys, int consys) {
        Converter conv = new Converter();
        try {
            double d = Double.parseDouble(valstr);
            res = Double.toString(conv.conFloat(d,sys,consys));
            System.out.println(d);
        } catch (Exception ex) {
            if (sys == 1) {
                int a = valstr.toCharArray().length;
                if (consys == 10) res = f(a);
                else res = f(conv.tenToAny(f(a), consys));
            } else if (sys == 10) {
                if (consys != 1) {
                    res = f(conv.tenToAny(valstr, consys));
                } else {
                    res = "1".repeat(valstr.length());
                }
            } else if (sys == 36 || sys == 35) {
                try {
                    int a = Integer.parseInt(valstr, sys);
                    res = Integer.toString(a, consys);

                } catch (Exception e) {
                    StringBuilder number = new StringBuilder();
                    List<Integer> nums = new ArrayList<>();
                    for (int i = 0; i < valstr.length(); i++) {
                        for (char c : arr.toCharArray()) {
                            if (valstr.toCharArray()[i] == c) {
                                number.append(arr.indexOf(c)).append(" ");
                                nums.add(arr.indexOf(c));
                            }
                        }
                    }
                    double b = conv.conToDec(nums, sys);
                    System.out.println();
                    System.out.println(number);
                }
            } else {
                if (consys == 10) {
                    res = f(Integer.parseInt(valstr, sys));
                } else {

                }
            }
        }
        System.out.println("*******\nResult = " + res);
    }

    static String f(int val) {
        return String.format("%s", val);
    }

    static int i(String str) {
        return Integer.parseInt(str);
    }
}
