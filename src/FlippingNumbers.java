public class FlippingNumbers {
    static boolean isFlippingNumber(int number) {
        int length = (int) (Math.log10(number) + 1);
        int arrIndex = 0;

        if (number < 10)
            return true;
        int[] arr = new int[length];
        while (number > 0) {
            arr[arrIndex] = number % 10;
            arrIndex++;
            number = number / 10;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] % 2 == 1) {
                if (arr[i + 1] % 2 == 0) {
                    continue;
                } else
                    return false;
            } else if (arr[i] % 2 == 0) {
                if (arr[i + 1] % 2 == 1) {
                    continue;
                } else
                    return false;
            }
        }
        return true;
    }
    public static int sumOfDigits(int number) {
        int sumOfDigits = 0;
        int digit;
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
    public static int indexOfTheLowestFlipping(int[] arr) {
        double lowest = Double.POSITIVE_INFINITY;
        int sumOfIndex;
        int lowestSumIndex = 0;
        for (int i = 0; i < arr.length; i++) {

            if (isFlippingNumber(arr[i])) {
                sumOfIndex = sumOfDigits(arr[i]);
                if (lowest > sumOfIndex) {
                    lowest = sumOfIndex;
                    lowestSumIndex = i;
                }
                return lowestSumIndex;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
     //   System.out.println(isFlippingNumber(163458 ));
     //   System.out.println(isFlippingNumber(163789   ));
    //    System.out.println(indexOfTheLowestFlipping(new int []{21,32,33,44}));

    }
}
