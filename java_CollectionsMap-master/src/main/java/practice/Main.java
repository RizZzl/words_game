package practice;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static PhoneBook phonesBook = new PhoneBook();

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();

            String command = str.replaceAll("[^A-Z]+", "");
            String name = str.replaceAll("[^А-Яа-я]+", "");
            String phone = str.replaceAll("[^0-9]+", "");

            if (str.equals(phone + " " + name)) {
                phonesBook.addContact(phone, name);
            }
            if (str.equals(name)) {
                phonesBook.addContact(phone, name);
            }

            if (str.equals(phone)) {
                phonesBook.addContact(phone, name);
            }

            if (command.equals("LIST")) {
                System.out.println(phonesBook.getAllContacts());
            }
        }
    }
}
