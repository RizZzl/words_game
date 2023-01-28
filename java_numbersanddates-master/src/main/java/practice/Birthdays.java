package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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



        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        for (int i = 0; birthday.isBefore(now) || birthday.isEqual(now); i++) {
            int numberDayOfWeek = birthday.getDayOfWeek().getValue();
            String dayOfWeek = "";

            if (numberDayOfWeek == 1) {
                dayOfWeek = "Mon";
            } else if (numberDayOfWeek == 2) {
                dayOfWeek = "Tue";
            } else if (numberDayOfWeek == 3) {
                dayOfWeek = "Wed";
            } else if (numberDayOfWeek == 4) {
                dayOfWeek = "Thu";
            } else if (numberDayOfWeek == 5) {
                dayOfWeek = "Fri";
            } else if (numberDayOfWeek == 6) {
                dayOfWeek = "Sat";
            } else if (numberDayOfWeek == 7) {
                dayOfWeek = "Sun";
            }

            System.out.println(i + " - " + birthday.format(formatter) + " - " + dayOfWeek);
            birthday = birthday.plusYears(1);
        }
        
        return "";
    }
}
