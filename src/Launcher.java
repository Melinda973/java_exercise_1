import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

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

    private static void Freq(String filename) {
        String content;
        try {
            content = java.nio.file.Files.readString(Path.of(filename));
        } catch (IOException e) {
            System.err.println("Unreadable file: " + e.getMessage());
            return;
        }

        content = content.toLowerCase().replaceAll("[.!?\\-'\"\n]", " ");

        Map<String, Integer> freq = new HashMap<>();

        for (var word : content.split(" ")) {
            if (word.isBlank()) continue;

            freq.putIfAbsent(word, 0);
            freq.put(word, freq.get(word) + 1);
        }

        List<String> words = new ArrayList<>();

        while(words.size() < 3 && freq.keySet().size() > 0) {
            int max = Collections.max(freq.values());
            var keys = freq.keySet().stream().filter(k -> freq.get(k) == max).collect(Collectors.toList());
            var last = keys.get(keys.size() - 1);
            words.add(last);
            freq.remove(last);
        }

        System.out.println(String.join(" ", words));
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
            else if (entry.equals("freq")) {
                System.out.println("Veuillez saisir le nom du fichier pour lequel vous voulez une analyse:");
                Freq(scanner.nextLine());
            }
            else {
                System.out.println("Unknown command");
            }
        } while(ShouldContinue);
    }
}
