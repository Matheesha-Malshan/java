import java.util.*;

class Contacts{
	
	public Scanner input=new Scanner(System.in);
	
	public int[] contactIdArray=new int[5];
	public String[] nameArray=new String[5];
	public String[] phoneNumberArray=new String[5];        
	public String[] companyNameArray=new String[5];
	public double[] salaryArray=new double[5];
	public String[] birthDayArray=new String[5];            
	
	public void table(int[] idA,String[] nameA,String[] phoneN,String[] companyN,double[] salaryA,
				String[] birthDayA){
		
		int u=0;
		
		
		String s="-|------------------------------------------------------------------------|-\n"+
			  "| Contact Id |    Name    | phone Number| company | salary|  Birthday   |\n";
		
		String ta=s;        
	         
		while(companyNameArray[u]!=null){
			
			String n=String.format(
			"--------------------------------------------------------------------------\n"+
		        "|%10d |%-12s|%-13s|%-9s|%8.2f|%-13s|\n",
			 idA[u],nameA[u],phoneN[u],companyN[u],salaryA[u],birthDayA[u]);
			 
			 ta+=n;
			 
			 u++;
		} 
		System.out.println(ta);
	
	}
	
	public void orderFind(String[] array){
	
		int[] idA=contactIdArray;
		String[] nameA=nameArray;
		String[] phoneN=phoneNumberArray;        
		String[] companyN=companyNameArray;
		double[] salaryA=salaryArray;
		String[] birthDayA=birthDayArray; 
		
		           
		String temp;
		double sal;
		int co;
		int len=0;
		
		for(int y=0;y<array.length;y++){
			
			if(array[y]!=null){
				len+=1;
			}
		}
		
		
		for(int i=0;i<len;i++){
		
			for(int j=i;j<len;j++){
				
				for(int t=0;t<3;t++){
				
					int d=(int)array[i].charAt(t); 
					
					int c=(int)array[j].charAt(t); 
					
					if(d>c){
					
						temp=nameA[j];
						nameA[j]=nameA[i];
						nameA[i]=temp;
					
						temp=phoneN[j];
						phoneN[j]=phoneN[i];
						phoneN[i]=temp;
						
						temp=companyN[j];
						companyN[j]=companyN[i];
						companyN[i]=temp;
						
						sal=salaryA[j];
						salaryA[j]=salaryA[i];
						salaryA[i]=sal;
						
						temp=birthDayA[j];
						birthDayA[j]=birthDayA[i];
						birthDayA[i]=temp;
						
						co=idA[j];
						idA[j]=idA[i];
						idA[i]=co;
						t=3;
						
					}
					
				}
	
			}
		
		}
		System.out.println(Arrays.toString(nameA));
		System.out.println(Arrays.toString(phoneN));
		System.out.println(Arrays.toString(companyN));
		System.out.println(Arrays.toString(salaryA));
		System.out.println(Arrays.toString(birthDayA));
		System.out.println(Arrays.toString(idA));
		
		table(idA,nameA,phoneN,companyN,salaryA,birthDayA);
	}

	public void list(){

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
				
				 orderFind(companyNameArray);
				
				 
				
			}
			else if (op ==2){
				//op
			}
			System.out.print("do you want to continue");
			opt=input.nextLine();
		}while(opt=="yes");
		
	
	}
	
	public void delete(){
			
		boolean index=true;
		boolean find=false;
		int j=0;
		String spNumber="";
		int option;
		String newName;
		String newPhone;
		String newCompany;
		double newSalary;
		String run;
		
		do{

			do{	
				System.out.print("search contact by name or phone number");
				input.nextLine();
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
					for(;j<phoneNumberArray.length;j++){
						if(spNumber.equals(phoneNumberArray[j])){
							find=true;
						
							break;
						}
						
					}
					
				}else{	
					
					for(;j<nameArray.length;j++){
						if(nameArray[j]==var){
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
			
			String name=nameArray[j];
			String phoneNumber= phoneNumberArray[j];
			String companyName=companyNameArray[j];
			double salary=salaryArray[j];
			String birthDay=birthDayArray[j];
			int cId=contactIdArray[j];
			
			System.out.println("contact ID\t :"+cId);
			System.out.println("name\t\t :"+name);
			System.out.println("phone number\t :"+phoneNumber);
			System.out.println("company name\t :"+companyName);
			System.out.println("salary\t\t :"+salary);
			System.out.println("birthDay(YYYY-MM-DD) :"+birthDay);
			
			System.out.print("do you want delete this contact");
			String answer=input.nextLine();
			
			if (answer=="yes"){
			
				if(contactIdArray[j+1]!=0){
					int yu=1;
					for(;yu<contactIdArray.length;yu++){
						if(contactIdArray[yu] == 0){
							break;
						}
					}

					for(int p=0; p <= yu; p++){
					
						contactIdArray[j]=contactIdArray[j+1];
						birthDayArray[j]=birthDayArray[j+1];
						salaryArray[j]=salaryArray[j+1];
						companyNameArray[j]=companyNameArray[j+1];
						phoneNumberArray[j]=phoneNumberArray[j+1];
						nameArray[j]=nameArray[j+1];
	
						j++;
					}
					
				}
			}else{
				contactIdArray[j]=0;
				birthDayArray[j]=null;
				salaryArray[j]=0.0;
				companyNameArray[j]=null;
				phoneNumberArray[j]=null;
				nameArray[j]=null;
			}
			
			System.out.print("do you want delete another contact");
			run=input.nextLine();
		
		}while(run=="yes");	
		
	}
	
	
		
	public void update(){
	
		System.out.print("-|--------------------------------------------|-\n"+
				 " |            update contact                  | \n"+
				 "-|--------------------------------------------|-\n");
		
	
		
		
		
		boolean index=true;
		boolean find=false;
		int j=0;
		String spNumber="";
		int option;
		String newName;
		String newPhone;
		String newCompany;
		double newSalary;
		String run;
		
		do{
			do{	
				System.out.print("search contact by name or phone number");
				input.nextLine();
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
					for(;j<phoneNumberArray.length;j++){
						if(spNumber.equals(phoneNumberArray[j])){
							find=true;
						
							break;
						}
						
					}
					
				}else{	
					
					for(;j<nameArray.length;j++){
						if(nameArray[j]==var){
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
			
			String na=nameArray[j];
			String phoneNumber= phoneNumberArray[j];
			String companyName=companyNameArray[j];
			double salary=salaryArray[j];
			String birthDay=birthDayArray[j];
			int cId=contactIdArray[j];
			
			System.out.println("contact ID\t :"+cId);
			System.out.println("name\t\t :"+na);
			System.out.println("phone number\t :"+phoneNumber);
			System.out.println("company name\t :"+companyName);
			System.out.println("salary\t\t :"+salary);
			System.out.println("birthDay(YYYY-MM-DD) :"+birthDay);
			
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
				nameArray[j]=newName;
				
				
			}else if(option==2){
				System.out.print("update number\n"+
						  "============");
			
				do{	
					System.out.println("Input new phone number");
					newPhone=input.nextLine();
					input.nextLine();
					
				}while (newPhone.charAt(0) !=0 && newPhone.length() !=10);
				
				phoneNumberArray[j]=newPhone;
				
				
			}else if(option==3){
				System.out.print("update company name\n"+
						  "==================");
				System.out.println("Input new company name");
				newCompany=input.nextLine();
				input.nextLine();
				companyNameArray[j]=newCompany;
			
			}else if(option==4){
				System.out.print("update salary\n"+
						  "============");
				do{
					System.out.print("salary\t\t:");
					newSalary=input.nextDouble();
					input.nextLine();
					
				}while(newSalary<0);
				salaryArray[j]=newSalary;
			}
			
		
		
		System.out.println("contact has been saved successfully");
		System.out.print("do you want to update more contacts : ");
		run=input.nextLine();
				
		}while(run=="yes");
		
	}
	
	public void contact(){
		int contact,contactId=0;
		int ui=0;
		
		System.out.print("-|--------------------------------------------|-\n"+
				 " |       Add contact to the list              | \n"+
				 "-|--------------------------------------------|-");
		System.out.println("\n\n");
		
		for(;ui< phoneNumberArray.length;ui++){
			if(phoneNumberArray[ui]!=null){
				contactId=ui+1;
			
			}
		}
		
	

		contactIdArray[contactId]=contactId;
	
		contact=contactId;
		
		System.out.println("C"+contactIdArray[contact]+"\n"+
				   " =================");
		String name;
		String phoneNumber;
		String companyName;
		double salary;
		String birthDay;
		boolean format=true;
		
		System.out.print("Name\t\t:");
		name=input.nextLine();
		nameArray[contact]=name;
		
		
		do{	
			System.out.print("phone number\t:");
			phoneNumber=input.nextLine();
		
		}while (phoneNumber.charAt(0) !=0 && phoneNumber.length() !=10);
		phoneNumberArray[contact]=phoneNumber;
		
		System.out.print("companyName\t:");
		companyName=input.nextLine();
		companyNameArray[contact]=companyName;
		
		do{
			System.out.print("salary\t\t:");
			salary=input.nextDouble();
			input.nextLine();
		}while(salary<0);
		salaryArray[contact]=salary;

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
				birthDayArray[contact]=birthDay;
				format=true;
				return;
			}
			
		}while(!format);
	
	}

}


class Main{

	public static void main(String[] args){
	     
	     Scanner input=new Scanner(System.in);
	     
	     Contacts c1=new Contacts();
	     
	     System.out.println("======================================");
	   
	     int choise;
	     
	     do{
	     	
	     	System.out.println("\t\t[01] add contacts");
	     	System.out.println("\t\t[02] update contacts");
	     	System.out.println("\t\t[03] delete contacts");
	     	System.out.println("\t\t[04] list contacts");
	     
	     	System.out.print("Enter an option to continue -> ");
	     	
	     	choise=input.nextInt();
	     	
	     	if(choise==1){
	     		c1.contact();
	     	
	     	}
	     	else if(choise==2){
	     		c1.update();
	     		
	     	}else if(choise==3){
	     		c1.delete();
	     		
	     	}else if(choise==4){
	     		c1.list();
	     	}
	     	
	     }while(choise!=-1);
	
	}
} 


