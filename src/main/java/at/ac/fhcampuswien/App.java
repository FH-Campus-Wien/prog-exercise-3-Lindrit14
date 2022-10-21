package at.ac.fhcampuswien;

import java.security.cert.CertStore;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class App {

    // Implement all methods as public static

    public static void oneMonthCalendar(int amountOfDays, int dayToStart) {

        int numberOfRows;
        int cnt = 1;
        int currentColumn = dayToStart;


        //Wenn Anzahl der Tage nicht durch 7 teilbar sind
        if ((amountOfDays + dayToStart) % 7 != 0) {
            numberOfRows = (amountOfDays / 7) + 1;
        } else {
            numberOfRows = amountOfDays / 7;
        }

        //3 Leerzeichen fuer eine fehlende Zahl einfuegen
        // um die erste Reihe rechtbuendig zu machen
        for (int i = 1; i < dayToStart; i++) {
            System.out.print("   ");
        }


        for (int i = 0; i < numberOfRows; i++) {
            while (currentColumn <= 7) {
                System.out.printf("%2d ", cnt); //Formatierung der Zahlen
                if (cnt == amountOfDays) {
                    System.out.println();
                    return;
                }
                currentColumn++;
                cnt++;
            }
            currentColumn = 1; //passiert nach dem 7-mal durchgegangen ist
            System.out.println();
        }
    }


    public static long[] lcg(long seed) {

        long modul = ((long) Math.pow(2, 31));
        long factor = 1103515245;
        long inc = 12345;

        long[] randomNumbers = new long[11];
        randomNumbers[0] = seed;

        for (int i = 1; i < 11; i++) {
            randomNumbers[i] = ((factor * randomNumbers[i - 1]) + inc) % modul;
        }

        //das Array randomNumbers von der Stelle 1 bis Stelle 10 ausgeben.
        return Arrays.copyOfRange(randomNumbers, 1, randomNumbers.length);
    }

    public static void guessingGame(int numberToGuess) {
        Scanner sc = new Scanner(System.in);
        int userGuess;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Guess number " + i + ": ");
            userGuess = sc.nextInt();

            if (userGuess == numberToGuess) {
                System.out.println("You won wisenheimer!");
                break;
            }

            if (i == 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }

            if (userGuess > numberToGuess)
                System.out.println("The number AI picked is lower than your guess.");
            if (userGuess < numberToGuess)
                System.out.println("The number AI picked is higher than your guess.");
        }

    }


    public static boolean swapArrays(int[] firstArray, int[] secondArray) {
        //Wenn Arrays nicht gleich lang sind

        if (firstArray.length != secondArray.length) {
            return false;
        }

        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = firstArray[i] + secondArray[i];
            secondArray[i] = firstArray[i] - secondArray[i];
            firstArray[i] = firstArray[i] - secondArray[i];
        }
        return true;
    }


    public static String camelCase(String sentenceToBeCamelCased) {
        char[] sentence = sentenceToBeCamelCased.toCharArray();
        if (sentence[0] >= 97 && sentence[0] <= 122) {
            sentence[0] -= 32;
        }

        for (int i = 0; i < sentence.length; i++) {
            if (i >= 1 && sentence[i - 1] == ' ' && sentence[i] <= 122 && sentence[i] >= 97) {
                sentence[i] -= 32; //Kleinbuchstaben in gross
            }
            if (i >= 1 && sentence[i - 1] != ' ' && sentence[i] <= 90 && sentence[i] >= 65) {
                sentence[i] += 32;//grossbuchstaben in Kleinbuchstaben
            }
        }

        for (int i = 0; i < sentence.length; i++) {
            if (((sentence[i] >= 123 && sentence[i] <= 127)) || (sentence[i] >= 91 && sentence[i] <= 96) || sentence[i] > 0 && sentence[i] <= 64) {
                sentence[i] = 32;
            }
        }

        return String.valueOf(sentence).replaceAll(" ", "");

    }

    public static int checkDigit(int[] digitArray) {
        int weighting = 2;
        int sum = 0;
        int resOfModulo;

        for (int i = 0; i < digitArray.length; i++) {
            sum += digitArray[i] * (weighting + i);
        }
        resOfModulo = sum%11;

        if (11-resOfModulo == 10){
            return 0;
        }else if (11-resOfModulo == 11){
            return 5;
        }

        return 11-resOfModulo;

    }

    public static int randomNumberBetweenOneAndHundred() {
        Random random = new Random();
        int randomNumber = random.nextInt(100)+1;
        return randomNumber;
    }


    public static void main(String[] args) {


//        oneMonthCalendar(28, 1);

//        lcg(12345);

//        guessingGame(33);

        int[] fArray = new int[]{0, 1, 2, 3, 4, 5};
        int[] sArray = new int[]{6, 7, 8, 9, 10, 11};
        swapArrays(fArray, sArray);


    }
}