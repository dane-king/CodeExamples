package refactoring;
public class Calculator {

    public static void main(String args[]) {

        double num1 = 10.0;
        double num2 = 5.0;
        char operation = '+';

        if(operation == '+') {
            double result = num1 + num2;
            System.out.println("Result: " + result);
        }
        else if(operation == '-') {
            double result = num1 - num2;
            System.out.println("Result: " + result);
        }
        else if(operation == '*') {
            double result = num1 * num2;
            System.out.println("Result: " + result);
        }
        else if(operation == '/') {
            double result = num1 / num2;
            System.out.println("Result: " + result);
        }
        else {
            System.out.println("Invalid operator");
        }

    }

}
