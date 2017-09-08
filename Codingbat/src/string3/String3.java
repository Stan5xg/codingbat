package string3;

public class String3 {
	/*
	 * Given a string, count the number of words ending in 'y' or 'z' -- so the
	 * 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow"
	 * (not case sensitive). We'll say that a y or z is at the end of a word if
	 * there is not an alphabetic letter immediately following it. (Note:
	 * Character.isLetter(char) tests if a char is an alphabetic letter.)
	 */
	public int countYZ(String str) {
		char[] strArr = str.toCharArray();
		int count = 0;
		for (int i = 0; i < strArr.length - 1; i++) {
			if (isYZ(strArr[i]) && !Character.isLetter(strArr[i + 1])) {
				count++;
			}
		}
		if (isYZ(strArr[strArr.length - 1])) {
			count++;
		}
		return count;
	}

	private boolean isYZ(char c) {
		c = Character.toLowerCase(c);
		return c == 'y' || c == 'z';
	}

	/*
	 * Given two strings, base and remove, return a version of the base string
	 * where all instances of the remove string have been removed (not case
	 * sensitive). You may assume that the remove string is length 1 or more.
	 * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves
	 * "x".
	 */
	public String withoutString(String base, String remove) {
		return java.util.regex.Pattern.compile(remove, java.util.regex.Pattern.CASE_INSENSITIVE).matcher(base)
				.replaceAll("");
	}

	/*
	 * Given a string, return true if the number of appearances of "is" anywhere
	 * in the string is equal to the number of appearances of "not" anywhere in
	 * the string (case sensitive).
	 */
	public boolean equalIsNot(String str) {
		int isCount = 0;
		int i = str.indexOf("is");
		while (i != -1) {
			isCount++;
			i = str.indexOf("is", i + 1);
		}
		int notCount = 0;
		i = str.indexOf("not");
		while (i != -1) {
			notCount++;
			i = str.indexOf("not", i + 1);
		}
		return isCount == notCount;
	}

	/*
	 * We'll say that a lowercase 'g' in a string is "happy" if there is another
	 * 'g' immediately to its left or right. Return true if all the g's in the
	 * given string are happy.
	 */
	public boolean gHappy(String str) {
		int i = str.indexOf('g');
		int gCount = 0;
		while (i != -1) {
			gCount = 0;
			if (i != str.length() - 1) {
				if (str.charAt(i + 1) == 'g') {
					gCount++;
				}
			}
			if (i != 0) {
				if (str.charAt(i - 1) == 'g') {
					gCount++;
				}
			}
			if (gCount == 0) {
				return false;
			}
			i = str.indexOf('g', i + 1);
		}
		return true;
	}

	/*
	 * We'll say that a "triple" in a string is a char appearing three times in
	 * a row. Return the number of triples in the given string. The triples may
	 * overlap.
	 */
	public int countTriple(String str) {
		int count = 0;
		for (int i = 2; i < str.length(); i++) {
			if (str.charAt(i - 2) == str.charAt(i - 1) && str.charAt(i - 1) == str.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	/*
	 * Given a string, return the sum of the digits 0-9 that appear in the
	 * string, ignoring all other characters. Return 0 if there are no digits in
	 * the string. (Note: Character.isDigit(char) tests if a char is one of the
	 * chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an
	 * int.)
	 */
	public int sumDigits(String str) {
		int sum = 0;
		char currChar;
		for (int i = 0; i < str.length(); i++) {
			currChar = str.charAt(i);
			if (Character.isDigit(currChar)) {
				sum += Integer.parseInt(String.valueOf(currChar));
			}
		}
		return sum;
	}

	/*
	 * Given a string, return the longest substring that appears at both the
	 * beginning and end of the string without overlapping. For example,
	 * sameEnds("abXab") is "ab".
	 */
	public String sameEnds(String string) {    int start = string.length() / 2; // 4/2 = 2 3/ 2 = 1 5 / 2 = 2  // abXYab l = 6; mid = 3; start = 3 <- for even lenght start the same as mid  // 012345    // abXFCYab l = 8; mid = 4; start = 4   // 01234567  // abXab l = 5; mid = 2;  start = 3 <- for odd length start = mid + 1;  // 01234    if (string.length() % 2 != 0) {    start++;  }    int len = 0;  while (start < string.length()) {    if (string.charAt(len) == string.charAt(start)) {      len ++;    } else if (len > 0) {      len = 0;    }    start ++;  }    return string.substring(0,len);}
	/* Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string. In other words, zero or more characters at the very begining of the given string, and at the very end of the string in reverse order (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab". */

	public String mirrorEnds(String string) {
		int left = 0;
		int right = string.length() - 1;
		StringBuilder result = new StringBuilder();
		while (left < string.length() && (string.charAt(left) == string.charAt(right))) {
			result.append(string.charAt(left));
			right--;
			left++;
		}
		return result.toString();
	}

	/*
	 * Given a string, return the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same.
	 */
	public int maxBlock(String str) {  if(str.length() < 1) {    return 0;  }    int sameCharInd = 0;   char prev = str.charAt(0);  int max = 0;    for (int i = 1; i < str.length(); i++) {    if (str.charAt(i) != prev) {      // aaabccd      // 0123456      // ^  ^^ ^      max = Math.max(max, i - sameCharInd);            sameCharInd = i;    }        if (i == str.length() - 1) {      max = Math.max(max, i - sameCharInd + 1);    }        prev = str.charAt(i);  }        return max;}
	/* Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.) */

	public int sumNumbers(String str) {
		if (str.length() < 1) {
			return 0;
		}
		int sum = 0;
		StringBuilder numStr = new StringBuilder();
		numStr.append("0");
		for (int i = 0; i < str.length(); i++) {
			char currChar = str.charAt(i);
			if (Character.isDigit(currChar)) {
				numStr.append(currChar);
			}
			if (!Character.isDigit(currChar) || i == str.length() - 1) {
				sum += Integer.parseInt(numStr.toString());
				numStr = new StringBuilder();
				numStr.append("0");
			}
		}
		return sum;
	}

	/*
	 * Given a string, return a string where every appearance of the lowercase
	 * word "is" has been replaced with "is not". The word "is" should not be
	 * immediately preceeded or followed by a letter -- so for example the "is"
	 * in "this" does not count. (Note: Character.isLetter(char) tests if a char
	 * is a letter.)
	 */
	public String notReplace(String str) {
		int indIs = str.indexOf("is");
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		while (indIs != -1 || indIs >= sb.length()) {
			if (replace(indIs, sb)) {
				sb.replace(indIs, indIs + 2, "is not");
			}
			indIs = sb.indexOf("is", indIs + 1);
		}
		return sb.toString();
	}

	private boolean replace(int indIs, StringBuilder str) {
		int prev = indIs - 1;
		int next = indIs + 2;
		int len = str.length();
		boolean nextNotLetter = next < len && !Character.isLetter(str.charAt(next));
		nextNotLetter |= next >= len;
		boolean prevNotLetter = prev > 0 && !Character.isLetter(str.charAt(prev));
		prevNotLetter |= prev < 0;
		return nextNotLetter && prevNotLetter;
	}

}
