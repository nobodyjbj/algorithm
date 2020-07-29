package org.designpattern.strategy;

import org.designpattern.strategy.design.Duck;

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
