import java.util.*;

abstract class Customer {
    abstract double calculate(double amount);
}

class Student extends Customer {
    double calculate(double amount) {
        return amount * 0.90;  
    }
}

class Staff extends Customer {
    double calculate(double amount) {
        return amount * 0.95;  
    }
}

class Guest extends Customer {
    double calculate(double amount) {
        return amount + 10;  
    }
}

public class Bill {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double total = 0;

        for (int i = 0; i < N; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            if (type.equals("STUDENT"))
                customer = new Student();
            else if (type.equals("STAFF"))
                customer = new Staff();
            else
                customer = new Guest();

            double finalAmount = customer.calculate(amount);

            System.out.printf("%s: %.2f%n", type, finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
