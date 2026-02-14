public class OutOfOrderState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public OutOfOrderState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(int index) {
        System.out.println("Out of order.");
    }

    @Override
    public void insertCoin(double amount) {
        System.out.println("Out of order.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Out of order.");
    }

    @Override
    public void setOutOfOrder() {
        System.out.println("Out of order.");
    }
}