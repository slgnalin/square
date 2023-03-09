package org.slgnalin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> lengths = Arrays.asList(3, 5, 7);

		String square = square(lengths);

		System.out.println(square);
	}

	static String square(List<Integer> lengths) {
		if (lengths.isEmpty()) {
			return "";
		}

		Integer max = Collections.max(lengths);
		String s = " ".repeat(max * max); // Fill string with " "
		for (Integer currentSize : lengths) {
			for (int i = 0; i < currentSize; i++) {
				for (int j = 0; j < currentSize; j++) {
					if (i == 0 // first row
							|| j == 0 // first column
							|| i == currentSize - 1 // last row
							|| j == currentSize - 1 // last column
					) {
						s = s.substring(0, max * i + j) + "#" + s.substring(max * i + j + 1); // Replace " " with "#" where the conditions are met
					}
				}
			}
		}
		s = s.replaceAll("(.{" + max + "})", "$1\n"); // Insert a new-line character '\n' every {max} characters (after each row)
		return s;
	}
}
