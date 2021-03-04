import java.util.ArrayList;

public class VendingMachine {

    private ArrayList items;
    private double register;
    private int[] size;
    private int key = 123;

    public VendingMachine(ArrayList items, double register, int[] size, int key) {
        this.items = items;
        this.register = register;
        this.size = size;
        this.key = key;
    }
    public VendingMachine(){}
    public void buy(){

    }

    public void fill(){

    }

    public int changePrice(){
return 0;
    }

    public int checkAndReturnMoney(){
return 0;
    }

    public void changeItem(){

    }

    public void printAutomat(){

    }

    public boolean checkKey(){
        return false;
    }

    public int getKey() {
        return key;
    }
}
