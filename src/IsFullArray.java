public class IsFullArray {

    public static boolean arrayIsFull(int[] arr) {
        int lowestNumber;
        int biggestNumber;
        if (arr.length == 0) {
            return true;
        }
        lowestNumber = arr[0];
        biggestNumber = arr[0];
        for (int number : arr) {
            if (number < lowestNumber)
                lowestNumber = number;
            else if (number > biggestNumber) {
                biggestNumber = number;
            }

        }
        if (arr.length != biggestNumber - lowestNumber + 1) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < lowestNumber || arr[i] > biggestNumber) {
                return false;
            }
            for (int value : arr) {
                if (arr[i] - value == 1)
                    break;
            }
        }
        return true;

    }

    public static boolean IsDesendingArrayIsFull(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] - arr[i + 1] != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a[] = new int[]{12,11,10,9};
        //System.out.println(arrayIsFull(a));
        // System.out.println(IsDesendingArrayIsFull(a));
    }
}
