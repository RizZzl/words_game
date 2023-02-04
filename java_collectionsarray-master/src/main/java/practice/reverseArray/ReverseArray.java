package practice.reverseArray;

public class ReverseArray {

    private static void swap(String[] strings, int i, int j) {
        String temp = strings[i];
        strings[i] = strings[j];
        strings[j] = temp;
    }

    public static String[] reverse(String[] strings) {
        for (int low = 0, high = strings.length - 1; low < high; low++, high--) {
            swap(strings, low, high);
        }
        return strings;
    }

}