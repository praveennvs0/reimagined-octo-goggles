package DataStructures;

public class MinimumJump {

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} ;
		int num = minimumNoOfSteps(arr);
		System.out.println("minimum number of steps is : " + num);
		
	}

	private static int minimumNoOfSteps(int[] arr) {
		int num = minimumNoOfSteps(arr,0,0,arr.length-1,arr.length);
		return num;
	}

	private static int minimumNoOfSteps(int[] arr, int currStep, int stepCount, int target,int min) {
		if(currStep == target) {
			System.out.println("target reached in " + stepCount + " steps");
			return stepCount;
		}
		if(currStep > target)
			return stepCount;
		for(int i=1;i<= arr[currStep] && i < arr.length-1 ; i++) {
			   int k =  minimumNoOfSteps(arr,currStep+i,stepCount+1,target,min);
			   min = Math.min(min, k);
		}
		return min ;
	}

}
