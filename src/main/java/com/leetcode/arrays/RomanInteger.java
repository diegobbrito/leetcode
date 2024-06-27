package com.leetcode.arrays;

public class RomanInteger {

	public static void main(String[] args) {
		romanToInt("MCMXCIV");
	}
	public static int romanToInt(String s) {
		var sum = 0;

		for ( int c = 0; c < s.length(); c++) {
			var helper = String.valueOf(s.charAt(c + 1));
			switch (s.charAt(c)){
				case 'I' -> {
					if( "V".equals(helper) || "X".equals(helper))
						sum -= 1;
					else
						sum += 1;
				}
				case 'V' -> sum += 5;
				case 'X' -> {
					if( "L".equals(helper) || "C".equals(helper))
						sum -= 10;
					else
						sum += 10;
				}
				case 'L' -> sum += 50;
				case 'C' ->{
					if( "D".equals(helper) || "M".equals(helper))
						sum -= 100;
					else
						sum += 100;
				}
				case 'D' -> sum += 500;
				default -> sum += 1000;
			}
		}
		switch (s.charAt(s.length() - 1)){
			case 'I' -> sum += 1;
			case 'V' -> sum += 5;
			case 'X' -> sum += 10;
			case 'L' -> sum += 50;
			case 'C' -> sum += 100;
			case 'D' -> sum += 500;
			default -> sum += 1000;
		}

		return sum;
	}
}