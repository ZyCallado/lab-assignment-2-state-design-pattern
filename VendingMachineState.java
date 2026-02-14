public interface VendingMachineState {
    void selectItem(int index);
    void insertCoin(double amount);
    void dispenseItem();
    void setOutOfOrder();
}