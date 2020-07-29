package org.designpattern.strategy;

import org.designpattern.strategy.design.QuackBehavior;

public class Squack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("quick! quick! quick!");
	}
	
}
