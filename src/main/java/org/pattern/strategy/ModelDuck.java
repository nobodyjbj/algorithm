package org.pattern.strategy;

import org.pattern.strategy.design.Duck;

public class ModelDuck extends Duck{

	public ModelDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyNoWay();
	}
	
	@Override
	public void display() {
		System.out.println("I'm Model");
	}
	
}
