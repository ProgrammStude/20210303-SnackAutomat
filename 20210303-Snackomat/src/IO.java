public class IO {

    private final String stopVar = "x";
    private int filled = 0;
    private boolean loop = true;

    public void inputOutputManagement(VendingMachine vendingMachine) {
        while (loop) {
            String productNumber;
            printVendingMachine(vendingMachine);
            int productInt = 0;
            int counter = 0;
            double moneyDouble;
            if (filled == 0) {
                System.out.println("Code: ");
                productInt = Methods.readRangedInt(vendingMachine.getKey(), vendingMachine.getKey()) - 1;
            } else {
                do {
                    counter -= -1;
                    if (counter == 1) System.out.println("Product Number: ");
                    else {
                        System.out.println("Product Number (Product was Empty): ");
                    }
                    productNumber = Methods.readSpecInput(vendingMachine.getKey(), stopVar, 1,
                            vendingMachine.getSize(1) * vendingMachine.getSize(0));
                    productInt = Methods.parseStringToInt(productNumber) - 1;
                    if (abortProcess(productNumber) || productInt + 1 == vendingMachine.getKey()) break;
                } while (vendingMachine.getItems().get(productInt).getAmount() == 0);
                if (abortProcess(productNumber)) continue;
            }

            if (productInt + 1 == vendingMachine.getKey()) {
                if (loginAdmin(vendingMachine)) continue;
                continue;
            }
            String printPrice = String.format("%.2f", vendingMachine.getItems().get(productInt).getPrice());
            System.out.println("Give me CHF " + printPrice);
            String money = Methods.readSpecInput(vendingMachine.getKey(), stopVar, 0.05, 100);
            if (abortProcess(money)) continue;
            moneyDouble = Methods.parseStringToDouble(money);

            while (!(vendingMachine.checkMoney(moneyDouble, productInt))) {
                String missingMoney = String.format("%.2f",
                        vendingMachine.getItems().get(productInt).getPrice() - moneyDouble);
                System.out.println("Give me CHF " + missingMoney);
                money = Methods.readSpecInput(vendingMachine.getKey(), stopVar, 0.05, 100);
                if (abortProcess(money)) {
                    String moneyRefund = String.format("%.2f", moneyDouble);
                    System.out.println("Refund CHF " + moneyRefund);
                    Methods.delay(3000, 3000);
                    break;
                }
                moneyDouble += Methods.parseStringToDouble(money);
            }
        }
    }

    public boolean loginAdmin(VendingMachine vendingMachine) {
        int productInt;
        int rangeMax = 0;
        String productNumber;
        String productName;
        System.out.println("Try to log in as Admin");

        System.out.print("[");
        for (int i = 0; i < 18; i++) {
            System.out.print("=");
            Methods.delay(20, 50);
        }
        Methods.delay(90, 90);
        System.out.print("==");
        System.out.println("]\n");
        System.out.println("What do you want to do?\nRefill machine(1), Change prize of a product(2)," +
                " Swap a product(3), Get the money out of your register(4), Add new Item to vending machine(5), " +
                "Shut the machine down(9)");
        if (filled == 0) {
            rangeMax = 1;
            System.out.println("---> Machine is empty please refill first!");
        }
        else {
            rangeMax = 5;
        }
        String action = Methods.readSpecInput(9, stopVar, 1, rangeMax);
        if (abortProcess(action)) return false;
        int actionInt = Methods.parseStringToInt(action);
        switch (actionInt) {
            case 1:
                vendingMachine.fill();
                filled = 1;
                break;
            case 2:
                System.out.println("Product Number: ");
                productNumber = Methods.readSpecInput(1, stopVar, 1,
                        vendingMachine.getSize(1) * vendingMachine.getSize(0));
                if (abortProcess(productNumber)) return false;
                productInt = Methods.parseStringToInt(productNumber) - 1;
                System.out.println("New Price: ");
                String newPriceString = Methods.readSpecInput(1, stopVar, 0.05,
                        100);
                if (abortProcess(newPriceString)) return false;
                double newPrice = Methods.parseStringToDouble(newPriceString);
                vendingMachine.changePrice(productInt, newPrice);
                break;
            case 3:
                System.out.println("Product Number: ");
                productNumber = Methods.readSpecInput(1, stopVar, 1,
                        vendingMachine.getSize(1) * vendingMachine.getSize(0));
                if (abortProcess(productNumber)) return false;
                productInt = Methods.parseStringToInt(productNumber) - 1;

                do {
                    System.out.println("Possible new Products: ");
                    for (Item i : vendingMachine.items) {
                        if (i.getProductId() > 14) {
                            System.out.println(vendingMachine.getItems().get(i.getProductId()).getName());
                        }
                    }
                    System.out.println("New product name: ");
                    productName = Methods.readAlphabeticString();
                    if (productName.equals(stopVar)) break;
                } while (!(vendingMachine.changeItem(productInt, productName)));
                break;
            case 4:
                String printRegister = String.format("%.2f", vendingMachine.clearRegister());
                System.out.println("Money in the register: CHF " + printRegister);
                Methods.delay(3000, 3000);
                break;
            case 5:
                System.out.println("Enter product name, except 'x': ");
                String name = Methods.readAlphabeticString();
                if (abortProcess(name)) return false;
                System.out.println("Enter product price: ");
                String priceString = Methods.readSpecInput(1, stopVar, 0.05, 100);
                if (abortProcess(priceString)) return false;
                double price = Methods.parseStringToDouble(priceString);
                System.out.println("Enter product amount: ");
                String amountString = Methods.readSpecInput(1, stopVar, 0, 10);
                if (abortProcess(priceString)) return false;
                int amount = Methods.parseStringToInt(amountString);
                vendingMachine.items.add(vendingMachine.createItem(price, amount, vendingMachine.items.size(), name));
                break;
            case 9:
                System.out.println("Vending Machine shuts down");
                loop = false;
                break;
            default:
                break;
        }
        return true;
    }

    public boolean abortProcess(String check) {
        return (check.equals(stopVar));
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
                informationLength = spaceDistance(length,
                        vendingMachine.getItems().get(j * width + k).getName().length());
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
                String printProductID = String.format("%03d",
                        vendingMachine.getItems().get(j * width + k).getProductId() + 1);
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
                if (vendingMachine.getItems().get(j * width + k).getAmount() == 0) {
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

    public int[] spaceDistance(int maxLength, int informationLength) {
        int[] spaceGap = new int[2];
        spaceGap[0] = (maxLength - informationLength) / 2;

        if ((maxLength - informationLength) % 2 == 1) {
            spaceGap[1] = spaceGap[0] + 1;
        } else {
            spaceGap[1] = spaceGap[0];
        }
        return spaceGap;
    }

    public void printBoughtItem(String name, double money, double price) {
        System.out.println("Here is your " + name);
        System.out.printf("Exchange: %.2f\n", (money - price));
    }

}