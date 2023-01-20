public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);

        Basket basket1 = new Basket();
        basket1.add("Juice", 50);

        Basket basket2 = new Basket();
        basket2.add("Meet", 100);
        basket2.add("sweet", 25);

        System.out.println(Basket.getItemCount());
        System.out.println(Basket.getTotalCost());
        System.out.println(Basket.averageProductPrice());
        System.out.println(Basket.averageCostBasket());
    }
}
