package warmup1;

public class Warmup1_2 {
	/*
	 * Given a string, take the last char and return a new string with the last
	 * char added at the front and back, so "cat" yields "tcatt". The original
	 * string will be length 1 or more.
	 */
	public String backAround(String str) {
		char last = str.charAt(str.length() - 1);
		return last + str + last;
	}

	/*
	 * Return true if the given non-negative number is a multiple of 3 or a
	 * multiple of 5. Use the % "mod" operator -- see Introduction to Mod
	 */
	public boolean or35(int n) {
		return (n % 3 == 0) || (n % 5 == 0);
	}

	/*
	 * Given a string, take the first 2 chars and return the string with the 2
	 * chars added at both the front and back, so "kitten" yields "kikittenki".
	 * If the string length is less than 2, use whatever chars are there.
	 */
	public String front22(String str) {
		String head;
		if (str.length() < 2) {
			head = str;
		} else {
			head = str.substring(0, 2);
		}

		return head + str + head;
	}

	/*
	 * Given a string, return true if the string starts with "hi" and false
	 * otherwise.
	 */
	public boolean startHi(String str) {
		return str.startsWith("hi");
	}

	/*
	 * Given two temperatures, return true if one is less than 0 and the other
	 * is greater than 100.
	 */
	public boolean icyHot(int temp1, int temp2) {
		return (temp1 < 0) && (temp2 > 100) || (temp2 < 0) && (temp1 > 100);
	}

	/*
	 * Given 2 int values, return true if either of them is in the range 10..20
	 * inclusive.
	 */
	public boolean in1020(int a, int b) {
		return ((a >= 10) && (a <= 20)) || ((b >= 10) && (b <= 20));
	}

	/*
	 * We'll say that a number is "teen" if it is in the range 13..19 inclusive.
	 * Given 3 int values, return true if 1 or more of them are teen.
	 */
	public boolean hasTeen(int a, int b, int c) {
		return isTeen(a) || isTeen(b) || isTeen(c);
	}

	private boolean isTeen(int i) {
		return (i >= 13) && (i <= 19);
	}

	/*
	 * We'll say that a number is "teen" if it is in the range 13..19 inclusive.
	 * Given 2 int values, return true if one or the other is teen, but not
	 * both.
	 */
	public boolean loneTeen(int a, int b) {
		return isTeen(a) ^ isTeen(b);
	}

	/*
	 * Given a string, if the string "del" appears starting at index 1, return a
	 * string where that "del" has been deleted. Otherwise, return the string
	 * unchanged.
	 */
	public String delDel(String str) {
		if (str.length() < 4) {
			return str;
		}
		String maybeDel = str.substring(1, 4);

		if (maybeDel.equals("del")) {
			String head = str.substring(0, 1);
			String tail = str.substring(4, str.length());
			return head + tail;
		}
		return str;
	}

	/*
	 * Return true if the given string begins with "mix", except the 'm' can be
	 * anything, so "pix", "9ix" .. all count.
	 */
	public boolean mixStart(String str) {
		return (str.length() >= 3) && (str.substring(1, 3).equals("ix"));
	}

	/*
	 * Given a string, return a string made of the first 2 chars (if present),
	 * however include first char only if it is 'o' and include the second only
	 * if it is 'z', so "ozymandias" yields "oz".
	 */
	public String startOz(String str) {
		String result = "";

		if (str.length() < 2) {
			return str;
		}

		char first = str.charAt(0);
		char second = str.charAt(1);

		if (first == 'o') {
			result += first;
		}

		if (second == 'z') {
			result += second;
		}

		return result;
	}

	/*
	 * Given three int values, a b c, return the largest.
	 */
	public int intMax(int a, int b, int c) {
		int max = a;
		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}

		return max;
	}

	/*
	 * Given 2 int values, return whichever value is nearest to the value 10, or
	 * return 0 in the event of a tie. Note that Math.abs(n) returns the
	 * absolute value of a number.
	 */
	public int close10(int a, int b) {
		int aDiff = Math.abs(10 - a);
		int bDiff = Math.abs(10 - b);

		if (aDiff == bDiff) {
			return 0;
		}

		if (aDiff < bDiff) {
			return a;
		} else {
			return b;
		}

	}

	/*
	 * Given 2 int values, return true if they are both in the range 30..40
	 * inclusive, or they are both in the range 40..50 inclusive.
	 */
	public boolean in3050(int a, int b) {
		return (inRange(30, 40, a) && (inRange(30, 40, b))) || (inRange(40, 50, a) && (inRange(40, 50, b)));

	}

	private boolean inRange(int rangeStart, int rangeEnd, int val) {
		return (val >= rangeStart) && (val <= rangeEnd);
	}

	/*
	 * Given 2 positive int values, return the larger value that is in the range
	 * 10..20 inclusive, or return 0 if neither is in that range.
	 */
	public int max1020(int a, int b) {
		int max = 0;

		if (inRange(10, 20, a)) {
			max = a;
		}

		if (inRange(10, 20, b) && (b > max)) {
			max = b;
		}

		return max;

	}

	/*
	 * Return true if the given string contains between 1 and 3 'e' chars.
	 */
	public boolean stringE(String str) {
		char[] chars = str.toCharArray();
		int eCount = 0;
		for (char c : chars) {
			if (c == 'e') {
				eCount++;
			}
		}

		return (eCount >= 1) && (eCount <= 3);
	}

	/*
	 * Given two non-negative int values, return true if they have the same last
	 * digit, such as with 27 and 57. Note that the % "mod" operator computes
	 * remainders, so 17 % 10 is 7.
	 */
	public boolean lastDigit(int a, int b) {
		return (a % 10) == (b % 10);
	}

	/*
	 * Given a string, return a new string where the last 3 chars are now in
	 * upper case. If the string has less than 3 chars, uppercase whatever is
	 * there. Note that str.toUpperCase() returns the uppercase version of a
	 * string.
	 */
	public String endUp(String str) {
		if (str.length() < 3) {
			return str.toUpperCase();
		}
		String head = str.substring(0, str.length() - 3);
		String tail = str.substring(str.length() - 3, str.length());

		return head + tail.toUpperCase();

	}

	/*
	 * Given a non-empty string and an int N, return the string made starting
	 * with char 0, and then every Nth char of the string. So if N is 3, use
	 * char 0, 3, 6, ... and so on. N is 1 or more.
	 */
	public String everyNth(String str, int n) {
		String result = "";

		for (int i = 0; i < str.length(); i += n) {
			result += str.charAt(i);
		}

		return result;
	}

}
