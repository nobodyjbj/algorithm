package org.designpattern.strategy;

import org.designpattern.strategy.design.QuackBehavior;

public class Quack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("quack! quack! quack!");
	}
	
}
