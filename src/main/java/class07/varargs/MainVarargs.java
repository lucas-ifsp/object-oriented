import class07.varargs.SalaryUtils;

import java.util.ArrayList;

void main(){
    System.out.println(SalaryUtils.averageSalary(1_000.0, 3_000.0));
    System.out.println(SalaryUtils.averageSalary(1_000.0, 3_000.0, 5_000.0));
    // It is necessary to create an array or collection to store the data before using the method
    //double[] salaries = {1_000.0, 3_000.0, 5_000.0, 7_000.0};
    System.out.println(SalaryUtils.averageSalary(1_000.0, 3_000.0, 5_000.0, 7_000.0));
}

