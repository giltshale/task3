import java.util.Scanner;

public class SwitchBetween2Letters {
    public static String switchedText(String receivedText) {
        char popular = receivedText.charAt(0);
        char secondPopular = receivedText.charAt(0);
        int count;
        int count2 = 0;
        int count3;
        int count4 = 0;
        char[] mixedArray;

        for (int j = 0; j < receivedText.length(); j++) {
            count = 0;
            count3 = 0;
            for (int k = 0; k < receivedText.length(); k++) {
                if (receivedText.charAt(j) == receivedText.charAt(k) && receivedText.charAt(j) != ' ') {
                    count++;
                    if (count > count2) {
                        popular = receivedText.charAt(j);
                        count2 = count;
                    }
                }
                if (popular != receivedText.charAt(k) && receivedText.charAt(k) != ' ' &&
                        receivedText.charAt(k) == receivedText.charAt(j)) {
                    count3++;

                    if (k != j && count3 < count2 && count3 > count4) {
                        secondPopular = receivedText.charAt(j);
                        count4 = count3;
                    }
                }
            }
        }
        System.out.println(popular);
        System.out.println(secondPopular);

        mixedArray = new char[receivedText.length()];
        for (int j = 0; j < receivedText.length(); j++) {

            if (popular == receivedText.charAt(j)) {
                mixedArray[j] = secondPopular;
            } else if ((secondPopular == receivedText.charAt(j))) {
                mixedArray[j] = popular;
            } else
                mixedArray[j] = receivedText.charAt(j);
        }
        return new String(mixedArray);
    }

    public static void main(String[] args) {
        String s = "mmmtt";
        String s1 = " this take text and test it";
        //ehis eakt etxe etse ie

        System.out.println(switchedText(s));
        System.out.println(switchedText(s1));
    }
}