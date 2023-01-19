package src;

public class CargoInformations {
    public int dimensions;
    public int weight;
    public String address;
    public boolean abilityToRotate;
    public String registrationNumber;
    public boolean fragile;

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

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAbilityToRotate() {
        return abilityToRotate;
    }

    public void setAbilityToRotate(boolean abilityToRotate) {
        this.abilityToRotate = abilityToRotate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isFragile() {
        return fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }







    public String toString(){
        return  dimensions + "\n" + weight + "\n"
                + address + "\n" + abilityToRotate + "\n"
                + registrationNumber + "\n" + fragile;
    }

    //    public int getDimensions() {
////        return dimensions;
////    }
////
////    public CargoInformations setDimensions(int dimensions) {
////        return new CargoInformations(dimensions, weight,
////                address, abilityToRotate,
////                registrationNumber, fragile);
////    }
////
////    public int getWeight() {
////        return weight;
////    }
////
////    public CargoInformations setWeight(int weight) {
////        return new CargoInformations(
////                dimensions, weight,
////                address, abilityToRotate,
////                registrationNumber, fragile);
////    }
////
////    public String getAddress() {
////        return address;
////    }
////
////    public CargoInformations setAddress(String address) {
////        return new CargoInformations(
////                dimensions, weight,
////                address, abilityToRotate,
////                registrationNumber, fragile);
////    }
////
////    public boolean isAbilityToRotate() {
////        return abilityToRotate;
////    }
////
////    public CargoInformations setAbilityToRotate(boolean abilityToRotate) {
////        return new CargoInformations(
////                dimensions, weight,
////                address, abilityToRotate,
////                registrationNumber, fragile);
////    }
////
////    public String getRegistrationNumber() {
////        return registrationNumber;
////    }
////
////    public CargoInformations setRegistrationNumber(String registrationNumber) {
////        return new CargoInformations(
////                dimensions, weight,
////                address, abilityToRotate,
////                registrationNumber, fragile);
////    }
////
////    public boolean isFragile() {
////        return fragile;
////    }
////
////    public CargoInformations setFragile(boolean fragile) {
////        return new CargoInformations(
////                dimensions, weight,
////                address, abilityToRotate,
////                registrationNumber, fragile);
////    }
}
