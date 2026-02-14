public class IdleState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(int index) {
        if (vendingMachine.getInventory()[index].isAvailable()) {
            System.out.println(vendingMachine.getInventory()[index].getName() + " selected.");
            System.out.println("Please insert coins: " + (vendingMachine.getInventory()[index].getPrice() -
                            vendingMachine.getBalance()));
            vendingMachine.setMachineState(new ItemSelectedState(vendingMachine, index));
        } else {
            System.out.println("Item out of stock.");
        }
    }

    @Override
    public void insertCoin(double amount) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please select an item first.");
    }

    @Override
    public void setOutOfOrder() {
        System.out.println("Vending machine now out of order.");
        vendingMachine.setMachineState(new OutOfOrderState(vendingMachine));
    }
}