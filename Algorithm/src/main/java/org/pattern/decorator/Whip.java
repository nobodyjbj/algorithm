package org.pattern.decorator;

import org.pattern.decorator.design.Beverage;
import org.pattern.decorator.design.CondimentDecorator;

public class Whip implements CondimentDecorator {
	Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public double cost() {
		return .15 + beverage.cost();
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
	
}
