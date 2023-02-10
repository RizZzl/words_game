package practice;
import java.util.*;

public class EmailList {
    TreeSet<String> emailList = new TreeSet<>();

    public void add(String email) {
        email = email.toLowerCase();
        String format = email.replaceAll("[^@.]", "").trim();
        if (format.equals("@.")) {
            emailList.add(email);
        }

    }

    public List<String> getSortedEmails() {
        return new ArrayList<String>(emailList);
    }

}
