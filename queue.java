import java.util.*;


class Queue{

	private int[] queue;
	private int var;
	
	Queue(){
		var=0;
		queue=new int[5];
	}
	
	public void enqueue(int data){
		if(!isFull()){
			queue[var++]=data;
		}
	
	}
	public boolean isEmpty(){
		return  queue.length>0;
	}
	
	public boolean isFull(){
		return  var>=queue.length;
	}
	
	public void printQueue(){
		
		if (isEmpty()){
			System.out.println(Arrays.toString(queue));
		}else{
			System.out.println("empty");
		}
		
	}
	public void deQueue(){
		if(isEmpty()){
			int[] temp=new int[queue.length-1];
			
			for(int i=0;i<queue.length-1;i++){
				temp[i]=queue[i+1];
			}
			queue=temp;
		}
	}
}

class Demo{

	public static void main(String[] args){
		
		Queue q1=new Queue();
		
		q1.enqueue(100);
		q1.enqueue(200);
		q1.enqueue(300);
		q1.enqueue(400);
		q1.enqueue(500);
		q1.printQueue(); 
		
		q1.deQueue();
		q1.deQueue();
		q1.deQueue();
		q1.deQueue();
		
		
		q1.printQueue();
		q1.deQueue();	
	}
}
