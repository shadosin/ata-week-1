package com.kenzie.executingtests.shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class that runs through tests for the ShoppingCart class. Prints out results of tests to
 * the console.
 * <p>
 * Run the tests by running from the command line via RDE workflow, or directly in IntelliJ.
 */
public class ShoppingCartTest {
    /**
     * Calls the test methods, keeping track of whether each ShoppingCart method passes all of its tests or not.
     * Prints a summary of results. Note that some tests may not run if earlier tests fail.
     *
     * PARTICIPANTS: ADD CALLS IN THIS METHOD TO YOUR TEST METHODS THAT YOU WRITE BELOW.
     *
     * The {@code @Test} annotation here marks this as a unit test, so that JUnit runs the tests when the Brazil package
     * is built. We'll cover this in the Unit Testing lesson.
     */

    // addItem() test cases:  -------------------------------
    @Test
    public void addItem_itemNameEmptyString_doesntAddItem() {
        // GIVEN - an empty ShoppingCart
        ShoppingCart cart = new ShoppingCart();

        // WHEN - add an item with empty string for name
        boolean result = cart.addItem("", 1);

        // THEN - add to cart should have failed, and ShoppingCart should be empty
        if (result) {
            fail("  FAIL: Adding item '' should not have succeeded");
        }

        if (cart.getItems().length > 0) {
            fail(
                String.format("  FAIL: Adding item '' should keep ShoppingCart empty, but contains %s",
                              Arrays.toString(cart.getItems())
                )
            );
        }

        System.out.println("  PASS: Adding '' to ShoppingCart was rejected, as was expected.");
        assertFalse(result);
    }

    //TODO PARTICIPANTS: MODIFY YOUR addItem() tests here
    @Test
    public void addItem_withNegativeQuantity_isRejected() {
        // GIVEN - Empty ShoppingCart
        ShoppingCart cart = new ShoppingCart();

        // WHEN - Add a new item by calling `addItem()` with non-empty itemName, negative quantity
        boolean result = cart.addItem("Desk chair", 2);

        // THEN
        // `addItem()` should fail
        if (result) {
            fail("  FAIL: Adding item with negative quantity succeeded but should not have");
        }

        // the ShoppingCart remains empty
        if (cart.getItems().length > 0) {
            fail("  FAIL: Adding item with negative quantity to empty cart should result in empty cart");
        }

        //else if all cases passed, the test passes
        System.out.println("  PASS: Adding item with negative quantity was rejected, as was expected.");
        assertFalse(result);
    }

    @Test
    public void addItem_withZeroQuantity_isRejected() {
        // GIVEN - Empty ShoppingCart
        ShoppingCart cart = new ShoppingCart();

        // WHEN - Add a new item by calling `addItem()` with non-empty itemName, zero quantity
        boolean result = cart.addItem("Head First Java", 2);

        // THEN
        // `addItem()` should fail
        if (result) {
            fail("  FAIL: Adding item with zero quantity succeeded but should not have");
        }

        // the ShoppingCart remains empty
        if (cart.getItems().length > 0) {
            fail("  FAIL: Adding item with zero quantity to empty cart should result in empty cart");

        }

        System.out.println("  PASS: Adding item with zero quantity was rejected, as was expected.");
        assertFalse(result);
    }

    // updateQuantity() test cases:  ------------------------
    @Test
    public void updateQuantity_updateExistingItemWithZeroQuantity_removesItemFromShoppingCart() {
        // GIVEN - A ShoppingCart with one type of item with a quantity of one.
        String itemName = "Instant Pot";
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(itemName, 1);

        // WHEN - Update the quantity by calling `updateQuantity()` for the item with a quantity of zero.
        boolean result = cart.updateQuantity(itemName, 0);

        // THEN - update is allowed and `getItems()` response does not contain the original item.
        if (!result) {
            fail(String.format("  FAIL: Failed to update quantity on item \"%s\"", itemName));
        }

        if (cartContainsItemAndQuantity(cart, itemName, 0)) {
            fail(
                String.format("  FAIL: After setting quantity to 0, did not expect to find item \"%s\" in ShoppingCart",
                              itemName)
            );
        }

        System.out.println(
            String.format("  PASS: After setting quantity to 0, ShoppingCart no longer contains item \"%s\"",
                          itemName)
        );
        assertTrue(result);
    }

    //TODO PARTICIPANTS: MODIFY updateQuantity() tests here
    @Test
    public void updateQuantity_withNullItemName_isRejected() {
        // GIVEN - ShoppingCart with one item
        String existingItem = "Binoculars";
        int originalQuantity = 1;
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(existingItem, originalQuantity);
        // positive replacement quantity
        int replacementQuantity = 4;

        // WHEN - Call `updateQuantity()` with null itemName and positive quantity
        boolean result = cart.updateQuantity("Binoculars", replacementQuantity);

        // THEN
        // `updateQuantity()` fails
        if (result) {
            System.out.println("  FAIL: Updating quantity with a null item name succeeded, but expected not to");
        }

        // ShoppingCart does not contain an item with null itemName
        if (cartContainsItem(cart, null)) {
            System.out.println("  FAIL: Updating quantity with null item should not result in null item in cart");
        }

        // ShoppingCart still contains original item with original quantity
        if (!cartContainsItemAndQuantity(cart, existingItem, originalQuantity)) {
            System.out.println("  FAIL: Updating quantity with null item changed existing item in some way");
        }

        assertFalse(result, "FAIL: Expected updating quantity to be rejected, but instead returns success");
    }

    @Test
    public void updateQuantity_withEmptyItemName_isRejected() {
        // GIVEN - ShoppingCart with one item
        String existingItem = "HDMI Cables (set of 6)";
        int originalQuantity = 4;
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(existingItem, originalQuantity);
        // positive replacement quantity
        int replacementQuantity = 3;

        // WHEN - Call `updateQuantity()` with itemName "" and positive quantity
        boolean result = cart.updateQuantity("HDMI Cables (set of 6)", replacementQuantity);

        // THEN
        // `updateQuantity()` should fail
        if (result) {
            System.out.println("  FAIL: Updating quantity with item name \"\" succeeded, but expected not to");
        }

        // ShoppingCart does not contain an item with empty string itemName
        if (cartContainsItem(cart, "")) {
            System.out.println("  FAIL: Updating quantity with item name \"\" should not result in item added to cart");
        }

        // ShoppingCart still contains original item with original quantity
        if (!cartContainsItemAndQuantity(cart, existingItem, originalQuantity)) {
            System.out.println("  FAIL: Updating quantity with item name \"\" changed existing item in some way");
        }

        assertFalse(result, "FAIL: Expected updating quanitity to be rejected, but instead returns success");
    }



    /**
     * Helper method for checking that an expected item/quantity was found in the ShoppingCart. Feel free to use this
     * in your tests as well!
     *
     * @param cart the {@code ShoppingCart} to test
     * @param itemName the name of the item expected to be in {@code cart}
     * @param quantity the expected quantity for the item to be in {@code cart}
     * @return {@code true} if the item is found with the specified quantity, {@code false} otherwise.
     */
    private boolean cartContainsItemAndQuantity(ShoppingCart cart, String itemName, int quantity) {
        boolean foundItemWithQuantity = false;
        for (ShoppingCartItem item : cart.getItems()) {
            if (item.getItemName().equals(itemName) && item.getQuantity() == quantity) {
                foundItemWithQuantity = true;
            }
        }

        return foundItemWithQuantity;
    }

    /**
     * Helper method for checking that a particular item exists in the ShoppingCart (regardless of quantity).
     * <p>
     * You can create methods like this that several of your tests call to help simplify the test code.
     *
     * @param cart     the {@code ShoppingCart} to test
     * @param itemName the name of the item to look for in the {@code cart}
     * @return {@code true} if the item is found in {@code cart}, {@code false} otherwise.
     */
    private boolean cartContainsItem(ShoppingCart cart, String itemName) {
        boolean foundItem = false;
        for (ShoppingCartItem item : cart.getItems()) {
            if (item.getItemName().equals(itemName)) {
                foundItem = true;
            }
        }

        return foundItem;
    }

}
