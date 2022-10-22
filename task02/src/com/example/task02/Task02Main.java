package com.example.task02;

public class Task02Main {

    private static final Item ITEM1 = new Item("product 1", 10);
    private static final Item ITEM2 = new Item("product 2", 20);
    private static final Item ITEM3 = new Item("product 3", 30);
    private static final Item ITEM4 = new Item("product 4", 40);
    private static final Item ITEM5 = new Item("product 5", 50);
    private static final Item ITEM6 = new Item("product 6", 60);

    public static void main(String[] args) {
        DiscountBill bill = new DiscountBill();
        bill.setDiscount(100);
        bill.add(ITEM1, 10);
        bill.add(ITEM3, 3);
        bill.add(ITEM6, 1);
        System.out.println(bill);
        bill.add(ITEM3, 3);
        System.out.println(bill);
    }
}
