package recursion1;

public class Recursion1 {
	/*
	 * Given n of 1 or more, return the factorial of n, which is n * (n-1) *
	 * (n-2) ... 1. Compute the result recursively (without loops).
	 */
	public int factorial(int n) {
		if (n < 3) {
			return n;
		} else {
			return n * factorial(n - 1);
		}
	}

	/*
	 * We have a number of bunnies and each bunny has two big floppy ears. We
	 * want to compute the total number of ears across all the bunnies
	 * recursively (without loops or multiplication).
	 */
	public int bunnyEars(int bunnies) {
		if (bunnies == 0) {
			return 0;
		} else {
			return bunnyEars(bunnies - 1) + 2;
		}
	}

	/*
	 * The fibonacci sequence is a famous bit of mathematics, and it happens to
	 * have a recursive definition. The first two values in the sequence are 0
	 * and 1 (essentially 2 base cases). Each subsequent value is the sum of the
	 * previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13,
	 * 21 and so on. Define a recursive fibonacci(n) method that returns the nth
	 * fibonacci number, with n=0 representing the start of the sequence.
	 */
	public int fibonacci(int n) {
		if (n < 2) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	/*
	 * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies
	 * (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say
	 * have 3 ears, because they each have a raised foot. Recursively return the
	 * number of "ears" in the bunny line 1, 2, ... n (without loops or
	 * multiplication).
	 */
	public int bunnyEars2(int bunnies) {
		if (bunnies <= 0) {
			return 0;
		}
		if (bunnies == 1) {
			return 2;
		} else {
			if (bunnies % 2 != 0) {
				return 2 + bunnyEars2(bunnies - 1);
			} else {
				return 3 + bunnyEars2(bunnies - 1);
			}
		}
	}

	/*
	 * We have triangle made of blocks. The topmost row has 1 block, the next
	 * row down has 2 blocks, the next row has 3 blocks, and so on. Compute
	 * recursively (no loops or multiplication) the total number of blocks in
	 * such a triangle with the given number of rows.
	 */
	public int triangle(int rows) {
		if (rows <= 0) {
			return 0;
		} else {
			return triangle(rows - 1) + rows;
		}
	}

	/*
	 * Given a non-negative int n, return the sum of its digits recursively (no
	 * loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is
	 * 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
	 */
	public int sumDigits(int n) {
		if (n < 10) {
			return n;
		} else {
			return n % 10 + sumDigits(n / 10);
		}
	}

	/*
	 * Given a non-negative int n, return the count of the occurrences of 7 as a
	 * digit, so for example 717 yields 2. (no loops). Note that mod (%) by 10
	 * yields the rightmost digit (126 % 10 is 6), while divide (/) by 10
	 * removes the rightmost digit (126 / 10 is 12).
	 */
	public int count7(int n) {
		if (n < 10) {
			return n == 7 ? 1 : 0;
		} else {
			return (n % 10 == 7) ? count7(n / 10) + 1 : count7(n / 10);
		}
	}

	/*
	 * Given a non-negative int n, compute recursively (no loops) the count of
	 * the occurrences of 8 as a digit, except that an 8 with another 8
	 * immediately to its left counts double, so 8818 yields 4. Note that mod
	 * (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by
	 * 10 removes the rightmost digit (126 / 10 is 12).
	 */
	public int count8(int n) {
		if (n == 0) {
			return 0;
		}
		int curr = n % 10;
		int next = (n / 10) % 10;
		if (curr == 8 && next == 8) {
			return count8(n / 10) + 2;
		}
		if (curr == 8) {
			return count8(n / 10) + 1;
		}
		return count8(n / 10);
	}

	/*
	 * Given base and n that are both 1 or more, compute recursively (no loops)
	 * the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
	 */
	public int powerN(int base, int n) {
		if (n <= 0) {
			return 1;
		}
		return base * powerN(base, n - 1);
	}

	/*
	 * Given a string, compute recursively (no loops) the number of lowercase
	 * 'x' chars in the string.
	 */
	public int countX(String str) {
		if (str.length() == 0) {
			return 0;
		}
		int addition = 0;
		if (str.endsWith("x")) {
			addition = 1;
		}
		return countX(str.substring(0, str.length() - 1)) + addition;
	}

	/*
	 * Given a string, compute recursively (no loops) the number of times
	 * lowercase "hi" appears in the string.
	 */
	public int countHi(String str) {
		if (str.length() < 2) {
			return 0;
		}
		int add = 0;
		if (str.endsWith("hi")) {
			add = 1;
		}
		return countHi(str.substring(0, str.length() - 1)) + add;
	}

	/*
	 * Given a string, compute recursively (no loops) a new string where all the
	 * lowercase 'x' chars have been changed to 'y' chars.
	 */
	public String changeXY(String str) {
		if (str.length() < 1) {
			return "";
		}
		char last = str.charAt(str.length() - 1);
		if (last == 'x') {
			last = 'y';
		}
		return changeXY(str.substring(0, str.length() - 1)) + last;
	}

	/*
	 * Given a string, compute recursively (no loops) a new string where all
	 * appearances of "pi" have been replaced by "3.14".
	 */
	public String changePi(String str) {
		if (str.length() < 2) {
			return str;
		}
		String suffix = str.substring(str.length() - 2);
		if (suffix.equals("pi")) {
			return changePi(str.substring(0, str.length() - 2)) + "3.14";
		}
		return changePi(str.substring(0, str.length() - 1)) + suffix.substring(suffix.length() - 1);
	}

	/*
	 * Given a string, compute recursively a new string where all the 'x' chars
	 * have been removed.
	 */
	public String noX(String str) {
		if (str.length() < 1) {
			return "";
		}
		String last = str.substring(str.length() - 1);
		if (last.equals("x")) {
			last = "";
		}
		return noX(str.substring(0, str.length() - 1)) + last;
	}

	/*
	 * Given an array of ints, compute recursively if the array contains a 6.
	 * We'll use the convention of considering only the part of the array that
	 * begins at the given index. In this way, a recursive call can pass index+1
	 * to move down the array. The initial call will pass in index as 0.
	 */
	public boolean array6(int[] nums, int index) {
		if (index >= nums.length) {
			return false;
		}
		if (nums[index] == 6) {
			return true;
		} else {
			return array6(nums, index + 1);
		}
	}

	/*
	 * Given an array of ints, compute recursively the number of times that the
	 * value 11 appears in the array. We'll use the convention of considering
	 * only the part of the array that begins at the given index. In this way, a
	 * recursive call can pass index+1 to move down the array. The initial call
	 * will pass in index as 0.
	 */
	public int array11(int[] nums, int index) {
		if (index >= nums.length) {
			return 0;
		}
		int count = 0;
		if (nums[index] == 11) {
			count = 1;
		}
		return array11(nums, index + 1) + count;
	}

	/*
	 * Given an array of ints, compute recursively if the array contains
	 * somewhere a value followed in the array by that value times 10. We'll use
	 * the convention of considering only the part of the array that begins at
	 * the given index. In this way, a recursive call can pass index+1 to move
	 * down the array. The initial call will pass in index as 0.
	 */
	public boolean array220(int[] nums, int index) {
		if (index + 1 >= nums.length) {
			return false;
		}
		if (nums[index] * 10 == nums[index + 1]) {
			return true;
		} else {
			return array220(nums, index + 1);
		}
	}

	/*
	 * Given a string, compute recursively a new string where all the adjacent
	 * chars are now separated by a "*".
	 */
	public String allStar(String str) {
		if (str.length() <= 1) {
			return str;
		}
		String suff = str.substring(str.length() - 1);
		return allStar(str.substring(0, str.length() - 1)) + "*" + suff;
	}

	/*
	 * Given a string, compute recursively a new string where identical chars
	 * that are adjacent in the original string are separated from each other by
	 * a "*".
	 */
	public String pairStar(String str) {
		if (str.length() < 2) {
			return str;
		}
		String suf = str.substring(str.length() - 1);
		String pref = str.substring(0, str.length() - 1);
		String add = "";
		if (pref.endsWith(suf)) {
			add = "*";
		}
		return pairStar(pref) + add + suf;
	}

	/*
	 * Given a string, compute recursively a new string where all the lowercase
	 * 'x' chars have been moved to the end of the string.
	 */
	public String endX(String str) {
		if (str.length() < 1) {
			return "";
		}
		String pref = str.substring(0, 1);
		String suf = str.substring(1, str.length());
		if (pref.equals("x")) {
			return endX(suf) + pref;
		} else {
			return pref + endX(suf);
		}
	}

	/*
	 * We'll say that a "pair" in a string is two instances of a char separated
	 * by a char. So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA"
	 * contains 3 pairs -- 2 for A and 1 for x. Recursively compute the number
	 * of pairs in the given string.
	 */
	public int countPairs(String str) {
		if (str.length() < 3) {
			return 0;
		}
		char one = str.charAt(0);
		char two = str.charAt(2);
		int count = 0;
		if (one == two) {
			count = 1;
		}
		return count + countPairs(str.substring(1));
	}

	/*
	 * Count recursively the total number of "abc" and "aba" substrings that
	 * appear in the given string.
	 */
	public int countAbc(String str) {
		if (str.length() < 3) {
			return 0;
		}
		String ab = str.substring(0, 2);
		char ca = str.charAt(2);
		if (ab.equals("ab") && (ca == 'c' || ca == 'a')) {
			return 1 + countAbc(str.substring(2));
		}
		return countAbc(str.substring(1));
	}

	/*
	 * Given a string, compute recursively (no loops) the number of "11"
	 * substrings in the string. The "11" substrings should not overlap.
	 */
	public int count11(String str) {
		if (str.length() < 2) {
			return 0;
		}
		int count = 0;
		if (str.startsWith("11")) {
			count = 1;
		}
		return count + count11(str.substring(1 + count));
	}

	/*
	 * Given a string, return recursively a "cleaned" string where adjacent
	 * chars that are the same have been reduced to a single char. So "yyzzza"
	 * yields "yza".
	 */
	public String stringClean(String str) {
		if (str.length() < 2) {
			return str;
		}
		char first = str.charAt(0);
		str = str.substring(1, str.length());
		if (first == str.charAt(0)) {
			return stringClean(str);
		}
		return first + stringClean(str);
	}

	/*
	 * Given a string, compute recursively the number of times lowercase "hi"
	 * appears in the string, however do not count "hi" that have an 'x'
	 * immedately before them.
	 */
	public int countHi2(String str) {
		if (str.length() < 2) {
			return 0;
		}
		char one = str.charAt(0);
		char two = str.charAt(1);
		int jump = 1;
		int count = 0;
		if (one == 'x') {
			if (two != 'x') {
				jump = 2;
			}
		}
		if (one == 'h' && two == 'i') {
			count = 1;
		}
		return count + countHi2(str.substring(jump));
	}

	/*
	 * Given a string that contains a single pair of parenthesis, compute
	 * recursively a new string made of only of the parenthesis and their
	 * contents, so "xyz(abc)123" yields "(abc)".
	 */
	public String parenBit(String str) {
		if (str.length() < 1) {
			return "";
		}
		int start = 1;
		int end = str.length() - 1;
		if (str.startsWith("(")) {
			start = 0;
		}
		if (str.endsWith(")")) {
			end = str.length();
		}
		if (start == 0 && end == str.length()) {
			return str;
		} else {
			return parenBit(str.substring(start, end));
		}
	}

	/*
	 * Given a string, return true if it is a nesting of zero or more pairs of
	 * parenthesis, like "(())" or "((()))". Suggestion: check the first and
	 * last chars, and then recur on what's inside them.
	 */
	public boolean nestParen(String str) {
		if (str.length() == 0) {
			return true;
		}
		if (str.length() == 1) {
			return (str.charAt(0) != '(' && str.charAt(0) != ')');
		}
		if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
			return nestParen(str.substring(1, str.length() - 1));
		} else {
			return false;
		}
	}

	/*
	 * Given a string and a non-empty substring sub, compute recursively the
	 * number of times that sub appears in the string, without the sub strings
	 * overlapping.
	 */
	public int strCount(String str, String sub) {
		if (str.length() < sub.length()) {
			return 0;
		}
		if (str.startsWith(sub)) {
			return 1 + strCount(str.substring(sub.length()), sub);
		} else {
			return strCount(str.substring(1), sub);
		}
	}

	/*
	 * Given a string and a non-empty substring sub, compute recursively if at
	 * least n copies of sub appear in the string somewhere, possibly with
	 * overlapping. N will be non-negative.
	 */
	public boolean strCopies(String str, String sub, int n) {
		if (str.length() < sub.length()) {
			return n <= 0;
		}
		if (str.startsWith(sub)) {
			return strCopies(str.substring(1), sub, n - 1);
		} else {
			return strCopies(str.substring(1), sub, n);
		}
	}

	/*
	 * Given a string and a non-empty substring sub, compute recursively the
	 * largest substring which starts and ends with sub and return its length.
	 */
	public int strDist(String str, String sub) {
		if (str.length() < sub.length()) {
			return 0;
		}
		if (str.length() == sub.length()) {
			return str.equals(sub) ? str.length() : 0;
		}
		int frontJump = 1;
		int backJump = 1;
		if (str.startsWith(sub)) {
			frontJump = 0;
		}
		if (str.endsWith(sub)) {
			backJump = 0;
		}
		if (frontJump == 0 && backJump == 0) {
			return str.length();
		} else {
			return strDist(str.substring(frontJump, str.length() - backJump), sub);
		}
	}

}
