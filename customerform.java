import javax.swing.* ;
import java.awt.*;

class window extends JFrame{
	
	JLabel label;
	JLabel id;
	JLabel name;
	JLabel salary;
	JLabel address;
	
	JPanel panel;
	JButton addBtn;
	JButton canBtn;
	
	JTextField tid;
	JTextField tname;
	JTextField tmoney;
	JTextField taddress;
	JPanel tpanel;
	
	window(){
		setSize(300,300);
		setTitle("calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		label=new JLabel("add customer form");
		label.setFont(new Font("",1,20));
		label.setHorizontalAlignment(JLabel.CENTER);
		add("North",label);
		
		panel=new JPanel(new GridLayout(4,1));
		
		JLabel id=new JLabel("id");
		id.setFont(new Font("",1,20));
		panel.add(id);
		
		name=new JLabel("name");
		name.setFont(new Font("",1,20));
		panel.add(name);
		
		salary=new JLabel("salary");
		salary.setFont(new Font("",1,20));
		panel.add(salary);
		
		address=new JLabel("address");
		address.setFont(new Font("",1,20));
		panel.add(address);
		
		add("West",panel);
		
	JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		addBtn=new JButton("add");
		addBtn.setFont(new Font("",1,20));
		buttonPanel.add(addBtn);
		
		canBtn=new JButton("cancel");
		canBtn.setFont(new Font("",1,20));
		buttonPanel.add(canBtn);
		
		add("South",buttonPanel);
		
		tpanel=new JPanel(new GridLayout(4,1));
		
		tid=new JTextField(4);
		tid.setFont(new Font("",1,20));
		JPanel idpanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		idpanel.add(tid);
		tpanel.add(idpanel);
		
		
		tname=new JTextField(10);
		tname.setFont(new Font("",1,20));
		JPanel namepanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		namepanel.add(tname);
		tpanel.add(namepanel);
		
		tmoney=new JTextField(6);
		tmoney.setFont(new Font("",1,20));
		JPanel salarypanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		salarypanel.add(tmoney);
		tpanel.add(salarypanel);
		
		taddress=new JTextField(25);
		taddress.setFont(new Font("",1,20));
		JPanel addresspanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		addresspanel.add(taddress);
		tpanel.add(addresspanel);
		
		add("Center",tpanel);
		
	
	}
	
}

class Demo{
	public static void main(String[] args){
		
		new window().setVisible(true);
	}
}
