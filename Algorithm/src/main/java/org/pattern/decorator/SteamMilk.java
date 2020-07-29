package org.pattern.decorator;

import org.pattern.decorator.design.Beverage;
import org.pattern.decorator.design.CondimentDecorator;

public class SteamMilk implements CondimentDecorator {
	Beverage beverage;
	
	public SteamMilk(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public double cost() {
		return .25 + beverage.cost();
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", SteamMilk";
	}
	
}