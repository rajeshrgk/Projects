package test;

import java.util.Arrays;
import java.util.Collections;

public class AnagramCheck {

	public static void main(String[] args) {

		/*
		 * checkforAnagram("test", "estt");
		 * 
		 * reverseAnInteger(121);
		 * 
		 * checkforPrime(123);
		 */

		// largestNumberInArray(new Integer[] { 1, 2, 3, 4 });

		largestNumWithoutUsingInbuiltFuncitons(new Integer[] { 15, 4, 7, 8, 9 });

	}

	private static void largestNumWithoutUsingInbuiltFuncitons(Integer[] arr) {
		int firstMax = 0;
		int secondMax = 0;

		for (int i = 0; i < arr.length; i++) {
			if (firstMax < arr[i]) {
				secondMax = firstMax;
				firstMax = arr[i];
			} else if (secondMax < arr[i]) {
				secondMax = arr[i];
			}
		}
		System.out.println("largestNumber::" + firstMax);
		System.out.println("Second largestNumber::" + secondMax);

	}

	private static void largestNumberInArray(Integer[] arr) {
		// TODO Auto-generated method stub
		int sum = 0;
		Arrays.sort(arr, Collections.reverseOrder());

		// ascending Order
		Arrays.sort(arr);

		System.out.println(arr.toString());

		Arrays.asList(arr);

		for (int i = 0; i < arr.length - 1; i++) {
			sum += arr[i];
		}

		System.out.println("Sum " + sum);

	}

	private static void checkforPrime(int num) {

		// TODO Auto-generated method stub
		int halfvalue = num / 2;
		boolean flag = false;
		for (int i = 2; i < halfvalue; i++) {
			if (halfvalue / i == 0) {
				flag = false;
			} else
				flag = true;

		}
		System.out.println(flag ? "Prime Number" : "Not an Prime Number");

	}

	private static void reverseAnInteger(int num) {
		// TODO Auto-generated method stub

		int temp = num, r = 0, sum = 0;

		while (num > 0) {
			r = num % 10;
			sum = (sum * 10) + r;
			num = num / 10;

		}
		System.out.println("Integer Reverse Value::" + sum);
		System.out.println(temp == sum ? "Palindrome" : "Not an Palindrome");

	}

	private static void checkforAnagram(String str1, String str2) {
		// TODO Auto-generated method stub

		char[] charArray = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();

		Arrays.sort(charArray);
		Arrays.sort(charArray2);

		if (Arrays.equals(charArray, charArray2))
			System.out.println("Anagram");
		else
			System.out.println("Not an Anagram");
	}

}
