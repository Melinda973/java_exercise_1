import java.util.Scanner;

public class Launcher {

    private static int Fibo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Should be positive");
        }
        if (n == 0 || n == 1) {
            return n;
        }
        return Fibo(n-1) + Fibo(n-2);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Launcher Class!");
        Scanner scanner = new Scanner(System.in);
        boolean ShouldContinue = true;
        do {
            System.out.println("Enter some command:");
            String entry = scanner.nextLine();
            if (entry.equals("quit")) {
                ShouldContinue = false;
            }
            else if (entry.equals("fibo")) {
                System.out.print("Enter a number: ");
                String num = scanner.nextLine();
                int n = Integer.parseInt(num);
                System.out.println(Fibo(n));
            }
            else {
                System.out.println("Unknown command");
            }
        } while(ShouldContinue);
    }
}
