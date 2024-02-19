package class07.varargs;

import java.util.Arrays;

public class SalaryUtils {
    private SalaryUtils(){}

//    public static double averageSalary(double salary1, double salary2){
//        return (salary1 + salary2) / 2;
//    }
//
//    public static double averageSalary(double salary1, double salary2, double salary3){
//        return (salary1 + salary2 + salary3) / 3;
//    }

//    public static double averageSalary(double[] salaries){
//        return Arrays.stream(salaries).average().orElse(0);
//    }

    public static double averageSalary(double... salaries){
        return Arrays.stream(salaries).average().orElse(0);
    }
}
