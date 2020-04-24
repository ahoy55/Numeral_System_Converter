package converter;

import java.util.List;

public class Converter {
    public double conToDec(List<Integer> nums, int sys) {
        int sq = (nums.size() - 2) - nums.indexOf(36);
        System.out.println(sq + " | " + nums.indexOf(36));
        double sum = 0.F;
        for (Integer num : nums) {

            double sums = sum;
            if (num != 36) {
                sum += num * (Math.pow(sys, sq));
                System.out.println(sums + " = " + num + "*" + sys + "^" + sq);
                sq--;
            }
        }
        return sum;
    }
    public int tenToAny(String val, int consys) {
        return Integer.parseInt(val, consys);
    }
    public double conFloat(double d, int sys, int consys) {
        double res = 0.f;
        if(sys == 10) {
            for (int i = 0; i < 3; i++) {
                res = d * consys;
                System.out.println(res);
                res -= (int) res;
            }
        }
        return  res;
    }
}
