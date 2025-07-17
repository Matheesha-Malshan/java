import java.util.*;

class Item{

	private String itemCode;
	private double unitPrice;
	
	Item(String itemCode,double unitPrice){
		
		this.itemCode=itemCode;
		this.unitPrice=unitPrice;
	}
	public String toString(){
		return itemCode+" "+unitPrice;
	}
}
class Customer{
	
	private int code;
	private String name; 
	
	Customer(int code,String name){
		this.code=code;
		this.name=name;
	}
	public String toString(){
		return code+" "+ name;
	}
	public boolean equals(Object o1){
	 
		Customer c1=(Customer)o1;
		return this.code==c1.code;
	}
	
}
class Stack<T>{
	  
	private Node top;
	
	public void push(T obj){
	  	 
		Node n1= new Node(obj);
		n1.next=top;
		top=n1;
	}
	 
	public T pop(){
		
		if(top!=null){
			T obj=top.obj;
			top=top.next;
			return obj;
		}
		return null;
	}
	
	
	
	public int search(T obj){
		
		Node temp=top;
		int index=0;
		
	 	while(temp != null){
  		  if(obj.equals(temp.obj)){
		  	return index;
		  }
		  index++;
		  temp=temp.next;
		}
		return -1;
	}
	public String toString(){
	
		Node temp=top;
		String row_data="[";
		
		while(temp!=null){
			
			row_data+=temp.obj;
			temp=temp.next;
		}
		return top==null? "empy":row_data+"]";
  		
	 }
	
	class Node{
	
		private T obj;
		private Node next;
		Node(T obj){
			this.obj=obj;
		}
	  
	}

}
class Demo{
	public static void main(String args[]){
	  
		Stack<Customer> customerStack= new Stack<>();
		
		customerStack.push(new Customer(1001,"Danapala"));
		customerStack.push(new Customer(1002,"Gunapala"));
		customerStack.push(new Customer(1003,"Somapala"));
		customerStack.push(new Customer(1004,"Siripala"));
		
		Stack<Item> itemStack=new Stack<>();
		
		itemStack.push(new Item("1001",45));
		itemStack.push(new Item("1002",55));
		itemStack.push(new Item("1003",85));
		itemStack.push(new Item("1004",75));
		
		customerStack.search(new Customer(1003,"Somapala"));
		
	}
}     
 
