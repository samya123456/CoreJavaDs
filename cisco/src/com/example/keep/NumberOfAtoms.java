package com.example.keep;

import java.util.Map;
import java.util.TreeMap;

public class NumberOfAtoms {
	static Map<String, Integer> atomMap = new TreeMap<String, Integer>();
	static boolean letter = false;
	static boolean number = false;
	static boolean upperCase = false;
	static String atom = "";
	static String digit = "";
	static String multiplier = "";
	static boolean isBraket = false;

	public static String countOfAtoms(String formula) {
		
		int n = formula.length();
		
		for (int i = 0; i < n; i++) {
			
			if (formula.charAt(i) == '(') {
				if (!"".equals(digit)) {
					atomMap.put(atom, Integer.parseInt(digit));
				} else {
					atomMap.put(atom, 1);
				}

				atom = "";
				digit = "";
				letter = true;
				number = false;
				upperCase = true;
				countOfAtoms(formula.substring(i + 1));
				
			} else if (formula.charAt(i) == ')') {
				if (!"".equals(digit)) {
					atomMap.put(atom, Integer.parseInt(digit));
				} else {
					atomMap.put(atom, 1);
				}
				atom = "";
				digit = "";
				letter = true;
				number = false;
				upperCase = true;
				if (i == n - 1) {
					multiplier = "1";
				}
				while (i + 1 < n && Character.isDigit(formula.charAt(++i))) {

					if (i < n) {
						multiplier = multiplier + Character.valueOf(formula.charAt(i)).toString();
					} else {
						break;
					}

				}

				for (Map.Entry<String, Integer> entry : atomMap.entrySet()) {
					atomMap.put(entry.getKey(), entry.getValue() * Integer.parseInt(multiplier));

				}

				multiplier = "";

			} else {
				constructFormula(formula, i);
			}

		}
		if (!"".equals(digit)) {
			atomMap.put(atom, Integer.parseInt(digit));
		} else {
			atomMap.put(atom, 1);
		}

		return "";

	}

	private static void constructFormula(String formula, int i) {

		if (number && !letter && Character.isLetter(formula.charAt(i))) {
			atomMap.put(atom, Integer.parseInt(digit));
			atom = Character.valueOf(formula.charAt(i)).toString();
			digit = "";
			letter = true;
			number = false;
			upperCase = true;
		} else {
			if (Character.isLetter(formula.charAt(i))) {
				if (!upperCase && Character.isUpperCase(formula.charAt(i))) {
					atom = Character.valueOf(formula.charAt(i)).toString();
					upperCase = true;
				} else if (upperCase && Character.isUpperCase(formula.charAt(i))) {
					if ("".equals(atom)) {
						atom = Character.valueOf(formula.charAt(i)).toString();
					}
					atomMap.put(atom, 1);
					digit = "";
					letter = true;
					number = false;
					atom = Character.valueOf(formula.charAt(i)).toString();
					upperCase = false;
				} else {
					atom = atom + Character.valueOf(formula.charAt(i)).toString();
					upperCase = false;
				}
				letter = true;
				number = false;
			} else {
				if (Character.isDigit(formula.charAt(i))) {
					digit = digit + Character.valueOf(formula.charAt(i)).toString();
					number = true;
					letter = false;

				}

			}
		}

	}

	public static void main(String[] args) {

		// "K4(ON(SO3)2)2"
		countOfAtoms("Na(OH)2");

	}

}
