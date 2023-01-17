package src;

public class CargoInformations {
    public final int dimensions;
    public final int weight;
    public final String address;
    public final boolean abilityToRotate;
    public final String registrationNumber;
    public final boolean fragile;

    public CargoInformations(int dimensions, int weight,
                             String address, boolean abilityToRotate,
                             String registrationNumber, boolean fragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.address = address;
        this.abilityToRotate = abilityToRotate;
        this.registrationNumber = registrationNumber;
        this.fragile = fragile;
    }

    public int getDimensions() {
        return dimensions;
    }

    public CargoInformations setDimensions(int dimensions) {
        return new CargoInformations(dimensions, weight,
                address, abilityToRotate,
                registrationNumber, fragile);
    }

    public int getWeight() {
        return weight;
    }

    public CargoInformations setWeight(int weight) {
        return new CargoInformations(
                dimensions, weight,
                address, abilityToRotate,
                registrationNumber, fragile);
    }

    public String getAddress() {
        return address;
    }

    public CargoInformations setAddress(String address) {
        return new CargoInformations(
                dimensions, weight,
                address, abilityToRotate,
                registrationNumber, fragile);
    }

    public boolean isAbilityToRotate() {
        return abilityToRotate;
    }

    public CargoInformations setAbilityToRotate(boolean abilityToRotate) {
        return new CargoInformations(
                dimensions, weight,
                address, abilityToRotate,
                registrationNumber, fragile);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public CargoInformations setRegistrationNumber(String registrationNumber) {
        return new CargoInformations(
                dimensions, weight,
                address, abilityToRotate,
                registrationNumber, fragile);
    }

    public boolean isFragile() {
        return fragile;
    }

    public CargoInformations setFragile(boolean fragile) {
        return new CargoInformations(
                dimensions, weight,
                address, abilityToRotate,
                registrationNumber, fragile);
    }

    public String toString(){
        return  dimensions + "\n" + weight + "\n"
                + address + "\n" + abilityToRotate + "\n"
                + registrationNumber + "\n" + fragile;
    }
}
