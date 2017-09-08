package string2;

public class String2 {
	/*
	 * Given a string, return a string where for every char in the original,
	 * there are two chars.
	 */
	public String doubleChar(String str) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			result.append(str.charAt(i));
			result.append(str.charAt(i));
		}
		return result.toString();
	}

	/*
	 * Return the number of times that the string "hi" appears anywhere in the
	 * given string.
	 */
	public int countHi(String str) {
		int hiCount = 0;
		int i = str.indexOf("hi");
		while (i != -1) {
			hiCount++;
			i = str.indexOf("hi", i + 1);
		}
		return hiCount;
	}

	/*
	 * Return true if the string "cat" and "dog" appear the same number of times
	 * in the given string.
	 */
	public boolean catDog(String str) {
		int catCount = countSub(str, "cat");
		int dogCount = countSub(str, "dog");
		return catCount == dogCount;
	}

	private int countSub(String str, String subStr) {
		int subCount = 0;
		int i = str.indexOf(subStr);
		while (i != -1) {
			subCount++;
			i = str.indexOf(subStr, i + 1);
		}
		return subCount;
	}

	/*
	 * Return the number of times that the string "code" appears anywhere in the
	 * given string, except we'll accept any letter for the 'd', so "cope" and
	 * "cooe" count.
	 */
	public int countCode(String str) {
		if (str.length() < 4) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < str.length() - 3; i++) {
			if (str.charAt(i) == 'c' && str.charAt(i + 1) == 'o' && str.charAt(i + 3) == 'e') {
				count++;
				i += 3;
			}
		}
		return count;
	}

	/*
	 * Given two strings, return true if either of the strings appears at the
	 * very end of the other string, ignoring upper/lower case differences (in
	 * other words, the computation should not be "case sensitive"). Note:
	 * str.toLowerCase() returns the lowercase version of a string.
	 */
	public boolean endOther(String a, String b) {
		a = a.toLowerCase();
		b = b.toLowerCase();
		return a.endsWith(b) || b.endsWith(a);
	}

	/*
	 * Return true if the given string contains an appearance of "xyz" where the
	 * xyz is not directly preceeded by a period (.). So "xxyz" counts but
	 * "x.xyz" does not.
	 */
	public boolean xyzThere(String str) {
		if (str.length() < 3) {
			return false;
		}
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.charAt(i) == 'x' && str.charAt(i + 1) == 'y' && str.charAt(i + 2) == 'z'
					&& (i == 0 || str.charAt(i - 1) != '.')) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Return true if the given string contains a "bob" string, but where the
	 * middle 'o' char can be any char.
	 */
	public boolean bobThere(String str) {
		return str.matches(".*b.b.*");
	}

	/*
	 * We'll say that a String is xy-balanced if for all the 'x' chars in the
	 * string, there exists a 'y' char somewhere later in the string. So "xxy"
	 * is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return
	 * true if the given string is xy-balanced.
	 */
	public boolean xyBalance(String str) {
		if (!str.contains("x")) {
			return true;
		}
		return str.matches(".*x.*y[^x]*");
	}

	/*
	 * Given two strings, a and b, create a bigger string made of the first char
	 * of a, the first char of b, the second char of a, the second char of b,
	 * and so on. Any leftover chars go at the end of the result.
	 */
	public String mixString(String a, String b) {
		StringBuilder result = new StringBuilder();
		int i = 0;
		while (i < Math.max(a.length(), b.length())) {
			if (i < a.length()) {
				result.append(a.charAt(i));
			}
			if (i < b.length()) {
				result.append(b.charAt(i));
			}
			i++;
		}
		return result.toString();
	}

	/*
	 * Given a string and an int n, return a string made of n repetitions of the
	 * last n characters of the string. You may assume that n is between 0 and
	 * the length of the string, inclusive.
	 */
	public String repeatEnd(String str, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(str.substring(str.length() - n));
		}
		return sb.toString();
	}

	/*
	 * Given a string and an int n, return a string made of the first n
	 * characters of the string, followed by the first n-1 characters of the
	 * string, and so on. You may assume that n is between 0 and the length of
	 * the string, inclusive (i.e. n >= 0 and n <= str.length()).
	 */
	public String repeatFront(String str, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = n; i > 0; i--) {
			sb.append(str.substring(0, i));
		}
		return sb.toString();
	}

	/*
	 * Given two strings, word and a separator sep, return a big string made of
	 * count occurrences of the word, separated by the separator string.
	 */
	public String repeatSeparator(String word, String sep, int count) {
		if (count < 1) {
			return "";
		}
		if (count == 1) {
			return word;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < count; i++) {
			sb.append(word);
			sb.append(sep);
		}
		sb.append(word);
		return sb.toString();
	}

	/*
	 * Given a string, consider the prefix string made of the first N chars of
	 * the string. Does that prefix string appear somewhere else in the string?
	 * Assume that the string is not empty and that N is in the range
	 * 1..str.length().
	 */
	public boolean prefixAgain(String str, int n) {
		String prefix = str.substring(0, n);
		return str.indexOf(prefix, n) > -1;
	}

	/*
	 * Given a string, does "xyz" appear in the middle of the string? To define
	 * middle, we'll say that the number of chars to the left and right of the
	 * "xyz" must differ by at most one. This problem is harder than it looks.
	 */
	public boolean xyzMiddle(String str) { // AAAxyzB l = 7 m = 3 false //
											// 0123456 // ^ // AxyzBBB l = 7 m =
											// 3 false // 0123456 // ^ //
											// AAxyzBB l = 7 m = 3 // 0123456 //
											// ^ // AxyzBB l = 6 m =3 // 012345
											// // ^ // AAxyzB l = 6 m = 3 //
											// 012345 // ^ // start = m - 2 if
											// (str.length() <= 3) { return
											// str.equals("xyz"); } int m =
											// str.length()/2; String middle =
											// str.substring(m-2,m+2); int ind =
											// middle.indexOf("xyz"); int left =
											// m-2+ind; int right = str.length()
											// - (left + 3); return
											// Math.abs(left - right) <= 1;}
	/*
	 * A sandwich is two pieces of bread with something in between. Return the
	 * string that is between the first and last appearance of "bread" in the
	 * given string, or return the empty string "" if there are not two pieces
	 * of bread.
	 */

	public String getSandwich(String str) {
		int first = str.indexOf("bread");
		int last = str.lastIndexOf("bread");
		if (first == -1 || last == -1 || last == first) {
			return "";
		}
		return str.substring(first + 5, last);
	}

	/*
	 * Returns true if for every '*' (star) in the string, if there are chars
	 * both immediately before and after the star, they are the same.
	 */
	public boolean sameStarChar(String str) {
		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == '*') {
				if (str.charAt(i - 1) != str.charAt(i + 1)) {
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * Given a string, compute a new string by moving the first char to come
	 * after the next two chars, so "abc" yields "bca". Repeat this process for
	 * each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any
	 * group of fewer than 3 chars at the end.
	 */
	public String oneTwo(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i + 2 < str.length(); i += 3) {
			sb.append(str.charAt(i + 1));
			sb.append(str.charAt(i + 2));
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	/*
	 * Look for patterns like "zip" and "zap" in the string -- length-3,
	 * starting with 'z' and ending with 'p'. Return a string where for all such
	 * words, the middle letter is gone, so "zipXzap" yields "zpXzp".
	 */
	public String zipZap(String str) {
		return str.replaceAll("z\\wp", "zp");
	}

	/*
	 * Return a version of the given string, where for every star (*) in the
	 * string the star and the chars immediately to its left and right are gone.
	 * So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
	 */
	public String starOut(String str) {
		return str.replaceAll(".?\\*+.?", "");
	}

	/*
	 * Given a string and a non-empty word string, return a version of the
	 * original String where all chars have been replaced by pluses ("+"),
	 * except for appearances of the word string which are preserved unchanged.
	 */
	public String plusOut(String str, String word) {
		StringBuilder sb = new StringBuilder();
		int j = 0;
		int wordPart = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == word.charAt(j)) {
				j++;
			} else {
				while (j > 0) {
					sb.append("+");
					j--;
				}
				sb.append("+");
			}
			if (j == word.length()) {
				j = 0;
				sb.append(word);
			}
		}
		return sb.toString();
	}

	/*
	 * Given a string and a non-empty word string, return a string made of each
	 * char just before and just after every appearance of the word in the
	 * string. Ignore cases where there is no char before or after the word, and
	 * a char may be included twice if it is between two words.
	 */
	public String wordEnds(String str, String word) {
		StringBuilder sb = new StringBuilder();
		int ind = str.indexOf(word);
		while (ind > -1) {
			int before = ind - 1;
			int after = ind + word.length();
			if (before >= 0) {
				sb.append(str.charAt(before));
			}
			if (after < str.length()) {
				sb.append(str.charAt(after));
			}
			ind = str.indexOf(word, ind + 1);
		}
		return sb.toString();
	}

}
