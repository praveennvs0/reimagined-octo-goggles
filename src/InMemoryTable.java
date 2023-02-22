import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTable {

	String name ;
	Map<String,Record> map = new HashMap<String,Record>() ;
	
	public void insertRecord(Record record) {
		
		
		
		map.put(record.id,record);
	}
	
	
	public Record fetchRecord(String id) {
		return map.get(id);
	}
	
}
