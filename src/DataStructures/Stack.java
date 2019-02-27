package DataStructures;

public class Stack<T> {
T array[] ;
int top = -1 ;


@SuppressWarnings("unchecked")
public Stack() {
    array = (T[]) new Object[10] ;
}

public void push(T e) {

    top = top + 1;
    array[top] = e ;
}


public T pop() {
    T topMostElement = array[top] ;
    top = top - 1;
    
    return topMostElement;
}

public T peek(){
    return array[top] ;
}


public void printElements () {
    System.out.println("The elements in the stack are : " );
    for(int i=0 ; i <= top ; i++){
        System.out.println(array[i]);
    }
}
}

