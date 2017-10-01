package dailyprogrammer;

public class Calculator {
	
	/**
	 * Performs a numeric operation on two numbers.
	 * @param op: Operation to perform
	 * @param num_1: Number 1
	 * @param num_2: Number 2
	 * @return int
	 */
	public int performOperation(char op, int num_1, int num_2) {
		int result = Integer.MIN_VALUE;
		switch (op) {
		case '+':
			result = add(num_1, num_2);
			break;
		case '-':
			result = subtract(num_1, num_2);
			break;
		case '*':
			result = multiply(num_1, num_2);
			break;
		case '/':
			result = divide(num_1, num_2);
			break;
		case '^':
			result = exponent(num_1, num_2);
			break;
		case '%':
			break;
		default:
			System.err.printf("Unknown operation: %c\n", op);
			break;
		}
		return result;
	}
	
	/**
	 * Performs the exponent operation on two numbers:
	 * 		num_1 ^ num_2
	 * @param num_1: First number
	 * @param num_2: Second number
	 * @return int
	 */
	public int exponent(int num_1, int num_2) {
		if (num_2 < 0) {
			return Integer.MIN_VALUE;
		}
		
		if (num_2 == 0) {
			return 1;
		}
		
		if (num_2 == 1) {
			return num_1;
		}
		int result = 0;
		boolean neg = false;
		if (num_1 < 0) {
			if (divide(num_2, 2) == Integer.MIN_VALUE) {
				neg = true;
			}
			num_1 = subtract(0, num_1);
		}
		result += num_1;
		for (int i = 1; i < num_2; i++) {
			result = multiply(result, num_1);
		}
		return neg ? -result : result;
	}
	
	/**
	 * Divides two numbers.
	 * @param num_1: Numerator
	 * @param num_2: Denominator
	 * @return int
	 */
	public int divide(int num_1, int num_2) {
		if (num_2 == 0) {
			return Integer.MIN_VALUE;
		}
		boolean neg = false;
		if (num_1 < 0 && num_2 > 0) {
			neg = true;
			num_1 = subtract(0, num_1);
		}
		
		if (num_2 < 0 && num_1 > 0) {
			neg = true;
			num_2 = subtract(0, num_2);
		}
		
		if (num_1 < 0 && num_2 < 0) {
			neg = false;
			num_1 = subtract(0, num_1);
			num_2 = subtract(0, num_2);
		}
		int rem = num_1;
		int quo = 0;
		while (rem >= num_2) {
			rem = subtract(rem, num_2);
			quo++;
		}
		return rem > 0 ? Integer.MIN_VALUE : (neg ? -quo : quo);
	}

	/**
	 * Adds two numbers
	 * @param num_1: First Number
	 * @param num_2: Second Number
	 * @return int
	 */
	public int add(int num_1, int num_2) {
		return num_1 + num_2;
	}
	
	/**
	 * Multiplies two numbers
	 * @param num_1: First Number
	 * @param num_2: Second Number
	 * @return int
	 */
	public int multiply(int num_1, int num_2) {
		boolean neg = false;
		if (num_1 < 0 && num_2 > 0) {
			neg = true;
			num_1 = subtract(0, num_1);
		}
		
		if (num_2 < 0 && num_1 > 0) {
			neg = true;
			num_2 = subtract(0, num_2);
		}
		
		if (num_1 < 0 && num_2 < 0) {
			neg = false;
			num_1 = subtract(0, num_1);
			num_2 = subtract(0, num_2);
		}
		
		int result = 0;
		for (int i = 0; i < num_2; i++) {
			result += num_1;
		}
		return neg ? -result : result;
	}
	
	/**
	 * Subtracts two numbers
	 * @param num_1: First Number
	 * @param num_2: Second Number
	 * @return int
	 */
	public int subtract(int num_1, int num_2) {
		return num_1 + -num_2;
	}
	
	/**
	 * Formats the output of an operation
	 * @param num_1: First Number
	 * @param num_2: Second Number
	 * @param op: Operator
	 * @param result: Result of the operation
	 * @return String
	 */
	public String format(int num_1, int num_2, char op, int result) {
		return num_1 + " " + op + " " + num_2 + " = " + result;
	}
	
}
