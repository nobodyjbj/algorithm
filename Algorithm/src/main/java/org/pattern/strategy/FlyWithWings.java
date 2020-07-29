package org.pattern.strategy;

import org.pattern.strategy.design.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can fly.");
	}
	
}
