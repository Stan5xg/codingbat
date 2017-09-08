package map1;

import java.util.Map;

public class Map1 {
	/*
	 * Modify and return the given map as follows: if the key "a" has a value,
	 * set the key "b" to have that value, and set the key "a" to have the value
	 * "". Basically "b" is a bully, taking the value and replacing it with the
	 * empty string.
	 */
	public Map<String, String> mapBully(Map<String, String> map) {
		String value = map.replace("a", "");
		if (value != null) {
			map.put("b", value);
		}
		return map;
	}

	/*
	 * Modify and return the given map as follows: if the key "a" has a value,
	 * set the key "b" to have that same value. In all cases remove the key "c",
	 * leaving the rest of the map unchanged.
	 */
	public Map<String, String> mapShare(Map<String, String> map) {
		map.remove("c");
		String aValue = map.get("a");
		if (aValue != null) {
			map.put("b", aValue);
		}
		return map;
	}

	/*
	 * Modify and return the given map as follows: for this problem the map may
	 * or may not contain the "a" and "b" keys. If both keys are present, append
	 * their 2 string values together and store the result under the key "ab".
	 */
	public Map<String, String> mapAB(Map<String, String> map) {
		String aVal = map.get("a");
		String bVal = map.get("b");
		if (aVal != null && bVal != null) {
			map.put("ab", aVal + bVal);
		}
		return map;
	}

	/*
	 * Given a map of food keys and topping values, modify and return the map as
	 * follows: if the key "ice cream" is present, set its value to "cherry". In
	 * all cases, set the key "bread" to have the value "butter".
	 */
	public Map<String, String> topping1(Map<String, String> map) {
		if (map.containsKey("ice cream")) {
			map.put("ice cream", "cherry");
		}
		map.put("bread", "butter");
		return map;
	}

	/*
	 * Given a map of food keys and their topping values, modify and return the
	 * map as follows: if the key "ice cream" has a value, set that as the value
	 * for the key "yogurt" also. If the key "spinach" has a value, change that
	 * value to "nuts".
	 */
	public Map<String, String> topping2(Map<String, String> map) {
		String iceCreamVal = map.get("ice cream");
		String spinachVal = map.get("spinach");
		if (iceCreamVal != null) {
			map.put("yogurt", iceCreamVal);
		}
		if (spinachVal != null) {
			map.put("spinach", "nuts");
		}
		return map;
	}

	/*
	 * Given a map of food keys and topping values, modify and return the map as
	 * follows: if the key "potato" has a value, set that as the value for the
	 * key "fries". If the key "salad" has a value, set that as the value for
	 * the key "spinach".
	 */
	public Map<String, String> topping3(Map<String, String> map) {
		String potatoVal = map.get("potato");
		String saladVal = map.get("salad");
		if (potatoVal != null) {
			map.put("fries", potatoVal);
		}
		if (saladVal != null) {
			map.put("spinach", saladVal);
		}
		return map;
	}

	/*
	 * Modify and return the given map as follows: if the keys "a" and "b" are
	 * both in the map and have equal values, remove them both.
	 */
	public Map<String, String> mapAB2(Map<String, String> map) {
		String a = map.get("a");
		String b = map.get("b");
		if (a != null && b != null && a.equals(b)) {
			map.remove("a");
			map.remove("b");
		}
		return map;
	}

	/*
	 * Modify and return the given map as follows: if exactly one of the keys
	 * "a" or "b" has a value in the map (but not both), set the other to have
	 * that same value in the map.
	 */
	public Map<String, String> mapAB3(Map<String, String> map) {
		String a = map.get("a");
		String b = map.get("b");
		if (a == null && b != null) {
			map.put("a", b);
		}
		if (a != null && b == null) {
			map.put("b", a);
		}
		return map;
	}

	/*
	 * Modify and return the given map as follows: if the keys "a" and "b" have
	 * values that have different lengths, then set "c" to have the longer
	 * value. If the values exist and have the same length, change them both to
	 * the empty string in the map.
	 */
	public Map<String, String> mapAB4(Map<String, String> map) {
		String a = map.get("a");
		String b = map.get("b");
		if (a == null || b == null) {
			return map;
		}
		if (a.length() == b.length()) {
			map.put("a", "");
			map.put("b", "");
		} else if (a.length() > b.length()) {
			map.put("c", a);
		} else {
			map.put("c", b);
		}
		return map;
	}

}
