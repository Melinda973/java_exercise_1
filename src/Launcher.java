import java.util.List;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome !");

        List<Command> commands = List.of(
                new Quit(),
                new Fibo(),
                new Freq()
        );

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter some command:");
            String instruction = scanner.nextLine();
            boolean shouldContinue = false;
            for (var i : commands) {
                if (i.name().equals(instruction)) {
                    if (i.run(scanner))
                        return;

                    shouldContinue = true;
                }
            }

            if (!shouldContinue)
                System.out.println("Unknown command");
        } while (true);
    }
}
