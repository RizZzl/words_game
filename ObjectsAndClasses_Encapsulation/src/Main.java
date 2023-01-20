package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dimensions volume = new Dimensions(3, 4, 1);
        volume.toPrintVolume();

        CargoInformations cargo = new CargoInformations(2, 3,
                "a", true,
                "2f", false);
        System.out.println(cargo);
        CargoInformations cargoWithNewAddress = cargo.setAddress("g");
        CargoInformations cargoWithNewAddressAndWeight = cargoWithNewAddress.setWeight(1);
        System.out.println(cargoWithNewAddressAndWeight);

        Elevator elevator = new Elevator(-3, 26);
        while (true) {
            System.out.print("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }

    }
}