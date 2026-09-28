package part1_syntax;

public class Part1Syntax {

    public static void main(String[] args) {

       
        printMessage();
        printMessage("Hello from a method with one String argument.");
        printNumbers(10, 20);

    
        printSeparator();

       
        int sum = addNumbers(7, 5);
        double average = calculateAverage(8.0, 10.0);
        String greeting = createGreeting("Student Max");

        System.out.println("Returned int value: " + sum);
        System.out.println("Returned double value: " + average);
        System.out.println("Returned String value: " + greeting);

       
        demonstrateDecomposition();
    }

    
    public static void printMessage() {
        System.out.println("Method with 0 arguments.");
    }

    
    public static void printMessage(String message) {
        System.out.println(message);
    }

    
    public static void printNumbers(int first, int second) {
        System.out.println("Two numbers: " + first + " and " + second);
    }

    
    public static void printSeparator() {
        System.out.println("------------------------------------------");
    }

    
    public static int addNumbers(int first, int second) {
        return first + second;
    }

    
    public static double calculateAverage(double first, double second) {
        return (first + second) / 2;
    }

    
    public static String createGreeting(String name) {
        return "Hello, " + name + "!";
    }

    
    public static void demonstrateDecomposition() {

        System.out.println("\nPart 1.4. Decomposition into methods:");

        printSeparator();

        int result = calculateAndDisplaySum(12, 8);

        displayResult(result);

        printSeparator();
    }

    
    public static int calculateAndDisplaySum(int first, int second) {

        printCalculation(first, second);

        return addNumbers(first, second);
    }

    
    public static void printCalculation(int first, int second) {

        System.out.println("Calculating: " + first + " + " + second);
    }

    
    public static void displayResult(int result) {

        System.out.println("Calculation result: " + result);
    }
}