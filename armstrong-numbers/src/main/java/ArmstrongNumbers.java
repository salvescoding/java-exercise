import java.util.List;

class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		String numbers = Integer.toString(numberToCheck);
		int powerOf = numbers.length();
		int total = 0;
		for (int i = 0; i < powerOf; i++) {
			int val = Character.getNumericValue(numbers.charAt(i));
			total += Math.pow(val, powerOf);
		}
		return total == numberToCheck;

	}
}
