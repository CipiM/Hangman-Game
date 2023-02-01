import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("D:/Generatia TECH/Angajabilitate/Tier 1/Hangman/words.txt"));


        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        Random random = new Random();

        String word = words.get(random.nextInt(words.size()));

        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();


        Scanner keyboard = new Scanner(System.in);

        int wrongCount = 0;

        while (true) {

            printHangman(wrongCount);

            if (wrongCount >=6){
                System.out.println("I'm sorry! YOU lose!");
                break;
            }

            printWord(word, playerGuesses);
            if(!getPlayerGuesses(word, playerGuesses, keyboard)){
                wrongCount++;
            }

            if (printWord(word, playerGuesses)) {
                System.out.println("Nicee! YOU WIN!");
                break;
            }
            System.out.println("Enter your guess for the word: ");
            if (keyboard.nextLine().equals(word)) {
                System.out.println("Nicee! YOU WIN!");
                break;
            } else {
                System.out.println("Sorry! Try again.");
            }
        }

    }



    private static boolean getPlayerGuesses(String word, List<Character> playerGuesses, Scanner keyboard) {
        System.out.println("Enter a letter: ");
        String letterG = keyboard.nextLine();         //input from the user
        playerGuesses.add(letterG.charAt(0));

        return word.contains(letterG);

    }

    private static boolean printWord(String word, List<Character> playerGuesses) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                count++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
        return (word.length() == count);
    }

    private static void printHangman(int wrongCount) {
        System.out.println(" _______ ");
        System.out.println(" |     ");
        if (wrongCount >= 1) {
            System.out.println(" 0");
        }

        if (wrongCount >= 2) {
            System.out.print("\\ ");
        }

        if (wrongCount >= 3) {
            System.out.println("/");
        } else {
            System.out.println("");
        }

        if (wrongCount >= 4) {
            System.out.println(" |");
        }

        if (wrongCount >= 5) {
            System.out.print("/ ");
        }

        if (wrongCount >= 6) {
            System.out.println("\\");
        } else {
            System.out.println("");
        }
        System.out.println("");
    }
}
