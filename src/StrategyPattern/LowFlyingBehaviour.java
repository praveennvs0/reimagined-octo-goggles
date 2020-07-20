package StrategyPattern;

public class LowFlyingBehaviour implements FlyBehaviour{

	@Override
	public void fly() {
		System.out.println("I am flying at a low level");
	}

}
