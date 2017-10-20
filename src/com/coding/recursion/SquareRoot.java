package com.coding.recursion;

public class SquareRoot {

	public static void main(String[] args) {
		SquareRoot root = new SquareRoot();
		System.out.println(root.squareRoot(29));
	}
	
	public double squareRoot(double target) {
		return squareRoot(target, 0, target);
	}
	
	private double squareRoot(double target, double start, double end) {
		double midPoint = (start + end) / 2;
		boolean withinRange = Math.abs((midPoint * midPoint) - target) <= 0.00001; 
		if (withinRange) {
			return midPoint;
		} else if (midPoint * midPoint > target) {
			return squareRoot(target, start, midPoint);
		} else {
			return squareRoot(target, midPoint, end);
		}
	}
}
