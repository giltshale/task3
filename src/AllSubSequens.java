import java.util.Arrays;
import java.util.Scanner;

class AllSubSequence {
    public static String addSubStringToArray(int beginIndex, int endIndex, String str) {
        int subLength = endIndex - beginIndex;
        String combinedWord = "";
        if (((beginIndex == 0) && (endIndex == str.length()))) {
            return str;
        } else if (beginIndex >= 0) {
            if (endIndex <= str.length()) {
                if (subLength > 0) {
                    for (int i = beginIndex; i <= endIndex; i++)
                        combinedWord += str.charAt(i);
                }
            }
        }
        return combinedWord;

    }
    public static String[] substringsOfGivenString(String userInput) {
        int indexOfArray = 0;

        String[] allSubStringsLongerThen2Char;

        allSubStringsLongerThen2Char = new String[sizeOfSubStringArray(userInput)];

        for (int start = 0; start < userInput.length(); start++) {
            for (int end = start + 1; end < userInput.length(); end++) {
                if (allSubStringsLongerThen2Char[indexOfArray] == null) {
                    allSubStringsLongerThen2Char[indexOfArray] = "";
                }
                allSubStringsLongerThen2Char[indexOfArray] = addSubStringToArray(start, end, userInput);
                indexOfArray++;
            }
        }
        return allSubStringsLongerThen2Char;
    }
    public static String[] input() {

        String userInput;
        String separatingWords = "";
        String[] allSeparatedWords;
        int count = 0;
        int inputsOfUser = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("please enter 4 charecters string");
            userInput = scanner.nextLine();
            separatingWords += userInput + '-';
            count++;
        } while (userInput.length() >= 4);
        allSeparatedWords = new String[count - 1];
        String seperated = "";
        for (int j = 0; j < separatingWords.length(); j++) {
            if (separatingWords.charAt(j) == '-') {
                if (separatingWords.length() - j + 1 > 3) {
                    allSeparatedWords[inputsOfUser] = seperated;
                    seperated = "";
                    inputsOfUser++;
                }
            } else {
                seperated += separatingWords.charAt(j);
            }
        }
        return allSeparatedWords;

    }
    public static boolean areTheSameStrings(String first, String second) {
        boolean theSame = true;
        if (first.length() == second.length()) {
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    theSame = false;
                    break;
                }
            }
        } else {
            theSame = false;
        }
        return theSame;
    }
    public static int sizeOfSubStringArray(String userInput) {
        int count = 0;
        for (int i = 1; i < userInput.length(); i++) {
            count += userInput.length() - i;
        }
        return count;
    }
    public static String[] allSubSequencesArray(String[] receivedString) {
        int count = 0;
        for (String c : receivedString) {
            count += substringsOfGivenString(c).length;
        }
        String[] subSequences = new String[count];
        int k = 0;
        for (int i = 0; i < receivedString.length; i++) {
            for (int j = 0; j < substringsOfGivenString(receivedString[i]).length; j++) {
                if (k != subSequences.length) {
                    subSequences[k] = substringsOfGivenString(receivedString[i])[j];
                    k++;
                } else break;
            }
        }
        return subSequences;
    }
    public static String mostPopularString(String[] receivedString) {
        int maxCount = 1;
        String startingString="";
        String wantedString="";
        String comparedString;
        for (int i = 0; i < allSubSequencesArray(receivedString).length; i++) {
            int count = 0;
            startingString = allSubSequencesArray(receivedString)[i];
            for (int j = 0; j < allSubSequencesArray(receivedString).length; j++) {
                comparedString = allSubSequencesArray(receivedString)[j];
                if (i != j && areTheSameStrings(startingString,
                        comparedString)) {
                    count++;
                }
                if (count >= maxCount) {
                    maxCount = count;
                    wantedString = startingString;
                }
            }

        }return wantedString;
    }
    public static void main(String[] args) {
       // input();
      //  String[] s = new String[2];
       //  System.out.println(Arrays.toString(substringsOfGivenString(("java"))));
     //   System.out.println(Arrays.toString(input()));
    }

}

