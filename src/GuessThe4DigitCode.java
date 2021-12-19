
import java.util.Random;
import java.util.Scanner;

public class GuessThe4DigitCode {
    public static boolean duplicatedNumber(int digit) {
        boolean duplicte = false;
        String divert = "";
        divert += digit;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (divert.charAt(i) == divert.charAt(j)) {
                    duplicte = true;
                    break;
                }
            }
        }
        return duplicte;
    }

    public static void correctLocationGuess(int userGuess, int code) {
        String userInput = "";
        String randomeCode = "";
        int count = 0;
        int count2 = 0;
        userInput += userGuess;
        randomeCode += code;
        for (int i = 0; i < 4; i++) {
            if (userInput.charAt(i) == randomeCode.charAt(i)) {
                count++;
            }
        }
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                if (k != j && randomeCode.charAt(j) == userInput.charAt(k)) {
                    count2++;
                }
            }
        }
        System.out.println(" you have " + count + " acurate guesses, " + " and " + count2 + " half correct guesses "+ "\n");
    }

    public static boolean isCorrectCode(int digit) {
        boolean correct = true;
        String diverted = "";
        diverted += digit;
        if (diverted.length() == 3) {
            diverted = "0" + diverted;
        }
        if (diverted.length() != 4 || diverted.charAt(0) != '1') {
            correct = false;
        }

        for (int j = 0; j < 4; j++) {
            if (diverted.charAt(j) > '6' || diverted.charAt(j) < '1') {
                correct = false;
                break;

            }

        }
        return correct;
    }

    public static int level() {
        int userChoice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("please enter level in range of 1-4: "+"\n"+"" +
                    "number 1: 20 attempts" +"\n"+
                    "number 2: 15 attempts" +"\n"+
                    "number 3: 10 attempts" +"\n"+
                    "number 4: unknown numbers of attempts and without knowing how many attempts left. "+"\n");
            userChoice = scanner.nextInt();
        } while (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 4);
        return userChoice;
    }

    public static void main(String[] args) {
        int code;
        int attemptsLeft = 0;
        int level;
        int userGuess=0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        do {
            code = random.nextInt(5999) + 1234;

        } while (!isCorrectCode(code) || duplicatedNumber(code));
        System.out.println(code);
        level = level();
        switch (level) {
            case 1:
                attemptsLeft = 20;
                System.out.println("you have 20 attemps to find the code! ! !"+ "\n");
                break;
            case 2:
                attemptsLeft = 15;
                System.out.println("you have 15 attemps to find the code! ! !"+ "\n");
                break;
            case 3:
                attemptsLeft = 10;
                System.out.println("you have 10 attemps to find the code! ! !"+ "\n");
                break;
            case 4:
                attemptsLeft = random.nextInt(20) + 5;
                break;
            default:
                System.out.println("there is no level " + level+ "\n");
                break;
        }
        String userAttemp = "";
        while (attemptsLeft != 0) {
            do {
                System.out.println(" please enter 4 digit number all in range 1-6: " + "\n" +
                        "* number starts with  the digit 1 " + "\n" +
                        "* no digits that repeats twice");

                userGuess = scanner.nextInt();
                userAttemp += userGuess;

            } while (userAttemp.length() != 4 && !isCorrectCode(userGuess));
            if (code == userGuess) {
                System.out.println("congratulations you found the correct code!");
                break;
            } else if (isCorrectCode(userGuess) && !duplicatedNumber(userGuess)) {
                attemptsLeft--;
                if (level != 4) {
                    System.out.println("you have left " + attemptsLeft+ " attemps ");
                }
                correctLocationGuess(userGuess, code);
            } else if (duplicatedNumber(userGuess)) {
                attemptsLeft -= 2;
                if (level != 4) {
                    System.out.println("you entered twice the same number!! you have left " + attemptsLeft+ " attemps "+ "\n");
                }
                correctLocationGuess(userGuess, code);
            }
        }
        if (attemptsLeft == 0&& userGuess!=code) {
            System.out.println("YOU LOSE,THE CORRECT CODE IS: " + code+ "\n");
        }
    }
}
