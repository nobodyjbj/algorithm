package org.pattern.decorator;

import org.pattern.decorator.design.Beverage;
import org.pattern.decorator.design.CondimentDecorator;

public class Soy implements CondimentDecorator {
	Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public double cost() {
		return .10 + beverage.cost();
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}
	
}
