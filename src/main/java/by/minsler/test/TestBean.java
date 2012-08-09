package by.minsler.test;

import by.minsler.beans.PageData;

public class TestBean {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PageData p1 = new PageData();
		PageData p2 = new PageData();
		p2.setId("19");

		System.out.println(p1.equals(p2));
	}

}
