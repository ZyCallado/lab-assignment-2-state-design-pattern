public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        System.out.println("=== Vending Machine Demo ===\n");

        // Demo 1: Successful purchase
        System.out.println("--- Demo 1: Successful Purchase ---");
        machine.selectItem(0); // Select Soda
        machine.insertCoin(3.0); // Insert 3.0
        machine.insertCoin(2.0); // Insert 2.0 more (total 5.0)
        System.out.println();

        // Demo 2: Select item and insert coins for Chips
        System.out.println("--- Demo 2: Purchase Chips ---");
        machine.selectItem(1); // Select Chips
        machine.insertCoin(10.0); // Insert exact amount
        System.out.println();

        // Demo 3: Attempt to select item without enough coins
        System.out.println("--- Demo 3: Insufficient Coins ---");
        machine.selectItem(2); // Select Candy
        machine.insertCoin(0.5); // Not enough
        machine.insertCoin(0.5); // Add more to reach 1.0
        System.out.println();

        // Demo 4: Try operations in Idle State
        System.out.println("--- Demo 4: Idle State Operations ---");
        machine.insertCoin(5.0); // Should fail - no item selected
        System.out.println();

        // Demo 5: Set machine out of order
        System.out.println("--- Demo 5: Out of Order ---");
        machine.selectItem(0);
        machine.setOutOfOrder(); // Set to out of order
        machine.selectItem(1); // Try to select item - should fail
        machine.insertCoin(5.0); // Try to insert coin - should fail
        System.out.println();

        // Demo 6: Create new machine and demonstrate item out of stock
        System.out.println("--- Demo 6: Item Out of Stock ---");
        VendingMachine machine2 = new VendingMachine();
        
        // Deplete Soda stock (originally 5)
        for (int i = 0; i < 5; i++) {
            machine2.selectItem(0);
            machine2.insertCoin(5.0);
        }
        
        // Try to select Soda when it's out of stock
        System.out.println("Attempting to select Soda (should be out of stock):");
        machine2.selectItem(0);
        System.out.println();

        // Demo 7: Multiple consecutive purchases
        System.out.println("--- Demo 7: Multiple Purchases ---");
        VendingMachine machine3 = new VendingMachine();
        
        System.out.println("Purchase 1:");
        machine3.selectItem(2); // Candy
        machine3.insertCoin(1.0);
        
        System.out.println("\nPurchase 2:");
        machine3.selectItem(2); // Candy again
        machine3.insertCoin(1.0);
        
        System.out.println("\nPurchase 3:");
        machine3.selectItem(2); // Candy again
        machine3.insertCoin(1.0);
    }
}