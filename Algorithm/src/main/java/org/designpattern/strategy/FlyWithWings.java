package org.designpattern.strategy;

import org.designpattern.strategy.design.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can fly.");
	}
	
}
