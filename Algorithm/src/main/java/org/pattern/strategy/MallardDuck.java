package org.pattern.strategy;

import org.pattern.strategy.design.Duck;

public class MallardDuck extends Duck {
	
	public MallardDuck () {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
	
	@Override
	public void display() {
		System.out.println("I'm MallardDuck.");
	}
	
}
