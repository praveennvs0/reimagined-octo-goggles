package StrategyPattern;

public abstract class Bird {
	
	FlyBehaviour flyBehaviour ;
	
	public FlyBehaviour getFlyBehaviour() {
		return flyBehaviour;
	}

	public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
		this.flyBehaviour = flyBehaviour;
	}

	public abstract void display();
	
	
	public void fly() {
		flyBehaviour.fly();
	}
	
	


}
