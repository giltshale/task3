import java.util.Arrays;

public class DefuseToPrimeMultiplication {
    public static int[] primeIngredients(int number) {
        int[] arrayWithZeros = new int[number];
        int[] fixedArray;
        int count = 0;
        int i;
        for (i = 2; i < number; i++) {
            while (number % i == 0) {
                arrayWithZeros[count] = i;
                count++;
                number /= i;
            }
        }
        if (number >= 2) {
            arrayWithZeros[count] = number;
        } else {
            count--;
        }

        fixedArray = new int[count + 1];
        for (int j = 0; j < fixedArray.length; j++) {
            if (arrayWithZeros[j] > 0) {
                fixedArray[j] = arrayWithZeros[j];
            }
        }
        return fixedArray;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(primeIngredients(12600)));
    }
}
