import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class ForgotPassWord implements ActionListener
{
	JFrame f;
	JPanel jp;
	JPasswordField npass,cpass;
	JButton reset;
	JLabel newp,conp;
	FileOutputStream fout;
	ForgotPassWord()
	{
		f=new JFrame("Password reset");
		jp=new JPanel();
		npass=new JPasswordField();
		cpass=new JPasswordField();
		reset=new JButton("Reset");
		newp=new JLabel("New Password:");
		conp=new JLabel("Confirm Password:");
		newp.setBounds(50,80,150,30);
		npass.setBounds(200,80,150,30);
		conp.setBounds(50,140,180,30);
		cpass.setBounds(200,140,150,30);
		reset.setBounds(120,210,150,30);
		jp.add(npass);
		jp.add(cpass);
		jp.add(reset);
		jp.add(newp);
		jp.add(conp);
		reset.addActionListener(this);
		jp.setLayout(null);
		f.setContentPane(jp);
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(500,500);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==reset)
		{
			try
			{
				fout=new FileOutputStream("pass.txt");
				String newpass=npass.getText();
				String conpass=cpass.getText();
				byte b[]=newpass.getBytes();
				if(newpass.equals(conpass))
				{
					fout.write(b);
					JOptionPane.showMessageDialog(f,"Your PassWord has been reset");
					MainPage.f.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(f,"New PassWord and Confirm Password fields doesn't match");
					npass.setText("");
					cpass.setText("");
				}
				fout.close();
			}
			catch(Exception e1){}
			
		}


	}
}