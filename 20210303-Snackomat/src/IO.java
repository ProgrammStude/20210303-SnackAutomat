
import java.util.Scanner;

public class IO {
    private String stopVar = "x";

    public void inputOutputManagement(VendingMachine vendingMachine) {
        while (true) {
            printVendingMachine(vendingMachine);
            int productInt;
            double moneyDouble;
            System.out.println("Product Number: ");
            String productNumber = Methods.readSpecInput(vendingMachine.getKey(), stopVar, 1, 15);
            if (abortProcess(productNumber)) continue;
            productInt = Methods.parseStringToInt(productNumber) - 1;
            if (productInt + 1 == vendingMachine.getKey()) {
                if (loginAdmin(vendingMachine, productNumber)) continue;
            }
            String printPrice = String.format("%.2f", vendingMachine.getItems().get(productInt).getPrice());
            System.out.println("Give me CHF " + printPrice);
            String money = Methods.readSpecInput(vendingMachine.getKey(), stopVar, 0.05, 100);
            if (abortProcess(money)) continue;
            moneyDouble = Methods.parseStringToDouble(money);
            while (vendingMachine.checkAndReturnMoney(moneyDouble, productInt) == 0) {
                String missingMoney = String.format("%.2f", vendingMachine.getItems().get(productInt).getPrice() - moneyDouble);
                System.out.println("Give me CHF " + missingMoney);
                money = Methods.readSpecInput(vendingMachine.getKey(), stopVar, 0.05, 50);
                if (abortProcess(money)) break;
                moneyDouble += Methods.parseStringToDouble(money);
            }
        }
    }

    public boolean loginAdmin(VendingMachine vendingMachine, String productNumber) {
        int productInt;
        System.out.println("Try to log in as Admin");
        System.out.print("[");
        for (int i = 0; i < 20; i++) {
            System.out.print("=");
            Methods.delay(10, 20);
        }
        System.out.println("]\n");
        System.out.println("What do you want to do?\nRefill Machine(1), Change Prize of a Product(2)," +
                " Swap a Product(3)");
        String action = Methods.readSpecInput(123, stopVar, 1, 50);
        if (abortProcess(productNumber)) return false;
        int actionInt = Methods.parseStringToInt(action);
        switch (actionInt) {
            case 1:
                vendingMachine.fill();
                break;
            case 2:
                System.out.println("Product Number: ");
                productNumber = Methods.readSpecInput(123, stopVar, 1, 50);
                if (abortProcess(productNumber)) return false;
                System.out.println("New Price: ");
                if (abortProcess(productNumber)) return false;
                double newPrice = Methods.readInt();
                productInt = Methods.parseStringToInt(productNumber);
                vendingMachine.changePrice(productInt, newPrice);
                break;
            case 3:
                System.out.println("Product Number: ");
                productInt = Methods.readRangedInt(1, 50);
                if (abortProcess(productNumber)) return false;
                System.out.println("New product name: ");
                if (abortProcess(productNumber)) return false;
                String productName = Methods.readAlphabeticString();
                vendingMachine.changeItem(productInt, productName);
                break;
            default:
                break;
        }
        return true;
    }


    public static boolean abortProcess(String check) {
        boolean willAbort = false;
        if (check.equals("x")) {
            willAbort = true;
        }
        return willAbort;
    }

    public void printVendingMachine(VendingMachine vendingMachine) {
        int length = stringLength(vendingMachine);
        int width = vendingMachine.getSize(0);
        int lengthItems = vendingMachine.getSize(1);

        //Top line border
        System.out.print("╔");
        for (int i = 0; i < width * (length + 4); i++) {
            System.out.print("═");
        }
        System.out.print("╗\n║");
        //print content
        for (int j = 0; j < vendingMachine.getItems().size() / width && j < lengthItems; j++){
            //Top line Item
            for (int i = 0; i < width; i++) {
                System.out.print(" ╔");
                for (int k = 0; k < length; k++) {
                    System.out.print("═");
                }
                System.out.print("╗ ");
            }
            System.out.print("║\n║");

            //Line with name
            int[] informationLength;
            for (int k = 0; k < width; k++) {
                informationLength = spaceDistance(length, vendingMachine.getItems().get(j * width + k).getName().length());
                System.out.print(" ║");
                for (int i = 0; i < informationLength[0]; i++) {
                    System.out.print(" ");
                }
                System.out.print(vendingMachine.getItems().get(j * width + k).getName());
                for (int i = 0; i < informationLength[1]; i++) {
                    System.out.print(" ");
                }
                System.out.print("║ ");
            }
            System.out.print("║\n║");

            //Line with productId and Amount
            for (int k = 0; k < width; k++) {
                System.out.print(" ║");
                String printProductID = String.format("%03d", vendingMachine.getItems().get(j * width + k).getProductId() + 1);
                String printAmount = String.format("%02d", vendingMachine.getItems().get(j * width + k).getAmount());

                informationLength = spaceDistance(length, (7 + printProductID.length() + printAmount.length()));
                for (int i = 0; i < informationLength[0]; i++) {
                    System.out.print(" ");
                }
                System.out.print("Nr. " + printProductID + " (" + printAmount + ")");
                for (int i = 0; i < informationLength[1]; i++) {
                    System.out.print(" ");
                }
                System.out.print("║ ");
            }
            System.out.print("║\n║");

            //Line with Price
            for (int k = 0; k < width; k++) {
                String printPrice = String.format("%04.2f", vendingMachine.getItems().get(j * width + k).getPrice());
                System.out.print(" ║");
                informationLength = spaceDistance(length, (4 + printPrice.length()));
                for (int i = 0; i < informationLength[0]; i++) {
                    System.out.print(" ");
                }
                System.out.print("CHF " + printPrice);
                for (int i = 0; i < informationLength[1]; i++) {
                    System.out.print(" ");
                }
                System.out.print("║ ");
            }

            //Bottom line of Item
            System.out.print("║\n║");
            for (int k = 0; k < width ; k++) {
                System.out.print(" ╚");
                for (int i = 0; i < length; i++) {
                    System.out.print("═");
                }
                System.out.print("╝ ");
            }

            //Check if it is the last iteration
            if (j + 1 == lengthItems) {
                System.out.print("║\n");
            } else {
                System.out.print("║\n║");
            }
        }
        //Bottom line border
        System.out.print("╚");
        for (int i = 0; i < width * (length + 4); i++) {
            System.out.print("═");
        }
        System.out.println("╝");

    }


    public int stringLength(VendingMachine vendingMachine) {
        int maxStringLength = 13;
        for (int i = 0; i < vendingMachine.getItems().size(); i++) {
            maxStringLength = Math.max(maxStringLength, vendingMachine.getItems().get(i).getName().length());
        }
        return maxStringLength + 2;
    }

    public int[] spaceDistance(int maxLength, int minLength) {
        int[] spaceGap = new int[2];
        spaceGap[0] = (maxLength - minLength) / 2;

        if ((maxLength - minLength) % 2 == 1) {
            spaceGap[1] = spaceGap[0] + 1;
        } else {
            spaceGap[1] = spaceGap[0];
        }
        return spaceGap;
    }
}
