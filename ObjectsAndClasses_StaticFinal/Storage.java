public class Storage {
    private final StorageType type;
    private final int memoryCapacity;
    private final double weight;

    public Storage(StorageType type, int memoryCapacity, double weight) {
        this.type = type;
        this.memoryCapacity = memoryCapacity;
        this.weight = weight;
    }

    public StorageType getType() {
        return type;
    }

    public Storage setType(StorageType type) {
        return new Storage(type, memoryCapacity, weight);
    }

    public int getMemoryCapacity() {
        return memoryCapacity;
    }

    public Storage setMemoryCapacity(int memoryCapacity) {
        return new Storage(type, memoryCapacity, weight);
    }

    public double getWeight() {
        return weight;
    }

    public Storage setWeight(double weight) {
        return new Storage(type, memoryCapacity, weight);
    }

    public String toString() {
        return "Тип накопителя: " + type + "\n" +
                "Объем накопителя: " + memoryCapacity + "\n" +
                "Вес: " + weight + "\n";
    }
}
