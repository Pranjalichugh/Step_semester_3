import java.util.*;

abstract class Room {
    abstract double calculateBill(int units, int occupants);
}

class Single extends Room {
    double calculateBill(int units, int occupants) {
        return units * 8;
    }
}

class Shared extends Room {
    double calculateBill(int units, int occupants) {
        return (units * 6) / (double) occupants;
    }
}

class AC extends Room {
    double calculateBill(int units, int occupants) {
        return units * 10 + 200;
    }
}

public class Hostel {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double total = 0;

        for (int i = 0; i < N; i++) {

            String type = sc.next();
            int units = sc.nextInt();
            int occupants = 1;

            if (type.equalsIgnoreCase("SHARED"))
                occupants = sc.nextInt();

            Room room;

            if (type.equalsIgnoreCase("SINGLE"))
                room = new Single();
            else if (type.equalsIgnoreCase("SHARED"))
                room = new Shared();
            else
                room = new AC();

            double bill = room.calculateBill(units, occupants);

            System.out.printf("%s: %.2f%n", type, bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}