import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Item> items = new ArrayList<>();
    private double register;
    private int[] size;
    private int key;

    public VendingMachine( double register, int[] size, int key) {
        this.register = register;
        this.size = size;
        this.key = key;
    }

    public void buy() {
//        boolean buyProduct = false;
//        do{
//            //get char convert to int -1= num1
//            //get int -1= num2
//
//            //Produkt mit stelle num1 * länge  + num2 = num3
//            //checkAndReturnMoney
//            //if buyProduct
//            if (IO.abortProcess()){
//                buyProduct = false;
//            }
//
//        }while(buyProduct);
    }

    public void fill() {
        Item cola = new Item(3.50, 10, 1, "Coca Cola");
        Item colaSecondRow = new Item(3.50, 5, 2, "Coca Cola");
        Item water = new Item(3.00, 10, 3, "Water");
        Item fanta = new Item(3.50, 5, 4, "Fanta");
        Item sprite = new Item(3.50, 8, 5, "Sprite");
        Item snickers = new Item(2.20, 6, 6, "Snickers");
        Item snickersSecondRow = new Item(2.20, 10, 7, "Snickers");
        Item mars = new Item(2.10, 6, 8, "Mars");
        Item twix = new Item(2.50, 10, 9, "Twix");
        Item twixSecondRow = new Item(2.50, 6, 10, "Twix");
        Item maltesers = new Item(2.80, 5, 11, "Maltesers");
        Item gum = new Item(2.50, 12, 12, "Chewing Gum (Mint)");
        Item gumSecondRow = new Item(2.50, 3, 13, "Chewing Gum (Blue Berry)");
        Item oreo = new Item(3.10, 6, 14, "Oreo Cookie");
        Item oreoSecondRow = new Item(3.10, 8, 15, "Oreo Cookie");
        items.add(cola);
        items.add(colaSecondRow);

    }

    public int changePrice() {
        return 0;
    }

    public int checkAndReturnMoney(int money, int productId) {
       for (Item f: items) {
            if (f.getProductId() == (productId)){
                if (f.getPrice() > money){
                    System.out.println("Give more money");
                }
                else {
                    System.out.println("Hier dein(e) "+ f.getName());
                }
                break;
            }
        }
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
