package dailyprogrammer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This program performs the operation of adding, subtracting,
 * multiplying, dividing, and using exponents only using addition.
 * Test cases are run first (using the asserts). If all test
 * cases pass, you will be brought into stdin where you can
 * provide any valid operation supported by the program and it
 * will solve it for you.
 * @author devinkott
 *
 */
public class AddingCalculator {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		assert(c.performOperation('+', 12, 25) == 37);
		assert(c.performOperation('+', -30, 100) == 70);
		assert(c.performOperation('-', 100, 30) == 70);
		assert(c.performOperation('-', 100, -30) == 130);
		assert(c.performOperation('-', -25, 29) == -54);
		assert(c.performOperation('-', -41, -10) == -31);
		assert(c.performOperation('*', 9, 3) == 27);
		assert(c.performOperation('*', 9, -4) == -36);
		assert(c.performOperation('*', -4, 8) == -32);
		assert(c.performOperation('*', -12, -9) == 108);
		assert(c.performOperation('/', 100, 2) == 50);
		assert(c.performOperation('/', 75, -3) == -25);
		assert(c.performOperation('/', -75, 3) == -25);
		assert(c.performOperation('/', 7, 3) == Integer.MIN_VALUE);
		assert(c.performOperation('/', 0, 0) == Integer.MIN_VALUE);
		assert(c.performOperation('^', 5, 3) == 125);
		assert(c.performOperation('^', -5, 3) == -125);
		assert(c.performOperation('^', -8, 3) == -512);
		assert(c.performOperation('^', -1, 1) == -1);
		assert(c.performOperation('^', 1, 1) == 1);
		assert(c.performOperation('^', 0, 5) == 0);
		assert(c.performOperation('^', 5, 0) == 1);
		assert(c.performOperation('^', 10, -3) == Integer.MIN_VALUE);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String s = "";
			while ((s = br.readLine()) != null) {
				if (isBadInput(s)) {
					System.err.printf("Correct format: 'num op num'\n");
					continue;
				}
				String[] parts = s.split("\\s+");
				int num_1 = Integer.parseInt(parts[0]);
				char op = parts[1].charAt(0);
				int num_2 = Integer.parseInt(parts[2]);
				int result = c.performOperation(op, num_1, num_2);
				if (result != Integer.MIN_VALUE) {
					System.out.printf("%s\n", c.format(num_1, num_2, op, result));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns true if the input was bad, false otherwise.
	 * @param s: Line from stdin
	 * @return boolean
	 */
	private static boolean isBadInput(String s) {
		String[] split = s.split("\\s+");
		if (split.length != 3) {
			System.err.printf("Unknow length: %d\n", split.length);
			return true;
		}
		try {
			Integer.parseInt(split[0]);
			Integer.parseInt(split[2]);
		} catch (NumberFormatException e) {
			System.err.printf("Input numbers only.\n");
			return true;
		}
		
		if (split[1].length() != 1) {
			System.err.printf("Operator should be one character.\n");
			return true;
		}
		return false;
	}
	
}
