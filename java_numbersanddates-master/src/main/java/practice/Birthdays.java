package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate now = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" - dd.MM.yyyy - EE", Locale.ENGLISH);

        String builder = "";
        for (int i = 0; birthday.isBefore(now) || birthday.isEqual(now); i++) {
            builder = builder + i + birthday.format(formatter) + "\n";
            birthday = birthday.plusYears(1);

        }
        return builder;
    }
}
