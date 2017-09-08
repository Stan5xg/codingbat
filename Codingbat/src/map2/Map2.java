package map2;

import java.util.HashMap;
import java.util.Map;

public class Map2 {
	/*
	 * Given an array of strings, return a Map<String, Integer> containing a key
	 * for every different string in the array, always with the value 0. For
	 * example the string "hello" makes the pair "hello":0. We'll do more
	 * complicated counting later, but for this problem the value is simply 0.
	 */
	public Map<String, Integer> word0(String[] strings) {
		Map<String, Integer> map = new HashMap<>();
		for (String string : strings) {
			map.put(string, 0);
		}
		return map;
	}

	/*
	 * Given an array of strings, return a Map<String, Integer> containing a key
	 * for every different string in the array, and the value is that string's
	 * length.
	 */
	public Map<String, Integer> wordLen(String[] strings) {
		Map<String, Integer> map = new HashMap<>();
		for (String string : strings) {
			map.put(string, string.length());
		}
		return map;
	}

	/*
	 * Given an array of non-empty strings, create and return a Map<String,
	 * String> as follows: for each string add its first character as a key with
	 * its last character as the value.
	 */
	public Map<String, String> pairs(String[] strings) {
		Map<String, String> map = new HashMap<>();
		for (String string : strings) {
			map.put(string.charAt(0) + "", string.charAt(string.length() - 1) + "");
		}
		return map;
	}

	/*
	 * The classic word-count algorithm: given an array of strings, return a
	 * Map<String, Integer> with a key for each different string, with the value
	 * the number of times that string appears in the array.
	 */
	public Map<String, Integer> wordCount(String[] strings) {
		Map<String, Integer> map = new HashMap<>();
		for (String string : strings) {
			Integer count = map.get(string);
			if (count == null) {
				map.put(string, 1);
			} else {
				map.put(string, ++count);
			}
		}
		return map;
	}

	/*
	 * Given an array of non-empty strings, return a Map<String, String> with a
	 * key for every different first character seen, with the value of all the
	 * strings starting with that character appended together in the order they
	 * appear in the array.
	 */
	public Map<String, String> firstChar(String[] strings) {
		Map<String, String> map = new HashMap<>();
		for (String string : strings) {
			String key = String.valueOf(string.charAt(0));
			String value = map.get(key);
			if (value == null) {
				value = string;
			} else {
				value += string;
			}
			map.put(key, value);
		}
		return map;
	}

	/*
	 * Loop over the given array of strings to build a result string like this:
	 * when a string appears the 2nd, 4th, 6th, etc. time in the array, append
	 * the string to the result. Return the empty string if no string appears a
	 * 2nd time.
	 */
	public String wordAppend(String[] strings) {
		Map<String, Integer> map = new HashMap<>();
		StringBuilder result = new StringBuilder();
		for (String string : strings) {
			Integer counter = map.get(string);
			if (counter == null) {
				map.put(string, 1);
			} else {
				counter++;
				if (counter % 2 == 0) {
					result.append(string);
				}
				map.put(string, counter);
			}
		}
		return result.toString();
	}

	/*
	 * Given an array of strings, return a Map<String, Boolean> where each
	 * different string is a key and its value is true if that string appears 2
	 * or more times in the array.
	 */
	public Map<String, Boolean> wordMultiple(String[] strings) {
		Map<String, Boolean> map = new HashMap<>();
		for (String string : strings) {
			Boolean val = map.get(string);
			if (val == null) {
				map.put(string, false);
			} else {
				map.put(string, true);
			}
		}
		return map;
	}

	/*
	 * We'll say that 2 strings "match" if they are non-empty and their first
	 * chars are the same. Loop over and then return the given array of
	 * non-empty strings as follows: if a string matches an earlier string in
	 * the array, swap the 2 strings in the array. When a position in the array
	 * has been swapped, it no longer matches anything. Using a map, this can be
	 * solved making just one pass over the array. More difficult than it looks.
	 */
	public String[] allSwap(String[] strings) {
		Map<Character, Integer> positions = new HashMap<>();
		for (int i = 0; i < strings.length; i++) {
			Character firstChar = strings[i].charAt(0);
			Integer pos = positions.get(firstChar);
			if (pos == null) {
				positions.put(firstChar, i);
			} else {
				swap(strings, pos, i);
				positions.remove(firstChar);
			}
		}
		return strings;
	}

//	private void swap(String[] arr, int pos1, int pos2) { //already presented
//		String tmp = arr[pos1];
//		arr[pos1] = arr[pos2];
//		arr[pos2] = tmp;
//	}

	/*
	 * We'll say that 2 strings "match" if they are non-empty and their first
	 * chars are the same. Loop over and then return the given array of
	 * non-empty strings as follows: if a string matches an earlier string in
	 * the array, swap the 2 strings in the array. A particular first char can
	 * only cause 1 swap, so once a char has caused a swap, its later swaps are
	 * disabled. Using a map, this can be solved making just one pass over the
	 * array. More difficult than it looks.
	 */
	public String[] firstSwap(String[] strings) {
		Map<Character, Integer> positions = new HashMap<>();
		for (int i = 0; i < strings.length; i++) {
			Character firstChar = strings[i].charAt(0);
			Integer pos = positions.get(firstChar);
			if (pos == null) {
				positions.put(firstChar, i);
			} else if (pos >= 0) {
				swap(strings, pos, i);
				positions.put(firstChar, -1);
			}
		}
		return strings;
	}

	private void swap(String[] arr, int pos1, int pos2) {
		String tmp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = tmp;
	}

}
