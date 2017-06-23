package warmup1;

public class Warmup1_1 {

	/*
	 * The parameter weekday is true if it is a weekday, and the parameter
	 * vacation is true if we are on vacation. We sleep in if it is not a
	 * weekday or we're on vacation. Return true if we sleep in.
	 */
	public boolean sleepIn(boolean weekday, boolean vacation) {
		return !weekday || vacation;
	}

	/*
	 * We have two monkeys, a and b, and the parameters aSmile and bSmile
	 * indicate if each is smiling. We are in trouble if they are both smiling
	 * or if neither of them is smiling. Return true if we are in trouble.
	 */
	public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
		return aSmile == bSmile;
	}

	/*
	 * Given two int values, return their sum. Unless the two values are the
	 * same, then return double their sum.
	 */
	public int sumDouble(int a, int b) {
		if (a == b) {
			return 2 * (a + b);
		}

		return a + b;

	}

	/*
	 * Given an int n, return the absolute difference between n and 21, except
	 * return double the absolute difference if n is over 21.
	 */
	public int diff21(int n) {
		int diff = 21 - n;
		if (diff < 0) {
			diff *= -2;
		}

		return diff;
	}

	/*
	 * We have a loud talking parrot. The "hour" parameter is the current hour
	 * time in the range 0..23. We are in trouble if the parrot is talking and
	 * the hour is before 7 or after 20. Return true if we are in trouble.
	 */
	public boolean parrotTrouble(boolean talking, int hour) {
		boolean badHour = (hour < 7) || (hour > 20);
		return talking && badHour;
	}

	/*
	 * Given 2 ints, a and b, return true if one if them is 10 or if their sum
	 * is 10.
	 */
	public boolean makes10(int a, int b) {
		if ((a + b) == 10) {
			return true;
		}
		return ((a == 10) || (b == 10));
	}

	/*
	 * Given an int n, return true if it is within 10 of 100 or 200. Note:
	 * Math.abs(num) computes the absolute value of a number.
	 */
	public boolean nearHundred(int n) {
		if (n < 0) {
			return false;
		}
		int oneHund = Math.abs(100 - n);
		int twoHund = Math.abs(200 - n);

		return (oneHund <= 10) || (twoHund <= 10);
	}

	/*
	 * Given 2 int values, return true if one is negative and one is positive.
	 * Except if the parameter "negative" is true, then return true only if both
	 * are negative.
	 */
	public boolean posNeg(int a, int b, boolean negative) {
		if (negative) {
			return (a < 0) && (b < 0);
		}

		return ((a < 0) && (b > 0)) || ((a > 0) && (b < 0));
	}

	/*
	 * Given a string, return a new string where "not " has been added to the
	 * front. However, if the string already begins with "not", return the
	 * string unchanged. Note: use .equals() to compare 2 strings.
	 */
	public String notString(String str) {
		if (str.startsWith("not")) {
			return str;
		}

		return "not " + str;
	}

	/*
	 * Given a non-empty string and an int n, return a new string where the char
	 * at index n has been removed. The value of n will be a valid index of a
	 * char in the original string (i.e. n will be in the range
	 * 0..str.length()-1 inclusive).
	 */
	public String missingChar(String str, int n) {
		return str.substring(0, n) + str.substring(n + 1, str.length());
	}

	/*
	 * Given a string, return a new string where the first and last chars have
	 * been exchanged.
	 */
	public String frontBack(String str) {
		if (str.length() <= 1) {
			return str;
		}

		char lastChar = str.charAt(str.length() - 1);
		char firstChar = str.charAt(0);

		return lastChar + str.substring(1, str.length() - 1) + firstChar;
	}

	/*
	 * Given a string, we'll say that the front is the first 3 chars of the
	 * string. If the string length is less than 3, the front is whatever is
	 * there. Return a new string which is 3 copies of the front.
	 */
	public String front3(String str) {
		String front;

		if (str.length() < 3) {
			front = str;
		} else {
			front = str.substring(0, 3);
		}

		return front + front + front;
	}

}
