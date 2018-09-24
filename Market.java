import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Market extends JPanel implements ActionListener ,ItemListener
{	final int fruitTypes=4;
	Fruit f[];
	JPanel p;
	JPanel img[]=new JPanel[4];
	JLabel l1[]=new JLabel[4]; // for fruit name
	JLabel l2[]=new JLabel[4]; //for price per kg
	JComboBox cb[]=new JComboBox[4]; //for quantity
	JLabel l3[]=new JLabel[4]; //for total price per fruit
	JLabel l4[]=new JLabel[7]; // for description of rows
	JButton b1[]=new JButton[4];
	Integer q[]=new Integer[4];
	int selected[]={0,0,0,0};
	Market(Fruit f1[],JPanel parent)
	{	f=f1;
		p=parent;
		int i;
		for (i=0;i<4;i++)
			q[i]=new Integer(i);
		for(i=0;i<4;i++)
		{
			l1[i]=new JLabel(f[i].getName());
			l2[i]=new JLabel(f[i].getPrice()+"");
			cb[i]=new JComboBox(q);
			cb[i].addItemListener(this);
			l3[i]=new JLabel();
		}
		b1[0]=new JButton("Proceed to Checkout");
		b1[1]=new JButton("wait");
		b1[2]=new JButton("Back");
		b1[3]=new JButton("Exit");
		
		for(i=0;i<4;i++)
			b1[i].addActionListener(this);
		
		img[0]=new createImage("C:/Users/Michael Edinburgh/Desktop/John Britto/Project/apple.jpg");
		img[1]=new createImage("C:/Users/Michael Edinburgh/Desktop/John Britto/Project/mango.png");
		img[2]=new createImage("C:/Users/Michael Edinburgh/Desktop/John Britto/Project/orange.jpg");
		img[3]=new createImage("C:/Users/Michael Edinburgh/Desktop/John Britto/Project/banana.jpg");
		
		l4[0]=new JLabel("Welcome User!!!");
		l4[1]=new JLabel("Fruits:");
		l4[2]=new JLabel("Prices(in Rs./Kg):");
		l4[3]=new JLabel("Choose quantity(in Kg):");
		l4[4]=new JLabel("Sum Total(in Rupees):");
		l4[5]=new JLabel();
			
		GridLayout b=new GridLayout(6,5,15,15);
		setLayout(b);
		
		// adding the different components
		add(l4[0]);
		for(i=0;i<4;i++)
			add(img[i]);
		add(l4[1]);
		for(i=0;i<4;i++)
			add(l1[i]);
		add(l4[2]);
		for(i=0;i<4;i++)
			add(l2[i]);
		add(l4[3]);
		for(i=0;i<4;i++)
			add(cb[i]);
		add(l4[4]);
		for(i=0;i<4;i++)
			add(l3[i]);
		add(l4[5]);
		for(i=0;i<4;i++)
			add(b1[i]);
		
		
		
	
	    setVisible(true);  
	
		

	} //end of constructor
	
	
	public void calculateValid()
	{
		
		
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
			JButton b=(JButton)ae.getSource();
			if(b==b1[0])
			{
				calculateValid();
				
			}
			if(b==b1[2])   // b1[2] is back button
			{
				CardLayout cl = (CardLayout)p.getLayout();
				cl.show(p, "Option");
			}
			if(b==b1[3])  // b1[3] is exit button
				System.exit(0);
	}
	
	public void itemStateChanged(ItemEvent ie) 
	{
			JComboBox c=(JComboBox)ie.getSource();
			int item=(Integer)ie.getItem();
			if(c==cb[0])
			{l3[0].setText(item*f[0].getPrice()+"");
			selected[0]=item;
			}
			if(c==cb[1])
				{
				l3[1].setText(item*f[1].getPrice()+"");
				selected[1]=item;
				}
			if(c==cb[2])
				{
				l3[2].setText(item*f[2].getPrice()+"");
				selected[2]=item;
				}
			if(c==cb[3])
				{
				l3[3].setText(item*f[3].getPrice()+"");
				selected[3]=item;
				}
	}
	
	


}
