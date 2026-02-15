public class DispensingState implements VendingMachineState {
    private VendingMachine vendingMachine;
    private int selectedIndex;

    public DispensingState(VendingMachine vendingMachine, int selectedIndex) {
        this.vendingMachine = vendingMachine;
        this.selectedIndex = selectedIndex;
    }

    @Override
    public void selectItem(int index) {
        System.out.println("Please wait...");
    }

    @Override
    public void insertCoin(double amount) {
        System.out.println("Please wait...");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Here is your " + vendingMachine.getInventory()[selectedIndex].getName() + ". Thank you!");
        vendingMachine.getInventory()[selectedIndex].reduceQuantity();
        vendingMachine.resetBalance();
        vendingMachine.setMachineState(new IdleState(vendingMachine));
    }

    @Override
    public void setOutOfOrder() {
        System.out.println("Vending machine now out of order.");
        vendingMachine.setMachineState(new OutOfOrderState(vendingMachine));
    }
}
