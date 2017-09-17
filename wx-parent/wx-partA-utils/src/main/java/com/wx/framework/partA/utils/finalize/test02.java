package com.wx.framework.partA.utils.finalize;

public class test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Spiciness s : Spiciness.values()) {
			System.out.println(s + ", ordinal " + s.ordinal());
		}
		switchEnum(Spiciness.GREEN);
	}

	public static void switchEnum(Spiciness s) {

		switch (s) {
		case BLUE:
			System.out.println(s);
			break;
		case RED:
			System.out.println(s);
			break;
		case GREEN:
			System.out.println(s);
			break;
		case YELLOW:
			System.out.println(s);
			break;
		default:
			System.out.println("default");
			break;
		}
	}
}
