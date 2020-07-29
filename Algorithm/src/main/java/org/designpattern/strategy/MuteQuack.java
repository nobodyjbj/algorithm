package org.designpattern.strategy;

import org.designpattern.strategy.design.QuackBehavior;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("...");
	}
	
}
