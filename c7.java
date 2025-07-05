import java.util.*;


class c7{
	
	
	
	public static int[] contactIdArray=new int[5];
	public static String[] nameArray=new String[5];
	public static String[] phoneNumberArray=new String[5];        
	public static String[] companyNameArray=new String[5];
	public static double[] salaryArray=new double[5];
	public static String[] birthDayArray=new String[5];            
	
	public static Scanner input=new Scanner(System.in);
	 
	public static void main(String[] args){
	     
	     System.out.println("======================================");
	     int uindex=0;
	     int choise;
	     
	     do{
	     	
	     	System.out.println("\t\t[01] add contacts");
	     	System.out.println("\t\t[02] update contacts");
	     	System.out.println("\t\t[03] delete contacts");
	     	System.out.println("\t\t[04] list contacts");
	     
	     	System.out.print("Enter an option to continue -> ");
	     	choise=input.nextInt();
	     	
	     	if(choise==1){
	     		
	     		contact();
	     		
	     	}
	     	else if(choise==2){
	     		update();
	     		
	     	}else if(choise==3){
	     		delete();
	     		
	     	}else if(choise==4){
	     		list();
	     	}
	     	
	     }while(choise!=-1);
	}
	
	public static void table(){
		/*
		int u=0;
		
		String n="--------------------------------------------------------------------------\n"+
			 "|    %d      | %s        |     %s    |  %s      |  %d     |  %d           |",
			 contactIdArray[u],phoneNumberArray[u],companyNameArray[u],salaryArray[u],birthDayArray[u]
			 
		int table_length=3;
		
		String s="-|------------------------------------------------------------------------|-\n"+
			  "| Contact Id |    Name    | phone Number| company | salary |  Birthday   |\n";
		        
	         
		for (int u=0;u<Contact Id.length;u++){
		
			  n=n+"\n"+n;
		
		} 
		*/
		
	}
	public static void makeOrder(int i,int j){
		 
		String temp;
		double sal;
		int co;
		
		temp=phoneNumberArray[j];
		phoneNumberArray[j]=phoneNumberArray[i];
		phoneNumberArray[i]=temp;
		
		temp=companyNameArray[j];
		companyNameArray[j]=companyNameArray[i];
		companyNameArray[i]=temp;
		
		sal=salaryArray[j];
		salaryArray[j]=salaryArray[i];
		salaryArray[i]=sal;
		
		temp=birthDayArray[j];
		birthDayArray[j]=birthDayArray[i];
		birthDayArray[i]=temp;
		
		co=contactIdArray[j];
		contactIdArray[j]=contactIdArray[i];
		contactIdArray[i]=co;
		
	}
	public static void orderFind(String[] array){
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
					
						temp=phoneNumberArray[j];
						phoneNumberArray[j]=phoneNumberArray[i];
						phoneNumberArray[i]=temp;
						
						temp=companyNameArray[j];
						companyNameArray[j]=companyNameArray[i];
						companyNameArray[i]=temp;
						
						sal=salaryArray[j];
						salaryArray[j]=salaryArray[i];
						salaryArray[i]=sal;
						
						temp=birthDayArray[j];
						birthDayArray[j]=birthDayArray[i];
						birthDayArray[i]=temp;
						
						co=contactIdArray[j];
						contactIdArray[j]=contactIdArray[i];
						contactIdArray[i]=co;
						t=3;
						
					}
					
				}
	
			}
		
		}
		System.out.println(Arrays.toString(nameArray));
		System.out.println(Arrays.toString(phoneNumberArray));
		System.out.println(Arrays.toString(companyNameArray));
		System.out.println(Arrays.toString(salaryArray));
		System.out.println(Arrays.toString(birthDayArray));
		System.out.println(Arrays.toString(contactIdArray));
	}

	public static void list(){

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
				System.out.print("called");
				 orderFind(companyNameArray);
				 //table();
			}
			else if (op ==2){
				//op
			}
			System.out.print("do you want to continue");
			opt=input.nextLine();
		}while(opt=="yes");
		
	
	}
	
	public static void delete(){
			
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
				System.out.print("search contact bu name or phone number");
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
			
			System.out.println("do you want delete this contact");
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
			
			System.out.println("do you want delete another contact");
			run=input.nextLine();
		
		}while(run=="yes");	
		
	}
	
	
		
	public static void update(){
	
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
				System.out.print("search contact bu name or phone number");
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
			
			
			if(option==1){
				
				System.out.print("update name\n"+
						 "============");
				System.out.print("Input new name");
				newName=input.nextLine();
				input.nextLine();
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
		
		System.out.println("do you want to update more contacts");
		run=input.nextLine();
				
		}while(run=="yes");
		
	}
	
	public static void contact(){
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
		input.nextLine();
		
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


