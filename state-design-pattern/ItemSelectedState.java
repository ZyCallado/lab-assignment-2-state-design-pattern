public class ItemSelectedState implements VendingMachineState {
    private VendingMachine vendingMachine;
    private int selectedIndex;

    public ItemSelectedState(VendingMachine vendingMachine, int selectedIndex) {
        this.vendingMachine = vendingMachine;
        this.selectedIndex = selectedIndex;
    }

    @Override
    public void selectItem(int index) {
        System.out.println("Please insert coins: " + (vendingMachine.getInventory()[selectedIndex].getPrice() -
                          vendingMachine.getBalance()));
    }

    @Override
    public void insertCoin(double amount) {
        vendingMachine.addBalance(amount);
        if (vendingMachine.getBalance() >= vendingMachine.getInventory()[selectedIndex].getPrice()) {
            dispenseItem();
        } else {
            System.out.println("Please insert coins: " + (vendingMachine.getInventory()[selectedIndex].getPrice() -
                          vendingMachine.getBalance()));
        }
    }

    @Override
    public void dispenseItem() {
        vendingMachine.setMachineState(new DispensingState(vendingMachine, selectedIndex));
        vendingMachine.getMachineState().dispenseItem();
    }

    @Override
    public void setOutOfOrder() {
        System.out.println("Vending machine now out of order.");
        vendingMachine.setMachineState(new OutOfOrderState(vendingMachine));
    }
}
