import ch.noseryoung.blj.Methods;

import java.util.Scanner;

public class IO {
    public void inputOutputManagement() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Product Number: ");
            String productNumber = Methods.readSpecInput("123","x",1,50);
            if (abortProcess(productNumber)) break;
            System.out.println("GIVE ME YOUR MONEY!!!");
            String money = Methods.readSpecInput("123","x",0.05,50);
            if (abortProcess(money)) break;
            System.out.println(money);
        }
    }

    public boolean abortProcess(String check) {
        boolean test = false;
        if (check.equals("x")) {
            test = true;
        }
        return test;

    }
}
