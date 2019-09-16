package com.mera.training.myHW;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsHW {

	enum Bridge {
		BRIDGE_0_0(0, 0), BRIDGE_0_25(0, 25), BRIDGE_0_26(0, 26), BRIDGE_0_28(0, 28), BRIDGE_1_0(1, 0), BRIDGE_1_25(1,
				25), BRIDGE_1_26(1, 26), BRIDGE_1_28(1, 28), BRIDGE_2_0(2,
						0), BRIDGE_2_25(2, 25), BRIDGE_2_26(2, 26), BRIDGE_2_28(2, 28), BRIDGE_3_0(3, 0), BRIDGE_3_25(3,
								25), BRIDGE_3_26(3, 26), BRIDGE_3_28(3, 28), BRIDGE_4_0(4, 0), BRIDGE_4_25(4,
										25), BRIDGE_4_26(4, 26), BRIDGE_4_28(4, 28), BRIDGE_5_0(5, 0), BRIDGE_5_25(5,
												25), BRIDGE_5_26(5, 26), BRIDGE_5_28(5, 28), BRIDGE_6_0(6,
														0), BRIDGE_6_25(6, 25), BRIDGE_6_26(6, 26), BRIDGE_6_28(6, 28);

		private final int shelf;
		private final int slot;

		Bridge(int shelf, int slot) {
			this.shelf = shelf;
			this.slot = slot;
		}

		public int getShelf() {
			return shelf;
		}

		public int getSlot() {
			return slot;
		}

	}

	private static List<Bridge> getAllBridges(List<Integer> shelfList) {
		return Arrays.stream(Bridge.values())
				.filter(b -> shelfList.stream().anyMatch(shelf -> shelf.equals(b.getShelf())))
				.filter(b -> b.getShelf() % 2 == 0).collect(Collectors.toList());
	}

	private static String convertToHex(String str) {
		return Arrays.stream(str.split("\\.")).map(s -> {
			return (Integer.toHexString(Integer.valueOf(s)).toUpperCase());
		}).map(s -> {
			return (s.length() == 1) ? "0".concat(s) : s;
		}).collect(Collectors.joining(":"));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> shelfNumbers = new ArrayList<Integer>();
		shelfNumbers.add(1);
		shelfNumbers.add(2);
		shelfNumbers.add(3);
		shelfNumbers.add(6);
		shelfNumbers.add(7);
		getAllBridges(shelfNumbers).stream().forEach(b -> System.out.println(b.getShelf() + "-" + b.getSlot()));

		System.out.println(convertToHex("192.168.0.1"));
		System.out.println(convertToHex("255.255.0.0"));

	}

}
