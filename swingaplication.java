import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;


class Contacts{
		int contactId;
		String name;
		String phoneNumber;        
		String companyName;
		double salary;
		String birthDay;
		
		String[] fieldnames={"name","phoneNumber","companyName","salary"};
		
		Contacts(int cid,String pname,String pphone,String pcname,Double psalary,String pbirthday){
			this.contactId=cid;
			this.name=pname;
			this.phoneNumber=pphone;        
			this.companyName=pcname;
			this.salary=psalary;
			this.birthDay=pbirthday;
		}
	public static void contact(int r){
	
	}
	
	public void update(int r,Contacts[] c1){}
	
	public void delete(int r,Contacts[] c1){}
	
	public void list(int r,Contacts[] c1){}
}
class Validation{
	
	Validation(){}
	
	Validation(String phoneNumber){
		checkPhone(phoneNumber);
	}
	Validation(Double salary){
		checkSalary(salary);
	}
	
	public boolean checkPhone(String phoneNumber){
		if(phoneNumber.charAt(0) !=0 && phoneNumber.length() !=10){
			return false;
		}
		return true;
	}
	public boolean checkSalary(double salary){
		if(salary<0){
			return false;
		}
		return true;
	}
	public boolean birthday(String birthDay){
		String year="";
		String month="";
		String date="";
		boolean format=true;
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
			return false;
		}
		return true;
	
	}

}

class ViewContacts extends JFrame{
	
	JLabel label;
	JButton addCustomer;
	JPanel panel;
	
	JTextField tid;
	JTextField tname;
	JTextField tmoney;
	JTextField taddress;
	JPanel tpanel;
	
	JButton addButton;
	
	ViewContacts(int[] r,Contacts[] c1){
		
		setSize(500,300);
		setTitle("I Contact");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		
		label=new JLabel("add customer form");
		label.setFont(new Font("",1,20));
		label.setHorizontalAlignment(JLabel.CENTER);
		add("North",label);
		
		panel=new JPanel(new GridLayout(5,1));
		
		JLabel name=new JLabel("name");
		name.setFont(new Font("",1,20));
		panel.add(name);
		
		JLabel phoneNumber=new JLabel("phone number");
		phoneNumber.setFont(new Font("",1,20));
		panel.add(phoneNumber);
		
		
		JLabel cname=new JLabel("company name");
		cname.setFont(new Font("",1,20));
		panel.add(cname);
		
		JLabel salary=new JLabel("salary");
		salary.setFont(new Font("",1,20));
		panel.add(salary);
		
		JLabel birthday=new JLabel("birthday");
		birthday.setFont(new Font("",1,20));
		panel.add(birthday);
		
		add("West",panel);
		
		tpanel=new JPanel(new GridLayout(5,1));
		
		
		JTextField tname=new JTextField(10);
		tname.setFont(new Font("",1,20));
		JPanel namepanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		namepanel.add(tname);
		tpanel.add(namepanel);
		
		JTextField tphone=new JTextField(11);
		tphone.setFont(new Font("",1,20));
		JPanel tphonepanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		tphonepanel.add(tphone);
		tpanel.add(tphonepanel);
		
		JTextField tcname=new JTextField(10);
		tcname.setFont(new Font("",1,20));
		JPanel tcnamepanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		tcnamepanel.add(tcname);
		tpanel.add(tcnamepanel);
		
		
		JTextField tsalary=new JTextField(6);
		tsalary.setFont(new Font("",1,20));
		JPanel tsalarypanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		tsalarypanel.add(tsalary);
		tpanel.add(tsalarypanel);
		
		JTextField tbirthday=new JTextField(12);
		tbirthday.setFont(new Font("",1,20));
		JPanel tbirthdaypanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		tbirthdaypanel.add(tbirthday);
		tpanel.add(tbirthdaypanel);
		
		add("Center",tpanel);
		
		JPanel btnpanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		addButton=new JButton("Add customer");
		btnpanel.add(addButton);
		
		add("South",btnpanel);
		
		addButton.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent evt){
				
				String pname=tname.getText();
				String pphone=tphone.getText();
				String pcname=tcname.getText();
				double psalary=Double.parseDouble(tsalary.getText());
				String pbirthday=tbirthday.getText();
				
				Validation v=new Validation();
				
				if(v.checkPhone(pphone)==true && v.checkSalary(psalary)==true && v.birthday(pbirthday)==true){
					c1[r[0]]=new Contacts(r[0],pname,pphone,pcname,psalary,pbirthday);
					System.out.println(Arrays.toString(c1));
					r[0]++;
					
				}
				else{
					 JOptionPane.showMessageDialog(null, "invalid information is addedd.");
					 
				}	
				
			}
		
		});
	}
}
class FindObject{
	
	String spNumber;
	int j;
	
	FindObject(){}
	
	FindObject(String spNumber,Contacts[] c1,int r){
	
		obj(spNumber,c1,r);
	}
	
	public int obj(String spNumber,Contacts[] c1,int r){
		
		boolean index=true;
		j=r;
		boolean find=false;
		
		if (index){
			
			for(int time=0;time<=j;j--){
			
				if(spNumber.equals(c1[j].phoneNumber)){  
					find=true;
					break;
				}
				
			}
			
			if(find){
				return j;
				
			}return -1;
			
		}return -2;
	}
}
class Delobject extends JFrame{
	
	Delobject(int[] r,Contacts[] c1){
	
		setSize(300,300);
		setTitle("I Contact");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel delPanel=new JPanel(new GridLayout(3,1));
		
		JLabel dellabel=new JLabel("search contact");
		dellabel.setFont(new Font("",1,20));
		delPanel.add(dellabel);
		
		
		JTextField deltext=new JTextField(12);
		deltext.setFont(new Font("",1,20));
		JPanel delpanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		delPanel.add(deltext);
		
		JButton delsubmit=new JButton("submit");
		delsubmit.setFont(new Font("",1,20));
		
		
		delsubmit.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent evt){
				FindObject fb=new FindObject();
				
				int indexOf=fb.obj(deltext.getText(),c1,r[0]-1);
				int j=indexOf;
				Contacts temp;
				
				if(c1[j+1]!=null){
					
					while(c1[j+1]!=null){
					
						c1[j]=c1[j+1];
						j++;
					}
					
				}else{
					c1[j]=null;
			       }
			}
		
		});
		
		delPanel.add(delsubmit);
		add(delPanel);
	}
	

}


class addUpdateContact extends JFrame{
	
	static String datas;
	
	addUpdateContact(int[] tempp,String fieldNum,Contacts[] c1){
	
		setSize(600,300);
		setTitle("I Contact");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel dataPanel=new JPanel(new GridLayout(1,3));
		
		int field=Integer.parseInt(fieldNum);
		
		JLabel laname=new JLabel(c1[tempp[0]].fieldnames[field-1]);
		laname.setFont(new Font("",1,20));
		dataPanel.add(laname);
		
		JTextField intext=new JTextField(12);
		intext.setFont(new Font("",1,20));
		JPanel ipanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		ipanel.add(intext);
		dataPanel.add(ipanel);
		
		JButton subButton=new JButton("submit");
		subButton.setFont(new Font("",1,20));
		
		
		
		subButton.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent evt){
				
				if(field==1){c1[tempp[0]].name=intext.getText();}
				if(field==2){c1[tempp[0]].phoneNumber=intext.getText();}
				if(field==3){c1[tempp[0]].companyName=intext.getText();}
				if(field==4){c1[tempp[0]].salary=Double.parseDouble(intext.getText());}	
				
				
			}
		
		});
		dataPanel.add(subButton);
		
		add(dataPanel);
		
	}
	
}
class UpdateContacts extends JFrame{

	UpdateContacts(int[] r,Contacts[] c1){
		setSize(800,500);
		setTitle("I Contact");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		
		JPanel rightPanel=new JPanel(new GridLayout(6,1));
		
		JLabel search=new JLabel("search contact");
		search.setFont(new Font("",1,20));
		rightPanel.add(search);
		
		
		
		
		JLabel lname=new JLabel("1] name");
		lname.setFont(new Font("",1,20));
		rightPanel.add(lname);
		
		JLabel lphone=new JLabel("2] phonenumber");
		lphone.setFont(new Font("",1,20));
		rightPanel.add(lphone);
		
		JLabel lcname=new JLabel("3] cname");
		lcname.setFont(new Font("",1,20));
		rightPanel.add(lcname);
		
		JLabel lsalary=new JLabel("4] salary");
		lsalary.setFont(new Font("",1,20));
		rightPanel.add(lsalary);
		
		
		JLabel coption=new JLabel("continue option");
		coption.setFont(new Font("",1,20));
		rightPanel.add(coption);
		
		add("West",rightPanel);
		
		JPanel middlePanel=new JPanel(new GridLayout(8,1));
		
		JTextField toption=new JTextField(12);
		toption.setFont(new Font("",1,20));
		JPanel toptionpanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		toptionpanel.add(toption);
		middlePanel.add(toptionpanel);
		
		add("Center",middlePanel);
		
		JPanel rrightPanel=new JPanel(new GridLayout(8,1));
		
		JButton asubmit=new JButton("submit");
		asubmit.setFont(new Font("",1,20));
		int[] tempp={0};
		
		asubmit.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent evt){
				
				String op=toption.getText();
				
				FindObject f=new FindObject();
				int i=f.obj(op,c1,r[0]-1);
				
				JOptionPane.showMessageDialog(null, "Contact id:"+c1[i].contactId+"\n"+"name:"+c1[i].name+"\n"+
				"phone:"+c1[i].phoneNumber+"\n"+"company name:"+c1[i].companyName+"\n"+
				"salary:"+c1[i].salary+"\n"+"birthDay:"+c1[i].birthDay);
				System.out.println(c1[i].contactId);
				
				tempp[0]=i;
		
			}
		
		});

		JTextField tcon=new JTextField(5);
		tcon.setFont(new Font("",1,20));
		JPanel toptionpane=new JPanel(new FlowLayout(FlowLayout.CENTER));
		toptionpane.add("South",tcon);
		middlePanel.add(toptionpane);
		
		add(middlePanel);
		
		rrightPanel.add("North",asubmit);
		add("East",rrightPanel);
		
		JButton csubmit=new JButton("submit");
		csubmit.setFont(new Font("",1,20));
		
	
		
		csubmit.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent evt){
				
				new addUpdateContact(tempp,tcon.getText(),c1).setVisible(true);
				
			}
		
		});
		
		rrightPanel.add("South",csubmit);
		add("East",rrightPanel);
		
	}

}
class ListbjectorderFind{
	
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
	}


class Listbject extends JFrame{

	Listbject(int[] r,Contacts[] c1){
		
		setSize(300,300);
		setTitle("I Contact");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel buttonPanel=new JPanel(new GridLayout(2,1));
		
		JButton companyButton=new JButton("sort by company name");
		companyButton.setFont(new Font("",1,20));
		
		companyButton.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent evt){
				ListbjectorderFind orf=new ListbjectorderFind();
				orf.orderFind(r[0]-1,c1);
				
			}
		
		});
		buttonPanel.add(companyButton);
		
		JButton nameButton=new JButton("sort by name");
		nameButton.setFont(new Font("",1,20));
		buttonPanel.add(nameButton);
		
		add(buttonPanel);
	}

}
class Form extends JFrame{
	
	Scanner input=new Scanner(System.in);
	Contacts[] c1=new Contacts[5];
	int choise;
	int[] r={0};
	
	Form(){
		setSize(300,300);
		setTitle("I Contact");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel buttonPanel=new JPanel(new GridLayout(4,1));
		
		JButton addButton=new JButton("Add customer");
		addButton.setFont(new Font("",1,20));
		
		addButton.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent evt){
				new ViewContacts(r,c1).setVisible(true);
				
			}
		
		});
		
		
		buttonPanel.add(addButton);
		
		
		JButton updateButton=new JButton("update customer");
		updateButton.setFont(new Font("",1,20));
		
		updateButton.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent evt){
				new UpdateContacts(r,c1).setVisible(true);
				
			}
		
		});
		
		
		buttonPanel.add(updateButton);
		
	
		JButton deleteButton=new JButton("delete customer");
		deleteButton.setFont(new Font("",1,20));
		
		deleteButton.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent evt){
				new Delobject(r,c1).setVisible(true);
				
			}
		
		});
		
		buttonPanel.add(deleteButton);
		
		
		JButton listButton=new JButton("list customer");
		listButton.setFont(new Font("",1,20));
		
		listButton.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent evt){
				new Listbject(r,c1).setVisible(true);
				
			}
		
		});
		
		buttonPanel.add(listButton);
		
		add(buttonPanel);
	
	}   

}

class Main{

	public static void main(String[] args){
	     
	     
	     new Form().setVisible(true);
	   
	}
}
