import java.util.*;

class Stack{
	
	 private Node top; 
	 Node n1;
	        
	 
	 public void push(int d){
	 	Node n1=new Node(d);  
		n1.next=top;
	 	top=n1; 
	 	
	 }
	 public void printStack(){
	  	
	  	Node temp=top;
	  	int c=0;
	 	while(temp!=null){
	 		System.out.println(temp.data);
	 		temp=temp.next;
	 		c++;
	 	}
	 	if (c==0){
	 		System.out.println("empty");
	 	}
	 	
	 }
	 public void pop(){
	 	
	 	top=top.next;
	 }
	 public int size(){
	 	Node temp=top;
	 	int c=0;
	 	while(temp!=null){
	 		temp=temp.next;
	 		c++;
	 	}
	 	return c;
	 }
	 public void clear(){
	 	top=null; 
	 }
      	 public int peek(){
      	 	return top.data;
      	 
      	 }
      	 
      	 public int poll(){
      	 	Node temp=top;
	 	
		if(top!=null){
			top=top.next;
			return temp.data;
		}else{
			return -1;
		}
		
      	 }
      	 public int search(int searchdata){
      	 	int count=0;
      	 	Node temp=top;
      	 	while(temp!=null){
      	 		if(temp.data==searchdata){
      	 			return count;	
      	 		}
      	 		temp=temp.next;
      	 		count++;
      	 	}return -1;
      	 
      	 }public int[] toArray(){
      	 	int[] array=new int[size()];
      	 	Node temp=top;
      	 	
      	 	for(int i=0;i<array.length;i++){
      	 		array[i]=temp.data;
      	 		temp=temp.next;
      	 	}
      	 	return array;
      	 }
      	 

	class Node{
		   
		private int data;
		private Node next ;
		
		Node(int data){
			
			this.data=data;
		}
	}
}

class Demo{
	public static void main(String[] args){
		
		Stack s1=new Stack();
		s1.printStack();
		System.out.println("size of the stack is :" + s1.size());
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
		s1.push(50);
		System.out.println("size of the stack is :" + s1.size());
		s1.pop();
		System.out.println("size of the stack is :" + s1.size());
		s1.printStack();   
		
		int topData=s1.peek();
		System.out.println("Top data is :" + topData); 
		System.out.println("after calling peek()");
		s1.printStack();
		
		int index=s1.search(20);
		System.out.println("index 20 is"+ index); 
		
		index=s1.search(80);
		System.out.println("index 80 is"+ index);
		
		int[] ar=s1.toArray();
		System.out.println(Arrays.toString(ar));
		
		topData=s1.poll();
		System.out.println("Top data is :" + topData); 
		System.out.println("after calling poll()");
		s1.printStack();
		s1.clear();
		System.out.println("size of the stack is :" + s1.size()); 
	}
}

