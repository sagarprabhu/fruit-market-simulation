	
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	
	
	public class ConsumerInterface extends JPanel implements ActionListener ,ItemListener
		{
			Fruit f[];
			int item;
			final int fruitTypes=4;
			final int totalStock=100;
			JPanel p;
			JPanel img[]=new JPanel[fruitTypes];
			//JLabel stockLeft[]=new JLabel[fruitTypes];
			JLabel l1[]=new JLabel[fruitTypes]; // for fruit name
			JLabel l2[]=new JLabel[fruitTypes]; //for price per kg
			JComboBox cb[]=new JComboBox[fruitTypes]; //what about generic?
			JLabel l3[]=new JLabel[fruitTypes]; //for total price per fruit
			JLabel l4[]=new JLabel[6]; // for description of rows
			JButton b1[]=new JButton[fruitTypes];
			Integer q[]=new Integer[11];
			JLabel totalAmount=new JLabel("Total Amount: 0");
			int selectionC[]={0,0,0,0};
			ConsumerInterface(Fruit f1[],JPanel parent)
			{	f=f1;
				p=parent;
				setFruitPrice();
				int i;
				for (i=0;i<=10;i++)
					q[i]=new Integer(i);
				for(i=0;i<fruitTypes;i++)
				{	//stockLeft[i]=new JLabel();
					l1[i]=new JLabel(f[i].getName());
					l2[i]=new JLabel(f[i].getPrice()+"");
					cb[i]=new JComboBox(q);
					cb[i].addItemListener(this);
					l3[i]=new JLabel();
				}
				setStockLabel();
				b1[0]=new JButton("Proceed to Checkout");
				b1[1]=new JButton("wait");
				b1[2]=new JButton("Back");
				b1[3]=new JButton("Exit");
				
				for(i=0;i<fruitTypes;i++)
					b1[i].addActionListener(this);
				
				img[0]=new createImage("C:/Users/Michael Edinburgh/Desktop/John Britto/Project/apple.jpg");
				img[1]=new createImage("C:/Users/Michael Edinburgh/Desktop/John Britto/Project/mango.png");
				img[2]=new createImage("C:/Users/Michael Edinburgh/Desktop/John Britto/Project/orange.jpg");
				img[3]=new createImage("C:/Users/Michael Edinburgh/Desktop/John Britto/Project/banana.jpg");
				
				l4[0]=new JLabel("Welcome Consumer!!!");
				l4[1]=new JLabel("Fruits:");
				l4[2]=new JLabel("Prices(in Rs./Kg):");
				l4[3]=new JLabel("Choose quantity(in Kg):");
				l4[4]=new JLabel("Sum Total(in Rupees):");
				//l4[5]=new JLabel("Stock Left:");
					
				GridLayout b=new GridLayout(7,5);
				setLayout(b);
				
				// adding the different components
				add(l4[0]);
				for(i=0;i<fruitTypes;i++)
					add(img[i]);
				add(l4[1]);
				for(i=0;i<fruitTypes;i++)
					add(l1[i]);
				//add(l4[5]);
				for(i=0;i<fruitTypes;i++)
					{//add(stockLeft[i]);}
				setStockLabel();
				setStockLabel();
				add(l4[2]);
				for(i=0;i<fruitTypes;i++)
					add(l2[i]);
				add(l4[3]);
				for(i=0;i<fruitTypes;i++)
					add(cb[i]);
				add(l4[4]);
				for(i=0;i<fruitTypes;i++)
					add(l3[i]);
				add(totalAmount);
				for(i=0;i<fruitTypes;i++)
					add(b1[i]);
				b1[1].setEnabled(true);
				b1[0].setEnabled(false);
				setStockLabel();
			    setVisible(true);  
					}
			 	
			} //end of constructor
			
			void setStockLabel()
		 	{
		 		//for(int i=0;i<fruitTypes;i++)
		 			//stockLeft[i].setText(Integer.toString(f[i].getStock()));
		 			
		 	}
			
			void setFruitPrice()
			{
				f[0].setPrice(55);
				f[1].setPrice(50);
				f[2].setPrice(52);
				f[3].setPrice(54);
			}
			
			void setIndexZero()
			{
				for(int i=0;i<fruitTypes;i++)
				{cb[i].setSelectedIndex(0);
				selectionC[i]=0;
				}
			}
			
			
			
			public void checkout()
			{
				for(int k=0;k<fruitTypes;k++)
					{f[k].changeStock(f[k].getStock()-selectionC[k]);
					//stockLeft[k].setText(Integer.toString(f[k].getStock()));
					}
			}
			
			
			public void actionPerformed(ActionEvent ae)
			{
					JButton b=(JButton)ae.getSource();
					if(b==b1[0])
					{
						String s=totalAmount.getText();
						int x=Integer.parseInt(s.replaceAll("[\\D]", ""));
						JOptionPane.showMessageDialog(null,x+" is the amount for what you have bought!");
						checkout();
						setIndexZero();
						b1[0].setEnabled(false);
						CardLayout cl = (CardLayout)p.getLayout();
						cl.show(p, "Option");
						
						
					}
					
					if(b==b1[1])
					{
						JOptionPane.showMessageDialog(null,"You will be notified when the fruit becomes available. Thank you!");
						setIndexZero();
						b1[1].setEnabled(false);
						CardLayout cl = (CardLayout)p.getLayout();
						cl.show(p, "Option");
					}
					
					if(b==b1[2])   // b1[2] is back button
					{	setIndexZero();
						b1[0].setEnabled(false);
						CardLayout cl = (CardLayout)p.getLayout();
						cl.show(p, "Option");
					}
					
					if(b==b1[3])  // b1[3] is exit button
						System.exit(0);
					
			}
			
			public void itemStateChanged(ItemEvent ie) 
			{		setFruitPrice();
					int k;
					JComboBox c=(JComboBox)ie.getSource();
					item=(Integer)ie.getItem();
					b1[1].setEnabled(false);
					if(c==cb[0])
					{
						if(f[0].getStock()-item<0)
						{	
							b1[1].setEnabled(true);
							JOptionPane.showMessageDialog(null,f[0].getName()+" is not in stock.");
						}
						else
							{l3[0].setText(item*f[0].getPrice()+"");
							selectionC[0]=item;
							}
					}
						else
							if(c==cb[1])
						{
							
								if(f[1].getStock()-item<0)
								{	
									b1[1].setEnabled(true);
									JOptionPane.showMessageDialog(null,f[1].getName()+" is not in stock.");
								}
							
							else
							{	l3[1].setText(item*f[1].getPrice()+"");
								selectionC[1]=item;
							}
						}
							else if(c==cb[2])
						{
						if(f[2].getStock()-item<0)
						{	
							b1[1].setEnabled(true);
							JOptionPane.showMessageDialog(null,f[2].getName()+" is not in stock.");
						}
							else
							{	l3[2].setText(item*f[2].getPrice()+"");
								selectionC[2]=item;
							}
						}
							else if(c==cb[3])
						{
							if(f[3].getStock()-item<0)
							{	
								b1[1].setEnabled(true);
								JOptionPane.showMessageDialog(null,f[3].getName()+" is not in stock.");
							}
							else
							{	l3[3].setText(item*f[3].getPrice()+"");
								selectionC[3]=item;
							}
						}
					totalAmount.setText("Total Amount: "+(selectionC[0]*f[0].getPrice()+selectionC[1]*f[1].getPrice()+selectionC[2]*f[2].getPrice()+selectionC[3]*f[3].getPrice()));
					b1[0].setEnabled(true);
			}
		
			public int notify(Fruit t, int c)
			{
				if((t==f[0]&&item>=c)||(t==f[1]&&item>=c)||(t==f[2]&&item>=c)||(t==f[3]&&item>=c))
				{
					return 1;
				}
				else
					return 0;
			}
			
	
	
		
		
	}	
