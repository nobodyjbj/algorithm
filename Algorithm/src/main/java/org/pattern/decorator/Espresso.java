package org.pattern.decorator;

import org.pattern.decorator.design.Beverage;

public class Espresso implements Beverage {
	
	@Override
	public String getDescription() {
		return "Espresso";
	}

	@Override
	public double cost() {
		return 1.99;
	}
	
}
