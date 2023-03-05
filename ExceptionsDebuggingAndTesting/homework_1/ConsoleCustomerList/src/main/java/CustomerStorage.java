import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws IllegalAccessException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String phoneNumberRegExp = "^(\\+7|8)[0-9]{10}";
        String emailCheckRegExp = "\\A[^@]+@([^@\\.]+\\.)+[^@\\.]+\\z";

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong format.\nCorrect format: " +
                    "Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if(!components[2].matches(emailCheckRegExp)) {// проверяем почтовый ящик
            throw new IllegalArgumentException("Wrong format e-mail address: " + components[2] +
                    "\nCorrect format: vasily.petrov@gmail.com");
        }
        if(!components[3].matches(phoneNumberRegExp)) // проверяем номер телефона
            throw new IllegalArgumentException("Wrong format phone number: "  + components[3] +
                    "\nCorrect format: +79215637722");

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        if(storage.size() == 0) {
            throw new IllegalArgumentException("The list of clients is empty");
        }
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if(!storage.containsKey(name)) {
            throw new IllegalArgumentException("The specified client was not found");
        }
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}