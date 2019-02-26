
public class PrintArray {

    
    public static void print(int a[],int index) {
        
        System.out.println(a[index]);
    
    if(index-1 >=0 ) {
        print(a,index-1) ;
    }
        
    }
    
 public static void main(String args[]) {
    int a[]={-9,93,1,2,8,4,45};
    print(a,a.length-1) ;
}

}
