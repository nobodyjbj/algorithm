package org.designpattern.strategy;

import org.designpattern.strategy.design.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I cant't fly.");
	}

}
