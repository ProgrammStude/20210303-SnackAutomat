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

    public void buy() {
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

    }

    public Item createItem(double price, int amount, int productID, String name) {
        Item item = new Item(price, amount, productID, name);
        return item;
    }

    public void fill() {
        double[] price = {3.50, 3.50, 3.00, 3.50, 3.50, 2.20, 2.20, 2.10, 2.50, 2.50, 2.80, 2.50, 2.50, 3.10, 3.10};
        int amount = 10;
        String[] product = {"Coca Cola", "Coca Cola", "Water", "Fanta", "Sprite", "Snickers", "Snickers", "Mars",
                "Twix", "Twix", "Maltesers", "Chewing Gum (Mint)", "Chewing Gum (Blue Berry)", "Oreo Cookie",
                "Oreo Cookie"};
        for (int productId = 0; productId < 15; productId++) {
            items.add(createItem(price[productId], amount, productId, product[productId]));
        }


//        Item cola = new Item(3.50, 10, 1, "Coca Cola");
//        Item colaSecondRow = new Item(3.50, 5, 2, "Coca Cola");
//        Item water = new Item(3.00, 10, 3, "Water");
//        Item fanta = new Item(3.50, 5, 4, "Fanta");
//        Item sprite = new Item(3.50, 8, 5, "Sprite");
//        Item snickers = new Item(2.20, 6, 6, "Snickers");
//        Item snickersSecondRow = new Item(2.20, 10, 7, "Snickers");
//        Item mars = new Item(2.10, 6, 8, "Mars");
//        Item twix = new Item(2.50, 10, 9, "Twix");
//        Item twixSecondRow = new Item(2.50, 6, 10, "Twix");
//        Item maltesers = new Item(2.80, 5, 11, "Maltesers");
//        Item gum = new Item(2.50, 12, 12, "Chewing Gum (Mint)");
//        Item gumSecondRow = new Item(2.50, 3, 13, "Chewing Gum (Blue Berry)");
//        Item oreo = new Item(3.10, 6, 14, "Oreo Cookie");
//        Item oreoSecondRow = new Item(3.10, 8, 15, "Oreo Cookie");
//        items.add(cola);
//        items.add(colaSecondRow);
    }

    public int changePrice() {
        return 0;
    }


    public int checkAndReturnMoney(double money, int productId) {
       /* for (Item f: items) {
            if (f.getProductId() == (productId)){
                f.pos = pos;
                break;
            }
        }*/
        return 0;

    }


    public void changeItem() {

    }

    public void printMachine() {

    }

    public boolean checkKey() {
        return false;
    }

    public ArrayList getItems() {
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
