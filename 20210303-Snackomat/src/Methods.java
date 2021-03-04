
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Methods {
    public Methods() {
    }

    public static Double readDouble() {
        Scanner scn = new Scanner(System.in);

        while(!scn.hasNextDouble()) {
            System.out.println("Error, wrong Input, try again: ");
            scn.next();
        }

        double input = scn.nextDouble();
        return input;
    }

    public static boolean readBoolean() {
        Scanner scn = new Scanner(System.in);

        while(!scn.hasNextBoolean()) {
            System.out.println("Error, wrong Input, try again: ");
            scn.next();
        }

        boolean input = scn.nextBoolean();
        return input;
    }

    public static Float readFloat() {
        Scanner scn = new Scanner(System.in);

        while(!scn.hasNextFloat()) {
            System.out.println("Error, wrong Input, try again: ");
            scn.next();
        }

        float input = scn.nextFloat();
        return input;
    }

    public static Integer readRangedInt(int min, int max) {
        Scanner scn = new Scanner(System.in);
        int input = -1;

        try {
            input = scn.nextInt();
        } catch (InputMismatchException var6) {
            scn.nextLine();
        }

        while(input < min || input > max) {
            System.out.println("There was an Error, please repeat your input");

            try {
                input = scn.nextInt();
            } catch (InputMismatchException var5) {
                scn.nextLine();
            }
        }

        return input;
    }

    public static Integer readInt() {
        Scanner scn = new Scanner(System.in);
        int input = -1;

        boolean fail;
        do {
            fail = false;

            try {
                input = scn.nextInt();
            } catch (InputMismatchException var4) {
                scn.nextLine();
                fail = true;
            }
        } while(fail);

        return input;
    }

    public static String readString() {
        Scanner scn = new Scanner(System.in);
        String string = scn.nextLine();
        return string;
    }

    public static String readSpecChar(String chars) {
        Scanner scn = new Scanner(System.in);

        String string;
        boolean fail;
        do {
            fail = false;
            int correctCounter = 0;
            string = scn.nextLine();
            int strLength = string.length();

            for(int i = 0; i < strLength; ++i) {
                if (string.charAt(i) == chars.charAt(0) || string.charAt(i) == chars.charAt(1)) {
                    ++correctCounter;
                }
            }

            if (correctCounter != strLength) {
                fail = true;
            }
        } while(fail);

        return string;
    }

    public static String readSpecInput(int exept1, String exept2, double rangeMin, double rangeMax) {
        Scanner scn = new Scanner(System.in);
        String string = scn.nextLine();
        double stringInt = 0.0;

        try {
            stringInt = Double.parseDouble(string);
        } catch (NumberFormatException var12) {
            stringInt = -1.0D;
        }

        if (stringInt >= rangeMin && stringInt <= rangeMax) {
            string = Double.toString(stringInt);
        }

        while(!(stringInt == exept1 && !string.equals(exept2) && (stringInt < rangeMin || stringInt > rangeMax))) {
            System.out.println("There was an Error, please repeat your input");
            string = scn.nextLine();

            try {
                stringInt = (double)Integer.parseInt(string);
            } catch (NumberFormatException var11) {
                stringInt = -1.0D;
            }

            if (stringInt >= rangeMin && stringInt <= rangeMax) {
                string = Double.toString(stringInt);
            }
        }

        return string;
    }

    public static String readAlphabeticString() {
        Scanner scn = new Scanner(System.in);

        String string;
        boolean fail;
        do {
            fail = false;
            int correctCounter = 0;
            string = scn.nextLine();
            int strLength = string.length();

            for(int i = 0; i < strLength; ++i) {
                if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z' || string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
                    ++correctCounter;
                }
            }

            if (correctCounter != strLength) {
                fail = true;
            }
        } while(fail);

        return string;
    }

    public static void delay(int min, int max){
        Random random = new Random();
        int timeToSleep = min+random.nextInt(max-min+1);
        try
        {
            Thread.sleep(random.nextInt(timeToSleep));
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }


    public static String removeSpecialChar(String string) {
        return string.replaceAll("[^a-zA-Z0-9]", "");
    }
}
