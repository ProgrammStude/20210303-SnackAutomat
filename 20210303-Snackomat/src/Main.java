public class Main {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(100,new int[]{3,5},1223);
        IO io = new IO();

        io.inputOutputManagement(vendingMachine);
    }
}
