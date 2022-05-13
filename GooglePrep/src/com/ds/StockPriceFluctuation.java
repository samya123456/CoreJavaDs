package com.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class StockPriceFluctuation {

	static Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
	static TreeSet<Integer> priceSet = new TreeSet<>();
	static int theMinimum = 0;
	static int theMaximum = 0;
	static int latestPrice = 0;

	public StockPriceFluctuation() {

	}

	public static void update(int timestamp, int price) {
		if (map.size() == 0) {
			theMinimum = price;
			theMaximum = price;
			priceSet.add(price);
		} else if (map.containsKey(timestamp)) {
			int keyPrice = map.get(timestamp);
			priceSet.remove(keyPrice);
			priceSet.add(price);
			List<Integer> list = new ArrayList<>(priceSet);
			theMaximum = list.get(list.size()-1);
			theMinimum = list.get(0);
			

		} else {
			priceSet.add(price);
			List<Integer> list = new ArrayList<>(priceSet);
			theMaximum = list.get(list.size()-1);
			theMinimum = list.get(0);
			
		}
		map.put(timestamp, price);
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		latestPrice = list.get(0).getValue();

	}

	public static int current() {
		return latestPrice;
	}

	public static int maximum() {
		return theMaximum;
	}

	public static int minimum() {
		return theMinimum;
	}

	public static void main(String[] args) {
		update(1, 10);
		update(2, 5);
		System.out.println("latest price  =" + current());
		System.out.println("minimum price  =" + minimum());
		System.out.println("maximum price  =" + maximum());
		update(1, 3);
		System.out.println("latest price  =" + current());
		System.out.println("minimum price  =" + minimum());
		System.out.println("maximum price  =" + maximum());
		update(4, 2);
	}

}
