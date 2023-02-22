package newPackage;

public class MyHashTable {
	
	Entry[] buckets = new Entry[32]; 
	
	public void put(Object key,Object value) {
		int index = key.hashCode() % 32 ;
		Entry entry = buckets[index];
		
		if (entry == null) {
		    // first time. the bucket is empty
			synchronized
			{
				if(entry == null)
			Entry newEntry = new Entry(key,value);
			buckets[index] = newEntry;
			}
		}
		else { 
			Entry temp = entry ;
			while(temp.next != null) {
				if(temp.key.equals(key)) {
					temp.value = value ;  // existing key
					return;
				}
				
				temp = temp.next;
			}
			Entry newEntry = new Entry(key,value);
			temp.next = newEntry;  // new key
		}
		
	}
	
	
	public Object get(Object key) {
		if(key == null)
			return null;
		int index = key.hashCode() % 32;
		Entry entry = buckets[index];
		if(entry == null)
			return null;
		
		Entry temp = entry ;
		while(temp != null) {
			if(temp.key.equals(key)) {
				return temp.value;
			}
			temp = temp.next;
		}
		
		return null;
	}
	
	
	

}
