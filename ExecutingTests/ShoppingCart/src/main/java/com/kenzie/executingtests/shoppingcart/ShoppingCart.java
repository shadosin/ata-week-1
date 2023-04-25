package com.kenzie.executingtests.shoppingcart;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a customer's shopping cart, which they can add items to, specifying the quantity for each item.
 *
 * Item names are *case-sensitive*. For example, "Fire Engine" and "fire engine" are considered to be distinct
 * item names for {@code ShoppingCart}.
 */
public class ShoppingCart {
    private Map<String, ShoppingCartItem> items;

    /**
     * Creates a new ShoppingCart, initially empty.
     */
    public ShoppingCart() {
        items = new HashMap<>();
    }

    /**
     * Adds the specified item to the ShoppingCart, with the given quantity, which must be at least one.
     *
     * If the specified item is already in the ShoppingCart, then, the cart's quantity will be updated so that
     * it is the sum of what is already in the cart and the specified additional quantity.
     *
     * @param itemName The {@code String} name of the item to add to the ShoppingCart
     * @param quantity The number of the item that should be added to the ShoppingCart, expressed as an {@code int}
     * @return {@code true} if adding the item to the cart succeeded, including case of adding quantity to existing
     *         item; {@code false} otherwise.
     *
     */
    public boolean addItem(String itemName, int quantity) {
        if (!isItemNameValid(itemName)) {
            return false;
        }

        if (quantity <= 0) {
            return false;
        }

        ShoppingCartItem item;
        if (items.containsKey(itemName)) {
            item = new ShoppingCartItem(itemName, quantity + items.get(itemName).getQuantity());
        } else {
            item = new ShoppingCartItem(itemName, quantity);
        }

        items.put(itemName, item);

        return true;
    }

    /**
     * Updates the quantity for the specified item, setting it to the quantity provided, which must be at least zero.
     * If the quantity is zero, the item is removed from the ShoppingCart.
     *
     * If the specified item is not in the ShoppingCart, the request fails, and false is returned.
     *
     * @param itemName The {@code String} name of the item to update in the ShoppingCart
     * @param quantity The number of the item to be set to the ShoppingCart, expressed as an {@code int}
     * @return True if updating the quantity for the item succeeded (including if removed from cart), false otherwise.
     */
    public boolean updateQuantity(String itemName, int quantity) {
        if (!isItemNameValid(itemName)) {
            return false;
        }

        if (quantity < 0) {
            return false;
        }

        if (!items.containsKey(itemName)) {
            return false;
        }

        if (quantity == 0) {
            items.remove(itemName);
        } else {
            items.put(itemName, new ShoppingCartItem(itemName, quantity));
        }

        return true;
    }

    /**
     * Returns an array of ShoppingCartItem currently in the ShoppingCart.
     *
     * @return an array of ShoppingCartItem corresponding to the ShoppingCart's current contents
     */
    public ShoppingCartItem[] getItems() {
        return items.values().toArray(new ShoppingCartItem[items.size()]);
    }

    private boolean isItemNameValid(String itemName) {
        return (!(itemName == null || itemName.equals("")));
    }
}
