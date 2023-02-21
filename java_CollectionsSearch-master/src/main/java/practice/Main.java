package practice;

import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        var number = "Н555НН100";
        List list = CoolNumbers.generateCoolNumbers();
        System.out.println("Количество номеров: " + list.size());

        long timeStart = System.nanoTime();
        String seach = CoolNumbers.bruteForceSearchInList(list, number) ? "найден" : "не найден";
        long timeEnd = System.nanoTime();
        String time = Long.toString(timeEnd - timeStart);
        System.out.println("Поиск перебором: номер " + seach + ", поиск занял " + time + "нс");

        ArrayList<String> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        timeStart = System.nanoTime();
        seach = CoolNumbers.binarySearchInList(sortedList, number) ? "найден" : "не найден";
        timeEnd = System.nanoTime();
        time = Long.toString(timeEnd - timeStart);
        System.out.println("Бинарный поиск:  номер " + seach + ", поиск занял " + time + "нс");

        HashSet<String> hashSet = new HashSet<>(list);
        timeStart = System.nanoTime();
        seach = CoolNumbers.searchInHashSet(hashSet, number) ? "найден" : "не найден";
        timeEnd = System.nanoTime();
        time = Long.toString(timeEnd - timeStart);
        System.out.println("Поиск в HashSet: номер " + seach + ", поиск занял " + time + "нс");

        TreeSet<String> treeSet = new TreeSet<>(list);
        timeStart = System.nanoTime();
        seach = CoolNumbers.searchInTreeSet(treeSet, number) ? "найден" : "не найден";
        timeEnd = System.nanoTime();
        time = Long.toString(timeEnd - timeStart);
        System.out.println("Поиск в TreeSet: номер " + seach + ", поиск занял " + time + "нс");
    }
}
