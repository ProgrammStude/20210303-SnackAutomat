
import java.util.Scanner;

public class IO {
    public void inputOutputManagement(VendingMachine vendingMachine) {

        while (true) {
            int productInt;
            double productDouble;
            double moneyDouble;
            int moneyInt;
            System.out.println("Product Number: ");
            String productNumber = Methods.readSpecInput(vendingMachine.getKey(), "x", 1, 50);
            if (abortProcess(productNumber)) break;

            try {
                productDouble = Double.parseDouble(productNumber);
                productInt = (int) productDouble;
            } catch (NumberFormatException var11) {
                productInt = 0;
            }
            if (productInt == vendingMachine.getKey()) {
                System.out.println("Try to log in as Admin");
                System.out.print("[");
                for (int i = 0; i < 20; i++) {
                    System.out.print("=");
                    Methods.delay(10, 20);
                }
                System.out.println("]\n");
                System.out.println("What do you want to do?\nRefill Machine(1), Change Prize of a Product(2)," +
                        " Swap a Product(3)");
                int action = Methods.readRangedInt(1, 3);
                switch (action) {
                    case 1:
                        vendingMachine.fill();
                        break;
                    case 2:
                        vendingMachine.changePrice();
                        break;
                    case 3:
                        vendingMachine.changeItem();
                        break;
                    default:
                        break;
                }
                continue;
            }
            System.out.println("GIVE ME YOUR MONEY!!!");
            String money = Methods.readSpecInput(vendingMachine.getKey(), "x", 0.05, 50);
            if (abortProcess(money)) continue;
            try {
                moneyDouble = Double.parseDouble(money);
                moneyInt = (int) moneyDouble;
            } catch (NumberFormatException e) {
                moneyInt = 0;
            }
            vendingMachine.checkAndReturnMoney(moneyInt, productInt);
            System.out.println(money);
        }
    }

    public static boolean abortProcess(String check) {
        boolean willAbort = false;
        if (check.equals("x")) {
            willAbort = true;
        }
        return willAbort;
    }

    public void printVendingMachine() {
        System.out.print("╔");
        for (int i = 0; i < 10; i++) {
            System.out.print("═");
        }
        System.out.println("╗");


        System.out.print("║");
        for (int i = 0; i < 10; i++) {
            System.out.print(" ");
        }
        System.out.println("║");


        System.out.print("╚");
        for (int i = 0; i < 10; i++) {
            System.out.print("═");
        }
        System.out.println("╝");

//        System.out.println("╩");
//        System.out.println("╦");
//        System.out.println("╠");
//        System.out.println("╬");
//        System.out.println("╣");
    }
}
