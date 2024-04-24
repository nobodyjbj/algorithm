package org.pattern.strategy;

import org.pattern.strategy.design.Duck;

public class MiniDuckSimulator {
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
		
		Duck model = new ModelDuck();
		model.performFly();
		model.performQuack();
		model.setFlyBehavior(new FlyRocketPowerd());
		model.performFly();
	}
}
