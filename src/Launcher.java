import java.util.List;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome to the Launcher Class!");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String entry = scanner.nextLine();
         while (!entry.equals("quit")) {
            System.out.println("Unknown command");
            entry = scanner.nextLine();
        }
    }
}
