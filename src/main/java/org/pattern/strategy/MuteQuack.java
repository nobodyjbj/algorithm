package org.pattern.strategy;

import org.pattern.strategy.design.QuackBehavior;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("...");
	}
	
}
