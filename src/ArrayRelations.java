import java.sql.Array;
import java.util.Arrays;

public class ArrayRelations {
    public static int sumOfDigits(int number) {
        int digit ;
        int sumOfDigits = 0;
        if (number < 10) {
            return number;
        }
        while (number > 0) {
            digit = number % 10;
            sumOfDigits += digit;
            number /= 10;
        }
        return sumOfDigits;
    }

    public static boolean brothers(int firstNumber, int secondNumber) {
        return sumOfDigits(firstNumber) == sumOfDigits(secondNumber);
    }

    public static int relations(int[] arr1, int[] arr2) {
        int[] amountOfBothers = new int[arr1.length];
        int countBrothers ;
        for (int i = 0; i < arr1.length; i++) {
            countBrothers = 0;
            for (int j = 0; j < arr2.length; j++) {
                if (brothers(arr1[i], arr2[j])) {
                    countBrothers++;
                }
                if (j == arr2.length - 1) {
                    amountOfBothers[i] = countBrothers;
                }
            }
        }

        int relativeNumber = amountOfBothers[0];
        int indexWithMostBrothers=0;
        for (int i = 0; i < amountOfBothers.length ; i++) {
            if (relativeNumber < amountOfBothers[i]) {
                relativeNumber=amountOfBothers[i];
                indexWithMostBrothers = i;
            }
        }
        return indexWithMostBrothers;
    }

    public static void main(String[] args) {
       // int[] arr2 = new int[]{43, 340, 331, 24, 200, 31, 13};
     //   int[] arr1 = new int[]{0,0,7};
        //System.out.println(relations(arr1, arr2));

    }
}
