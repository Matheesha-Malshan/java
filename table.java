import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

class ViewCustomerForm extends JFrame{
	
	private JTable tblCustomerDetails;
	private DefaultTableModel dtm;
	private JLabel titleLabel;
	private JButton btnreload;
	ViewCustomerForm(){
		setSize(300,300);
		setTitle("view customer form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		titleLabel=new JLabel("view customer form");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		add("North",titleLabel);
		
		String[] columnName={"Customer id","Name","address","salary"};
		dtm=new DefaultTableModel(columnName,0);
		
		tblCustomerDetails=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
		add("Center",tablePane);
		
		JPanel buttonpanel=new JPanel();
		btnreload=new JButton("reload");
		btnreload.setFont(new Font("",1,20));
		buttonpanel.add(btnreload);
		add("South",buttonpanel);
	} 
}
class Demo{
	public static void main(String[] args){
		
		new ViewCustomerForm().setVisible(true);
	}
}
