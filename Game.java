import java.io.Console;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Game {
    public static void main(String[] args) {
        System.out.println("Countries Game");
        System.out.println("Type 'exit' to stop the game");
        Console console = System.console();
        BufferedReader br = null;
        int total = 0;
        int correct = 0;

        try {
            br = new BufferedReader(new FileReader("continents.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                total++;
                String[] cols = line.split(",");
                String country = cols[0];
                String continent = cols[1];
                String answer = null;
                answer = console.readLine("which continent does " + country + " belong to?");
                do {
                    answer = console.readLine("Which continent does " + country + " belong to? ");
                    if (answer.equalsIgnoreCase("help")) {
                        printHelp();
                    }
                } while (answer.equalsIgnoreCase("help"));
                if (answer.equalsIgnoreCase("exit")) {
                    break;
                } else if (answer.equals(continent)) {
                    System.out.println("Correct!");
                    correct++;
                } else {
                    System.out.println("No, the answer is " + continent);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("You scored  " + correct + " out of  " + total);
    }

    public static void printHelp() {
        System.out.println("Guess the continent");
        System.out.println("Type 'exit' to stop the game or 'help' to get this text.");
    }
}