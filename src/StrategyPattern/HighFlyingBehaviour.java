package StrategyPattern;

public class HighFlyingBehaviour implements FlyBehaviour{

	@Override
	public void fly() {
		System.out.println("I am flying at a high level");
	}

}
