
public class ClosestNumberLeetcode {
	
	public static void main(String[] args) {
		int[] arr = {1,3,4,15,16};
		int left=0,right=arr.length-1,mid;
		int target = 2;
		while(left < right) {
			mid = (left + right) / 2;
			if(target == arr[mid]) {
				System.out.println("target found");
			}
			else if(target < arr[mid]) {
				right = mid;
			}
			else {
				left = mid+1;
			}
		}
		}
	}

