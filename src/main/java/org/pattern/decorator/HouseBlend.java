package org.pattern.decorator;

import org.pattern.decorator.design.Beverage;

public class HouseBlend implements Beverage {

	@Override
	public String getDescription() {
		return "HouseBlend";
	}

	@Override
	public double cost() {
		return .89;
	}
	
}
