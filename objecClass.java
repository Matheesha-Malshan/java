import java.util.*;


class Teacher{
	
	int id;
	String name;
	
	Student(int id,String name){
		this.id=id;
		this.name=name;
	}
	
	public boolean equals(Object object){
		
		Student s=(Student)object;
		
		if(this.id == s.id){
			return true;
			
		}return false;
 	}
 	
}

class Student{
	int id;
	String name;
	
	Student(int id,String name){
		this.id=id;
		this.name=name;
	}
	
	public boolean equals(Object object){
		
		Student s=(Student)object;
		
		if(this.id == s.id){
			return true;
			
		}return false;
 	}
 	
}
class Demo{
	public static void main(String args[]){
	 
		Student s1=new Student(1,"m");
		Student s2=new Student(2,"m");
		
		System.out.println(s1.equals(s2));
	}
}  
