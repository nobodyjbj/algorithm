package org.pattern.decorator;

import org.pattern.decorator.design.Beverage;
import org.pattern.decorator.design.CondimentDecorator;

public class Mocha implements CondimentDecorator {
	Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public double cost() {
		return .20 + beverage.cost();
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
	
}
