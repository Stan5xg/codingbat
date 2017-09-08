package array3;

public class Array3 {
	/*
	 * Consider the leftmost and righmost appearances of some value in an array.
	 * We'll say that the "span" is the number of elements between the two
	 * inclusive. A single value has a span of 1. Returns the largest span found
	 * in the given array. (Efficiency is not a priority.)
	 */
	public int maxSpan(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		int max = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((nums[i] == nums[j]) && max < (j - i + 1)) {
					max = j - i + 1;
				}
			}
		}
		return max;
	}

	/*
	 * Return an array that contains exactly the same numbers as the given
	 * array, but rearranged so that every 3 is immediately followed by a 4. Do
	 * not move the 3's, but every other number may move. The array contains the
	 * same number of 3's and 4's, every 3 has a number after it that is not a
	 * 3, and a 3 appears in the array before any 4.
	 */
	public int[] fix34(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 3) {
				for (int j = 0; j < nums.length; j++) {
					if (nums[j] == 3) {
						j++;
						continue;
					}
					if (nums[j] == 4) {
						int buff = nums[i + 1];
						nums[i + 1] = nums[j];
						nums[j] = buff;
					}
				}
			}
		}
		return nums;
	}

	/*
	 * (This is a slightly harder version of the fix34 problem.) Return an array
	 * that contains exactly the same numbers as the given array, but rearranged
	 * so that every 4 is immediately followed by a 5. Do not move the 4's, but
	 * every other number may move. The array contains the same number of 4's
	 * and 5's, and every 4 has a number after it that is not a 4. In this
	 * version, 5's may appear anywhere in the original array.
	 */
	public int[] fix45(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 4) {
				for (int j = 0; j < nums.length; j++) {
					if (nums[j] == 4) {
						j++;
						continue;
					}
					if (nums[j] == 5) {
						int buff = nums[i + 1];
						nums[i + 1] = nums[j];
						nums[j] = buff;
					}
				}
			}
		}
		return nums;
	}

	/*
	 * Given a non-empty array, return true if there is a place to split the
	 * array so that the sum of the numbers on one side is equal to the sum of
	 * the numbers on the other side.
	 */
	public boolean canBalance(int[] nums) {
		int leftSum = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			leftSum += nums[i];
			int rightSum = 0;
			for (int j = i + 1; j < nums.length; j++) {
				rightSum += nums[j];
			}
			if (leftSum == rightSum) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Given two arrays of ints sorted in increasing order, outer and inner,
	 * return true if all of the numbers in inner appear in outer. The best
	 * solution makes only a single "linear" pass of both arrays, taking
	 * advantage of the fact that both arrays are already in sorted order.
	 */
	public boolean linearIn(int[] outer, int[] inner) {
		if (inner.length == 0) {
			return true;
		}
		int j = 0;
		for (int i = 0; i < outer.length; i++) {
			if (outer[i] == inner[j]) {
				j++;
				if (j >= inner.length) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * Given n>=0, create an array length n*n with the following pattern, shown
	 * here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show
	 * the 3 groups).
	 */
	public int[] squareUp(int n) {
		int[] res = new int[n * n];
		int val = 1;
		int zero = n + 1;
		for (int i = res.length - 1; i >= 0; i--) {
			if (val > n) {
				val = 1;
				zero--;
			}
			if (zero - val > 0) {
				res[i] = val;
			}
			val++;
		}
		return res;
	}

	/*
	 * Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,
	 *   ... 1, 2, 3 .. n} (spaces added to show the grouping). Note that the
	 * length of the array will be 1 + 2 + 3 ... + n, which is known to sum to
	 * exactly n*(n + 1)/2.
	 */
	public int[] seriesUp(int n) {
		int[] result = new int[n * (n + 1) / 2];
		int val = 1;
		int limit = 1;
		for (int i = 0; i < result.length; i++) {
			result[i] = val;
			if (val < limit) {
				val++;
			} else {
				val = 1;
				limit++;
			}
		}
		return result;
	}

	/*
	 * We'll say that a "mirror" section in an array is a group of contiguous
	 * elements such that somewhere in the array, the same group appears in
	 * reverse order. For example, the largest mirror section in {1, 2, 3, 8, 9,
	 * 3, 2, 1} is length 3 (the {1, 2, 3} part). Return the size of the largest
	 * mirror section found in the given array.
	 */
	public int maxMirror(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		int mirror = 1;
		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[i] == nums[j]) {
					mirror = checkLength(nums, i, j);
					if (max < mirror) {
						max = mirror;
					}
				}
			}
		}
		return max;
	}

	private int checkLength(int[] nums, int i, int j) {
		int length = 0;
		while (j >= 0 && i < nums.length && nums[i] == nums[j]) {
			length++;
			i++;
			j--;
		}
		return length;
	}

	/*
	 * Say that a "clump" in an array is a series of 2 or more adjacent elements
	 * of the same value. Return the number of clumps in the given array.
	 */
	public int countClumps(int[] nums) {
		if (nums.length <= 1) {
			return 0;
		}
		int clumps = 0;
		int currClump = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				currClump++;
			} else {
				if (currClump > 0) {
					clumps++;
				}
				currClump = 0;
			}
		}
		if (currClump > 0) {
			clumps++;
		}
		return clumps;
	}

}
