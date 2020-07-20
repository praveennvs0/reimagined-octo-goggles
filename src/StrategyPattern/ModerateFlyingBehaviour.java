package StrategyPattern;

public class ModerateFlyingBehaviour implements FlyBehaviour{

	@Override
	public void fly() {
		System.out.println("I am flying at a moderate level");
	}

}
