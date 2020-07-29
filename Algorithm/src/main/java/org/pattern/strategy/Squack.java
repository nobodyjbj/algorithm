package org.pattern.strategy;

import org.pattern.strategy.design.QuackBehavior;

public class Squack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("quick! quick! quick!");
	}
	
}
