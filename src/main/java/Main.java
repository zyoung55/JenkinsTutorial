import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("Welcome to the calculator");
    System.out.println("Enter a command (hit q to quit):");

    Calculator calculator = new Calculator();
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    while (!"q".equals(input)) {
      List<Integer> inputNums = new ArrayList<>();
      String[] splitInput = input.split(" ");

      for (int i=1; i < splitInput.length; ++i) {
        try {
          Integer newInt=Integer.parseInt(splitInput[i]);
          inputNums.add(newInt);
        } catch (NumberFormatException e) {
          System.out.println("Failed to convert arg " + splitInput[i] + " to int");
        }
      }

      switch (splitInput[0]) {
        case "add":
          System.out.println(calculator.add(inputNums.get(0), inputNums.get(1)));
          break;
        case "subtract":
          System.out.println(calculator.subtract(inputNums.get(0), inputNums.get(1)));
          break;
        case "multiply":
          System.out.println(calculator.multiply(inputNums.get(0), inputNums.get(1)));
          break;
        case "divide":
          System.out.println(calculator.divide(inputNums.get(0), inputNums.get(1)));
          break;
        case "fibonacci":
          System.out.println(calculator.fibonacciNumberFinder(inputNums.get(0)));
          break;
        case "binary":
          System.out.println(calculator.intToBinaryNumber(inputNums.get(0)));
          break;
        default:
          System.out.println("Command not recognized. Please try again.");
      }

      input = scanner.nextLine();
    }

    System.out.println("Quiting calculator");
  }
}
