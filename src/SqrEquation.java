import java.util.Scanner;

public class SqrEquation {
    public static boolean isNumber(String s) {
        boolean result = true;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                count++;
                continue;
            }
            if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                result = false;
                break;
            }
            if (count > 1) {
                result = false;
            }
        }
        return result;
    }

    public static void resultOfCorrectEquation(int a, int b, int c) {
        double delta = ((Math.pow(b, 2) - 4 * a * c));
        if (delta > 0) {
            System.out.println("The solutions are: ");
            System.out.println((-b + Math.sqrt(delta)) / (2 * a));
            System.out.println((-b - Math.sqrt(delta)) / (2 * a));
        } else if (delta < 0) {
            System.out.println("the equation cant be solved");

        } else {
            System.out.println("The solutions is: ");
            System.out.println(-b / 2 * a);

        }
    }

    public static String extractNumbers(int index, String userInput) {
        char symbol = 'x';
        String checkIfNotNumber = "";
        checkIfNotNumber += userInput.charAt(index + 1);
        if (index >= 6 && index <= 10) {
            if (userInput.charAt(index + 1) != 'x' || (isNumber(checkIfNotNumber) && userInput.charAt(index) == '-')) {
                symbol = '=';
            }
        }
        String startingString = "";
        int i = 0;
        while (userInput.charAt(index) != symbol) {
            if (i >= 3 && !isNumber(startingString)) {
                break;
            }
            startingString += userInput.charAt(index) + "";
            i++;
            if (index < userInput.length() - 1) {
                index++;
            }


        }
        return startingString;
    }

    public static void receiveDataAndCheckCorrection() {
        System.out.println("please enter userInput a b c for an equation in format ax^2+bx+c=0:");
        Scanner scanner = new Scanner(System.in);
        String startingString = "";
        String stringBelongsToB = "";
        String stringBelongsToC = "";
        String numberString = "";

        int inputLength;
        int a, b, c, j;
        boolean goodA = false;
        boolean goodB = false;
        boolean goodC = false;
         String userInput = scanner.nextLine();
        inputLength = userInput.length() - 1;
        a = 0;
        b = 0;
        c = 0;
        j = 0;
        if (inputLength >= 8 && userInput.charAt(inputLength) == '0' && userInput.charAt(inputLength - 1) == '=') {
            if (userInput.charAt(0) == '-' || userInput.charAt(0) == 'x' ||
                    (isNumber(startingString + userInput.charAt(0))&&userInput.charAt(1)=='x'))
                if (userInput.charAt(j) == 'x') {
                    a = 1;
                    goodA = true;
                } else if (userInput.charAt(j) == '-' && userInput.charAt(j + 1) == 'x') {
                    a = -1;
                    j++;
                    goodA = true;
                } else {
                    String stringBelongsToA = extractNumbers(j, userInput);
                    numberString = "";
                    if (stringBelongsToA.charAt(j) == '-') {
                        for (int i = j + 1; i < stringBelongsToA.length(); i++) {
                            numberString += userInput.charAt(i);
                            if (isNumber(numberString)) {
                                j += stringBelongsToA.length();
                                a = Integer.parseInt(stringBelongsToA);
                                goodA = true;
                            } else break;
                        }
                    } else if (isNumber(numberString)) {
                        j += stringBelongsToA.length();
                        a = Integer.parseInt(stringBelongsToA);
                        goodA = true;
                    }
                }
            if (userInput.charAt(j) == 'x') {
                j++;
                if (userInput.charAt(j) == '^') {
                    j++;
                    if (userInput.charAt(j) == '2') {
                        j++;
                        if (userInput.charAt(j) == '+' && userInput.charAt(j + 1) == 'x') {
                            b = 1;
                            j += 2;
                            goodB = true;
                        } else if (userInput.charAt(j) == '-' && userInput.charAt(j + 1) == 'x') {
                            b = -1;
                            j += 2;
                            goodB = true;
                        } else if ((userInput.charAt(j) == '+') && userInput.charAt(j + 1) != 'x') {
                            j++;
                            stringBelongsToB = extractNumbers(j, userInput);
                            numberString = "";
                            for (int i = 0; i < stringBelongsToB.length(); i++) {
                                numberString += userInput.charAt(j);
                                if (isNumber(stringBelongsToB)) {
                                    j += stringBelongsToB.length();
                                    b = Integer.parseInt(stringBelongsToB);
                                    goodB = true;
                                } else break;
                            }

                        } else if (userInput.charAt(j) == '-' && userInput.charAt(j + 1) != 'x') {
                            {
                                stringBelongsToB = extractNumbers(j, userInput);
                                if (isNumber(stringBelongsToB)) {
                                    j += stringBelongsToB.length();
                                    b = Integer.parseInt(stringBelongsToB);
                                    goodB = true;
                                }
                            }
                        }
                        if (userInput.charAt(j) == 'x') {
                            j++;
                        } else if (userInput.charAt(j) == '+' && userInput.charAt(j + 1) == '1') {
                            c = 1;
                            j += 2;
                            goodC = true;
                        } else if (userInput.charAt(j) == '-' && userInput.charAt(j + 1) == '1') {
                            c = -1;
                            j += 2;
                            goodC = true;
                        }
                        if (userInput.charAt(j) == '+' && isNumber(startingString + userInput.charAt(j + 1))) {
                            j++;
                            stringBelongsToC = extractNumbers(j, userInput);
                            numberString = "";
                            int i = 0;
                            while (i < stringBelongsToC.length()) {
                                numberString += userInput.charAt(j);
                                if (isNumber(numberString)) {
                                    c = Integer.parseInt(stringBelongsToC);
                                    goodC = true;
                                } else break;
                                i++;
                            }
                        } else if (userInput.charAt(j) == '-' && isNumber(startingString + userInput.charAt(j + 1))) {
                            {
                                stringBelongsToC = extractNumbers(j, userInput);
                                numberString = "";
                                int i = 0;
                                while (i <= stringBelongsToC.length() && goodB) {
                                    numberString += userInput.charAt(j);
                                    if (isNumber(numberString)) {
                                        c = Integer.parseInt(stringBelongsToC);
                                        goodC = true;
                                    }
                                    i++;
                                }
                                //  if (isNumber(numberString)) {
                                //      c = getC(userInput, c, j, stringBelongsToC, numberString);
                                //     goodC = true;
                                //  }
                            }
                        }
                    }

                }

            }
        }
        System.out.println(a + " " + b + " " + c);
        if (goodA && goodB && goodC) {
            resultOfCorrectEquation(a, b, c);
        } else System.out.println("wrong input");
    }

    public static void main(String[] args) {
receiveDataAndCheckCorrection();

    }
}
