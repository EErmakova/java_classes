package com.mera.training.myHW;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

import org.testng.annotations.Test;

public class LambdasHW {

	private static Map<Integer, Integer> table;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		table = new HashMap();
		table.put(1, 5);
		table.put(2, 4);
		table.put(3, 3);
		table.put(14, 2);
		System.out.println(getValue(6));
		System.out.println(table);

		System.out.println(calculate(6, 3, (x, y) -> x + y));
		System.out.println(calculate(6, 3, (x, y) -> x - y));
		System.out.println(calculate(6, 3, (x, y) -> x * y));
		System.out.println(calculate(6, 3, (x, y) -> x / y));
		System.out.println(calculate(6, 3, (x, y) -> Math.sqrt(x)));
		System.out.println(calculate(6, 3, (x, y) -> Math.pow(x, y)));
		System.out.println(calculate(6, 3, (x, y) -> Math.pow((x+y)/(x-117), 3)));


	}

	public static Integer getValue(int myKey) {
		return table.compute(myKey, (k, v) -> v == null ? myKey + 1 : v);
	}

	public static Integer getValue2(int myKey) {
		return table.putIfAbsent(myKey, myKey + 1);
	}
	
	public static double calculate(int x, int y, DoubleBinaryOperator action) {
		return action.applyAsDouble(x, y);
	}

}
