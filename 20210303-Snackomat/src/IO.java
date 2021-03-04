//import ch.noseryoung.blj.Methods;

import java.util.Scanner;

public class IO {
    public void inputOutputManagement() {
        VendingMachine vendingMachine = new VendingMachine();
        while (true) {
            int productInt;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Product Number: ");
            String productNumber = Methods.readSpecInput("123","x",1,50);

            try {
                productInt = Integer.parseInt(productNumber);
            } catch (NumberFormatException var11) {
                productInt = 0;
            }
            if (productInt == vendingMachine.getKey()){
                System.out.println("What do you want to do?\n Refill Machine(1), Change Prize of a Product(2)," +
                        " Swap a Product(3)");

            }
            if (abortProcess(productNumber)) break;
            System.out.println("GIVE ME YOUR MONEY!!!");
            String money = Methods.readSpecInput("123","x",0.05,50);
            if (abortProcess(money)) break;
            System.out.println(money);
        }
    }

    public boolean abortProcess(String check) {
        boolean test = false;
        if (check.equals("x")) {
            test = true;
        }
        return test;

    }

    public void printVendingMachine () {
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
