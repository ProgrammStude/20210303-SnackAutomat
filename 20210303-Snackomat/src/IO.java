import java.util.Scanner;

public class IO {
    public void inputOutput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Product Number: ");
        int productNumber = scanner.nextInt();
        System.out.println("GIVE ME YOUR MONEY!!!");
        double money = scanner.nextDouble();
        System.out.println("Press 1 to Complete (Anything else to stop the Process)");
        int breakVar = scanner.nextInt();
    }
}
