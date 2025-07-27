import java.util.*;

class Contacts{
	
	public Scanner input=new Scanner(System.in);
	
	int contactId;
	String name;
	String phoneNumber;        
	String companyName;
	double salary;
	String birthDay;            
	
	public void table(Contacts[] c2){
		
		int u=0;
		
		String s="-|------------------------------------------------------------------------|-\n"+
			  "| Contact Id |    Name    | phone Number| company | salary|  Birthday   |\n";
		
		String ta=s;        
	         
		while(c2[u]!=null){
			
			String n=String.format(
			"--------------------------------------------------------------------------\n"+
		        "|%10d |%-12s|%-13s|%-9s|%8.2f|%-13s|\n",
			 c2[u].contactId,c2[u].name,c2[u].phoneNumber,c2[u].companyName,c2[u].salary,c2[u].birthDay);
			 
			 ta+=n;
			 
			 u++;
		} 
		System.out.println(ta);
	
	}
	
	public void orderFind(int r,Contacts[] c1){
	
		Contacts[] c2=c1;
		Contacts temp;
		          
		
		double sal;
		int co;
		int len=r;
		
		System.out.println(c2[r].name);
		System.out.println(len);
		
		for(int i=0;i<len;i++){
		
			for(int j=i;j<len+1;j++){
				
				for(int t=0;t<3;t++){
				
					int d=(int)c1[i].companyName.charAt(t); 
					
					int c=(int)c1[j].companyName.charAt(t); 
					
					if(d>c){
					
						temp=c2[j];
						c2[j]=c2[i];
						c2[i]=temp;
						t=3;
					}
					
				}
	
			}
		
		}
		
		table(c2);
	}

	public void list(int r,Contacts[] c1){

		String opt;
		System.out.print("-|--------------------------------------------|-\n"+
				 " |           Sort   contact                   | \n"+
				 "-|--------------------------------------------|-\n");
				 
		do{
			System.out.println("[01] sorting by Company Name");
			
			System.out.println("[02] sorting by Name");
			
			System.out.println("[03] sorting by Birth day");
			
			System.out.print(" enter an option to continue");
			int op=input.nextInt();
			
			if (op==1){
				
				 orderFind(r,c1);
			
			}
			else if (op ==2){
				//op
			}
			System.out.print("do you want to continue");
			opt=input.nextLine();
		}while(opt=="yes");
		
	
	}
	
	public void delete(int r,Contacts[] c1){
			
		boolean index=true;
		boolean find=false;
		int j=r;
		String spNumber="";
		int option;
		String newName;
		String newPhone;
		String newCompany;
		double newSalary;
		String run;
		Contacts temp;
		
		do{

			do{	
				System.out.print("search contact by name or phone number");
				String var=input.nextLine();	
				
				try{	
					
					long pNumber=Long.parseLong(var);
					
					String PhoneNumber=Long.toString(pNumber);
					
					spNumber=PhoneNumber;
					
					index=true;
					
				}catch(NumberFormatException e){
					
					index=false;
				}
				
	
				
				if (index){
					spNumber="0"+spNumber;
					for(int time=0;time<=j;j--){
						if(spNumber.equals(c1[j].phoneNumber)){
							find=true;
							break;
						}
					}
						
	
		
				}else{	
					
					for(int time=0;time<=j;j--){
						if(name.equals(c1[j].name)){
							find=true;
							break;
						}
					}
				}
				
				if(!find){
					System.out.println("contact is not found");
					j=0;
				}
				
				
			}while(!find);
			System.out.println("contact is found");
			System.out.print("\n\n");
			
			System.out.println("contact ID\t :"+c1[j].contactId);
			System.out.println("name\t\t :"+c1[j].name);
			System.out.println("phone number\t :"+c1[j].phoneNumber);
			System.out.println("company name\t :"+c1[j].companyName);
			System.out.println("salary\t\t :"+c1[j].salary);
			System.out.println("birthDay(YYYY-MM-DD) :"+c1[j].birthDay);
			
			System.out.print("do you want delete this contact : ");
			String answer=input.nextLine();
			
			if (answer.equals("yes")){
				
				if(c1[j+1]!=null){
					
					while(c1[j]!=null){
					
						temp=c1[j];
						c1[j]=c1[j+1];
						c1[j]=temp;
						
						j++;
					}
					
				}else{
					System.out.print("do");
					c1[j]=null;
			       }
				
			}
			
			System.out.print("do you want delete another contact");
			run=input.nextLine();
		
		}while(run=="yes");	
		
	}
	

		
	public void update(int r,Contacts[] c1){
	
		System.out.print("-|--------------------------------------------|-\n"+
				 " |            update contact                  | \n"+
				 "-|--------------------------------------------|-\n");
		
		
		boolean index=true;
		boolean find=false;
		int j=r;
		String spNumber="";
		int option;
		String newName;
		String newPhone;
		String newCompany;
		double newSalary;
		String run;
		
		do{
			do{	
				System.out.print("search contact by name or phone number : ");
				String var=input.nextLine();	
				
				try{	
					
					
					long pNumber=Long.parseLong(var);
					
					String PhoneNumber=Long.toString(pNumber);
					
					spNumber=PhoneNumber;
					
					index=true;
					
				}catch(NumberFormatException e){
					
					index=false;
				}
				
				
				if (index){
					spNumber="0"+spNumber;
					
					for(int time=0;time<=j;j--){
					
						
						if(spNumber.equals(c1[j].phoneNumber)){  
							find=true;
							break;
						}
						
					}
					
				}else{	
					j=r;
					for(int time=0;time<=j;j--){
						if(this.phoneNumber==var){
							find=true;
							break;
						}
					}
				}
				System.out.println(find);
				
				if(!find){
					System.out.println("contact is not found");
					j=0;
				}
				
				
			}while(!find);
			System.out.println("contact is found");
			System.out.print("\n\n");
	
			
			System.out.println("contact ID\t :"+c1[j].contactId);
			System.out.println("name\t\t :"+c1[j].name);
			System.out.println("phone number\t :"+c1[j].phoneNumber);
			System.out.println("company name\t :"+c1[j].companyName);
			System.out.println("salary\t\t :"+c1[j].salary);
			System.out.println("birthDay(YYYY-MM-DD) :"+c1[j].birthDay);
			
			System.out.println("what do you want to update...");
			
			
			System.out.println("\t\t[01]name");
			System.out.println("\t\t[02]phone number");
			System.out.println("\t\t[03]company name");
			System.out.println("\t\t[04]salary");
			System.out.print("\n\n");
			System.out.print("Enter an option to continue");
			option=input.nextInt();
			input.nextLine();
			
			if(option==1){
				
				System.out.print("update name\n"+
						 "============");
				System.out.print("Input new name");
				newName=input.nextLine();
				c1[j].name=newName;
	
			}else if(option==2){
				System.out.print("update number\n"+
						  "============");
			
				do{	
					System.out.println("Input new phone number");
					newPhone=input.nextLine();
					input.nextLine();
					
				}while (newPhone.charAt(0) !=0 && newPhone.length() !=10);
				
				c1[j].phoneNumber=newPhone;
				
				
			}else if(option==3){
				System.out.print("update company name\n"+
						  "==================");
				System.out.println("Input new company name");
				newCompany=input.nextLine();
				input.nextLine();
				c1[j].companyName=newCompany;
			
			}else if(option==4){
				System.out.print("update salary\n"+
						  "============");
				do{
					System.out.print("salary\t\t:");
					newSalary=input.nextDouble();
					input.nextLine();
					
				}while(newSalary<0);
				c1[j].salary=newSalary;
			}
			
		
		
		System.out.println("contact has been saved successfully");
		System.out.print("do you want to update more contacts : ");
		run=input.nextLine();
				
		}while(run=="yes");
		
		
	}
		
	
	public void contact(int r){
	
		
		
		System.out.print("-|--------------------------------------------|-\n"+
				 " |       Add contact to the list              | \n"+
				 "-|--------------------------------------------|-");
		System.out.println("\n\n");
		
		contactId=r;
	
		System.out.println("C"+contactId+"\n"+
				   " =================");
		
		
		System.out.print("Name\t\t:");
		name=input.nextLine();
		
		boolean format=true;
		
		do{	
			System.out.print("phone number\t:");
			phoneNumber=input.nextLine();
		
		}while (phoneNumber.charAt(0) !=0 && phoneNumber.length() !=10);
		
		
		System.out.print("companyName\t:");
		companyName=input.nextLine();
		
		
		do{
			System.out.print("salary\t\t:");
			salary=input.nextDouble();
			input.nextLine();
		}while(salary<0);
		
		do{
			System.out.print("birthDay\t:");
			birthDay=input.nextLine();
			
			String year="";
			String month="";
			String date="";
			
			int count=0;
			
			String[] ymd=birthDay.split("-");
			for(String y:ymd){
				year+=y;
				count++;
				format=true;
				
				if (count==1){
					int ye=Integer.parseInt(year);
					if (ye>2005){
						format=false;
						break;
					}
				}if(count==2){
					month+=y;
					
					int m=Integer.parseInt(month);
					if(m>12){
						format=false;
						break;
					}
					
				}if(count==3){
					date+=y;
					
					int d=Integer.parseInt(date);
					if(d>31){
						format=false;
						break;
					}
		
				}
			
			}
			if(!format || year.length()<6){
				System.out.println("Ivalid birhtday");
				format=false;
			}else{
				System.out.println("contact has been update succesfully....");
				
				format=true;
				return;
			}
			
		}while(!format);
	
	}

}


class Main{

	public static void main(String[] args){
	     
	     Scanner input=new Scanner(System.in);
	     
	     Contacts[] c1=new Contacts[5];
	     
	     System.out.println("======================================");
	   
	     int choise;
	     int r=0;
	     
	     do{
	     	
	     	System.out.println("\t\t[01] add contacts");
	     	System.out.println("\t\t[02] update contacts");
	     	System.out.println("\t\t[03] delete contacts");
	     	System.out.println("\t\t[04] list contacts");
	     
	     	System.out.print("Enter an option to continue -> ");
	     	
	     	choise=input.nextInt();
	     	
	     	
	     	
	     	if(choise==1){
	     		c1[r]=new Contacts(); 
	     		c1[r].contact(r);
	     		r++;
	     	}
	     	else if(choise==2){
	     		int temp=r;
	     		temp-=1;
	     		c1[temp].update(temp,c1);
	     		
	     		
	     	}else if(choise==3){
	     		int temp=r; 
	     		temp-=1;
	     		c1[temp].delete(temp,c1);
	     		
	     	}else if(choise==4){
	     		int temp=r; 
	     		temp-=1;
	     		c1[temp].list(temp,c1);
	     	}
	     	
	     	
	     }while(choise!=-1);
	
	}
} 


