package StrategyPattern;

public class BirdApplication {
	
	public static void main(String[] args) {
		Bird eagle = new Eagle();
		
		eagle.setFlyBehaviour(new HighFlyingBehaviour());
		eagle.fly();
		
		eagle.setFlyBehaviour(new LowFlyingBehaviour());
		eagle.fly();
		
	}

}
