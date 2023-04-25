# Test plan for ShoppingCart

## Expectations

Document your test cases in this document. Remember:
* Each test case should be clear and testable, specifying the relevant preconditions, invariants, and postconditions
* Cover the 'happy path' (typical input that isn't a tricky edge case) **and** less common cases that are easy to
  miss when implementing a class (e.g. off-by-one errors with arrays, `null`s, empty arrays, empty Strings...)

We'll follow these standards in our test cases here (which match the Unit 1 Project expectations as well, so it's
great practice!):

### Each test case includes:
* A name. Naming:
    * `methodUnderTest_testCondition_expectedBehavior()`, replacing each segment of the name with an appropriate
      camel-case (starting with lowercase letter) description of each. See the example below.
        * `methodUnderTest`: Copy the method name exactly for the method you're testing on ShoppingCart
        * `testCondition`: Briefly name the condition you're testing for, which might include information from
          the GIVEN and/or WHEN sections below.
        * `expectedBehavior`: Briefly explain what you'll be looking for after calling the method under test. This
          should correspond to the THEN section below.
* A short description (sentence or two)
* "GIVEN":
    * The pre-conditions required for the test to take place. A *bulleted list* of the state of the object that
      is relevant for this test. Describe what you're doing to the object under test (rather than list method calls)
      to set up the test case. This may be as simple as "An empty ShoppingCart". See the example below.
* "WHEN":
    * A *numbered list* of the actions you'll take that you're trying to verify the behavior of.
      This is most often the method that you're calling plus a description of the values you're passing in as
      arguments. See the example below.
* "THEN":
    * A *bulleted list* of the testable results you're going to verify in the test. State what you expect to be
      true after the method is called. This may include the method's return value, or the results of other calls
      you make to the object after the WHEN step. See the example below.

### Template

1. **[methodUnderTest]_[testCondition]_[expectedBehavior]**
   * **Description**: [short description of the test case]
   * GIVEN
      * [bulleted list of relevant pre-conditions for the test to run (usually data you're setting up to test)]
   * WHEN
      1. [ordered list of methods you will call with description of relevant arguments]
      1. [most of your test cases will have a single WHEN item, but if you want more than one keep this line]
   * THEN
      * [bulleted list of verifications that you will perform to see if the test case passes]

### Example

1. **updateQuantity_updateExistingItemWithZeroQuantity_removesItemFromShoppingCart**
    * **Description**: Start with a ShoppingCart with one item in it, and update the item's quantity with a quantity
      of zero; the ShoppingCart should then return an array that does not contain that item when `getItems()` is called.
    * GIVEN
        * A ShoppingCart with one type of item with a quantity of one.
    * WHEN
        1. Update the quantity by calling `updateQuantity()` for the item with a quantity of zero.
    * THEN
        * update is allowed and `getItems()` response does not contain the original item.
1. ... [next test case] ...

## Your Test Plan for addItem()

Use the test template started for you below and complete the details for the test method.  We have provided a few examples and details to get you started.
Replace anything in brackets "[ ]" with the appropriate replacement--there should be no brackets in the test cases below when you're done.

1. **addItem_withValidNameAndQuantity_addsItemToCart**
    * **Description**: Happy path: new item name, positive quantity - accept!
    * GIVEN
        * Empty ShoppingCart
        * Valid item name
        * Positive quantity
    * WHEN
        1. Add a new item by calling `addItem()` with non-empty itemName and positive quantity
    * THEN
        * `addItem()` returns true
        * ShoppingCart contains the itemName and quantity specified

1. **addItem_withExistingItem_sumsItemQuantity**
    * **Description**: add item with itemName that already exists in ShoppingCart: add the quantities
    * GIVEN
        * ShoppingCart with one item in it
        * Positive additional quantity
    * WHEN
        1. Call `addItem()` same itemName and new positive quantity
    * THEN
        * `addItem()` returns true
        * ShoppingCart contains the itemName
        * That item's quantity is the sum of original quantity and new positive quantity

1. **addItem_withNullItemName_isRejected**
    * **Description**: null item name - reject
    * GIVEN
        * Empty ShoppingCart
        * Null item name
    * WHEN
        1. Add a new item by calling `addItem()` with null itemName, positive quantity
    * THEN
        * `addItem()` returns false
        * The ShoppingCart remains empty

1. **addItem_withEmptyItemName_isRejected**
    * **Description**: empty string item name - reject
    * GIVEN
        * [What given is needed]
        * [What other given is needed?]
    * WHEN
        1. Add a new item by calling `addItem()` with itemName "", positive quantity
    * THEN
        * `addItem()` returns false
        * The ShoppingCart remains empty

1. **addItem_withNegativeQuantity_isRejected**
    * **Description**: negative quantity - reject
    * GIVEN
        * Empty ShoppingCart
        * Negative quantity
    * WHEN
        1. Add a new item by calling `addItem()` with non-empty itemName, negative quantity
    * THEN
        * [What happens in this situation?]
        * [Take a look above if necessary]

1. **addItem_withZeroQuantity_isRejected**
    * **Description**: zero quantity - reject
    * GIVEN
        * [Provide a given]
        * [Provide a given]
    * WHEN
        1. Add a new item by calling `addItem()` with non-empty itemName, zero quantity
    * THEN
        * [What is returned?]
        * [What is the ShoppingCart's status? Has anything changed?]

## Your Test Plan for updateQuantity()

Complete the test template started for you below for the updateQuantity() method.
Replace anything in brackets "[ ]" with the appropriate replacement--there should be no brackets in the test cases below when you're done.

1. **updateQuantity_withPositiveQuantity_replacesQuantity**
   * **Description**: happy path: existing item name, positive quantity - replace quantity!
   * GIVEN
      * ShoppingCart with one item and positive quantity
      * Positive replacement quantity
   * WHEN
      1. Call `updateQuantity()` with same itemName and a new positive quantity
   * THEN
      * `updateQuantity()` returns true
      * Item still exists in ShoppingCart and its quantity is the new positive quantity

1. **updateQuantity_withZeroQuantity_removesItemFromCart**
   * **Description**: zero quantity - remove from cart
   * GIVEN
      * ShoppingCart with one item and positive quantity
      * Zero replacement quantity
   * WHEN
      1. Call `updateQuantity()` with same itemName and a zero quantity
   * THEN
      * `updateQuantity()` returns true
      * ShoppingCart no longer contains the item

1. **updateQuantity_withNullItemName_isRejected**
   * **Description**: null item name - reject
   * GIVEN
      * ShoppingCart with one item
      * [What else should be given?]
   * WHEN
      1. Call `updateQuantity()` with null itemName and positive quantity
   * THEN
      * `updateQuantity()` returns false
      * ShoppingCart does not contain an item with null itemName
      * ShoppingCart still contains original item with original quantity

1. **updateQuantity_withEmptyItemName_isRejected**
   * **Description**: empty string item name - reject
   * GIVEN
      * ShoppingCart with one item
      * [What else is given?]
   * WHEN
      1. Call `updateQuantity()` with itemName "" and positive quantity
   * THEN
      * `updateQuantity()` returns false
      * ShoppingCart [test1: does or does not?] contain an item with empty string itemName
      * ShoppingCart still contains original item with original quantity

1. **updateQuantity_onItemNotInCart_isRejected**
   * **Description**: item not already in cart - reject
   * GIVEN
      * ShoppingCart with one item
      * Item name not already in cart
   * WHEN
      1. Call `updateQuantity()` with a different item name and positive quantity
   * THEN
      * `updateQuantity()` returns false
      * ShoppingCart [test2: does or does not?] contain an item with the new itemName
      * ShoppingCart still contains original item with original quantity

1. **updateQuantity_withNegativeQuantity_isRejected**
   * **Description**: existing item and negative quantity - reject
   * GIVEN
      * ShoppingCart with one item
      * [What else is given based on the test name?]
   * WHEN
      1. Call `updateQuantity()` with the same itemName but negative quantity
   * THEN
      * `updateQuantity()` returns false
      * ShoppingCart still contains original item with original quantity
