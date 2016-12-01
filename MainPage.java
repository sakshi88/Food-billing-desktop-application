import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
//import Mypack.OrderAndRecord.*;

class MainPage implements ActionListener
{
	JFrame f;
	JLabel username,password;
	JTextField name,pass;
	JButton login;
	FileInputStream fin,fin1;
	JPanel p,p1;

	MainPage()
	{
		f=new JFrame("Kadimi's");
		username=new JLabel("Username",SwingConstants.CENTER);
		password=new JLabel("Password",SwingConstants.CENTER);
		name=new JTextField();
		pass=new JTextField();
		login=new JButton("LOGIN");
		p=new JPanel();
		GridBagConstraints gbc=new GridBagConstraints();

		p.setLayout(new GridBagLayout());
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.weightx=0.5;
		gbc.gridx=0;
		gbc.gridy=0;
		p.add(username,gbc); 
		username.setFont(new Font("Courier", Font.ITALIC, 25));
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.weightx=200;
		gbc.ipady=30;
		gbc.ipadx=80;
		p.add(name,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.ipady=30;
		gbc.ipady=80;
		p.add(password,gbc);
		password.setFont(new Font("Courier", Font.ITALIC, 25));
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.ipady=30;
		gbc.ipadx=80;
		p.add(pass,gbc);
		gbc.gridy=3;
		gbc.gridx=1;
		gbc.ipadx=50;
		p.add(login,gbc);
		login.setFont(new Font("Courier", Font.BOLD, 25));

		f.add(p);
		login.addActionListener(this);
		f.setVisible(true);
		f.setLayout(new GridBagLayout());
		f.setSize(550,700);
		//pack();
	}

	public static void main(String[] args) {
		new MainPage();
	}

	public void actionPerformed(ActionEvent e)
	{
		try
		{
			String s1=name.getText();
			String s4=pass.getText();
			fin=new FileInputStream("User.txt");
			fin1=new FileInputStream("pass.txt");
			byte s_user[]=new byte[fin.available()];
			fin.read(s_user);
			String s2=new String(s_user);

			byte P_name[]=new byte[fin1.available()];
			fin1.read(P_name);
			String s3=new String(P_name);

			if((s1.equalsIgnoreCase(s2))&&(s4.contentEquals(s3)))
			{
				JOptionPane.showMessageDialog(null,"You are Welcome!!!");

				new OrderAndRecord1();
			}	
			else
			{	JOptionPane.showMessageDialog(null,"Sorry You can't login");
			}	
		}
		catch(IOException e1)
		{ 
			System.out.println(e1);
		}	
	}
}