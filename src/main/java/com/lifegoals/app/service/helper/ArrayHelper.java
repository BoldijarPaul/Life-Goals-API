package com.lifegoals.app.service.helper;

import java.util.Random;

public class ArrayHelper {
	private static Random random = new Random();

	public static <T> void shuffleIntArray(int[] ar) {
		for (int i = ar.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}
}
