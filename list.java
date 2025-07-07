class List{
	private int[] array;
	private int nextIndex;
	
	List(int capacity){
		nextIndex=0;
		array=new int[capacity];
	}
	public void add(int data){
		
		array[nextIndex++]=data;
	}

	public void add(int index,int data){
		if(index>=0 && index<=nextIndex){
			
			int[] tempArray=new int[nextIndex+1];
			int temp=array[index-1];
			
			tempArray[index-1]=data;
			
			for(int i=0;i<nextIndex+1;i++){
				
				if(i<index-1){
					tempArray[i]=array[i];
					
				}else if(i>=index){
					
					tempArray[i]=temp;
					temp=array[i];
					
				}
			}array=tempArray;
		}else{
			System.out.println("index out of range");
		}
	}
	public void printList(){
		System.out.print("[");
		for(int i=0;i<array.length;i++){
			if(array[i]!=0){
				System.out.print(array[i]+",");
			}
			
		}System.out.print("\b]\n");
	}
}

class Demo{

	public static void main(String[] args){
		
		List list=new List(10);
		
		list.add(10);
		
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		list.add(1,22);
		
		list.printList();
		
	}
}
