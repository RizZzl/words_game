package practice.regex;

public class SplitText {

  public static void main(String[] args) {
  }

  public static String splitTextIntoWords(String text) {
    StringBuilder stringBuilder = new StringBuilder();
    String regex = "[^a-zA-z\\s]";
    text = text.replaceAll(regex, "");
    String[] words = text.split("\\s+");
    for(int i = 0; i < words.length; i++) {
      if (text.length() > 0) {
        stringBuilder.append(words[i]).append('\n');
      } else {
        return "";
      }
    }
    return stringBuilder.toString().trim();
  }

}