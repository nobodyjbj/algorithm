package org.pattern.strategy;

import org.pattern.strategy.design.FlyBehavior;

public class FlyRocketPowerd implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can rocket fly.");
	}
	
}
