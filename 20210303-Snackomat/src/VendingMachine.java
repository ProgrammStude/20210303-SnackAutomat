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
        this.items = fillDefault();
    }

    public void buy(Item f) {
        System.out.println("Here is your: "+ f.getName());
        setRegister(getRegister()+f.getPrice());
        f.setAmount(f.getAmount()-1);
    }

    public Item createItem(double price, int amount, int productID, String name) {
        return new Item(price, amount, productID, name);
    }

    public ArrayList<Item> fillDefault(){
        for (int i = 0; i < 15; i++) {
            items.add(createItem(0, 0, i, "Empty"));
        }
        return items;
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
        for (Item i: items) {
            if (i.getProductId() == (productId)) {
                i.setPrice(newPrice);
            }
        }
    }

    public int checkAndReturnMoney(double money, int productId) {
       for (Item i: items) {
            if (i.getProductId() == (productId)){
                if (i.getPrice() > money){
                    return 0;
                }
                else {
                    buy(i);
                    System.out.printf("Exchange: %.2f\n", (money - i.getPrice()));
                    Methods.delay(7000,7000);
                }
                break;
            }
        }
        return 1;

    }


    public void changeItem(int productId, String newProductName) {
        Item newProduct = null;
        for (Item i: items) {
            if (i.getName().equals(newProductName)) {
                newProduct = i;
            }
            else{


            }
        }
        for (Item i: items) {
            if (i.getProductId() == (productId)) {
                i.setPrice(newProduct.getPrice());
                i.setAmount(newProduct.getAmount());
                i.setName(newProductName);
                newProduct.setName(i.getName());
                newProduct.setPrice(i.getPrice());
                newProduct.setAmount(i.getAmount());
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

    public int getSize(int index) {
        return size[index];
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
