import java.util.ArrayList;

public class VendingMachine {

    private ArrayList items;
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

    }

    public int changePrice() {
        return 0;
    }

    public int checkAndReturnMoney() {
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
