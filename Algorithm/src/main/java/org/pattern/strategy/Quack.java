package org.pattern.strategy;

import org.pattern.strategy.design.QuackBehavior;

public class Quack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("quack! quack! quack!");
	}
	
}
