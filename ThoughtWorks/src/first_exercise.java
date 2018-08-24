import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class first_exercise {

    private static final int MAXFIZZ = 100;
    private static Scanner userInput = new Scanner(System.in);

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

    public static void printOne() {
        printTitle("Print one * ");
        printChar('*', 1);
    }

    public static void drawHorizontalLine(int n) {
        printTitle("Draw Horizontal Line");
        printChar('*', n);
    }

    public static void drawVerticalLine(int n) {
        printTitle("Draw Vertical Line");
        while (n > 0) {
            printChar('*', 1);
            n--;
        }
    }

    public static void drawRightTriangle(int n) {
        printTitle("Draw Right Triangle");
        int numberOfTimes = 1;
        while (n > 0) {
            printChar('*', numberOfTimes);
            n--;
            numberOfTimes++;
        }
    }

    public static void isoscelesTriangle(int n) {
        printTitle("Isosceles Triangle");
        buildTopDiamond(n);
    }

    public static void drawDiamond(int n) {
        printTitle("Draw Diamond centered");
        buildTopDiamond(n);
        buildBottomDiamond(n);
    }

    public static void drawDiamondWithName(int n) {
        printTitle("Diamond centered with name in middle");
        buildTopDiamondWithName(n);
        buildBottomDiamond(n);
    }

    private static void printChar(char character, int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            System.out.print(character);
        }
        System.out.println();
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

    public static void fizzBuzz() {
        printTitle("Print FizzBuzz");
        for (int i = 1; i<= MAXFIZZ; i++) {
            findFizzBuzz(i);
        }
    }

    public static List generatePrimes(int n) {
        printTitle("Generate prime numbers till " + n);
        return getPrimes(n);
    }

    private static void printTitle(String title) {
        System.out.println(title);
    }

    private static List getPrimes(int n) {
        List myList = new ArrayList();
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
