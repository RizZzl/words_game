package practice;

import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        String[] lettersForNumbers = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        String[] randomLettersForNumbers = new String[(lettersForNumbers.length - 1) * (lettersForNumbers.length - 1) + 1];
        for (int i = 0; i < lettersForNumbers.length; i++) {
            for (int j = 0; j < lettersForNumbers.length; j++) {
                StringBuilder builder = new StringBuilder();
                randomLettersForNumbers[i * 10 + j] = builder.append(lettersForNumbers[i]).append(lettersForNumbers[j]).toString();
            }
        }

        String[] digitsForNumbers = new String[9];
        for (int i = 1; i < digitsForNumbers.length; i++) {
            digitsForNumbers[i] = Integer.toString((i * 111));
        }

        List<String> coolNumbers = new ArrayList<>();
        for (int i = 1; i < 200; i++) {
            StringBuilder region = new StringBuilder();
            String formatRegion = region.append("00").append(i).substring(region.length() - 3);
            for (int j = 0; j < digitsForNumbers.length; j++) {
                for (int k = 0; k < lettersForNumbers.length; k++) {
                    for (int l = 0; l < randomLettersForNumbers.length; l++) {
                        StringBuilder builder = new StringBuilder();
                        coolNumbers.add(builder.append(lettersForNumbers[k]).append(digitsForNumbers[j]).append(randomLettersForNumbers[l]).append(formatRegion).toString());
                    }
                }
            }
        }
        return coolNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return Collections.binarySearch(sortedList, number) >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
