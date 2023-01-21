public class Processor {
    private final double frequency;
    private final int numberOfCores;
    private final String vendor;
    private final double weight;

    public Processor(double frequency, int numberOfCores, String vendor, double weight) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.vendor = vendor;
        this.weight = weight;
    }

    public double getFrequency() {
        return frequency;
    }

    public Processor setFrequency(double frequency) {
        return new Processor(frequency, numberOfCores, vendor, weight);
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public Processor setNumberOfCores(int numberOfCores) {
        return new Processor(frequency, numberOfCores, vendor, weight);
    }

    public String getVendor() {
        return vendor;
    }

    public Processor setVendor(String vendor) {
        return new Processor(frequency, numberOfCores, vendor, weight);
    }

    public double getWeight() {
        return weight;
    }

    public Processor setWeight(int weight) {
        return new Processor(frequency, numberOfCores, vendor, weight);
    }

    public String toString() {
        return "Чвстота процессора: " + frequency + "\n" +
                "Количество ядер: " + numberOfCores + "\n" +
                "Производитель: " + vendor + "\n" +
                "Вес: " + weight + "\n";
    }
}
