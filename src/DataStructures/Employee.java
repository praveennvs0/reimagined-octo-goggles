package DataStructures;

import java.util.Date;
import java.util.List;

public final class Employee {
	
	private String id;
	private Date date;
	private List<String> roles ;
	
	public String getId() {
		return id;
	}

	
	
	
	
	public Date getDate() {
		return date;
	}

	
	public List<String> getRoles() {
		return roles;
	}


	public Employee(String id, Date date, List<String> roles) {
		this.id = id;
		this.date = date;
		this.roles = roles;
		
		
		it.remove();
	}
	
	
	
	// employee.getRoles().add("one role");
	
	
	
	
	
	
	
	


}
