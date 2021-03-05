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

    public void buy(Item f) {
        System.out.println("Here is your: "+ f.getName());
        setRegister(getRegister()+f.getPrice());
        f.setAmount(f.getAmount()-1);
    }

    public Item createItem(double price, int amount, int productID, String name) {
        Item item = new Item(price, amount, productID, name);
        return item;
    }

    public void fill() {
        items.clear();
        double[] price = {3.50, 3.50, 3.00, 3.50, 3.50, 2.20, 2.20, 2.10, 2.50, 2.50, 2.80, 2.50, 2.50, 3.10, 3.10,2.80};
        int amount = 10;
        String[] product = {"Coca Cola", "Coca Cola", "Water", "Fanta", "Sprite", "Snickers", "Snickers", "Mars",
                "Twix", "Twix", "Maltesers", "Chewing Gum (Mint)", "Chewing Gum (Blue Berry)", "Oreo Cookie",
                "Oreo Cookie", "Crisps"};
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
                    buy(f);
                    System.out.printf("Exchange: %.2f\n", (money - f.getPrice()));
                    Methods.delay(10000,10000);
                }
                break;
            }
        }
        return 1;

    }


    public void changeItem(int productId, String newProductName) {
        Item newProduct = null;
        for (Item f: items) {
            if (f.getName().equals(newProductName)) {
                newProduct = f;
            }
            else{

            }
        }
        for (Item f: items) {
            if (f.getProductId() == (productId)) {
                f.setPrice(newProduct.getPrice());
                f.setAmount(newProduct.getAmount());
                f.setName(newProductName);
                newProduct.setName(f.getName());
                newProduct.setPrice(f.getPrice());
                newProduct.setAmount(f.getAmount());
            }
        }
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
