public class VendingMachine {
    private Item[] inventory;
    private double balance = 0.0;
    private VendingMachineState vendingMachineState;

    public VendingMachine() {
        inventory = new Item[] {
            new Item("Soda", 5.0, 5),
            new Item("Chips", 10.0, 10),
            new Item("Candy", 1.0, 15)
        };

        vendingMachineState = new IdleState(this); // Default state
    }

    public void selectItem(int index) {
        vendingMachineState.selectItem(index);
    }

    public void insertCoin(double amount) {
        vendingMachineState.insertCoin(amount);
    }

    public void setOutOfOrder() {
        vendingMachineState.setOutOfOrder();
    }

    public Item[] getInventory() {
        return inventory;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void resetBalance() {
        balance = 0.0;
    }

    public VendingMachineState getMachineState() {
        return vendingMachineState;
    }

    public void setMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }
}
