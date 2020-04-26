package converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startApp();
    }

    public static void startApp() {
        RadixConv radixConv = new RadixConv();
        String alph = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        int sourceBase = 0;
        String number = "";
        int newBase = 0;
        boolean isOk = true;
        List<Character> list = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        char[] mas = alph.toCharArray();

        Scanner scanner = new Scanner(System.in);
        String sc = scanner.next();
        for (char c : sc.toCharArray()) {
            list.add(c);
        }
        for (char s : mas) {
            if (list.contains(s)) {
                isOk = false;
                break;
            }
        }
        if (isOk) sourceBase = Integer.parseInt(sc);
        else System.out.println(sc);

        Scanner scanner1 = new Scanner(System.in);
        if(scanner1.hasNext()) {
            number = scanner1.nextLine();
        }

        Scanner scanner2 = new Scanner(System.in);
        if(scanner2.hasNext()) {
            String sc2 = scanner2.next();

            for (char c : sc2.toCharArray()) {
                list2.add(c);
            }
            for (char s : mas) {
                if (list2.contains(s)) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                newBase = Integer.parseInt(sc2);
                if(newBase < 1 || newBase > 36) {
                    isOk = false;
                    System.out.println(sc2);
                }
            }
            else System.out.println(sc2);
        } else { isOk = false; }
        if(isOk) radixConv.converter(sourceBase, number, newBase);
        else
            System.out.println("error");
    }
}
