public class Main {
    public static void main(String[] args) {
        Processor processor_1 = new Processor(3.5, 4, "Intel", 9.15);
        RAM ram_1 = new RAM("DDR3", 8192, 18.0);
        Storage storage_1 = new Storage(StorageType.SSD,  500, 200);
        Screen screen_1 = new Screen( "21", ScreenType.IPS, 5000);
        Keyboard keyboard_1 = new Keyboard(KeyboardType.Mechanical, true, 2500);

        Computer computer_1 = new Computer("AMD", "Ryzen 5 2600");
        computer_1.setProcessor(processor_1);
        computer_1.setRAM(ram_1);
        computer_1.setStorage(storage_1);
        computer_1.setScreen(screen_1);
        computer_1.setKeyboard(keyboard_1);

        System.out.println(computer_1.toString());
    }
}
