package practice;
import java.util.*;

public class EmailList {
        TreeSet<String> emailList = new TreeSet<>();
    public void add(String email) {
        char d = (char) 64;
        String a = String.valueOf(d);
        String point = email.substring(email.length() - 3, email.length() - 2);
        email = email.toLowerCase();
        if (point.equals(".")) {
            emailList.add(email);
        }

    }

    public List<String> getSortedEmails() {
        return new ArrayList<String>(emailList);
    }

}
