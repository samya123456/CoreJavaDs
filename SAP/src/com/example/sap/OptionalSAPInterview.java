package com.example.sap;
import java.util.Optional;
import java.util.Random;

public class OptionalSAPInterview {

	private static final Random RANDOM = new Random();

	public static void main(String[] args) {
		
		Optional<Integer> randomInt = getRandomInt(args);
		Integer orElse = randomInt.orElse(doPrintValue(-1));
		System.out.println(orElse);
	}

	private static Integer doPrintValue(int integer) {
		if (integer < 0) {
			throw new IllegalArgumentException("Integer value should not be negative");
		}
		System.out.println(integer);
		
		return integer;
	}

	private static Optional<Integer> getRandomInt(String[] args) {
		int nextInt = RANDOM.nextInt();
		if (args.length != 0) {
			if (args[0].equals("null")) {
				return Optional.empty();
			} else {
				return Optional.ofNullable(Integer.valueOf(args[0]));
			}
		} else {
			return Optional.of(Math.abs(nextInt));
		}
	}
}
