package com.kenzie.executingtests.shoppingcart;

/**
 * Represents an item in a ShoppingCart, containing a String for the name of the item, and an int for the
 * quantity of that item in the cart.
 */
public class ShoppingCartItem {
    private String itemName;
    private int quantity;

    public ShoppingCartItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{"
               + "itemName='" + itemName + '\''
               + ", quantity=" + quantity
               + '}';
    }
}
