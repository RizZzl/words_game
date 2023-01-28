package practice;

import java.util.Scanner;

public class TrucksAndContainers {

    public static void main(String[] args) {
        int container = 0;
        int truck = 0;

        Scanner scanner = new Scanner(System.in);
        int boxes = scanner.nextInt();
        if (boxes != 0) {
            System.out.println("Грузовик: " + ++truck);
            System.out.println("\t" + "Контейнер: " + ++container);
        }

        for (int i = 1; i <= boxes; i++) {
            System.out.println("\t\t" + "Ящик: " + i);
            if (i % (12 *27) == 0) {
                truck += 1;
                System.out.println("Грузовик: " + truck);
            }
            if (i % 27 == 0 && boxes != 27) {
                container += 1;
                System.out.println("\t" + "Контейнер: " + container);
            }
        }

        System.out.println("Необходимо:" + "\nгрузовиков - " + truck
                + " шт." + "\nконтейнеров - " + container + " шт.");
    }

}
