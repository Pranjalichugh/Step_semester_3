import java.time.LocalDate;
import java.util.*;

abstract class Plan {
    abstract int getDays();
}

class Basic extends Plan {
    int getDays() {
        return 30;
    }
}

class Standard extends Plan {
    int getDays() {
        return 90;
    }
}

class Premium extends Plan {
    int getDays() {
        return 365;
    }
}

public class Streaming {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {

            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            Plan plan;

            if (type.equalsIgnoreCase("BASIC"))
                plan = new Basic();
            else if (type.equalsIgnoreCase("STANDARD"))
                plan = new Standard();
            else
                plan = new Premium();

            LocalDate startDate = LocalDate.parse(date);
            LocalDate renewalDate = startDate.plusDays(plan.getDays());

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}