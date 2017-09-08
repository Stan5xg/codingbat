package array2;

public class Array2 {
	/*
	 * Return the number of even ints in the given array. Note: the % "mod"
	 * operator computes the remainder, e.g. 5 % 2 is 1.
	 */
	public int countEvens(int[] nums) {
		int even = 0;
		for (int num : nums) {
			if (num % 2 == 0) {
				even++;
			}
		}
		return even;
	}

	/*
	 * Given an array length 1 or more of ints, return the difference between
	 * the largest and smallest values in the array. Note: the built-in
	 * Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or
	 * larger of two values.
	 */
	public int bigDiff(int[] nums) {
		int min = nums[0];
		int max = nums[0];
		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		return max - min;
	}

	/*
	 * Return the "centered" average of an array of ints, which we'll say is the
	 * mean average of the values, except ignoring the largest and smallest
	 * values in the array. If there are multiple copies of the smallest value,
	 * ignore just one copy, and likewise for the largest value. Use int
	 * division to produce the final average. You may assume that the array is
	 * length 3 or more.
	 */
	public int centeredAverage(int[] nums) {  int min = nums[0];  int max = nums[0];  int sum = 0;     for (int i = 0; i < nums.length; i++) {    max = Math.max(max, nums[i]);    min = Math.min(min, nums[i]);    sum += nums[i];  } // sum
																																														// -=
																																														// max;
																																														// sum
																																														// -=
																																														// min
																																														// +
																																														// max;
																																														// return
																																														// sum
																																														// /
																																														// (nums.length
																																														// -
																																														// 2);
																																														// }
	/*
	 * Return the sum of the numbers in the array, returning 0 for an empty
	 * array. Except the number 13 is very unlucky, so it does not count and
	 * numbers that come immediately after a 13 also do not count.
	 */

	public int sum13(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		int sum = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != 13 && nums[i - 1] != 13) {
				sum += nums[i];
			}
		}
		if (nums[0] != 13) {
			sum += nums[0];
		}
		return sum;
	}

	/*
	 * Return the sum of the numbers in the array, except ignore sections of
	 * numbers starting with a 6 and extending to the next 7 (every 6 will be
	 * followed by at least one 7). Return 0 for no numbers.
	 */
	public int sum67(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		int sum = 0;
		boolean skip = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 6) {
				skip = true;
			}
			if (!skip) {
				sum += nums[i];
			}
			if (skip && nums[i] == 7) {
				skip = false;
			}
		}
		return sum;
	}

	/*
	 * Given an array of ints, return true if the array contains a 2 next to a 2
	 * somewhere.
	 */
	public boolean has22(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == 2 && nums[i - 1] == 2) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Given an array of ints, return true if the array contains no 1's and no
	 * 3's.
	 */
	public boolean lucky13(int[] nums) {
		for (int num : nums) {
			if (num == 1 || num == 3) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Given an array of ints, return true if the sum of all the 2's in the
	 * array is exactly 8.
	 */
	public boolean sum28(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			if (num == 2) {
				sum += 2;
			}
		}
		return sum == 8;
	}

	/*
	 * Given an array of ints, return true if the number of 1's is greater than
	 * the number of 4's
	 */
	public boolean more14(int[] nums) {
		int ones = 0;
		int fours = 0;
		for (int num : nums) {
			if (num == 1) {
				ones++;
			}
			if (num == 4) {
				fours++;
			}
		}
		return ones > fours;
	}

	/*
	 * Given a number n, create and return a new int array of length n,
	 * containing the numbers 0, 1, 2, ... n-1. The given n may be 0, in which
	 * case just return a length 0 array. You do not need a separate
	 * if-statement for the length-0 case; the for-loop should naturally execute
	 * 0 times in that case, so it just works. The syntax to make a new int
	 * array is: new int[desired_length]   (See also: FizzBuzz Code)
	 */
	public int[] fizzArray(int n) {
		int res[] = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = i;
		}
		return res;
	}

	/* Given an array of ints, return true if every element is a 1 or a 4. */
	public boolean only14(int[] nums) {
		for (int num : nums) {
			if (num != 1 && num != 4) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Given a number n, create and return a new string array of length n,
	 * containing the strings "0", "1" "2" .. through n-1. N may be 0, in which
	 * case just return a length 0 array. Note: String.valueOf(xxx) will make
	 * the String form of most types. The syntax to make a new string array is:
	 * new String[desired_length]  (See also: FizzBuzz Code)
	 */
	public String[] fizzArray2(int n) {
		String[] res = new String[n];
		for (int i = 0; i < n; i++) {
			res[i] = String.valueOf(i);
		}
		return res;
	}

	/*
	 * Given an array of ints, return true if it contains no 1's or it contains
	 * no 4's.
	 */
	public boolean no14(int[] nums) {
		int allow = 0;
		for (int num : nums) {
			if ((num == 4 || num == 1) && allow == 0) {
				allow = num;
			}
			if ((num == 4 || num == 1) && num != allow) {
				return false;
			}
		}
		return true;
	}

	/*
	 * We'll say that a value is "everywhere" in an array if for every pair of
	 * adjacent elements in the array, at least one of the pair is that value.
	 * Return true if the given value is everywhere in the array.
	 */
	public boolean isEverywhere(int[] nums, int val) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != val && nums[i + 1] != val) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Given an array of ints, return true if the array contains a 2 next to a 2
	 * or a 4 next to a 4, but not both.
	 */
	public boolean either24(int[] nums) {
		boolean contains2 = false;
		boolean contains4 = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] == 2 && nums[i] == 2) {
				contains2 = true;
			}
			if (nums[i - 1] == 4 && nums[i] == 4) {
				contains4 = true;
			}
		}
		return contains2 ^ contains4;
	}

	/*
	 * Given arrays nums1 and nums2 of the same length, for every element in
	 * nums1, consider the corresponding element in nums2 (at the same index).
	 * Return the count of the number of times that the two elements differ by 2
	 * or less, but are not equal.
	 */
	public int matchUp(int[] nums1, int[] nums2) {
		int count = 0;
		for (int i = 0; i < nums1.length; i++) {
			int diff = Math.abs(nums1[i] - nums2[i]);
			if (diff <= 2 && diff != 0) {
				count++;
			}
		}
		return count;
	}

	/*
	 * Given an array of ints, return true if the array contains two 7's next to
	 * each other, or there are two 7's separated by one element, such as with
	 * {7, 1, 7}.
	 */
	public boolean has77(int[] nums) {
		boolean result = false;
		int sevenInd = -100;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 7) {
				if ((i - sevenInd) <= 2) {
					return true;
				}
				sevenInd = i;
			}
		}
		return false;
	}

	/*
	 * Given an array of ints, return true if there is a 1 in the array with a 2
	 * somewhere later in the array.
	 */
	public boolean has12(int[] nums) {
		boolean searchTwo = false;
		for (int num : nums) {
			if (num == 1) {
				searchTwo = true;
			}
			if (searchTwo && num == 2) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Given an array of ints, return true if the array contains either 3 even
	 * or 3 odd values all next to each other.
	 */
	public boolean modThree(int[] nums) {  int odd = 0;  int even = 0;    boolean inOdd = false;  boolean inEven = false;    for (int num : nums) {    if (num % 2 == 0){  //even      if (inOdd) {        inOdd = false;        odd = 0;      }      inEven = true;      even ++;      if (even >= 3) {        return true;      }    }        if (num % 2 != 0){  //odd      if (inEven) {        inEven = false;        even = 0;      }      inOdd = true;      odd ++;      if (odd >= 3) {        return true;      }    }  }  
	/* Given an array of ints, return true if the value 3 appears in the array exactly 3 times, and no 3's are next to each other. */

	public boolean haveThree(int[] nums) {
		int count = 0;
		int lastInd = -10;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 3) {
				if (lastInd + 1 == i) {
					return false;
				}
				count++;
				lastInd = i;
			}
		}
		return count == 3;
	}

	/*
	 * Given an array of ints, return true if every 2 that appears in the array
	 * is next to another 2.
	 */
	public boolean twoTwo(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 2) {
				count++;
			} else {
				if (count == 1) {
					return false;
				}
				count = 0;
			}
		}
		return count != 1;
	}

	/*
	 * Return true if the group of N numbers at the start and end of the array
	 * are the same. For example, with {5, 6, 45, 99, 13, 5, 6}, the ends are
	 * the same for n=0 and n=2, and false for n=1 and n=3. You may assume that
	 * n is in the range 0..nums.length inclusive.
	 */
	public boolean sameEnds(int[] nums, int len) {
		for (int i = 0; i < len; i++) {
			if (nums[i] != nums[nums.length - len + i]) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Return true if the array contains, somewhere, three increasing adjacent
	 * numbers like .... 4, 5, 6, ... or 23, 24, 25.
	 */
	public boolean tripleUp(int[] nums) {
		if (nums.length < 3) {
			return false;
		}
		int val = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (val + 1 == nums[i]) {
				count++;
			} else {
				count = 1;
			}
			if (count == 3) {
				return true;
			}
			val = nums[i];
		}
		return false;
	}

	/*
	 * Given start and end numbers, return a new array containing the sequence
	 * of integers from start up to but not including end, so start=5 and end=10
	 * yields {5, 6, 7, 8, 9}. The end number will be greater or equal to the
	 * start number. Note that a length-0 array is valid. (See also: FizzBuzz
	 * Code)
	 */
	public int[] fizzArray3(int start, int end) {
		int[] res = new int[end - start];
		int val = start;
		for (int i = 0; i < res.length; i++) {
			res[i] = val++;
		}
		return res;
	}

	/*
	 * Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns
	 * {2, 5, 3, 6}. You may modify and return the given array, or return a new
	 * array.
	 */
	public int[] shiftLeft(int[] nums) {
		if (nums.length < 2) {
			return nums;
		}
		int first = nums[0];
		for (int i = 0; i < nums.length - 1; i++) {
			nums[i] = nums[i + 1];
		}
		nums[nums.length - 1] = first;
		return nums;
	}

	/*
	 * For each multiple of 10 in the given array, change all the values
	 * following it to be that multiple of 10, until encountering another
	 * multiple of 10. So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
	 */
	public int[] tenRun(int[] nums) {  int multiple = -1;  // boolean replace = false;  for (int i = 0; i < nums.length; i++) {    if (nums[i] % 10 == 0) {      multiple = nums[i];    }    if (multiple != -1) {      nums[i] = multiple;    }  }    return nums;}
	/* Given a non-empty array of ints, return a new array containing the elements from the original array that come before the first 4 in the original array. The original array will contain at least one 4. Note that it is valid in java to create an array of length 0. */

	public int[] pre4(int[] nums) {
		int fourInd = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 4) {
				fourInd = i;
				break;
			}
		}
		return Arrays.copyOf(nums, fourInd);
	}

	/*
	 * Given a non-empty array of ints, return a new array containing the
	 * elements from the original array that come after the last 4 in the
	 * original array. The original array will contain at least one 4. Note that
	 * it is valid in java to create an array of length 0.
	 */
	public int[] post4(int[] nums) {      int fourInd = -1;    for (int i = 0; i < nums.length; i++) {      if (nums[i] == 4) {        fourInd = i;        // break;      }    }    return Arrays.copyOfRange(nums, fourInd+1, nums.length);}
	/* We'll say that an element in an array is "alone" if there are values before and after it, and those values are different from it. Return a version of the given array where every instance of the given value which is alone is replaced by whichever value to its left or right is larger. */

	public int[] notAlone(int[] nums, int val) {
		if (nums.length <= 2) {
			return nums;
		}
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] == val && nums[i - 1] != val && nums[i + 1] != val) {
				nums[i] = Math.max(nums[i - 1], nums[i + 1]);
			}
		}
		return nums;
	}

	/*
	 * Return an array that contains the exact same numbers as the given array,
	 * but rearranged so that all the zeros are grouped at the start of the
	 * array. The order of the non-zero numbers does not matter. So {1, 0, 0, 1}
	 * becomes {0 ,0, 1, 1}. You may modify and return the given array or make a
	 * new array.
	 */
	public int[] zeroFront(int[] nums) {
		int border = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				nums[i] = nums[border];
				nums[border] = 0;
				border++;
			}
		}
		return nums;
	}

	/*
	 * Return a version of the given array where all the 10's have been removed.
	 * The remaining elements should shift left towards the start of the array
	 * as needed, and the empty spaces a the end of the array should be 0. So
	 * {1, 10, 10, 2} yields {1, 2, 0, 0}. You may modify and return the given
	 * array or make a new array.
	 */
	public int[] withoutTen(int[] nums) {  int border = nums.length - 1;  for (int i = 0; i < nums.length; i++) {    while (nums[i] == 10) {      for (int j = i; j < border; j++) {        nums[j] = nums[j+1];      }      nums[border] = 0;      border --;    } // border
																																														// --;
																																														// }
																																														// return
																																														// nums;}
	/*
	 * Return a version of the given array where each zero value in the array is
	 * replaced by the largest odd value to the right of the zero in the array.
	 * If there is no odd value to the right of the zero, leave the zero as a
	 * zero.
	 */

	public int[] zeroMax(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				nums[i] = largestOdd(nums, i);
			}
		}
		return nums;
	}

	private int largestOdd(int[] nums, int rightStart) {
		if (rightStart > nums.length - 2) {
			return nums[rightStart];
		}
		int oddMax = 0;
		for (int i = rightStart + 1; i < nums.length; i++) {
			if (nums[i] % 2 != 0) {
				oddMax = Math.max(oddMax, nums[i]);
			}
		}
		return oddMax;
	}

	/*
	 * Return an array that contains the exact same numbers as the given array,
	 * but rearranged so that all the even numbers come before all the odd
	 * numbers. Other than that, the numbers can be in any order. You may modify
	 * and return the given array, or make a new array.
	 */
	public int[] evenOdd(int[] nums) {
		int leftBorder = 0;
		int rightBorder = nums.length - 1;
		while (leftBorder < rightBorder) {
			while (nums[leftBorder] % 2 == 0 && leftBorder < rightBorder) {
				leftBorder++;
			}
			while (nums[rightBorder] % 2 != 0 && leftBorder < rightBorder) {
				rightBorder--;
			}
			int buff = nums[leftBorder];
			nums[leftBorder] = nums[rightBorder];
			nums[rightBorder] = buff;
		}
		return nums;
	}

	/*
	 * This is slightly more difficult version of the famous FizzBuzz problem
	 * which is sometimes given as a first problem for job interviews. (See
	 * also: FizzBuzz Code.) Consider the series of numbers beginning at start
	 * and running up to but not including end, so for example start=1 and end=5
	 * gives the series 1, 2, 3, 4. Return a new String[] array containing the
	 * string form of these numbers, except for multiples of 3, use "Fizz"
	 * instead of the number, for multiples of 5 use "Buzz", and for multiples
	 * of both 3 and 5 use "FizzBuzz". In Java, String.valueOf(xxx) will make
	 * the String form of an int or other type. This version is a little more
	 * complicated than the usual version since you have to allocate and index
	 * into an array instead of just printing, and we vary the start/end instead
	 * of just always doing 1..100.
	 */
	public String[] fizzBuzz(int start, int end) {
		String[] res = new String[end - start];
		String fb = "";
		int num = start;
		for (int i = 0; i < res.length; i++) {
			if (num % 3 == 0) {
				fb = "Fizz";
			}
			if (num % 5 == 0) {
				fb += "Buzz";
			}
			if (fb.length() == 0) {
				res[i] = String.valueOf(num);
			} else {
				res[i] = fb;
			}
			fb = "";
			num++;
		}
		return res;
	}

}
