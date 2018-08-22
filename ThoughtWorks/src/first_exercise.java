import java.util.Scanner;

public class first_exercise {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Your favorite number: ");
        if (userInput.hasNextInt()) {
            int numberEntered = userInput.nextInt();
            printOne();
            drawHorizontalLine(numberEntered);
            drawVerticalLine(numberEntered);
            drawRightTriangle(numberEntered);
            System.out.println("You have entered " + numberEntered);
        }
        else {
            System.out.println("Please enter an Integer");
        }
    }

    private static void printOne() {
        System.out.println("*");
    }

    private static void drawHorizontalLine(int n) {
        String repeated = new String(new char[n]).replace("\0", "*");
        System.out.println(repeated);
    }

    private static void drawVerticalLine(int n) {
        while (n > 0) {
            System.out.println("*");
            n--;
        }
    }

    private static void drawRightTriangle(int n) {
        int numberOfTimes = 1;
        while (n > 0) {
            String repeated = new String(new char[numberOfTimes]).replace("\0", "*");
            System.out.println(repeated);
            n--;
            numberOfTimes++;
        }
    }



}
