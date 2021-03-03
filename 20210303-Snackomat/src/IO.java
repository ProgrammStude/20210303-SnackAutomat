import ch.noseryoung.blj.Methods;

import java.rmi.server.ExportException;
import java.util.Scanner;

public class IO {
    public void inputOutputManagement() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Product Number: ");
            int productNumber = Methods.readInt();
            if (abortProcess(productNumber)) break;
            System.out.println("GIVE ME YOUR MONEY!!!");
            double money = Methods.readDouble();
            if (abortProcess((int) money)) break;
            System.out.println(money);
        }
    }

    public boolean abortProcess(int check) {
        boolean test = false;
        if (check == -123) {
            test = true;
        }
        return test;

    }
}
