
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Methods {

    public static int readRangedInt(int min, int max) {
        Scanner scn = new Scanner(System.in);
        int input = -1;

        try {
            input = scn.nextInt();
        } catch (InputMismatchException var6) {
            scn.nextLine();
        }

        while (input < min || input > max) {
            System.out.println("There was an Error, please repeat your input");

            try {
                input = scn.nextInt();
            } catch (InputMismatchException var5) {
                scn.nextLine();
            }
        }

        return input;
    }


    public static String readSpecInput(double exept1, String exept2, double rangeMin, double rangeMax) {
        Scanner scn = new Scanner(System.in);
        String string = scn.nextLine();
        boolean money = false;
        double stringDouble;

        try {
            stringDouble = Double.parseDouble(string);
        } catch (NumberFormatException e) {
            stringDouble = -1.0;
        }

        if (stringDouble >= rangeMin && stringDouble <= rangeMax) {
            string = Double.toString(stringDouble);
            money = checkMoney(stringDouble);
        }
        while (!((stringDouble == exept1) || (string.equals(exept2)) ||
                (stringDouble >= rangeMin && stringDouble <= rangeMax && money))) {
            System.out.println("There was an Error, please repeat your input");
            string = scn.nextLine();

            try {
                stringDouble = Double.parseDouble(string);
            } catch (NumberFormatException var11) {
                stringDouble = -1.0;
            }

            if (stringDouble >= rangeMin && stringDouble <= rangeMax) {
                string = Double.toString(stringDouble);
                money = checkMoney(stringDouble);
            }
        }

        return string;
    }
    public static boolean checkMoney(double amount){
        double decimal = (amount*100)%100;
        decimal = Math.round(decimal);
        return  (decimal % 5 == 0);
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

            for (int i = 0; i < strLength; ++i) {
                if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z' || string.charAt(i) >= 'A' &&
                        string.charAt(i) <= 'Z') {
                    ++correctCounter;
                }
            }

            if (correctCounter != strLength) {
                fail = true;
            }
        } while (fail);

        return string;
    }

    public static void delay(int min, int max) {
        Random random = new Random();
        int timeToSleep = min + random.nextInt(max - min + 1);
        try {
            Thread.sleep(random.nextInt(timeToSleep));
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static double parseStringToDouble(String string) {
        double varDouble;
        try {
            varDouble = Double.parseDouble(string);
        } catch (NumberFormatException e) {
            varDouble = 0;
        }
        return varDouble;
    }

    public static int parseStringToInt(String string) {
        int varInt;
        double varDouble;
        try {
            varDouble = parseStringToDouble(string);
            varInt = (int) varDouble;
        } catch (NumberFormatException var11) {
            varInt = 0;
        }
        return varInt;
    }
}

