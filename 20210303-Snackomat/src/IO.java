public class IO {

    private final String stopVar = "x";
    private int filled = 0;

    public void inputOutputManagement(VendingMachine vendingMachine) {
        while (true) {
            String productNumber = "";
            printVendingMachine(vendingMachine);
            int productInt = 0;
            double moneyDouble;
            if (filled == 0){
                System.out.println("Code: ");
                productInt = Methods.readRangedInt(123,123)-1;
            }
            else {
                do {
                    System.out.println("Product Number: ");
                    productNumber = Methods.readSpecInput(vendingMachine.getKey(), stopVar, 1,
                            vendingMachine.getSize(1)*vendingMachine.getSize(0));
                    if (abortProcess(productNumber)) break;
                    productInt = Methods.parseStringToInt(productNumber)-1;
                }while (vendingMachine.getItems().get(productInt).getAmount() == 0);
                if (abortProcess(productNumber)) continue;

            }

            if (productInt + 1 == vendingMachine.getKey()) {
                if (loginAdmin(vendingMachine)) continue;
            }
            String printPrice = String.format("%.2f", vendingMachine.getItems().get(productInt).getPrice());
            System.out.println("Give me CHF " + printPrice);
            String money = Methods.readSpecInput(vendingMachine.getKey(), stopVar, 0.05, 100);
            if (abortProcess(money)) continue;
            moneyDouble = Methods.parseStringToDouble(money);


            while (!(vendingMachine.checkMoney(moneyDouble,productInt))){
                String missingMoney = String.format("%.2f",
                        vendingMachine.getItems().get(productInt).getPrice() - moneyDouble);
                System.out.println("Give me CHF " + missingMoney);
                money = Methods.readSpecInput(vendingMachine.getKey(), stopVar, 0.05, 100);
                if (abortProcess(money)){
                    String moneyRefund = String.format("%.2f",moneyDouble);
                    System.out.println("Refund CHF " + moneyRefund);
                    Methods.delay(3000,3000);
                    break;
                }
                moneyDouble += Methods.parseStringToDouble(money);
            }
        }
    }

    public boolean loginAdmin(VendingMachine vendingMachine, double register) {
        int productInt;
        String productNumber = "";
        String productName;
        System.out.println("Try to log in as Admin");
        System.out.print("[");
        for (int i = 0; i < 20; i++) {
            System.out.print("=");
            Methods.delay(70,80);
        }
        System.out.println("]\n");
        System.out.println("What do you want to do?\nRefill Machine(1), Change Prize of a Product(2)," +
                " Swap a Product(3), Show how much money you have(4)");
        String action = Methods.readSpecInput(vendingMachine.getKey(), stopVar, 1, 3);
        if (abortProcess(action)) return false;
        int actionInt = Methods.parseStringToInt(action);
        switch (actionInt) {
            case 1:
                vendingMachine.fill();
                filled = 1;
                break;
            case 2:
                System.out.println("Product Number: ");
                productNumber = Methods.readSpecInput(vendingMachine.getKey(), stopVar, 1,
                        vendingMachine.getSize(1)*vendingMachine.getSize(0)-1);
                if (abortProcess(productNumber)) return false;
                System.out.println("New Price: ");
                String newPriceString = Methods.readSpecInput(vendingMachine.getKey(),stopVar,0.05,
                        100);
                if (abortProcess(newPriceString)) return false;
                double newPrice = Methods.parseStringToDouble(newPriceString);
                productInt = Methods.parseStringToInt(productNumber);
                vendingMachine.changePrice(productInt, newPrice);
                break;
            case 3:
                System.out.println("Product Number: ");
                productNumber = Methods.readSpecInput(123, stopVar, 1,
                        vendingMachine.getSize(1)*vendingMachine.getSize(0)-1);
                productInt = Methods.parseStringToInt(productNumber)-1;

                if (abortProcess(productNumber)) return false;
                do {
                    System.out.println("New product name: ");
                    productName = Methods.readAlphabeticString();
                    if (productName.equals("x") )break;
                } while (!(vendingMachine.changeItem(productInt, productName)));
                break;
            case 4:
                System.out.println(register);
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
        for (int j = 0; j < vendingMachine.getItems().size() / width && j < lengthItems; j++) {
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
                String tmpName = vendingMachine.getItems().get(j * width + k).getName();
                if (vendingMachine.getItems().get(j * width + k).getAmount() == 0) {
                    vendingMachine.getItems().get(j * width + k).setName("Empty");
                }
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
                vendingMachine.getItems().get(j * width + k).setName(tmpName);
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
                double tmpPrice = vendingMachine.getItems().get(j * width + k).getPrice();
                if(vendingMachine.getItems().get(j * width + k).getAmount() == 0){
                    vendingMachine.getItems().get(j * width + k).setPrice(0);
                }
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
                vendingMachine.getItems().get(j * width + k).setPrice(tmpPrice);
            }

            //Bottom line of Item
            System.out.print("║\n║");
            for (int k = 0; k < width; k++) {
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
    public void printBoughtItem(String name, double money, double price){
        System.out.println("Here is your " + name);
        System.out.printf("Exchange: %.2f\n", (money - price));
    }

    public void printRegister(double register){
        System.out.println(register);
    }
}

