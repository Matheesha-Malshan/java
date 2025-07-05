import java.util.*;

class c8{
	public static void main(String[] args){
	
		String[] array={"Eshan","Acal","Dmal","Abal","Cyman","Bimal"};
		
		double[] money={2500,2300,5600,7800,8500,9600};
		
	
		for(int i=0;i<array.length;i++){
		
			for(int j=i;j<array.length;j++){
				
				for(int t=0;t<3;t++){
				
					int d=(int)array[i].charAt(t); 
					
					int c=(int)array[j].charAt(t); 
					
					if(d>c){
					
						String temp=array[j];
						array[j]=array[i];
						array[i]=temp;
						
						
						double tem=money[j];
						money[j]=money[i];
						money[i]=tem;
						
						t=3;
						
					}
					
				}
	
			}
			
	
		}
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(money));
	}


}
