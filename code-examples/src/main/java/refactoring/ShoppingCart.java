package refactoring;

public class ShoppingCart {

    private int itemCount;
    private double totalPrice;

    public void addItem(String itemName, double price, int quantity) {
        if(itemName != null) {
            if(price > 0.0) {
                if(quantity > 0) {
                    itemCount += quantity;
                    totalPrice += price * quantity;
                    System.out.println(quantity + " " + itemName + " added to cart.");
                }
                else {
                    System.out.println("Invalid quantity.");
                }
            }
            else {
                System.out.println("Invalid price.");
            }
        }
        else {
            System.out.println("Invalid item name.");
        }
    }

}
