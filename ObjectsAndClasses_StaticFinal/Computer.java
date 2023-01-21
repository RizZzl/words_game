public class Computer {
    public final String vendor;
    public final String name;
    private Processor processor;
    private RAM RAM;
    private Storage storage;
    private Screen screen;
    private Keyboard keyboard;
    public double totalWeight;

    public Computer (String vendor,
                     String name,
                     Processor processor,
                     RAM RAM,
                     Storage storage,
                     Screen screen,
                     Keyboard keyboard,
                     double totalWeight) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.RAM = RAM;
        this.storage = storage;
        this.screen = screen;
        this.keyboard = keyboard;
        this.totalWeight = totalWeight;
    }

    public Computer (String vendor, String name){
        this.vendor = vendor;
        this.name = name;
    }

    public Computer setVendor(String vendor) {
        return new Computer(vendor, name);
    }
    public Computer setName(String name) {
        return new Computer(vendor, name);
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRAM() {
        return RAM;
    }

    public void setRAM(RAM RAM) {
        this.RAM = RAM;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public double getTotalWeight() {
        return processor.getWeight() + RAM.getWeight() + storage.getWeight() +
                screen.getWeight() + keyboard.getWeight();
    }

    public String toString() {
        return "Данные о компьютере:" + "\n" + "\n" +
                "Название: " + getName() + "\n" +
                "Поставщик: " + getVendor() + "\n" +
                processor.toString() + RAM.toString() + storage.toString() +
                screen.toString() + keyboard.toString() + "\n" + "Общий вес омпьютера: " + getTotalWeight() + "гр.";
        }
    }
