import java.util.ArrayList;

public class VendingMachine {

    private ArrayList items;
    private double register;
    private int[] size;
    private int key;

    public VendingMachine(ArrayList items, double register, int[] size, int key) {
        this.items = items;
        this.register = register;
        this.size = size;
        this.key = key;
    }

    public void buy(){

    }

    public void fill(){

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



    }

    public int changePrice(int){

    }

    public int checkAndReturnMoney(int){

    }

    public void changeItem(){

    }

    public void printAutomat(){

    }

    public boolean checkKey(){
        
    }

}
