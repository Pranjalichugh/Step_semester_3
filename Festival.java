import java.util.*;

abstract class Employee {
    abstract double calculateBonus(double salary);
}

class FullTime extends Employee {
    double calculateBonus(double salary) {
        return salary * 0.10;
    }
}

class PartTime extends Employee {
    double calculateBonus(double salary) {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    double calculateBonus(double salary) {
        return 2000;
    }
}

public class Festival {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double total = 0;

        for (int i = 0; i < N; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee;

            if (type.equalsIgnoreCase("FULLTIME"))
                employee = new FullTime();
            else if (type.equalsIgnoreCase("PARTTIME"))
                employee = new PartTime();
            else
                employee = new Intern();

            double bonus = employee.calculateBonus(salary);

            System.out.printf("%s: %.2f%n", name, bonus);

            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);

        sc.close();
    }
}