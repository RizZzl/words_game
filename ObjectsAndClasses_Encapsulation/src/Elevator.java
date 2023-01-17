package src;

public class Elevator {
    public int currentFloor = 1;
    public int minFloor;
    public int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor- 1 : currentFloor;
    }

    public void moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor) {
        if(floor > currentFloor && floor <= maxFloor) {
            for (int i = currentFloor; i < floor; i++) {
                moveUp();
                System.out.println(currentFloor);
            }
        } else if(floor < currentFloor && floor >= minFloor) {
            for (int i = currentFloor; i > floor; i--){
                moveDown();
                System.out.println(currentFloor);
            }
        } else {
            System.out.println("Произошла ошибка");
        }
    }
}
