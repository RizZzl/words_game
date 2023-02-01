package practice.string;

public class SequentialWordsNumbers {
    public static void main(String[] args) {
        System.out.println(sequentialWordsNumbers("Это"));
    }

    public static String sequentialWordsNumbers(String text){
        StringBuilder stringBuilder = new StringBuilder();
        String word = "";
        int num = 0;
        String textWithSpase = text + " ";
        if (textWithSpase.length() < 2) {
            return "";
        } else {
            for (int i = 0; i < textWithSpase.length(); i++) {
                if (textWithSpase.charAt(i) != ' ') {
                    word = word + textWithSpase.charAt(i);
                } else {
                    num++;
                    stringBuilder.append(" (" + num + ") " + word);
                    word = "";
                }
            }
        }
        return stringBuilder.toString().trim();
    }
}
