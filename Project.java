import java.util.Date;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
class Frame5 extends Frame implements ActionListener
{	
	Button back;
	Frame5()
	{	
		setLayout(null);
		back=new Button("Back");
		back.setBounds(600,600,100,30);
		back.setFont(new Font("Arial",Font.BOLD,20));
		back.setForeground(Color.WHITE);
		back.setBackground(Color.RED);
		add(back);
		back.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
		{
			this.dispose();
		}
	}
	public void paint(Graphics g)
	{
		int i=100;
		g.setColor(Color.RED);
		g.setFont(new Font("Arial Black",Font.BOLD,20));
		g.drawString("From",10,65);
		g.drawString("Destination",135,65);
		g.drawString("Payment Type",285,65);
		g.drawString("Date & Time",465,65);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial",Font.BOLD,18));
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","dbms123");
			PreparedStatement ps=con.prepareStatement("select fromp,top,ptype,bdate from myrides where username=?");
			ps.setString(1,Frame2.u);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				g.drawString(rs.getString(1),10,i);
				g.drawString(rs.getString(2),140,i);
				g.drawString(rs.getString(3),290,i);
				g.drawString(rs.getString(4),470,i);
				i=i+50;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
class Frame4 extends Frame implements ActionListener
{
	String name;
	int ct=0,i=0;
	Label pname,hi,wl,currentb,cb,addmoney,form,cabbk,blk,blank0,blank1,blank2,blank3,blank4,blank5;
	TextField bal;
	Choice add,pick,drop,ridetype,paymethod;
	Image image;
	Button ad,logout,submit,book,cancel2,myrides;
	Font font=new Font("Times New Roman",Font.BOLD,20);
	Font font1=new Font("Italic",Font.BOLD,18);
	Frame4()
	{
		setLayout(null);
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","dbms123");
			PreparedStatement ps1=con.prepareStatement("select name from customer where username=?");
			ps1.setString(1,Frame2.u);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
			{
				name=rs1.getString(1);
			}
		}
		catch(Exception e)
		{}
		pname=new Label(name);
		pname.setBounds(55,30,170,30);
		pname.setBackground(Color.DARK_GRAY);
		pname.setForeground(Color.WHITE);
		pname.setFont(font);
		bal=new TextField();
		bal.setBackground(Color.WHITE);
		bal.setBounds(140,90,100,27);
		bal.setFont(font);
		bal.setBackground(Color.WHITE);
		image=new ImageIcon("Capture5.png").getImage();
		hi=new Label("  Hi,");
		hi.setBounds(10,30,1370,30);
		hi.setFont(font);
		hi.setBackground(Color.DARK_GRAY);
		hi.setForeground(Color.WHITE);
		wl=new Label("  Welcome to VK-Cabs");
		wl.setBounds(10,60,1370,30);
		wl.setFont(font);
		wl.setBackground(Color.DARK_GRAY);
		wl.setForeground(Color.WHITE);
		currentb=new Label("  My wallet :");
		currentb.setBounds(10,90,1370,30);
		currentb.setFont(font);
		currentb.setBackground(Color.DARK_GRAY);
		currentb.setForeground(Color.WHITE);
		addmoney=new Label("  Add Money");
		addmoney.setBounds(10,120,1370,30);
		addmoney.setFont(font);
		addmoney.setBackground(Color.DARK_GRAY);
		addmoney.setForeground(Color.WHITE);
		add=new Choice();
		add.add("");
		add.add("100");
		add.add("200");
		add.add("300");
		add.add("400");
		add.add("500");
		add.add("600");
		add.add("700");
		add.add("800");
		add.add("900");
		add.add("1000");
		add.setBounds(140,125,100,2);
		add.setBackground(Color.WHITE);
		add.setFont(font);
		ad=new Button("Add");
		ad.setBounds(20,170,90,25);
		ad.setFont(font1);
		ad.setBackground(Color.RED);
		ad.setForeground(Color.WHITE);
		myrides=new Button("My Rides");
		myrides.setBounds(1230,40,125,25);
		myrides.setBackground(Color.RED);
		myrides.setFont(new Font("Arial",Font.BOLD,20));
		myrides.setForeground(Color.WHITE);
		logout=new Button("Logout");
		logout.setBounds(1230,170,125,25);
		logout.setFont(font);
		logout.setBackground(Color.WHITE);
		logout.setForeground(Color.BLACK);
		form=new Label("                         CAB BOOKING FORM");
		form.setFont(new Font("Arial Black",Font.BOLD,36));
		form.setBounds(240,125,990,80);
		form.setBackground(Color.DARK_GRAY);
		form.setForeground(Color.WHITE);
		blk=new Label("");
		blk.setBounds(10,125,250,80);
		blk.setBackground(Color.DARK_GRAY);
		blank0=new Label("");
		blank0.setBounds(1230,125,140,80);
		blank0.setBackground(Color.DARK_GRAY);
		pick=new Choice();
		pick.add("Select");
		pick.add("Hi-tech city");
		pick.add("Kondapur");
		pick.add("Habits");
		pick.add("Old city");
		pick.setBounds(640,320,250,20);
		pick.setFont(font1);
		pick.setBackground(Color.LIGHT_GRAY);
		pick.setForeground(new Color(20,30,100));
		drop=new Choice();
		drop.add("Select");
		drop.add("Hi-tech city");
		drop.add("Kondapur");
		drop.add("Habits");
		drop.add("Old city");
		drop.setBounds(640,360,250,20);
		drop.setFont(font1);
		drop.setBackground(Color.LIGHT_GRAY);
		drop.setForeground(new Color(20,30,100));
		ridetype=new Choice();
		ridetype.add("Select");
		ridetype.add("Single");
		ridetype.add("Share");
		ridetype.setBounds(640,400,250,20);
		ridetype.setFont(font1);
		ridetype.setBackground(Color.LIGHT_GRAY);
		ridetype.setForeground(new Color(20,30,100));
		submit=new Button("Submit");
		submit.setFont(font);
		submit.setBackground(Color.RED);
		submit.setForeground(Color.WHITE);
		submit.setBounds(760,460,125,30);
		cabbk=new Label(" ");
		cabbk.setBounds(386,215,150,50);
		cabbk.setBackground(Color.RED);
		blank1=new Label(" BOOK CAB NOW");
		blank1.setForeground(Color.WHITE);
		blank1.setBounds(536,215,455,50);
		blank1.setBackground(Color.RED);
		blank1.setFont(new Font("Arial Black",Font.BOLD,30));
		paymethod=new Choice();
		paymethod.add("Select");
		paymethod.add("Online");
		paymethod.add("Offline");		
		paymethod.setFont(font1);
		paymethod.setBackground(Color.LIGHT_GRAY);
		paymethod.setForeground(new Color(20,30,100));
		paymethod.setBounds(645,560,240,25);
		book=new Button("Book my cab");
		book.setBounds(480,640,170,30);
		book.setFont(font);
		book.setBackground(Color.RED);
		book.setForeground(Color.WHITE);
		cancel2=new Button("Cancel");
		cancel2.setBounds(760,640,125,30);
		cancel2.setFont(font);
		cancel2.setBackground(Color.BLUE);
		cancel2.setForeground(Color.WHITE);
		blank2=new Label(" ");
		blank2.setBounds(386,265,1,450);
		blank2.setBackground(Color.WHITE);
		blank3=new Label(" ");
		blank3.setBounds(386,715,600,1);
		blank3.setBackground(Color.WHITE);
		blank4=new Label(" ");
		blank4.setBounds(990,265,1,450);
		blank4.setBackground(Color.WHITE);
		blank5=new Label(" ");
		blank5.setBounds(10,730,1370,4);
		blank5.setBackground(Color.BLACK);
		add(bal);
		add(pname);
		add(form);
		add(blank5);
		add(blank4);
		add(blank3);
		add(blank2);
		add(book);
		add(cancel2);
		add(paymethod);
		add(cabbk);
		add(blank1);
		add(submit);
		add(ridetype);
		add(drop);
		add(pick);
		add(logout);
		add(ad);
		add(myrides);
		add(add);
		add(addmoney);
		add(currentb);
		add(hi);
		add(wl);
		add(blk);
		add(blank0);
		ad.addActionListener(this);
		logout.addActionListener(this);
		myrides.addActionListener(this);
		submit.addActionListener(this);
		book.addActionListener(this);
		cancel2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent aee)
	{
		if(aee.getSource()==submit)
		{
			try
			{
				if(pick.getSelectedItem().equals("Select")||drop.getSelectedItem().equals("Select")||ridetype.getSelectedItem().equals("Select"))
				{
					JOptionPane.showMessageDialog(null,"Please select all details");	
				}
				else if(pick.getSelectedItem().equals(drop.getSelectedItem()))
				{
					JOptionPane.showMessageDialog(null,"Pick up from and drop cannot be same");	
				}
				else
				{	
					if(ridetype.getSelectedItem().equals("Single"))
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","dbms123");
						PreparedStatement ps=con.prepareStatement("select Single_cost from fromto where pickat=? and dropat=?");
						ps.setString(1,pick.getSelectedItem());
						ps.setString(2,drop.getSelectedItem());
						ResultSet rs=ps.executeQuery();
						if(rs.next())
						{
							ct=rs.getInt(1);
						}
					}
					else if(ridetype.getSelectedItem().equals("Share"))
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","dbms123");
						PreparedStatement ps=con.prepareStatement("select Share_cost from fromto where pickat=? and dropat=?");
						ps.setString(1,pick.getSelectedItem());
						ps.setString(2,drop.getSelectedItem());
						ResultSet rs=ps.executeQuery();
						if(rs.next())
						{
							ct=rs.getInt(1);
						}
					}
					JOptionPane.showMessageDialog(null,"Submit complete.\nPlease select payment type to complete booking");			
				}
				repaint();	
			}
			catch(Exception e)
			{}
		}
		else if(aee.getSource()==book)
		{
			if(ct!=0)
			{
				if(paymethod.getSelectedItem().equals("Select"))
				{
					JOptionPane.showMessageDialog(null,"Please select payment type");	
				}
				else if(paymethod.getSelectedItem().equals("Online"))
				{		
					if(ct<=i)
					{
						Date date1=new Date();
						try
						{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","dbms123");
							PreparedStatement ps=con.prepareStatement("update customer set current_balance=current_balance-"+ct+" where username=?");
							ps.setString(1,Frame2.u);
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null,"Successfully booked your cab.\npick you soon....");		
							ct=0;
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
						try
						{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","dbms123");
							Statement st=con.createStatement();
							int i=st.executeUpdate("insert into myrides(username,fromp,top,ptype,bdate)values('"+Frame2.u+"','"+pick.getSelectedItem()+"','"+drop.getSelectedItem()+"','"+paymethod.getSelectedItem()+"','"+date1+"')");
						}
						catch(Exception m)
						{
							System.out.println(m);
						}
						pick.remove("Select");
						pick.insert("Select",0);
						drop.remove("Select");
						drop.insert("Select",0);
						ridetype.remove("Select");
						ridetype.insert("Select",0);
						paymethod.remove("Select");
						paymethod.insert("Select",0);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Cost exceeds wallet money.\nadd money to your wallet");
					}
				}
				else if(paymethod.getSelectedItem().equals("Offline"))
				{
					Date date1=new Date();	
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","dbms123");
						Statement st=con.createStatement();
						int i=st.executeUpdate("insert into myrides(username,fromp,top,ptype,bdate)values('"+Frame2.u+"','"+pick.getSelectedItem()+"','"+drop.getSelectedItem()+"','"+paymethod.getSelectedItem()+"','"+date1+"')");
					}
					catch(Exception m)
					{
						System.out.println(m);
					}
					JOptionPane.showMessageDialog(null,"Successfully booked your cab.\npick you soon....");
					pick.remove("Select");
					pick.insert("Select",0);
					drop.remove("Select");
					drop.insert("Select",0);
					ridetype.remove("Select");
					ridetype.insert("Select",0);
					paymethod.remove("Select");
					paymethod.insert("Select",0);
					ct=0;
				}
			}
			else if(ct==0)
			{
				JOptionPane.showMessageDialog(null,"Cab booking failed...\nPlease submit details");
			}
			repaint();
		}
		else if(aee.getSource()==cancel2)
		{	
			if(pick.getSelectedItem().equals("Select")&&pick.getSelectedItem().equals("Select")||add.getSelectedItem().equals("Select")||ridetype.getSelectedItem().equals("Select"))
			{}
			else
			{
				JOptionPane.showMessageDialog(null,"cancelation successfull...");
				pick.remove("Select");
				pick.insert("Select",0);
				drop.remove("Select");
				drop.insert("Select",0);
				ridetype.remove("Select");
				ridetype.insert("Select",0);
				paymethod.remove("Select");
				paymethod.insert("Select",0);
			}
			ct=0;
			repaint();
		}
		else if(aee.getSource()==logout)
		{
			this.dispose();
		}
		else if(aee.getSource()==ad)
		{
			if(add.getSelectedItem().equals(""))
			JOptionPane.showMessageDialog(null,"Please select amount");
			else
			{				
				int am=Integer.parseInt(add.getSelectedItem());
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","dbms123");
					PreparedStatement ps=con.prepareStatement("update customer set current_balance=current_balance+"+am+" where username=?");
					ps.setString(1,Frame2.u);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Added "+am+" to your wallet");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			repaint();
		}
		else if(aee.getSource()==myrides)
		{
			Frame5 f5=new Frame5();
			f5.setSize(800,800);
			f5.setBackground(Color.BLACK);
			f5.setVisible(true);
		}
	}
	public void paint(Graphics g)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","dbms123");
			PreparedStatement ps=con.prepareStatement("select current_balance from customer where username=?");
			ps.setString(1,Frame2.u);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				i=rs.getInt(1);
			}
		}						
		catch(Exception e)
		{
			System.out.println(e);
		}
		bal.setText("Rs."+i);
		bal.setEditable(false);
		g.drawImage(image,10,30,this);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Rs."+ct+"",650,540);
		String cost,pfrom,dat,rtype,pmethod;
		cost="FARE                :";
		pfrom="Pick up from  :";
		dat="Drop at           :";
		rtype="Ride Type      :";
		pmethod="Payment Type :";
		g.setFont(new Font("Arial Black",Font.BOLD,25));
		g.setColor(Color.WHITE);
		g.drawString(dat,470,380);
		g.setFont(font1);
		g.setColor(Color.WHITE);
		g.drawString(pfrom,470,340);
		g.drawString(rtype,470,420);
		g.drawString(cost,470,540);
		g.drawString(pmethod,470,580);

	}
}
class Frame3 extends Frame implements ActionListener
{
	Image image;
	Button create,back;
	TextField t1,t2,t3,t4;
	Font font=new Font("Arial",Font.BOLD,40);
	Font font1=new Font("Arial Black",Font.BOLD,18);
	Font font2=new Font("Arial",Font.BOLD,20);
	Frame3()
	{
		setLayout(null);
		image=new ImageIcon("Capture1.png").getImage();
		t1=new TextField();
		t1.setBounds(640,250,200,35);
		t1.setBackground(Color.DARK_GRAY);
		t1.setFont(font2);
		t1.setForeground(Color.WHITE);
		t2=new TextField();
		t2.setBackground(Color.DARK_GRAY);
		t2.setBounds(640,300,200,35);
		t2.setFont(font2);
		t2.setForeground(Color.WHITE);
		t3=new TextField();
		t3.setBackground(Color.DARK_GRAY);
		t3.setBounds(640,350,200,35);
		t3.setFont(font2);
		t3.setForeground(Color.WHITE);
		t4=new TextField();
		t4.setBackground(Color.DARK_GRAY);
		t4.setBounds(640,400,200,35);
		t4.setFont(font2);
		t4.setForeground(Color.WHITE);
		t4.setEchoChar('*');
		create=new Button("Create");
		create.setBounds(730,450,100,40);
		create.setFont(font1);
		create.setForeground(Color.WHITE);
		create.setBackground(Color.BLUE);
		back=new Button("Back");
		back.setForeground(Color.WHITE);
		back.setBounds(560,450,100,40);
		back.setFont(font1);
		back.setBackground(Color.RED);
		add(create);
		add(back);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		create.addActionListener(this);
		back.addActionListener(this);
	}
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource()==create)
		{
			String nm,uname,pswd,conpw;
			nm=t1.getText();
			uname=t2.getText();
			pswd=t3.getText();
			conpw=t4.getText();
			try
			{
				if((conpw.equals(pswd))&&!(pswd.equals(""))&&!(nm.equals(""))&&!(uname.equals("")))
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","dbms123");
					Statement st=con.createStatement();
					int i=st.executeUpdate("insert into customer(username,password,name,current_balance)values('"+uname+"','"+pswd+"','"+nm+"','"+0+"')");
					JOptionPane.showMessageDialog(null,"Succesfully Created your account.");
					this.dispose();
				}
				else if((pswd.equals(""))||(nm.equals(""))||(conpw.equals(""))||(uname.equals("")))
				JOptionPane.showMessageDialog(null,"fill the blank places to create account");
				else
				JOptionPane.showMessageDialog(null,"Please check your password");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Username already exists!");
			}	
				
		}
		else if(a.getSource()==back)
		this.dispose();
	}
	public void paint(Graphics g)
	{
		g.drawImage(image,10,60,this);
		String newa="NEW ACCOUNT";
		String name="                      Name:";
		String un="               Username:";
		String pw="               Password:";
		String cpw="  Confirm Password:";
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString(newa,550,210);
		g.setColor(Color.WHITE);
		g.setFont(font2);
		g.drawString(name,440,270);
		g.drawString(un,440,320);
		g.drawString(pw,440,370);
		g.drawString(cpw,440,420);
	}
}
class Frame2 extends Frame implements ActionListener
{
	Button submit,back,new_account;
	TextField t1,t2;
	static String u,p;
	Image image,image1;
	Font font=new Font("Arial Black",Font.BOLD,30);
	Font font2=new Font("Arial",Font.BOLD,18);
	Font font1=new Font("Arial",Font.BOLD,18);
	Frame2()
	{
		setLayout(null);
		image=new ImageIcon("d1ccf430d070f4662e75057d9fce7e9f.png").getImage();
		image1=new ImageIcon("Capture8.png").getImage();
		t1=new TextField();
		t1.setBounds(280,340,175,33);
		t1.setBackground(Color.DARK_GRAY);
		t1.setForeground(Color.WHITE);
		t2=new TextField();
		t2.setBackground(Color.DARK_GRAY);
		t2.setBounds(280,395,175,33);
		t2.setForeground(Color.WHITE);
		t1.setFont(font1);
		t2.setFont(font1);
		t2.setEchoChar('*');
		new_account=new Button("Click here to create account");
		new_account.setBounds(170,510,290,35);
		new_account.setBackground(Color.BLACK);
		new_account.setFont(font2);
		new_account.setForeground(Color.WHITE);
		submit=new Button("Login");
		submit.setBounds(360,450,100,35);
		submit.setBackground(Color.RED);
		submit.setFont(font2);
		submit.setForeground(Color.WHITE);
		back=new Button("Back");
		back.setBounds(170,450,100,35);
		back.setFont(font2);
		back.setBackground(Color.BLUE);
		back.setForeground(Color.WHITE);
		add(submit);
		add(back);
		add(new_account);
		add(t1);
		add(t2);
		new_account.addActionListener(this);
		submit.addActionListener(this);
		back.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==new_account)
		{
			Frame3 f3=new Frame3();
			f3.setSize(900,900);
			f3.setVisible(true);
			f3.setBackground(Color.BLACK);
		}
		else if(e.getSource()==submit)
		{
			Frame2.u=t1.getText();
			Frame2.p=t2.getText();
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","dbms123");
				PreparedStatement ps=con.prepareStatement("select * from customer where username=? and password=?");
				ps.setString(1,u);
				ps.setString(2,p);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					Frame4 f4=new Frame4();
					f4.setSize(800,800);
					f4.setVisible(true);
					f4.setBackground(Color.WHITE);
					JOptionPane.showMessageDialog(null,"Logged in");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Credentials Mismatch");
				} 	
			}
			catch(Exception y)
			{
				System.out.println(y);
			}
		}
		else if(e.getSource()==back)
		{
			this.dispose();
		}
	}
	public void paint(Graphics g)
	{
		g.drawImage(image1,10,35,this);
		g.drawImage(image,600,150,this);
		String lg="LOGIN TO VK-CABS";
		String un="  username:";
		String pw="  password:";
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString(lg,150,310);
		g.setFont(font1);
		g.drawString(un,160,360);
		g.drawString(pw,160,420);
	}
}
class Frame1 extends Frame implements ActionListener
{
	Button b1;
	Image image;
    Frame1()
	{
			setLayout(null);
		    b1=new Button("Get Started");
			b1.setBounds(550,600,150,40);
			b1.setFont(new Font("Arial",Font.BOLD,20));
			b1.setBackground(new Color(100,20,30));
			b1.setForeground(Color.WHITE);
			image=new ImageIcon("Capture.PNG").getImage();
			add(b1);
			b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			Frame2 f2 = new Frame2();
			f2.setSize(800,800);
			f2.setBackground(Color.BLACK);
			f2.setVisible(true);
		}
	}
	public void paint(Graphics g)
	{
		g.drawImage(image,10,35,this);
		String vk="VK-Cabs";
		String tag="We provide safe and secure journey.";
		g.setFont(new Font("Arial Black",Font.BOLD,50));
		g.setColor(Color.WHITE);
		g.drawString(vk,500,90);
		g.setFont(new Font("Courier",Font.BOLD,25));
		g.setColor(Color.ORANGE);
		g.drawString(tag,630,150);
	}
}
class Project
{
	public static void main(String args[])
	{
		Frame1 f1=new Frame1();
		f1.setSize(800,800);
	    f1.setBackground(Color.BLACK);
		f1.addWindowListener(new myclass());
		f1.setVisible(true);
	}		
}
class myclass extends WindowAdapter
{
	 public void windowClosing(WindowEvent e)
	 {
                 System.exit(0); 
     }
}