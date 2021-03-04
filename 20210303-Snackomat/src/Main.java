import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendingMachine vendingMachine = new VendingMachine(100,new int[]{3,5},123);

        IO io = new IO();
          io.inputOutputManagement(vendingMachine);
    }
}
