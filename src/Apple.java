import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
public class Apple {
	private String color;
 
	public Apple(String color) {
		this.color = color;
	}
	
	public int hashCode(){
		return this.color.hashCode();	
	}
 
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if (!(obj instanceof Apple))
			return false;	
		if (obj == this)
			return true;
		return this.color.equals(((Apple) obj).color);
	}
 
	public static void main(String[] args) {
		Apple a1 = new Apple("green");
		Apple a2 = new Apple("red");
 
		List<Integer> list = new ArrayList<>();
		//hashMap stores apple type and its quantity
		HashMap<Apple, Integer> m = new HashMap<Apple, Integer>();
		m.put(a1, 10);
		m.put(a2, 20);
		System.out.println(m.get(new Apple("green")));
	}
}