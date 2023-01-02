package patterns.behavioral.strategy.math;

import patterns.behavioral.strategy.math.operations.Addition;
import patterns.behavioral.strategy.math.operations.Division;
import patterns.behavioral.strategy.math.operations.Multiplication;
import patterns.behavioral.strategy.math.operations.Subtraction;

import java.util.HashMap;
import java.util.Map;

public class Example {
	public static void main(final String[] args) {
		Map<String, Context> operations = new HashMap<String, Context>();
		setupOperations(operations);

		displayOperations(operations);

	}

	private static void setupOperations(final Map<String, Context> operations) {
		operations.put("add", new Context(new Addition()));
		operations.put("subtract", new Context(new Subtraction()));
		operations.put("multiply", new Context(new Multiplication()));
		operations.put("divide", new Context(new Division()));
	}

	private static void displayOperations(final Map<String, Context> operations) {
		System.out.println("Add 4 and 10 = " + operations.get("add").execute(4, 10));
		System.out.println("Subtract 14 and 10 = " + operations.get("subtract").execute(14, 10));
		System.out.println("Multiply 3 and 2 = " + operations.get("multiply").execute(3, 2));
		System.out.println("Divide 24 and 8 = " + operations.get("divide").execute(24, 8));
	}
}
