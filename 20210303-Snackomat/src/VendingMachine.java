import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Item> items = new ArrayList<>();
    private double register;
    private int[] size;
    private int key;

    public VendingMachine(double register, int[] size, int key) {
        this.register = register;
        this.size = size;
        this.key = key;
    }

    public void buy() {/*
        boolean buyProduct;
        do {
            int userIn;
            System.out.println("Enter the product number: ");
            userIn = 10;
            Item userItem = items.get(userIn);
            System.out.print("Price: " + userItem.getPrice() + "\nEnter money: ");
            int userMoney = Methods.readInt();
            while(userItem.getPrice() > userMoney){
                System.out.println("Not enough Money, enter more or press 'x' to abort ");
                userMoney+= Methods.readInt();
            }
            if(userItem.getPrice() < userMoney){
                System.out.println("Return: " + (userMoney - userItem.getPrice()));
            }
            System.out.println("Buy an other Product? yes = 1/ no = 0");
            int repeatBuy = Methods.readInt();
            if(repeatBuy == 1){
                buyProduct = true;
            }else{
                buyProduct = false;
            }
        } while (buyProduct);
*/
    }

    public Item createItem(double price, int amount, int productID, String name) {
        Item item = new Item(price, amount, productID, name);
        return item;
    }

    public void fill() {
        double[] price = {3.50, 3.50, 3.00, 3.50, 3.50, 2.20, 2.20, 2.10, 2.50, 2.50, 2.80, 2.50, 2.50, 3.10, 3.10,2.80};
        int amount = 10;
        String[] product = {"Coca Cola", "Coca Cola", "Water", "Fanta", "Sprite", "Snickers", "Snickers", "Mars",
                "Twix", "Twix", "Maltesers", "Chewing Gum (Mint)", "Chewing Gum (Blue Berry)", "Oreo Cookie",
                "Oreo Cookie", " Crisps"};
        for (int productId = 0; productId < product.length; productId++) {
            items.add(createItem(price[productId], amount, productId, product[productId]));
        }
    }

    public void changePrice(int productId, double newPrice) {
        for (Item f: items) {
            if (f.getProductId() == (productId)) {
                f.setPrice(newPrice);
            }
        }
    }

    public int checkAndReturnMoney(double money, int productId) {
       for (Item f: items) {
            if (f.getProductId() == (productId)){
                if (f.getPrice() > money){
                    return 0;
                }
                else {
                    System.out.println("Here is your: "+ f.getName());
                    System.out.println("Exchange: " + (money - f.getPrice()));
                    setRegister(getRegister()+f.getPrice());
                }
                break;
            }
        }
        return 1;

    }


    public void changeItem(int productId, String newProductName) {
        int newProductId;
        Item newProduct = null;
        for (Item f: items) {
            if (f.getName().equals(newProductName)) {
                newProduct = f;
            }
        }
        for (Item f: items) {
            if (f.getProductId() == (productId)) {
                f.setPrice(newProduct.getPrice());

            }
        }
    }

    public void printMachine() {

    }

    public boolean checkKey() {
        return false;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList items) {
        this.items = items;
    }

    public double getRegister() {
        return register;
    }

    public void setRegister(double register) {
        this.register = register;
    }

    public int[] getSize() {
        return size;
    }

    public void setSize(int[] size) {
        this.size = size;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
