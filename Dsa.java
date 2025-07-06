import java.util.*;


class Stack{

	int current;
	int[] array;
	
	Stack(){
		
		array= new int[5];
		current=0;
	
	}
	
	public void push(int val){
		array[current++]=val;
		
		
	}
	public void pop(){
		current--;
		
	}
	public void clear(){
		
		current=0;		
	}
	
	public int size(){
		
		return current;
		
	}
	public void printStack(){
	
		System.out.print("[");
		
		for(int i=current-1;i>=0;i--){
			System.out.print(array[i]+",");
		}
		System.out.print("\b"+"]");
		
		System.out.println(current==0?"\bempty" :"");
	}
	
}

class dsa{
	
	public static void main(String[] args){
		
		Stack s1=new Stack();
		System.out.println("size is :" +s1.size());
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
		s1.push(50);
		s1.printStack();
		System.out.println("size is :" +s1.size());
		
		s1.pop();
		s1.printStack();
		System.out.println("size is :" +s1.size());
		
		s1.clear();
		System.out.println("size is :" +s1.size());
		s1.printStack();
	}
}
