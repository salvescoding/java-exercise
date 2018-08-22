import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class first_exercise {

    public static final int MAXFIZZ = 100;
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Your favorite number: ");
        if (userInput.hasNextInt()) {
            int numberEntered = userInput.nextInt();
            printOne();
            drawHorizontalLine(numberEntered);
            drawVerticalLine(numberEntered);
            drawRightTriangle(numberEntered);
            isoscelesTriangle(numberEntered);
            drawDiamond(numberEntered);
            drawDiamondWithName(numberEntered);
            fizzBuzz();
            generatePrimes(30);
            System.out.println("You have entered number: " + numberEntered);
        }
        else {
            System.out.println("Please enter an Integer");
        }
    }

    private static void printOne() {
        System.out.println("Print one *");
        System.out.println("*");
    }

    private static void drawHorizontalLine(int n) {
        String repeated = new String(new char[n]).replace("\0", "*");
        System.out.println("Draw Horizontal Line");
        System.out.println(repeated);
    }

    private static void drawVerticalLine(int n) {
        System.out.println("Draw Vertical Line");
        while (n > 0) {
            System.out.println("*");
            n--;
        }
    }

    private static void drawRightTriangle(int n) {
        int numberOfTimes = 1;
        System.out.println("Draw Right Triangle");
        while (n > 0) {
            String repeated = new String(new char[numberOfTimes]).replace("\0", "*");
            System.out.println(repeated);
            n--;
            numberOfTimes++;
        }
    }

    private static void isoscelesTriangle(int n) {
        System.out.println("Isosceles Triangle");
        buildTopDiamond(n);
    }

    private static void drawDiamond(int n) {
        System.out.println("Draw Diamond centered");
        buildTopDiamond(n);
        buildBottomDiamond(n);
    }

    private static void drawDiamondWithName(int n) {
        System.out.println("Diamond centered with name in middle");
        buildTopDiamondWithName(n);
        buildBottomDiamond(n);
    }

    private static void buildTopDiamond(int n) {
        int numberOfSpace = n - 1;
        for(int i=1; i<=n; i++){

            for(int j=numberOfSpace; j>0; j--){
                System.out.print(" ");
            }
            for(int k=1; k<=2*i-1; k++){
                System.out.print("*");
            }
            System.out.println();
            numberOfSpace--;
        }
    }

    private static void buildBottomDiamond(int n) {
        int increaseSpace = 1;
        for (int i = n-1; i > 0; i--){

            for(int j=0; j<increaseSpace; j++){
                System.out.print(" ");
            }
            for(int k=1; k<=2*i-1; k++){
                System.out.print("*");
            }
            System.out.println();
            increaseSpace++;
        }
    }

    private static void buildTopDiamondWithName(int n) {
        int numberOfSpace = n - 1;
        for(int i=1; i<n; i++){

            for(int j=numberOfSpace; j>0; j--){
                System.out.print(" ");
            }
            for(int k=1; k<=2*i-1; k++){
                System.out.print("*");
            }
            System.out.println();
            numberOfSpace--;
        }
        System.out.println("Sergio");
    }

    private static void fizzBuzz() {
        for (int i = 1; i<= MAXFIZZ; i++) {
            findFizzBuzz(i);
        }
    }

    private static List generatePrimes(int n) {
        List myList = new ArrayList();
        return getPrimes(n, myList);
    }

    private static List getPrimes(int n, List myList) {
        int findPrimes = 2;
        while (findPrimes <= n) {
            if (n % findPrimes == 0){
                myList.add(findPrimes);
                n = n / findPrimes;
            } else {
                findPrimes ++;
            }
        }
        System.out.println(myList);
        return myList;
    }

    private static void findFizzBuzz(int i) {
        if ((i % 3 == 0) && (i % 5 == 0)) {
            System.out.println("FizzBuzz");
        }
        else if (i % 3 == 0) {
            System.out.println("Fizz");
        }
        else if (i % 5 == 0) {
            System.out.println("Buzz");
        }
        else {
            System.out.println(i);
        }
    }





}
