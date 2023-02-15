package practice;

import java.util.*;

public class PhoneBook {
    Map<String, String> phoneBook = new HashMap<>();
    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (phone.matches("[\\d]{11}") && name.matches("[А-Яа-я]+")){
            if (phoneBook.containsKey(phone)){
                phoneBook.replace(phone, phoneBook.get(phone), name);
            } else {
                phoneBook.put(phone, name);
            }
        }
    }


    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        if (phoneBook.containsKey(phone)) {
            return phoneBook.get(phone) + " - " + phone;
        } else {
            return "";
        }
    }

    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        TreeSet<String> setPhoneBook = new TreeSet<>();
        String telPlusName = "";
        if (phoneBook.containsValue(name)) {
            telPlusName = telPlusName.concat(name) + " - ";
            for (String telephone : phoneBook.keySet()) {
                if (phoneBook.get(telephone).equals(name)) {
                    telPlusName = telPlusName.concat(telephone) + ", ";
                }
            }
            setPhoneBook.add(telPlusName.substring(0, telPlusName.length() - 2));
            return setPhoneBook;
        } else {
            return new TreeSet<>();
        }
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet

        Map<String, String> contacts = new HashMap<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (contacts.containsKey(entry.getValue())) {
                String numbers = contacts.get(entry.getValue());
                contacts.put(entry.getValue(), numbers.concat(", ").concat(entry.getKey()));
            } else {
                contacts.put(entry.getValue(), entry.getKey());
            }
        }
        TreeSet<String> setPhoneBook = new TreeSet<>();
        for (String key : contacts.keySet()) {
            String resultString = key + " - " + contacts.get(key);
            setPhoneBook.add(resultString.replaceAll("[\\[\\]]",""));
        }
        return new TreeSet<>(setPhoneBook);
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}