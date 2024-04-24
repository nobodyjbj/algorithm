package org.pattern.strategy;

import org.pattern.strategy.design.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I cant't fly.");
	}

}
