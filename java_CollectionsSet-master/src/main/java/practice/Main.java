package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    private static EmailList emailList = new EmailList();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            String[] commands = input.split("\\s");
            if (input.equals("0")) {
                break;
            }

            //TODO: write code here
            if (commands[0].equals("ADD")) {
                emailList.add(commands[1]);
            }

            if (commands[0].equals("LIST")) {
                System.out.println(emailList.getSortedEmails());
            }
        }
    }
}
