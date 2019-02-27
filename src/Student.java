
public class Student {

    private int id;
    private String name ;
    
    public Student(int id,String name) {
        this.setId(id);
        this.setName(name) ;
    }
    
    public Student clone() {
        try {
            return (Student) super.clone() ;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return this ;
            
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString() {
        return id + name ; 
    
    }
}
